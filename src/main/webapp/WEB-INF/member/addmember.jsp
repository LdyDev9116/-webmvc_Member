
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>회원가입</title>

</head>
<body>
<form action="/member/addMember.do" method="post">
    <table>
        <thead>
        <tr>
            <th colspan="2"><h1>회원가입</h1></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                아이디
            </td>
            <td>
                <input type="text" placeholder="ID" name="mid">
            </td>
        </tr>
        <tr>
            <td>
                비밀번호
            </td>
            <td>
                <input type="password" placeholder="PASSWORD" name="mpw">
            </td>
        </tr>
        <tr>
            <td>
                이름
            </td>
            <td>
                <input type="text" placeholder="NAME" name="mname">
            </td>
        </tr>
        <tr>
            <td>
                이메일
            </td>
            <td>
                <input type="email" placeholder="EMAIL" name="email">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">가입하기</button>
                <button type="reset">다시입력</button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
