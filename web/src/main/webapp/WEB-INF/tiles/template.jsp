<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title>
        <tiles:getAsString name="title"> </tiles:getAsString>
    </title>

    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/bootstrap.js"></script>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/bootstrap-datepicker.js"></script>
    <link type="text/css" href="/css/datepicker3.css" rel="stylesheet"/>
    <link type="text/css" href="/css/cover.css" rel="stylesheet"/>
    <style>

        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }


    </style>

</head>
<body>

<tiles:insertAttribute name="nav"/>
<tiles:insertAttribute name="body"/>

<div id="footer">

</div>
</body>
</html>