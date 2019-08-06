<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="company" items="${companies}">
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
        </tbody>
    </table>
</template:page>