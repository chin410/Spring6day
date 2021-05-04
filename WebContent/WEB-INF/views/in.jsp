<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="out" method="post">
		d1:<input type="text" name="da1"><br>
		<sp:hasBindErrors name="data1">
		<c:if test="${errors.hasFieldErrors('da1')}">
		${errors.getFieldError('da1').defaultMessage }
		</c:if>
		</sp:hasBindErrors>
		
		d2: <input name="da2"><br>
		<sp:hasBindErrors name="data2">
			<c:if test="${erros.hasFiledErros('da2') }">
				${errors.getFiledError('da2').defaultMessage }
			</c:if>
		</sp:hasBindErrors>
		
		<button type="submit">확인</button>
	</form>
</body>
</html>