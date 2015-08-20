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

    
	<header class="jumbotron subhead" id="overview">
	<div class="container">
		<h1>SLiPP</h1>
		<p class="lead">Sustaninable Life, Programming, Programmer</p>
	</div>
	</header>     
    
	<div class="container">
		<div class="row">
			<div class="span12">
		        <table class="table">
		            <tr>
		                <td span="3">사용자 아이디</td>
		                <td span="3">이름</td>
		                <td span="3">이메일</td>
		                <td></td>
		            </tr>
	                <tr>
	                    <td>javajigi</td>
	                    <td>박재성</td>
	                    <td>javajigi@slipp.net</td>
	                    <td><a href="">수정</a></td>
	                </tr>
	                <tr>
	                    <td>sanjigi</td>
	                    <td>산지기</td>
	                    <td>sanjigi@slipp.net</td>
	                    <td><a href="">수정</a></td>
	                </tr>	                
		        </table>
			</div>
		</div>
	</div>
</body>
</html>