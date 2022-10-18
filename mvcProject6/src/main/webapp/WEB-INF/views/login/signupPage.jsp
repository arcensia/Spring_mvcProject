<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 page</title>
</head>
<body>
	<div>
		<form id="signup" action="createUser.do" method="POST">
			<h1>login page</h1><!-- DB의 usertable 작성 -->
			아이디: <input type="text" name="id" placeholder="ID"></br>
			비밀번호: <input type="text" id="pw" name="pw" placeholder="PW">
			이메일 주소: <input type="text" name="email" placeholder="email"></br>
			핸드폰: <input type="text" name="pnum" placeholder="Phone Number"></br>
			이름: <input type="text" name="name" placeholder="name"></br>
			<button type="submit">가입</button>
		</form>
	</div>
</body>
</html>