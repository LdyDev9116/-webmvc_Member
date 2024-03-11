<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function deleteMember(mid) {

        if (confirm("삭제 요청 확인 Y / N ")) {
            window.location.href = "/member/delMember.do?mid=" + mid;
        }
    }

    function modifyMember(mid) {
        if (confirm("수정 요청 확인 Y / N ")) {
            window.location.href = "/member/modMember.do?mid=" + mid;
        }
    }
</script>

<body>

<table>
    <thead>

    <tr>
        <th><h1>회원목록</h1></th>
    </tr>

    </thead>
</table>
<table border="1">
    <thead style="border-color: burlywood">
    <tr style="background-color: lemonchiffon">
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${memberDTOList}" var="dto">
        <tr>
            <td>${dto.mid}</td>
            <td>${dto.mpw}</td>
            <td>${dto.mname}</td>
            <td>${dto.email}</td>
            <td>${dto.signdate}</td>
            <td><a href="javascript:modifyMember('${dto.mid}')">수정</a></td>
            <td><a href="javascript:deleteMember('${dto.mid}')">삭제</a></td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<table>
    <thead>

    <tr>
        <th><a href="/member/addMember.do">회원 가입하기</a></th>
    </tr>

    </thead>
</table>


</body>
</html>
