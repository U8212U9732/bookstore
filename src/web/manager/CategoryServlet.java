package web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.BusinessServiceImpl;
import utils.WebUtils;
import domain.Category;

//处理分类的CRUD请求
public class CategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("add")) {
			add(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if (method.equals("update")) {
			update(request, response);
		} else if (method.equals("updateJsp")) {
			updateJsp(request, response);
		} else if (method.equals("listall")) {
			listAll(request, response);
		} else {
			request.setAttribute("message", "不支持此类操作");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	private void listAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServiceImpl service = new BusinessServiceImpl();
		List<Category> CategoryList = service.getAllCategory();
		request.setAttribute("categories", CategoryList);
		request.getRequestDispatcher("/manager/listcategory.jsp").forward(request, response);
	}


	private void updateJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		BusinessServiceImpl service = new BusinessServiceImpl();
		Category c=service.findCategory(id);
		request.setAttribute("c", c);
		request.getRequestDispatcher("/manager/upcategory.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Category c= new Category();
		c.setId(id);
		c.setName(name);
		c.setDescription(description);
		BusinessServiceImpl service = new BusinessServiceImpl();
		service.updateCategory(c);
		response.sendRedirect(this.getServletContext().getContextPath() + "/manager/CategoryServlet?method=listall");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		BusinessServiceImpl service = new BusinessServiceImpl();
		service.deleteCategory(id);
		response.sendRedirect(this.getServletContext().getContextPath() + "/manager/CategoryServlet?method=listall");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Category category = new Category();
			category.setName(name);
			category.setDescription(description);
			category.setId(WebUtils.makeID());

			BusinessServiceImpl service = new BusinessServiceImpl();
			service.addCategory(category);
			request.setAttribute("message", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
