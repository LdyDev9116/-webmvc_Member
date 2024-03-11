
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Todo List2</h1>
<%--dtoList--%>
<h3>${loginInfo}</h3>
<span style="color: blue"> <h3>로그인 : ${loginInfo.mname} 님 반갑습니다.</h3></span>

<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished ? "DONE" : "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>

<form action="/logout" method="post">
    <button type="submit">로그아웃</button>
</form>
</body>
</html>
