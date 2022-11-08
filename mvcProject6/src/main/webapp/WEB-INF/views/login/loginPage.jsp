<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
	<div class="login">
		<form id="loginCheck" action="loginCheck.do" method="post">
			<h1>login page</h1>
			아이디: <input type="text" name="id" placeholder="ID"></br>
			비밀번호: <input type="text" id="pw" name="pw" placeholder="PW">
			<button type="submit">로그인</button>
		</form>
	</div>
	<div>	
		<a href="moveSignup.do">회원가입</a>
	</div>
	
</body>
</html>