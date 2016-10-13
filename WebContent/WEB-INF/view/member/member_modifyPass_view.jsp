<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
$(document).ready(function(){
	$("#modifyPassForm").submit(function(){
		if($("#memPass").val()==""){
			alert("비밀번호를 입력하세요");
			return false;
		}
		if($("#memPassConfirm").val()==""){
			alert("비밀번호 확인란을 입력하세요.");
			return false;
		}
	});
	//비밀번호+비밀번호확인
	$("#memPass").keyup(function() {
		var password = $("#memPass").val();
		if(password==""){
			$("#passCheckView").html("사용하실 비밀번호 안내").css("color","black");
			return false;
		}
		if (password != $("#memPassConfirm").val()) {
			$("#passCheckView").html("비밀번호가 일치하지 않아요.").css("color", "red");
		} else {
			$("#passCheckView").html("비밀번호 확인되었어요.").css("color", "blue");
		}
	});//keyup
	$("#memPassConfirm").keyup(function() {
		var passwordconfirm = $("#memPassConfirm").val();
		if(passwordconfirm==""){
			$("#passCheckView").html("사용하실 비밀번호 안내").css("color","black");
			return false;
		}
		if (passwordconfirm != $("#memPass").val()) {
			$("#passCheckView").html("비밀번호가 일치하지 않아요.").css("color", "red");
		} else {
			$("#passCheckView").html("비밀번호 확인되었어요.").css("color", "blue");
		}
	});//keyup
	//수정취소 버튼
	$("#cancel").click(function(){
		if(confirm("수정을 취소하시겠어요?")){
			location.href="/intro.do";
		}
	});
});
</script>
<center>
<form method="post" action="modifyPass.do" id="modifyPassForm">
<c:set var="mvo" value="${sessionScope.loginInfo}"></c:set>
<input type="hidden" name="memId" value='${mvo.memId }'>
	<fieldset>
		<legend><h1>비밀번호 수정</h1></legend>
		<table>
			<tr>
				<td>* 비밀번호</td>
				<td><input type="password" id="memPass" name="memPass" ></td>
			</tr>
			<tr>
				<td>* 비밀번호 확인</td>
				<td>
					<input type="password" id="memPassConfirm" name="memPassConfirm">
				</td>
			</tr>
			<tr><td colspan="2">
			<div id="passCheckView"> 사용하실 비밀번호 안내</div>
			</td></tr>
		</table>
		<input type="submit" id="modifyBtn" name="modifyBtn" value="수정하기">
		<input type="button" id="cancel" name="cancel" value="작성취소">
	</fieldset>
</form>
</center>