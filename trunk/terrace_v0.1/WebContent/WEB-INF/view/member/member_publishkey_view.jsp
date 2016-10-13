<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		var publishKey="";
		var memId="";
		var univEmail="";
		//지역 셀렉트박스
		$("#univLoc").change(function(){
			$.ajax({
				url:"univNameList.do",
				dataType:"json",
				data:"univLoc="+encodeURIComponent($(this).val()),
				success:function(univListByUnivLoc){
					$("#univName").empty()
					var initOp="<option value=''>학교선택</option>";
					$("#univName").append(initOp);
					$.each(univListByUnivLoc,function(index, univ){				
						var op="<option value="+univ+">"+univ+"</option>";
						$("#univName").append(op);
					});						
				}//success
			});//ajax
		});
		//대학 셀렉트박스
		$("#univName").change(function(){
			$.ajax({
				url:"univEmail.do",
				dataType:"json",
				data:"univName="+encodeURIComponent($(this).val()),
				success : function(data) {
					$("#univSite").val(data.univEmail);
					univEmail = data.univEmail;
				}//callback	
			});//ajax
		});
		
		//인증하기 버튼
		$("#publishKeyBtn").click(function(){
			memId=$("#univId").val()+$("#univSite").val();
			$.ajax({
				type : "POST",
				url : "publishKey.do",
				data : "memId=" + memId,
				success : function(data) {
					if (data.publishKey == "") {
						$("#testPublishKeyArea").html(memId + "가 이미 존재합니다.").css("color", "red");
					} else {
						alert("인증번호가 발송되었어요!");
						$("#testPublishKeyArea").html("인증번호 : " + data.publishKey).css("color", "blue");
					}
					publishKey=data.publishKey;
				}//callback			
			});//ajax
		});
		//확인 버튼
		$("#confirmBtn").click(function(){
			var memUniv = $("#univName").val();
			if($("#publishKey").val()!=publishKey || $("#publishKey").val()==""){
				alert("다시 한번 인증번호를 확인해주세요.");
				$("#publishKey").val("");
			} else {
				if(memId != $("#univId").val()+univEmail){
					alert("이메일이 변경되었네요. 확인 바랍니다.");
					$("#publishKey").val("");
					return false;
				}else{
					alert("인증완료! 가입하러 가실게요.");
					location.href="registerMemberView.do?memId="+memId+"&memUniv="+memUniv;
				}
			}
		});
		//취소 버튼
		$("#cancel").click(function(){
			if(confirm("회원가입을 취소하시겠어요?")){
				location.href="loginView.do";
			}
		});
	});
</script>
<center>
<form method="post" id="publishKeyForm" action="registerMemberView.do">
	<fieldset style="width:330px;">
		<h1>이메일 인증</h1>
		<table>
			<tr><td><hr></td></tr>
			<tr><td>
				<select id="univLoc" style="width:150px; height:30px;">
					<option value="">지역선택</option>
					<option value="경기도">경기도</option>
				</select>
				<select id="univName" style="width:150px; height:30px;">
					<option value=''>학교선택</option>
				</select>
			</td></tr>
			<tr><td><hr></td></tr>
			<tr><td>
				<input type="text" id="univId" placeholder="학교ID 입력" style="width:137px; height:30px;">
				<input type="text" id="univSite" value="" style="width:80px; height:30px;" readonly>
				<input type="button" id="publishKeyBtn" value="인증번호" style="width:70px; height:36px;">
			</td></tr>
			<tr><td>
				<input type="password" id="publishKey" placeholder="인증번호 입력" style="width:226px; height:30px;">
				<input type="button" id="confirmBtn" value="확인" style="width:70px; height:36px;">
			</td></tr>
			<tr><td>
				<font size="2">※ 이메일 인증 확인되어야 가입이 가능해요.</font>
			</td></tr>
		</table>
		<br>
		<div style="padding-top:5px; padding-bottom:5px; background: #EAEAEA"><input type="button" id="cancel" value="인증취소" style="width:70px; height:36px;"></div>
	</fieldset>
</form>
<div id="testPublishKeyArea"></div>
</center>