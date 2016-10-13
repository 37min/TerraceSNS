<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function(){
	$("#logoutMember").click(function(){
		if(confirm("로그아웃 하시겠어요?")){
			location.href= "auth_logoutMember.do"; 
		}	
	});
});
</script>
<a href="intro.do"><h1>Terrace</h1></a>
<hr>
<a href="terraceView.do">전체 테라스</a><br><br>
<a href="auth_myTerraceView.do">나의 테라스</a><br><br>
<a href="auth_registerableTerraceView.do">가입 가능한 테라스</a><br><br>
<a href="auth_joinView.do">조인하기</a><br><br>

<c:choose>
	<c:when test="${sessionScope.loginInfo == null }">
		<a href="loginView.do">로그인</a><br>
	</c:when>
	
	<c:otherwise>
		<a href="auth_modifyMemberView.do">회원정보 수정</a><br>
		<a href="#" onclick="logout()" id="logoutMember">로그아웃</a><br>
	</c:otherwise>
</c:choose>
<a href=""><font size="2">팀소개 |</a><a href=""> 서비스소개 |</a><a href=""> 사이트맵</font></a>