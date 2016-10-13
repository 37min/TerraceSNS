<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#memPassBtn").click(function(){
			//유효성 검사
			if($("#memPass").val()==""){
				alert("비밀번호를 입력하세요.");
			}
			$.ajax({
				type : "POST",
				url : "auth_memPassCheck.do",
				data : "memPass=" + $("#memPass").val(),
				success : function(data) {
					if (data.flag == "true") {
						if(confirm("비활성화 하시겠어요?")){
							location.href="auth_sleepMember.do";
						}else{
							location.href="auth_modifyMemberView.do";
						}
					}else{
						alert("비밀번호 입력 오류예요.");
					}//else 
				}//callback			
			});//ajax
		});
	});
</script>
<form method="post" id="memPassForm">
	<fieldset>
		<legend><h1>계정 비활성화</h1></legend>
		<h2>비밀번호 확인</h2><hr>
		<input type="text" id="memPass" name="memPass" placeholer="비밀번호 입력">
		<input type="button" id="memPassBtn" name="memPassBtn" value="확인">
	</fieldset>
</form>