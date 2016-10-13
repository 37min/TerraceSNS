<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	//유효성 검사
	$(document).ready(function(){
		//아이디 찾기 폼 제출
		$("#findMemIdForm").submit(function(){
			if($("#findMemName").val()==""){
				alert("회원 이름을 입력하세요.");
				return false;
			}
			if($("#findMemNo").val()==""){
				alert("학번을 입력하세요.");
				return false;
			}
		});
		//비밀번호 재발급 폼 제출
		$("#publishMemPassForm").submit(function(){
			var id=$("#passMemId").val();
			if(id==""){
				alert("회원 아이디를 입력하세요.");
				return false;
			}else if(id.indexOf('@')<=0 || id.indexOf('.') < id.indexOf('@')){
				alert("이메일 형식이 아니예요.");
				return false;
			}
			if($("#passMemName").val()==""){
				alert("회원 이름을 입력하세요.");
				return false;
			}
			if($("#passMemNo").val()==""){
				alert("학번을 입력하세요.");
				return false;
			}
		});
		//취소버튼
		$("#publishBtn").click(function(){
			location.href="publishKeyView.do";
		});
	});
</script>

<center>
<fieldset style="width:400px;">
	<h1>아이디 찾기/비밀번호 재발급</h1><hr>
	<form id="findMemIdForm" method="post" action="findMemId.do">
		<fieldset>
			<legend align="top"><h3>아이디 찾기</h3></legend>
			<table>
			<tr><td>
				<input type="text" id="findMemName" name="findMemName" placeholder="회원 이름 입력" style="width:280px; height:30px;">
			</td></tr>
			<tr><td>
				<input type="text" id="findMemNo" name="findMemNo" placeholder="학번 입력" style="width:280px; height:30px;">
			</td></tr>
			<tr><td>
				<input type="submit" id="findMemIdBtn" value="아이디 찾기" style="width:285px; height:30px;">
			</td></tr>
		</table>
		</fieldset>
	</form>
	<br>
	<form id="publishMemPassForm" method="post" action="publishMemPass.do">
		<fieldset>
			<legend align="top"><h3>비밀번호 재발급</h3></legend>
			<table>
				<tr><td>
					<input type="text" id="passMemId" name="passMemId" placeholder="회원 아이디 입력" style="width:280px; height:30px;">
				</td></tr>
				<tr><td>
					<input type="text" id="passMemName" name="passMemName" placeholder="회원 이름 입력" style="width:280px; height:30px;">
				</td></tr>
				<tr><td>
					<input type="text" id="passMemNo" name="passMemNo" placeholder="학번 입력" style="width:280px; height:30px;">
				</td></tr>
				<tr><td>
					<input type="submit" id="publishMemPassBtn" value="비밀번호 재발급" style="width:285px; height:30px;">
				</td></tr>
			</table>
		</fieldset>
	</form>
</fieldset>
</center>