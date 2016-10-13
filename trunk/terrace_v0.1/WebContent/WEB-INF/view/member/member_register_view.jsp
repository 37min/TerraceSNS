<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(document).ready(function(){
		//유효성 검사
		$("#registerForm").submit(function(){
			if($("#memPass").val()==""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if($("#memPassConfirm").val()==""){
				alert("비밀번호 확인란을 입력하세요.");
				return false;
			}
			if($("#memName").val()==""){
				alert("이름을 입력하세요.");
				return false;
			}
			if($("#memUniv").val()==""){
				alert("대학명을 선택하세요.");
				return false;
			}
			if($("#memDept").val()==""){
				alert("학부명을 입력하세요.");
				return false;
			}
			if($("#memNo").val()==""){
				alert("학번을 입력하세요.");
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
		
		//가입취소 버튼
		$("#cancel").click(function(){
			if(confirm("작성을 취소하시겠어요?")){
				location.href="loginView.do";
			}
		});
			
		//학번 unique 처리
		$("#memNo").keyup(function() {
			var memNo=$("#memNo").val();
			$.ajax({
				type : "POST",
				url : "memNoCheck.do",
				data : "memNo=" + memNo,
				success : function(data) {
					if (data.flag == true) {
						$("#memNoCheckView").html("가입이 불가능한 학번이예요.").css("color", "red");
					}else{
						$("#memNoCheckView").html("");
					}
				}//callback			
			});//ajax
		});//keyup
	});
</script>
<form action="registerMember.do" id="registerForm" method="post" enctype="multipart/form-data">
<fieldset>
	<legend><h1>회원가입</h1></legend>
	<h3>필수정보</h3>
	<table>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="memId" name="memId" value="${requestScope.mvo.memId }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="memPass" name="memPass"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td>
				<input type="password" id="memPassConfirm" name="memPassConfirm">
				<span id="passCheckView">사용하실 비밀번호 안내</span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="memName" name="memName"></td>
		</tr>
		<tr>
			<td>대학명</td>
			<td><input type="text" id="memUniv" name="memUniv" value="${requestScope.mvo.memUniv }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>학부명</td>
			<td><input type="text" id="memDept" name="memDept"></td>
		</tr>
		<tr>
			<td>학번</td>
			<td>
				<input type="text" id="memNo" name="memNo">
				<span id="memNoCheckView"></span>
			</td>
		</tr>
	</table>
	<h3>부가정보</h3>
	<table>
		<tr>
			<td>핸드폰번호</td>
			<td><input type="text" id="memPhone" name="memPhone"></td>
		</tr>
		<tr>
			<td>프로필 이미지</td>
			<td><input type="file" name="uploadImg"></td>
		</tr>
	</table>
	<input type="submit" id="registerBtn" name="registerBtn" value="가입신청">
	<input type="button" id="cancel" name="cancel" value="가입취소">
</fieldset>
</form>