/**
 * Created by Administrator on 2015/6/16.
 */



$(document).ready( function() {
    /*页面*/
    var $listForm = $("#listForm");
    var $pageTotal = $("#pageTotal");
    var $deleteButton = $("#deleteButton");
    var $listTable = $("#listTable");
    var $selectAll = $("#selectAll");
    var $ids = $("#listTable input[name='ids']");
    var $contentRow = $("#listTable tr:gt(0)");
    var $pageSize = $("#pageSize");
    var $pageNumber = $("#pageNumber");
    var $modalDeleteButton = $("#modalDeleteButton");

    // 点击模态对话框删除按钮
    $modalDeleteButton.click(function () {
        var $this = $(this);
        var $checkedIds = $("#listTable input[name='ids']:enabled:checked");
        $.ajax({
            url: "delete.jhtml",
            type: "POST",
            data: $checkedIds.serialize(),
            dataType: "json",
            cache: false,
            success: function (message) {
                if (message.type == "success") {
                    $.scojs_message("删除成功!", $.scojs_message.TYPE_OK);
                    $pageTotal.text(parseInt($pageTotal.text()) - $checkedIds.size());
                    $checkedIds.closest("tr").remove();
                    window.setTimeout(function () {
                        window.location.reload(true);
                    }, 1000);
//                    if ($listTable.find("tr").size() > 1) {
//                        window.setTimeout(function () {
//                            window.location.reload(true);
//                        }, 3000);
//                    }
                } else {
                    $.scojs_message("删除失败!", $.scojs_message.TYPE_ERROR);
                }
                $deleteButton.addClass("disabled");
                $selectAll.prop("checked", false);
                $checkedIds.prop("checked", false);
            },
            error: function (e) {
                console.log("error:", e);
            }
        });
    });

    // 全选
    $selectAll.click(function () {
        var $this = $(this);
        var $enabledIds = $("#listTable input[name='ids']:enabled");
        if ($this.prop("checked")) {
            $enabledIds.prop("checked", true);
            if ($enabledIds.filter(":checked").size() > 0) {
                $deleteButton.removeClass("disabled");
                //$contentRow.addClass("selected"); //被选上的行增加特殊颜色
            } else {
                $deleteButton.addClass("disabled");
            }
        } else {
            $enabledIds.prop("checked", false);
            $deleteButton.addClass("disabled");
            //$contentRow.removeClass("selected");
        }
    });

    // 选择
    $ids.click(function () {
        var $this = $(this);
        if ($this.prop("checked")) {
            //$this.closest("tr").addClass("selected");
            $deleteButton.removeClass("disabled");
        } else {
            //$this.closest("tr").removeClass("selected");
            if ($("#listTable input[name='ids']:enabled:checked").size() > 0) {
                $deleteButton.removeClass("disabled");
            } else {
                $deleteButton.addClass("disabled");
            }
        }
    });

    // 页码输入
    $pageNumber.keypress(function (event) {
        var key = event.keyCode ? event.keyCode : event.which;
        if ((key == 13 && $(this).val().length > 0) || (key >= 48 && key <= 57)) {
            return true;
        } else {
            return false;
        }
    });

    // 表单提交
    $listForm.submit(function () {
        if (!/^\d*[1-9]\d*$/.test($pageNumber.val())) {
            $pageNumber.val("1");
        }
    });

    //页码跳转
    $(".pageno").click(function () {
        var $this = $(this);
        $pageNumber.val($this.attr('skip'));
        $listForm.submit();
        return false;
    });

});

