<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Terrace</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<style type="text/css">
.action {
	cursor: pointer;
}
select {
	font-family:'맑은 고딕';
}
input {
	font-family:'맑은 고딕';
}
div{
	font-family:'맑은 고딕';
}
img:HOVER{
	background-color: black;
}

/* 한번도 클릭하지 않은 링크, none으로 언더라인 생기지 않게 함 */
a:link {
	color: #888;
	text-decoration: none;
}
/* 한번 이상 클릭한 링크, none으로 언더라인 생기지 않게 함 */
a:visited {
	color: #888;
	text-decoration: none;
}

#container {
	width: 1000px;
	margin: 0 auto;
	padding: 0;
	position: relative;
}

#left {
	padding: 10px 10px 30px 10px;
	background-color: #EAEAEA;
	width: 250px;
	height: 500px;
	position: relative;
	text-align: center;
	float: left;
}

#main {
	padding: 10px 10px 30px 10px;
	background-color: white;
	font-family: 맑은 고딕;
	font-size: 10.5pt;
	margin: 20px 0 0 0;
	height: 500px;
	box-shadow:10px 10px 20px #999;
}

</style>
</head>
<body>
	<div id="container">
		<div id="left">
			<tiles:insertAttribute name="left" />
		</div>
		<div id="main">
			<tiles:insertAttribute name="main" />
		</div>
	</div>
</body>
</html>