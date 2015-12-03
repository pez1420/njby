<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>导航新增</title>

    <link href="${base}/resources/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resources/css/admin/style-responsive.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/scojs.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/sco.message.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${base}/resources/html5shiv.js"></script>
    <script src="${base}/resources/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="frame-content">
    <!--.container-fluid 类用于 100% 宽度，占据全部视口（viewport）的容器-->
    <div class="container-fluid">
        <!-- 页面导航栏 -->
        <div class="row">
            <div class="col-md-12">
                <ul class="breadcrumb">
                    <li><a href="../../../common/overview.jhtml"><i class="fa fa-home"></i> 首页</a></li>
                    <li>添加导航</li>
                </ul>
            </div>
        </div>


        <!-- 主题表格数据 -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-heading">
                       	 基本信息
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" id="inputForm" action="save.jhtml" method="post" role="form">
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">名称</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="name" type="text" placeholder="名称">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">系统内容</label>

                                <div class="col-md-6 col-sm-6">
                                    <select class="form-control input-sm" id="systemUrl">
                                        <option value="">#</option>
                                        <option value="${base}/index.html">首页</option>
                                        <option value="${base}/aboutus.html">关于我们</option>
                                        <option value="${base}/contactus.html">联系我们</option>
                                        <option value="${base}/equipment/list.jhtml">设备管理</option>
                                    
                                        [#list productTypeTree as productType]
											<option value="${base}${productType.path}">
												[#if productType.grade != 0]
													[#list 1..productType.grade as i]
														&nbsp;&nbsp;
													[/#list]
												[/#if]
												${productType.name}
											</option>
										[/#list]
										
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">链接地址</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="url" id="url" type="text" placeholder="链接地址">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">位置</label>

                                <div class="col-md-6 col-sm-6">
                                    <select class="form-control input-sm" name="position">
                                        <option value="0">顶部</option>
                                        <option value="1">中间</option>
                                        <option value="2">底部</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">设置</label>
                                <div class="col-md-6 col-sm-6">
                                    <input type="checkbox" name="isBlankTarget" value="true"> 是否新窗口打开
                                    <input type="hidden" name="_isBlankTarget" value="false"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">排序</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="orders" type="text" placeholder="排序">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                    <a class="btn btn-danger" type="button" href="navigation_view.html">返回</a>
                                    <button class="btn btn-primary" type="submit">保存</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="${base}/resources/jquery-2.1.0.min.js"></script>
<script src="${base}/resources/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${base}/resources/jquery-migrate-1.2.1.min.js"></script>
<script src="${base}/uilib/bootstrap-3/js/bootstrap.min.js"></script>
<script src="${base}/resources/modernizr.min.js"></script>

<script src="${base}/resources/admin/input.js"></script>
<script src="${base}/resources/jquery.validate.min.js"></script>
<script src="${base}/resources/bootbox.min.js"></script>
<script src="${base}/uilib/sco-master/js/sco.message.js"></script>

<script>
    $(document).ready(function () {
        var $inputForm = $("#inputForm");
        var $systemUrl = $("#systemUrl");
        var $url = $("#url");

        // 将选择的系统内容地址填充至链接地址中
        $systemUrl.change(function() {
            $url.val($systemUrl.val());
        });

        // 链接地址内容修改时,系统内容选择框修改为不选择任何项目
        $url.keypress(function() {
            $systemUrl.val("");
        });

        $inputForm.validate({
            rules: {
                name: "required",
                url: "required",
                orders: {
                	required: true,
                	digit: true
                }
            },
            submitHandler: function (form) {
                //跳出验证对话框
                bootbox.confirm({
                    //size: 'small',
                    message: "您确定操作吗?",
                    buttons: {
                        cancel: {
                            label: "取消",
                            className: "btn-default"
                        },
                        confirm: {
                            label: "确定",
                            className: "btn-primary"
                        }
                    },
                    callback: function (result) {
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

</script>


</body>
</html>