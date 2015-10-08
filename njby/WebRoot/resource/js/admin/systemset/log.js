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

        var log_viewer_page = function () {
            list.init_list();
        };


        var log_edit_page = function() {
            private_validate_input();
        };

        return {
            log_viewer_page : log_viewer_page,
            log_edit_page   : log_edit_page
        };
    });

