<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.board2.*, java.util.*"%>
<jsp:useBean id="vo" class="model.board2.BoardVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<h3 style="background-color: pink;">#[${selClient}님]은 현재 [${data.writer}님]의 글을 보고 있습니다.</h3>


	<table border="1">

		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${data.title }"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="${data.writer }"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="${data.content }"></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><input type="text" name="wdate" value="${data.wdate }"></td>
		</tr>

	</table>

	<hr>
	<!-- <a href="deleteBoardAction.jsp">삭제하기</a> -->

	<hr>
	<a href="main.do">메인으로 이동하기</a>

</body>
</html>