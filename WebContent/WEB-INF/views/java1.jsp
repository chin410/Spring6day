<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><sp:message code='aa.a1'/></h1>
	<h1><sp:message code="aa.a2" arguments="${str }"></sp:message> </h1>
	<h1><sp:message code='bb.b1'/></h1>

</body>
</html>