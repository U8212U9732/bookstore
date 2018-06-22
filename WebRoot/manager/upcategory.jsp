<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>修改分类</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=update" method="post">
    	<input type="hidden" name="id" value="${c.id }">
    	分类名称：<input type="text" name="name" value="${c.name }"><br/><br/>
    	分类描述：<textarea rows="5" cols="40" name="description">${c.description }</textarea>
    	<input type="submit" value="修改">
    </form>
  </body>
</html>
