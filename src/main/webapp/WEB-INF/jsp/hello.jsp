<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Hello world:</title>
</head>


<body>
<h2>${message}</h2>
<table border="1">
            <c:forEach var="company" items="${companies}"  >
            <tr>
                <td>
                        ${company.id}
                </td>
                <td>
                        ${company.name}
                </td>
                <td>
                        ${company.slogan}
                </td>
                <td>
                        ${company.description}
                </td>

            </tr>

            </c:forEach>
</table>
</body>
</html>