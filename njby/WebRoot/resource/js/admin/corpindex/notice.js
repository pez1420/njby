/**
 * Created by Administrator on 2015/6/1.
 */

define(["jquery", "list", "input", "bootstrap", "bootbox", "scomessage"],
    function($, list, input, bootstrap, bootbox, scomessage){
        //表单验证以及提交
        var private_validate_input = function(){
            $(function() {
                var $inputForm = $("#inputForm");
                $inputForm.validate({
                    rules: {
                        title : "required"
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

        var notice_viewer_page = function () {
            list.init_list();
        };

        var notice_add_page = function() {
            private_validate_input();
        };

        var notice_edit_page = function() {
            private_validate_input();
        };

        return {
            notice_viewer_page : notice_viewer_page,
            notice_add_page   : notice_add_page,
            notice_edit_page  : notice_edit_page

        };
    });

