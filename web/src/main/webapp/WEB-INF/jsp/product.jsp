<%--
  Created by IntelliJ IDEA.
  User: Jabrik
  Date: 09/11/2014
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<br /><br /><br/>
<div class="container">
    <div class="col-md-12">
        <h1>Product Form</h1>
        <sf:form cssClass="form-horizontal" commandName="product" method="post" action="/product/add.htm">

            <div class="form-group">
                <sf:label path="name" for="name" cssClass="control-label col-sm-2">Name </sf:label>
                <div class="col-sm-6">
                    <sf:input path="name" cssClass="form-control"/>
                    <sf:errors path="name" cssClass="error"/>
                </div>
            </div>

            <div class="form-group">
                <sf:label path="price" for="price" cssClass="control-label col-sm-2">Price </sf:label>
                <div class="col-sm-6">
                    <sf:input path="price" cssClass="form-control"/>
                    <sf:errors path="price" cssClass="error"/>
                </div>
            </div>

            <div class="form-group">
                <sf:label path="active" cssClass="control-label col-sm-2">Active?</sf:label>
                <div class="col-sm-6">
                    <sf:label path="active" cssClass="radio-inline"><sf:radiobutton path="active"
                                                                                    value='Y'/>Yes
                    </sf:label>

                    <sf:label path="active" cssClass="radio-inline">
                        <sf:radiobutton path="active" value='N'/>No
                    </sf:label>
                </div>
            </div>


            <div class="form-group">
                <sf:label path="productTypesId" cssClass="control-label col-sm-2">ProductTypesId</sf:label>
                <div class="col-sm-6">
                    <sf:select path="productTypesId" cssClass="form-control">
                        <c:forEach var="pt" items="${product_types}">
                        <sf:option path="productTypesId" value="${pt.id}" />
                        </c:forEach>

                    </sf:select>

                </div>
            </div>


            <%--SUBMIT --%>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-default">Clear</button>
                </div>
            </div>

        </sf:form>
    </div>
</div>
