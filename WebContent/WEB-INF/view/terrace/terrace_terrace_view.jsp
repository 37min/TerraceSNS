<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){
		//테라스 만들기 버튼
		$("#createBtn").click(function(){
			location.href="auth_createTerraceView.do";
		});
		
		//테라스 갯수 카운팅
		$("#terCount").html();
		
		//테라스 카테고리 검색
		$("#terCategory").change(function(){
			$.ajax({
				type : "GET",
				url : "searchTerraceByCategory.do",
				data : "terCategory="+$("#terCategory").val()+"&listName=all",
				success : function(data) {
					$("#terCount").html($('#terCategory').val() + " 테라스는 " + data.tcListSize +" 개");
					var str="<table><tr>";
					$.each(data.tcList,function(index, tcList){							
						if(index %5==0){
							str+="</tr><tr>";
						}
						str+="<td><table><tr><td><img src=${initParam.terIconImgPath }"+tcList.terIconNewImg;
						str+=" width='100px'></td></tr><tr><td>"+tcList.terName+"</td></tr></td></table></td>";
					});		
					str+="</tr></table>"
					
					$("#listDiv").html(str);
					
				}//callback			
			});//ajax
		});
	
		//테라스명으로 검색
		$("#searchBtn").click(function(){
			$.ajax({
				type : "GET",
				url : "searchTerraceByTerName.do",
				data : "terName="+$("#terName").val()+"&listName=all",
				success : function(data) {
					$("#terCount").html("'"+$('#terName').val() + "'에 해당하는 테라스는 " + data.tnListSize +" 개");
					var str="<table><tr>";
					$.each(data.tnList,function(index, tnList){							
						if(index %5==0){
							str+="</tr><tr>";
						}
						str+="<td><table><tr><td><img src=${initParam.terIconImgPath }"+tnList.terIconNewImg;
						str+=" width='100px'></td></tr><tr><td>"+tnList.terName+"</td></tr></td></table></td>";
					});		
					str+="</tr></table>"
					
					$("#listDiv").html(str);
					
				}//callback			
			});//ajax
		});
		
		//해당 테라스 메인(게시판)으로 이동
		$("#boardInnerList").click(function(){
			location.href="boardInnerList.do";
		});
	});


</script>

<fieldset>
<h1>전체 테라스</h1><hr>
<!-- 테라스 검색폼 -->
<select id="terCategory" name="terCategory">
	<option value="전체">전체</option>
	<option value="IT">IT</option>
	<option value="동아리">동아리</option>
</select>
<input type="text" id="terName" name="terName" placeholder="테라스명 검색">
<input type="button" id="searchBtn" name="searchBtn" value="검색">
<hr>
<!-- 테라스정보 및 생성버튼 라인 -->
<table>
	<tr>
		<td><span id="terCount">전체 테라스는 ${requestScope.tpListSize } 개</span></td>
		<td><input type="button" id="createBtn" name="createBtn" value="테라스 만들기"></td>
	</tr>
</table>
<hr>
<!-- 테라스 목록 -->
<div id="listDiv">
<a id="boardInnerList">
<table>
	<!-- nx5 목록으로 표시 -->
	<tr>
	<c:forEach var="tvo" items="${requestScope.tpList }" varStatus="i">
		<c:if	test="${i.index %5==0 }">
		</tr><tr>
		</c:if>
		<td>
			<!-- 테라스당 칸 표현 -->
			<table>
				<%-- <tr><td>${tvo }</td></tr> --%>
				<tr><td><img src="${initParam.terIconImgPath }${tvo.terIconNewImg}" width="100px" height="100px">
				</td></tr>
				<tr><td>${tvo.terName }</td></tr>
				</td>
			</table>
		</td>
	</c:forEach>
	</tr>
</table>
</a>
</div>
</fieldset>
