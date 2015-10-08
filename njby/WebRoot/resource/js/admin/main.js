/**
 * 后台管理入口
 * */


 require.config({
    baseUrl : "/njbyv1/resource/js",
    shim : {
    },
    paths : {
        "main"  : "admin/main",     //主模块
        "jquery" : "../jquery-2.1.0.min", //jquery模块
        "bootstrap" : "../../uilib/bootstrap-3/js/bootstrap.min", //bootstrap模块
        "scomessage" : "../../uilib/sco-master/js/sco.message",
        "jqueryvalidate" : "../jquery.validate.min",  //jquery表单验证模块
        "bootbox"    :  "../bootbox.min", //bootbox对话框

        //页面基本操作
        "list" : "admin/common/list",
        "input" : "admin/common/input",

        //系统设置
        "adminer" : "admin/systemset/adminer", //管理员
        "role"    : "admin/systemset/role", //角色
        "log"    : "admin/systemset/log", //日志
        
        //内容管理
        "template" : "admin/content/template",  //模板管理
        "ad"        : "admin/content/ad",  //广告管理
        "adposition" : "admin/content/adposition",  //广告位置
        
        //产品管理
        "producttype"  : "admin/product/producttype", //产品类型	
        "productmgr"   : "admin/product/productmgr", //产品管理
        "notice"   :  "admin/corpindex/notice"         //通告管理
    }
});


define([],function(){
    //管理员列表页面、增加页面、修改页面
    var adminer_viewer_page = function() {
        require([ "adminer" ], function(adminer) {
            adminer.adminer_viewer_page();
        });
    };
    var adminer_add_page = function() {
        require([ "adminer" ], function(adminer) {
            adminer.adminer_add_page();
        });
    };
    var adminer_edit_page = function() {
        require([ "adminer" ], function(adminer) {
            adminer.adminer_edit_page();
        });
    };

    //角色列表页面、增加页面、修改页面
    var role_viewer_page = function() {
        require([ "role" ], function(role) {
            role.role_viewer_page();
        });
    };
    var role_add_page = function() {
        require([ "role" ], function(role) {
            role.role_add_page();
        });
    };
    var role_edit_page = function() {
        require([ "role" ], function(role) {
            role.role_edit_page();
        });
    };

    //日志列表页面、修改页面
    var log_viewer_page = function() {
        require([ "log" ], function(log) {
            log.log_viewer_page();
        });
    };
    var log_edit_page = function() {
        require([ "log" ], function(log) {
            log.log_edit_page();
        });
    };
    
    //模板列表页面、修改页面
    var template_viewer_page = function() {
        require([ "template" ], function(template) {
            template.template_viewer_page();
        });
    };
    var template_edit_page = function() {
        require([ "template" ], function(template) {
            template.template_edit_page();
        });
    };
    
    
    //产品类型列表页面、增加页面、修改页面
    var producttype_viewer_page = function() {
        require([ "producttype" ], function(producttype) {
            producttype.producttype_viewer_page();
        });
    };
    var producttype_add_page = function() {
        require([ "producttype" ], function(producttype) {
            producttype.producttype_add_page();
        });
    };
    var producttype_edit_page = function() {
        require([ "producttype" ], function(producttype) {
            producttype.producttype_edit_page();
        });
    };

    //产品管理列表页面、增加页面、修改页面
    var productmgr_viewer_page = function() {
        require([ "productmgr" ], function(productmgr) {
            productmgr.productmgr_viewer_page();
        });
    };
    var productmgr_add_page = function() {
        require([ "productmgr" ], function(productmgr) {
            productmgr.productmgr_add_page();
        });
    };
    var productmgr_edit_page = function() {
        require([ "productmgr" ], function(productmgr) {
            productmgr.productmgr_edit_page();
        });
    };

    //广告位置 列表页面、增加页面、修改页面
    var adposition_viewer_page = function() {
        require([ "adposition" ], function(adposition) {
            adposition.adposition_viewer_page();
        });
    };
    var adposition_add_page = function() {
        require([ "adposition" ], function(adposition) {
            adposition.adposition_add_page();
        });
    };
    var adposition_edit_page = function() {
        require([ "adposition" ], function(adposition) {
            adposition.adposition_edit_page();
        });
    };
    //广告管理 列表页面、增加页面、修改页面
    var ad_viewer_page = function() {
        require([ "ad" ], function(ad) {
            ad.ad_viewer_page();
        });
    };
    var ad_add_page = function() {
        require([ "ad" ], function(ad) {
            ad.ad_add_page();
        });
    };
    var ad_edit_page = function() {
        require([ "ad" ], function(ad) {
            ad.ad_edit_page();
        });
    };

    //通告管理 列表页面、增加页面、修改页面
    var notice_viewer_page = function() {
        require([ "notice" ], function(notice) {
            notice.notice_viewer_page();
        });
    };
    var notice_add_page = function() {
        require([ "notice" ], function(notice) {
            notice.notice_add_page();
        });
    };
    var notice_edit_page = function() {
        require([ "notice" ], function(notice) {
            notice.notice_edit_page();
        });
    };
    
    return {
        //管理员
        adminer_viewer_page   : adminer_viewer_page,
        adminer_add_page      : adminer_add_page,
        adminer_edit_page     : adminer_edit_page,
        //角色
        role_viewer_page   : role_viewer_page,
        role_add_page      : role_add_page,
        role_edit_page     : role_edit_page,
        //日志
        log_viewer_page   : log_viewer_page,
        log_edit_page     : log_edit_page,
        
        //模板管理
        template_viewer_page   : template_viewer_page,
        template_edit_page     : template_edit_page,
        //广告位置
        adposition_viewer_page   : adposition_viewer_page,
        adposition_add_page      : adposition_add_page,
        adposition_edit_page     : adposition_edit_page,
        //广告管理
        ad_viewer_page   : ad_viewer_page,
        ad_add_page      : ad_add_page,
        ad_edit_page     : ad_edit_page,
        
        //产品类别
        producttype_viewer_page   : producttype_viewer_page,
        producttype_add_page      : producttype_add_page,
        producttype_edit_page     : producttype_edit_page,
        //产品管理
        productmgr_viewer_page   : productmgr_viewer_page,
        productmgr_add_page      : productmgr_add_page,
        productmgr_edit_page     : productmgr_edit_page,
        //通告管理
        notice_viewer_page     :  notice_viewer_page,
        notice_add_page     :  notice_add_page,
        notice_edit_page     :  notice_edit_page
        
    };
});

