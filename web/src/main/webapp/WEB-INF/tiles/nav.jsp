<%--
  Created by IntelliJ IDEA.
  User: Jabrik
  Date: 09/11/2014
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand">Spring MVC</a>
        </div>

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <%--<li><a href="${pageContext.request.contextPath}/welcome.htm">Home</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/product.htm">Add New Product</a></li>

            </ul>

            <div>
                <c:if test="${sessionScope.username != null}">
                    <p class="navbar-text navbar-right">Signed in as ${username}</p>
                </c:if>

            </div>
            <%--<form class="navbar-form pull-right">--%>
            <%--<input type="text" class="span2" placeholder="Username">--%>
            <%--<input type="text" class="span2" placeholder="Password">--%>
            <%--<input type="submit" value="Login" class="btn"/>--%>
            <%--</form>--%>
        </div>

    </div>
</nav>