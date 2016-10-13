<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		//아이디 찾기 결과 내용
		var findMemId='${requestScope.findMemId}';
		if(findMemId=="noData"){//결과가 존재하지 않음
			$("#result").html("회원 정보가 존재하지 않아요 :(");
		}else{//회원 아이디 노출
			$("#result").html("회원님의 테라스 아이디는 "+findMemId+" 입니다.<br><br>");
			$("#btn").html("<input type='button' id='loginBtn' value='로그인 하기'>"
					+"<input type='button' id='passBtn' value='비밀번호 재발급'>");
		}
		//로그인 버튼
		$("#loginBtn").click(function(){
			location.href="loginView.do";
		});
		
		//비밀번호 재발급 버튼
		$("#passBtn").click(function(){
			location.href="findIdOrPassView.do";
		});
	});
</script>
<fieldset>
	<h1>아이디 찾기 결과</h1><hr>
	<div id="result"></div>
	<div id="btn"></div>
</fieldset>