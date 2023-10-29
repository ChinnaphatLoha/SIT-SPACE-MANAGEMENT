<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SIT Space Management</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        body {
            padding: 25px 20px;
        }

        a {
            color: #000;
        }

        hr {
            margin: 20px 0;
        }

        input {
            margin-right: 10px;
        }

        #title {
            text-align: center;
          margin-bottom: 20px;
        }

        .form-title {
            margin: 20px 0;
        }

        .submit-btn {
            margin-left: 15px;
        }
    </style>
</head>
<body>
<h1 id="title"><%= "SitSpaceManagement" %></h1>
<h3>PAGE :
    <a href="#">ADD/REMOVE Student</a> |
    <a href="all-data">All Data</a>
</h3>
<div class="form-container">
    <form action="add-student" method="post">
        <h3 class="form-title">Add Student Data</h3>
        <label for="addID" class="label">ID: </label>
        <input name="addID" id="addID" type="number">
        <label for="name" class="label">Name: </label>
        <input name="name" id="name" type="text">
        <label for="score" class="label">Score: </label>
        <input name="score" id="score" type="number">
        <input type="submit" value="ADD" class="submit-btn">
    </form>
    <hr>
    <form action="remove-student" method="post">
        <h3 class="form-title">Remove Student</h3>
        <label for="removeID">ID: </label>
        <input name="removeID" id="removeID" type="number">
        <input type="submit" value="REMOVE" class="submit-btn">
    </form>
    <hr>
</div>
<c:if test="${not empty message}">
    <h3 class="status">${message}</h3>
</c:if>
</body>
</html>