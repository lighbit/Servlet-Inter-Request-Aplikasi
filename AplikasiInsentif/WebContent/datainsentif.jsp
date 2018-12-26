<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<c:forEach items="${requestScope.empList}" var="emp">
				<tr>
				<td><c:out value="${emp.nama}"></c:out></td>
				<td><c:out value="${emp.namaGolongan}"></c:out></td>
				<td><c:out value="${emp.gajiGolongan}"></c:out></td>
				<td><c:out value="${emp.insentif}"></c:out></td>
				
				<td><c:out value="${emp.insentifGaji}"></c:out></td>
				</tr>
	</c:forEach>
</body>
</html>