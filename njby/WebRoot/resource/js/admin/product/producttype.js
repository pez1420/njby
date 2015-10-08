/**
 * Created by Administrator on 2015/4/24.
 */

define(["jquery", "list", "input"], function($, list, input){
    var producttype_viewer_page = function () {
        list.init_list();
    };

    var producttype_add_page = function() {

    };

    var producttype_edit_page = function() {

    };
    return {
        producttype_viewer_page : producttype_viewer_page,
        producttype_add_page    : producttype_add_page,
        producttype_edit_page   : producttype_edit_page
    };
});

