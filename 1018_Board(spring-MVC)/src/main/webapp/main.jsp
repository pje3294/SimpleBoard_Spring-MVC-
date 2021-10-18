<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.board2.*, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<a href="logout.do"
		style="text-decoration: none; background-color: silver;">로그아웃</a>
	<hr>

	<h1>글목록</h1>
	<h3>[${seClient}님], 환영합니다🤞</h3>
	<hr>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach var="v" items="${datas}">
			<tr>
				<td><a href="getBoard.do?id=${v.id}&selClient=${seClient}">${v.id}</a></td>
				<td>${v.title}</td>
				<td>${v.writer}</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<a href="insertBoard.jsp">글추가</a>

</body>
</html>