<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <table>
        <thead>
            <td>A</td>
            <td>B</td>
            <td>C</td>
            <td>D</td>
        </thead>
        <tbody>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>
                        <c:out value="${item.getA()}"/>
                    </td>
                    <td>
                        <c:out value="${item.getB()}"/>
                    </td>
                    <td>
                        <c:out value="${item.getC()}"/>
                    </td>
                    <td>
                        <c:out value="${item.getD()}"/>
                    </td>
                </tr>
            </c:forEach>
         </tbody>
    </table>
    </br>
    <form action="${pageContext.request.contextPath}/s" method="post">
        <p>A
        <input type="number" name="A" /></p>

        <p>B
        <input type="number" name="B" /></p>

        <input type="submit" name="submit" value="submit" /></p>
    </form>
</body>
</html>