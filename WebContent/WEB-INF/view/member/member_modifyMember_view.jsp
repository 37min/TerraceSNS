<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		//유효성 검사
		$("#modifyForm").submit(function(){
			if($("#memName").val()==""){
				alert("이름을 입력하세요.");
				return false;
			}
			if($("#memDept").val()==""){
				alert("학부명을 입력하세요.");
				return false;
			}
			if(!confirm("작성된 정보로 수정하시겠어요?")){
				return false;
			}
		});
		//수정취소 버튼
		$("#cancel").click(function(){
			if(confirm("수정을 취소하시겠어요?")){
				location.href="${initParam.root}intro.do";
			}
		});
	});
</script>
<form action= "auth_modifyMember.do" id="modifyForm" method ="post" enctype="multipart/form-data">
<c:set var="mvo" value="${sessionScope.loginInfo}"></c:set>
<fieldset>
	<legend><h1>회원정보 수정</h1></legend>
	<h3>필수정보</h3>
	<table>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="memId" name="memId" value="${mvo.memId }" readonly></td>
		</tr>
		<tr>
			<td>* 이름</td>
			<td><input type="text" id="memName" name="memName" value= "${mvo.memName }"></td>
		</tr>
		<tr>
			<td>대학명</td>
			<td><input type="text" id="memUniv" name="memUniv" value="${mvo.memUniv }" readonly></td>
		</tr>
		<tr>
			<td>* 학부명</td>
			<td><input type="text" id="memDept" name="memDept" value="${mvo.memDept }"></td>
		</tr>
		<tr>
			<td>학번</td>
			<td>
				<input type="text" id="memNo" name="memNo" value= "${mvo.memNo }" readonly>
				<span id="memNoCheckView"></span>
			</td>
		</tr>
	</table>
	<h3>부가정보</h3>
	<table>
		<tr>
			<td>* 핸드폰번호</td>
			<td><input type="text" id="memPhone" name="memPhone" value="${mvo.memPhone }"></td>
		</tr>
		<tr>
			<td>* 프로필 이미지</td>
			<td>
				<img src="${initParam.memImgPath }${mvo.memNewImg}" width="100px" height="100px"><br>
				이미지 수정&nbsp;<input type="file" name="uploadImg" id="uploadImg">
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" id="modifyBtn" name="modifyBtn" value="정보수정">
	<input type="button" id="cancel" name="cancel" value="수정취소"><br>
	<a href="auth_modifyPassView.do">비밀번호 변경</a> | 
	<a href="auth_sleepMemberView.do" >계정 비활성화</a>
</fieldset>
* 표시에 해당하는 요소만 수정이 가능해요.
</form>