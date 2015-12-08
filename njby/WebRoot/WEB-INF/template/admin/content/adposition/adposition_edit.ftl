<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>广告位置编辑</title>

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
                    <li>编辑广告位置</li>
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
                        <form class="form-horizontal" id="inputForm" action="update.jhtml" method="post" role="form">
                            <input type="hidden" name="id" value="${adPosition.id}" />
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">名称</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="name" value="${adPosition.name}" type="text" placeholder="名称">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">宽度</label>
                                <div class="col-md-6 col-sm-6">
									<input class="form-control" name="width" value="${adPosition.width}" type="text" placeholder="宽度">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">高度</label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="height" value="${adPosition.height}" type="text" placeholder="高度">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">描述</label>
                                <div class="col-md-6 col-sm-6">
									<input class="form-control" name="description" value="${adPosition.description}" type="text" placeholder="描述">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">模板</label>
                                <div class="col-md-6 col-sm-6">
									 <textarea name="template" style="width: 100%; height: 100px; padding: 0px;">${adPosition.template}
									 </textarea>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                    <a class="btn btn-danger" type="button" href="list.jhtml">返回</a>
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

        $inputForm.validate({
            rules: {
                name: "required",
                width: {
                	required: true,
                	digit: true
                },
                height: {
                	required: true,
                	digit: true
                },
                template: "required"
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