<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	//유효성 검사
	$(document).ready(function(){
		$("#loginMemberForm").submit(function(){
			var id=$("#memId").val();
			if(id==""){
				alert("이메일을 입력하세요.");
				return false;
			}else if(id.indexOf('@')<=0 || id.indexOf('.') < id.indexOf('@')){
				alert("이메일 형식이 아니예요.");
				return false;
			}
			if($("#memPass").val()==""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
		});
		//취소버튼
		$("#publishBtn").click(function(){
			location.href="publishKeyView.do";
		});
		//자동로그인 체크박스
		$("#autoLoginCheck").click(function(){
			$("#autoLogin").val($('input[type=checkbox]:checked').val());
		});
	});
</script>
<center>
<form id="loginMemberForm" method="post" action="loginMember.do">
<fieldset style="width:300px;">
	<h1>Terrace</h1>
	<table>
	<tr><td><hr></td></tr>
	<tr><td>
	<input type="text" id="memId" name="memId" placeholder="E-mail" style="width:280px; height:30px;">
	</td></tr>
	<tr><td>
	<input type="password" id="memPass" name="memPass" placeholder="Password" style="width:280px; height:30px;">
	</td></tr>
	<tr><td>
	<input type="submit" id="loginBtn" name="loginBtn" value="로그인" style="width:285px; height:30px;">
	</td></tr>
	<tr><td>
	<input type="checkbox" id="autoLoginCheck" name="autoLoginCheck">&nbsp;자동로그인
	<input type="hidden" id="autoLogin" name="autoLogin">
	</td></tr>
	<tr><td>
	<a href="${initParam.root }findIdOrPassView.do">아이디 찾기/비밀번호 재발급</a>
	</td></tr>
	<tr><td><hr></td></tr>
	<tr><td>
	<input type="button" id="publishBtn" name="publishBtn" value="회원 가입" style="width:285px; height:30px;">
	</td></tr>
	</table>
</fieldset>
</form>
</center>