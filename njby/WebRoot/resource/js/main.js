/**
 * Created by Administrator on 2015/4/1.
 */

require.config({
    baseUrl : "/njbyv1/resource",
    shim : {
        "fancybox" : {
            exports: 'fancybox'
        },
        "fancyboxbutton": {
            deps: ["fancybox", "jquery"],
            exports: "fancyboxbutton"
        }
    },
    paths : {
        "main"  : "js/main",
        "jquery" : "jquery-2.1.0.min",
        "bootstrap" : "../uilib/bootstrap-3/js/bootstrap.min",

         //首页
        "home" : "js/home/home",
        //在线咨询
        "online" : "js/common/online",
        //产品中心
        "product" : "js/service/product",

        
        "slider" : "responsiveslides.min",
        "fancybox" : "../uilib/fancybox/source/jquery.fancybox",
        "fancyboxbutton" : "../uilib/fancybox/source/helpers/jquery.fancybox-buttons"

    }
});


define([],function(){
    //首页
    var init_home_page = function() {
        require([ "home" ], function(home) {
            home.init_page();
        });
    };

    //产品中心
    var init_product_page = function() {
        require([ "product" ], function(product) {
            product.init_page();
        });
    };

    return {
        init_home_page      : init_home_page,
        init_product_page   : init_product_page
    };
});

