/**
 * Created by Administrator on 2015/4/24.
 */

define(["jquery", "list", "input"], function($, list, input){
    var role_viewer_page = function () {
        list.init_list();
    };

    var role_add_page = function() {
        $(function(){
            var $inputForm = $("#inputForm");
            var $selectAll = $("#inputForm .selectAll");

            //角色某项全选
            $selectAll.click(function() {
                var $this = $(this);
                /*closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上*/
                var $thisCheckbox = $this.closest("div").find(":checkbox");
                if ($thisCheckbox.filter(":checked").size() > 0) {
                    $thisCheckbox.prop("checked", false);
                } else {
                    $thisCheckbox.prop("checked", true);
                }
                return false;
            });

            //表单验证
        });
    };

    var role_edit_page = function() {

    };
    return {
        role_viewer_page : role_viewer_page,
        role_add_page    : role_add_page,
        role_edit_page   : role_edit_page
    };
});
