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
    <link rel="stylesheet" href="/css/jquery-ui.css" type="text/css"/>
    <link rel="stylesheet" href="/css/ui.jqgrid.css" type="text/css"/>
    <link rel="stylesheet" href="/css/fuelux.css" type="text/css"/>
    <link rel="stylesheet" href="/css/bootstrap-table.min.css" type="text/css"/>
    <link rel="stylesheet" href="/css/fancytree/skin-lion/ui.fancytree.min.css" type="text/css"/>

    <script type="text/javascript" src="/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/js/i18n/grid.locale-en.js"></script>
    <script type="text/javascript" src="/js/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="/js/amplify.js"></script>
    <script type="text/javascript" src="/js/fuelux.js"></script>
    <script type="text/javascript" src="/js/underscore.js"></script>
    <script type="text/javascript" src="/js/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-table-flatJSON.js"></script>
    <script type="text/javascript" src="/js/jquery.fancytree-all.min.js"></script>


</head>
<body>
<tiles:insertAttribute name="nav"/>
<tiles:insertAttribute name="body"/>

<div id="footer">

</div>
</body>
</html>