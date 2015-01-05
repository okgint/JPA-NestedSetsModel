/**
 * Created by Jabrik on 09/11/2014.
 */
$(document).ready(function () {
    $("#grid").jqGrid({
        url: '/supplier/list.htm',
        datatype: 'json',
        method: 'GET',
        colNames: ['Id', 'Name',  'Web Site'],
        colModel: [
            {name: 'id', index: 'id', width: 55, editable: false, editOptions: {readOnly: true, size: 10}, hidden: true},
            {name: 'name', index: 'name', width: 100, editable: true, editrules: {required: true}, editOptions: {size: 10}},
            {name: 'webSite', index: 'webSite', width: 100, editable: true, editrules: {required: true}, editOptions: {size: 10}}
        ],
        postData: {
        },
        rowNum: 20,
        rowList:[20,40,60],
        height:200,
        autowidth:true,
        rownumbers:true,
        pager: '#pager',
        sortname : 'id',
        viewrecords: true,
        sortorder : "asc",
        caption: 'Customer',
        emptyrecords: ' Empty Records',
        loadonce: false,
        loadComplete : function() {},
        jsonReader : {
            root: 'rows',
            page : 'page',
            total: 'total',
            records: 'records',
            repeatitems : false,
            cell : 'cell',
            id : 'id'
        }
    });

});