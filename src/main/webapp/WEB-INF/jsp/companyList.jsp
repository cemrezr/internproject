<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<template:page>

    <table class="table table-striped" style="width: 95%;position:absolute;top:94px;left:33px;right:33px" border="3"
           bordercolor="#c5c6c7">
        <thead>
        <tr>
            <th scope="col" style="width: 20%">Name</th>
            <th scope="col" style="width: 30%">Description</th>
            <th scope="col" style="width: 39%">Slogan</th>
            <th scope="col" style="width: 5%">Update</th>
            <th scope="col" style="width: 5%">Delete</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="company" items="${companies}">
            <tr>
                <td>
                        ${company.name}
                </td>
                <td>
                        ${company.description}
                </td>
                <td>
                        ${company.slogan}
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
        <tr style="text-align:right;">
            <td colspan="5">
                <c:url var="addLink" value="/company/add">
                </c:url>
                <a class="btn btn-outline-success btn-lg btn-block" href="${addLink}"/>Add</a>
            </td>
        </tr>

        </tbody>
    </table>

</template:page>