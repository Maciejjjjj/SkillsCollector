<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Twoja stara
  Date: 2019-10-13
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>
</header>
<h1>Register new user</h1>
<section>
    <div>
        <form method="post" action="/register">

            <fieldset>
                <legend>Registration</legend>
                <p>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required/>
                </p>

                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required/>
                </p>

                <p>
                    <label for="firstname">Firstname</label>
                    <input type="firstname" id="firstname" name="firstname"/>
                </p>

                <p>
                    <label for="lastname">Lastname</label>
                    <input type="lastname" id="lastname" name="lastname"/>
                </p>

            </fieldset>

            <p>
                <input type="submit" value="Register"/>
            </p>
            <c:if test="${error !=null}">
                <p>
                    ${error}
                </p>
            </c:if>
        </form>
    </div>
</section>
</body>
</html>
