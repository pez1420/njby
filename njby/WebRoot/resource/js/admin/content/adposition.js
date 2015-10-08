/**
 * Created by Administrator on 2015/5/29.
 */

/**
 * Created by Administrator on 2015/5/29.
 */


define(["jquery", "list", "input", "bootstrap", "bootbox", "scomessage"],
    function($, list, input, bootstrap, bootbox, scomessage){
        //表单验证以及提交
        var private_validate_input = function(){
            $(function() {
                var $inputForm = $("#inputForm");
                $inputForm.validate({
                    rules: {
                        content: {
                            required: true
                        }
                    },
                    submitHandler:function(form){
                        //跳出验证对话框
                        bootbox.confirm({
                            //size: 'small',
                            message: "您确定操作吗?",
                            buttons: {
                                cancel: {
                                    label: "取消",
                                    className: "btn-default"
                                },
                                confirm : {
                                    label: "确定",
                                    className: "btn-primary"
                                }
                            },
                            callback: function(result){
                                console.log("result :", result);
                                if (result) {
                                    console.log("form_serialize:", $inputForm.serialize());
                                    form.submit();
                                }
                            }
                        });
                    }
                });
            });

        };

        var adposition_viewer_page = function () {
            list.init_list();
        };

        var adposition_add_page = function() {
            private_validate_input();
        };

        var adposition_edit_page = function() {
            private_validate_input();
        };

        return {
            adposition_viewer_page : adposition_viewer_page,
            adposition_add_page    : adposition_add_page,
            adposition_edit_page   : adposition_edit_page
        };
    });

