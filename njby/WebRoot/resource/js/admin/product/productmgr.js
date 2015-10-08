/**
 * Created by Administrator on 2015/5/10.
 */
define(["jquery", "list", "input", "bootstrap", "bootbox"],
        function($, list, input, bootstrap, bootbox){
    var productmgr_viewer_page = function () {
        list.init_list();
    };

    var productmgr_add_page = function() {

        $(function(){

            var $inputForm = $("#inputForm");
            $inputForm.validate({
                rules: {
                    name: {
                        required: true
                    },
                    productTypeId: {
                        required: true
                    },
                    price: {
                        required : true
                    },
                    introduction : {
                        required : true
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

    var productmgr_edit_page = function() {

    };
    
    return {
        productmgr_viewer_page : productmgr_viewer_page,
        productmgr_add_page    : productmgr_add_page,
        productmgr_edit_page   : productmgr_edit_page
    };
});
