<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<template:page>
    <form method="post" style="width: 50%;position: absolute;top: 63px;left: 30px   ;" >
        <div class="form-row">
            <div class="form-group">
                <input hidden class="form-control" name="id"  value="${company.id}">
            </div>
        </div>
        <div class="form-group">
            <label>Name</label>
            <input class="form-control" name="name"  value="${company.name}">
        </div>
        </div>
        <div class="form-group">
            <label>Company Slogan</label>
            <input type="text" class="form-control" name="slogan" value="${company.slogan}">
        </div>
        <div class="form-group">
            <label>Company Description</label>
            <input type="text" class="form-control" name="description" value="${company.description}">
        </div>
        <c:url value="/company/edit/${company.id}" var="editLinkPost"></c:url>
        <button type="submit" class="btn btn-success btn-block" href=${editLinkPost}>Save</button>
    </form>
</template:page>