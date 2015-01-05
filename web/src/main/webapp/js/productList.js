$(document).ready(function () {
    var data = [
        {title: "148", key: "1"},
        {
            title: "121", key: "2", folder: true, children: [
            {title: "Node 2.1", key: "3", myOwnAttr: "abc"},
            {title: "Node 2.2", key: "4"}
        ]
        }
    ];

    $("#tree").fancytree(
        {
            source: {
                url: "/product/listJson.htm",
                cache: false
            },
            postProcess: function (event, data) {
                var d = data.response;
                var hasil = [];
                var hasilta = [];

                for (var i in d) {
                    var id = d[i].id;
                    var name = d[i].name;
                    var products = d[i].products;
                    for (var j in products) {
                        var productName = products[j].name;
                        var productPrice = products[j].price;
                        var productId = products[j].id;
                        hasilta.push({title:productId + "-" +  productName + ":"  + productPrice});
                    }
                    hasil.push({
                        title: id + "-" + name, folder: true, children:hasilta

                    });

                }
                // assuming the ajax resonse contains a list of child nodes:
                //data.response[0].title = " - hello from postProcess";
                data.result = hasil;
            },            // end prosessor
            checkbox: true,
            postProcessku: function (event, data) {
                var d = data.response;
                var dSize = data.response.length;
                console.log(dSize);
                var hasil = [];
                var hasilta = [];

                for (var i in d) {
                    var id = d[i].id;
                    var name = d[i].name;
                    var products = d[i].products;
                    for (var j in products) {
                        var productName = products[j].name;
                        var productPrice = products[j].price;
                        var productId = products[j].id;
                        hasilta.push({title:productId, folder : true, children : [{title: productName}, {title: productPrice}]});
                    }
                    hasil.push({
                        title: id, folder: true, children: [{title: name},
                            {
                                title: productId,
                                folder: true,
                                children: hasilta
                            }
                        ]
                    });

                }
                // assuming the ajax resonse contains a list of child nodes:
                //data.response[0].title = " - hello from postProcess";
                data.result = hasil;
            } // end prosessku
        }
    );
});