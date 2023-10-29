<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Data</title>
    <style>
        .container {
            margin: 20px;
        }

        #title {
            text-align: center;
            margin-bottom: 20px;
        }

        .table-header {
            display: flex;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .table-row {
            display: flex;
            margin-bottom: 10px;
        }

        .table-cell {
            flex: 1;
            text-align: center;
            border: 1px solid #ccc;
            padding: 10px;
        }

        .no-data {
          text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 id="title">SitSpaceManagement</h1>
    <h3>PAGE :
        <a href="AddRemoveStudent.jsp">ADD/REMOVE Student</a> |
        <a href="#">Show All Data</a> |
    </h3>

    <c:choose>
        <c:when test="${not empty message}">
            <h3 class="no-data">${message}</h3>
        </c:when>
        <c:otherwise>
            <c:forEach items="${allStudent.studentList}" var="student">
                <div class="table-row">
                    <div class="table-cell">${student.id}</div>
                    <div class="table-cell">${student.name}</div>
                    <div class="table-cell">${student.score}</div>
                    <div class="table-cell">${student.grade}</div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>