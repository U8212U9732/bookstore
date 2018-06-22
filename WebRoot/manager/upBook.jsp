<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>修改图书</title>
</head>

<body>
	<form
		action="${pageContext.request.contextPath }/manager/BookServlet?method=update"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${id}">
		<table frame="border" width="50%">
			<tr>
				<td>图书名称</td>
				<td><input type="text" name="name" value="${name}"></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author" value="${author}"></td>
			</tr>
			<tr>
				<td>售价</td>
				<td><input type="text" name="price" value="${price}"></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="file" value=""></td>
			</tr>
			<tr>
				<td>图书描述</td>
				<td><textarea rows="5" cols="40" name="description">${description}</textarea>
				</td>
			</tr>
			<tr>
				<td>所属分类</td>
				<td><select name="category_id">
						<c:forEach var="c" items="${categories }">
							<option value="${c.id }">${c.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="reset" value="清空"></td>
				<td><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>
