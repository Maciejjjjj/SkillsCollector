<%--
  Created by IntelliJ IDEA.
  User: Twoja stara
  Date: 2019-10-13
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Main menu</title>
</head>
<body>
<tr>
    <td>
        <c:url var="userSkills" value="/user/skills"/>
        <a href="${userSkills}">User skills</a>
    </td>
    <td>
        <c:url var="register" value="/register"/>
        <a href="${register}">Register</a>
    </td>
    <td>
        <c:url var="login" value="/login"/>
        <a href="${login}">Login</a>
    </td>
</tr>
</body>
</html>
