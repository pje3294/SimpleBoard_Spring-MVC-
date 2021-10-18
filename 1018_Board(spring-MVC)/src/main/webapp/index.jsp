<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>

<h2 style="color: navy;"><i>서비스를 이용하실려면, 로그인을 먼저 해주세요!</i>&nbsp;👧🏻</h2>

<form action="login.do" method="post"> 
	<table border="1">
		<tr>
			<td style="background: beige;">아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td style="background: lightblue;">비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: right;"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form> 

<br>
<hr>
<a href="join.jsp">회원가입 하러가기</a>



</body>
</html>