<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.*"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
					<c:choose>
					<c:when test="${(not empty user.userId) and (not empty user.password) and (not empty user.name) and (not empty user.email)}">
					<h1>개인정보수정</h1>
					</c:when>
					<c:otherwise>
					<h1>회원가입</h1>
					</c:otherwise>
					</c:choose>
				</div>
				
				<c:set var="actionUrl" value="/users/create"/>		<!--set태그로 변수지정가능-->
				<c:if test="${(not empty user.userId) and (not empty user.password) and (not empty user.name) and (not empty user.email)}">
				<c:set var="actionUrl" value="/users/update"/>
				</c:if>
				
				<form name="user" method="post" action="${actionUrl}">
					<c:if test="${not empty errorMessage}">
					<div class="control-group">
						<c:choose>
						<c:when test="${empty user.email}">
						<label class="error">이메일 오류</label>
						</c:when>
						<c:when test="${(empty user.name) or (fn:length(user.name)<2) or (fn:length(user.name)>10)}">
						<label class="error">이름 오류</label>
						</c:when>
						<c:when test="${(empty user.password) or (fn:length(user.password)<4) or (fn:length(user.password)>12)}">
						<label class="error">패스워드 오류</label>
						</c:when>
						<c:when test="${(empty user.userId) or (fn:length(user.userId)<4) or (fn:length(user.userId)>12)}">
						<label class="error">아이디 오류</label>
						</c:when>
						</c:choose>
						<label class="error">${errorMessage}</label>
					</div>	
					</c:if> 
					<table>
						<tr>
							<td>사용자 아이디</td>
							<td>
								<c:choose>
								<c:when test="${(not empty user.userId) and (not empty user.password) and (not empty user.name) and (not empty user.email)}">
								<input type="hidden" name="userId" value="${user.userId}"/>
								${user.userId}
								</c:when>
								<c:otherwise>
								<input type="text" name="userId" value="${user.userId}"/>
								</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password" value="${user.password}"></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" value="${user.name}"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="email" value="${user.email}"></td>
						</tr>
					</table>
					<c:choose>
					<c:when test ="${(not empty user.userId) and (not empty user.password) and (not empty user.name) and (not empty user.email)}">
					<input type="submit" value="변경하기" />
					</c:when>
					<c:otherwise>
					<input type="submit" value="회원가입" />
					</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
	</div>
</body>
</html>