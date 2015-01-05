<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<br/><br/><br/>

<script language="javascript">
    <tiles:insertAttribute name="scriptFile"/>
</script>
<table  data-toggle="table" data-url="/product/listJson.htm" data-show-refresh="true"
       data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1">
    <thead>
    <tr>
        <th data-field="state" data-radio="true">Item ID</th>
        <th data-field="id">ProductType Id</th>

        <th data-field="name">ProductType</th>
        <th data-field="products">Product ID</th>
        <th data-field="products" data-formatter="nameFormatter">ProductsName</th>
        <th data-field="products" data-formatter="priceFormatter">Price</th>
    </tr>
    </thead>
</table>

<script>
    function idFormatter(value, row, index) {
        var data = value;

        for(var i in data)
        {
            var id = data[i].id;
            var name = data[i].name;
        }
        return id;
    }

    function nameFormatter(value, row, index) {
        var data = value;

        for(var i in data)
        {
            var id = data[i].id;
            var name = data[i].name;
        }
        return name;
    }

    function priceFormatter(value, row, index) {
        var data = value;

        for(var i in data)
        {
            var id = data[i].id;
            var price = data[i].price;
        }
        return price;
    }

</script>

<div id="tree">

</div>