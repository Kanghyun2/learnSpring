<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 입력 폼</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<input type="file" name="upload"> <input type="submit">
	</form>
	<ul>
		<c:forEach var="filenames" items="${ filenames }">
			<li>${ filenames }</li>
		</c:forEach>
	</ul>
</body>
</html>