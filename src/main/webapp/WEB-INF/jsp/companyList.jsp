<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<template:page>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Slogan</th>
            <th scope="col">Description</th>
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
                <td>
                    <c:url var="updateLink" value="/company/edit/${company.id}">
                    </c:url>
                    <a class="btn btn-outline-primary" href="${updateLink}"/>Update</a>
                </td>
                <td>
                    <c:url var="removeLink" value="/company/remove/${company.id}">

                    </c:url>

                    <a class="btn btn-outline-danger" href="${removeLink}"/>Delete</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</template:page>