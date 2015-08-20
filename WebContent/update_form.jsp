<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@page import="java.util.*"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/commons/_head.jspf" %>
</head>
<body>
<%@ include file="/commons/_top.jspf" %>

	<div class="container">
		<div class="row">
			<div class="span12">
				<section id="typography">
				<div class="page-header">
					<h1>개인정보수정</h1>
				</div>
				
				<form name="user" method="post" action="/users/update">
					<input type="hidden" name="userId" value="${user.userId}">
					<table>
						<tr>
							<td>사용자 아이디</td>
							<td>${user.userId}</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password" value="${user.password}" placeholder=""></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" value="${user.name}" placeholder=""></td>	<!-- user.getName이 아닌 user.name임! 이건 자바 빔 규약이다. 얘가 알아서 getName()에서 get을 빼고 name을 바로 호출할 수 있게 함. 즉 겟터를 통해서 얻어오는 것! -->
						</tr>
						<tr>
						<td>이메일</td>
						<td><input type="text" name="email" value="${user.email}" placeholder=""></td>	
						</tr> <!--forward로 여기에 user에 대한 정보를 넘겼으니 저 위로 접근 가능. jsp 주석은 이렇게 처리 안함! 꼭 찾아보기!-->
					</table>
					<input type="submit" value="변경하기" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>