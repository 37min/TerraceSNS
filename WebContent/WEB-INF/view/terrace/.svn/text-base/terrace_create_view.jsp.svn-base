<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#createTerraceForm").submit(function(){
			if($("#terCategory").val()==""){
				alert("카테고리를 선택해주세요.");
				return false;
			}
			if($("#terName").val()==""){
				alert("테라스 이름을 입력해주세요.");
				return false;
			}
			if($("#terIntro").val()==""){
				alert("테라스 소개글을 입력해주세요.");
				return false;
			}
		});
		//작성취소 버튼
		$("#cancel").click(function(){
			if(confirm("작성을 취소하시겠어요?")){
				location.href="terraceView.do";
			}
		});
		// 아이콘 이미지 업로드 시 사진 보여주기
		function iconImgReadURL(input){
			if(input.files && input.files[0]){
				var reader = new FileReader();
				reader.onload= function(e){
					$("#terIconView").attr("src",e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		
		$("#uploadIconImg").change(function(){
			iconImgReadURL(this);
		});
		// 커버 이미지 업로드 시 사진 보여주기
		function coverImgReadURL(input){
			if(input.files && input.files[0]){
				var reader = new FileReader();
				reader.onload= function(e){
					$("#terCoverView").attr("src",e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		
		$("#uploadCoverImg").change(function(){
			coverImgReadURL(this);
		});
	});
</script>

<form method="post" action="createTerrace.do" id="createTerraceForm" enctype="multipart/form-data">
	<fieldset>
		<h1>테라스 만들기</h1><hr>
		<h2>필수정보</h2>
		<table>
			<tr>
			<td>카테고리</td>
			<td colspan="3">
				<select id="terCategory" name="terCategory">
					<option value="">카테고리 선택</option>
					<option value="IT">IT</option>
					<option value="동아리">동아리</option>
				</select>
			</td>
			</tr>
			
			<tr>
			<td>테라스 이름</td>
			<td colspan="3"><input type="text" id="terName" name="terName" placeholder="테라스 이름 입력"></td>
			</tr>
			
			<tr>
			<td>테라스 소개</td>
			<td colspan="3"><textarea rows="5px" cols="70px" id="terIntro" name="terIntro" placeholder="테라스 소개 입력"></textarea></td>
			</tr>
			
			<tr>
			<td>공개여부</td>
			<td><select id="terLock" name="terLock">
				<option value=0>공개</option>
				<option value=1>비공개</option>
			</select></td>
			
			<td>가입가능 여부</td>
			<td><select id="terRegister" name="terRegister">
				<option value=1>가입 가능</option>
				<option value=0>가입 불가능</option>
			</select></td>
			</tr>
			</table>
			<hr>
			<h2>부가정보</h2>
			<table>
			<tr>
			<td>아이콘 이미지</td>
			<td colspan="2"><img src="#" id="terIconView" width="80px"></td>
			<td><input type="file" id="uploadIconImg" name="uploadIconImg"></td>
			</tr>
			
			<tr>
			<td>커버 이미지</td>
			<td colspan="2"><img src="#" id="terCoverView" width="80px"></td>
			<td><input type="file" id="uploadCoverImg" name="uploadCoverImg"></td>
			</tr>
		</table>
		<input type="submit" id="createBtn" name="createBtn" value="만들기">
		<input type="button" id="cancel" name="cancel" value="작성취소">
	</fieldset>
</form>