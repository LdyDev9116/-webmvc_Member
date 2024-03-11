<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>회원가입</title>

</head>

<body>
<form action="/member/modMember.do" method="post" onsubmit="return confirmModification();">

    <table>
        <thead>
        <tr>
            <th colspan="2">${requestScope.dto.mid}님 정보수정</h3></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>

                <input type="hidden" name="mid" value="${requestScope.dto.mid}">
            </td>
        </tr>
        <tr>
            <td>
                비밀번호
            </td>
            <td>
                <input type="text" placeholder="PASSWORD" name="mpw"
                       value="${not empty param.mpw ? param.mpw : (not empty requestScope.dto.mpw ? requestScope.dto.mpw : '')}">
            </td>
        </tr>
        <tr>
            <td>
                이름
            </td>
            <td>
                <input type="text" placeholder="NAME" name="mname"
                       value="${not empty param.mname ? param.mname : (not empty requestScope.dto.mname ? requestScope.dto.mname : '')}">
            </td>
        </tr>
        <tr>
            <td>
                이메일
            </td>
            <td>
                <input type="email" placeholder="EMAIL" name="email"
                       value="${not empty param.email ? param.email : (not empty requestScope.dto.email ? requestScope.dto.email : '')}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">수정하기</button>
                <button type="reset">다시입력</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>


</body>
</html>
