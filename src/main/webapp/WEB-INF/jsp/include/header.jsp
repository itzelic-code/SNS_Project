<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<header class="d-flex align-items-center justify-content-between mt-3">
				<h2 class="ml-3">Marondalgram</h2>
				
				<c:if test="${not empty userId }">
				<div class="mr-3">${userLoginId }  <a href="/user/logout">로그아웃</a></div>
				</c:if>
			</header>
			<hr>	