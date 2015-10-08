/**
 * Created by Administrator on 2015/4/24.
 */

define(["jquery", "list", "input", "bootstrap", "bootbox"], function($, list, input, bootstrap, bootbox){

    //表单验证以及提交
    var private_validate_input = function(){
        $(function() {
            var $inputForm = $("#inputForm");
            $inputForm.validate({
                rules: {
                    username: {
                        required: true,
                        minlength: 2,
                        maxlength: 20
                    },
                    password: {
                        required: true,
                        minlength: 4,
                        maxlength: 20
                    },
                    rePassword: {
                        required: true,
                        equalTo: "#password"
                    },
                    email: {
                        required: true,
                        email: true
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
//                                $.ajax({
//                                    cache: false,
//                                    type: "POST",
//                                    url: "save.jhtml",
//                                    data: $inputForm.serialize(),
//                                    async: false,
//                                    error: function(request) {
//                                        $.scojs_message("添加失败!", $.scojs_message.TYPE_ERROR);
//                                    },
//                                    success: function(message) {
//                                        console.log("message:", message);
//                                        if (message.type == "success") {
//                                            $.scojs_message("添加成功!", $.scojs_message.TYPE_OK);
//                                        } else {
//                                        	$.scojs_message("添加失败!", $.scojs_message.TYPE_ERROR);
//                                        }
//                                    }
//                                });
                            }
                        }
                    });
                }
            });
        });
    };


    var adminer_viewer_page = function () {
        list.init_list();
    };

    var adminer_add_page = function() {
        private_validate_input();
    };

    var adminer_edit_page = function() {
        private_validate_input();
    };
    return {
        adminer_viewer_page : adminer_viewer_page,
        adminer_add_page    : adminer_add_page,
        adminer_edit_page   : adminer_edit_page
    };
});
