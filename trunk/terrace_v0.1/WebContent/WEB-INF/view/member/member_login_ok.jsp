<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	var sleepCheck='${requestScope.sleepCheck}';
	if(sleepCheck=="wakeUp"){
		alert("오랜만이예요 :)");
	}
	location.href="${initParam.root}intro.do";
</script>