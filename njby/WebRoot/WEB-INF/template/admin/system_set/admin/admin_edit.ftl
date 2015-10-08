<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>管理员编辑</title>

    <link href="${base}/resources/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resources/css/admin/style-responsive.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/scojs.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/sco.message.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${base}/resource/html5shiv.js"></script>
    <script src="${base}/resource/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
        .roles label {
            min-width: 120px;
            _width: 120px;
            display: block;
            float: left;
            padding-right: 4px;
            _white-space: nowrap;
        }
    </style>    
    
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
                    <li>编辑管理员</li>
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
                        <form  class="form-horizontal" id="inputForm" action="update.jhtml" method="post" role="form">
                            <input type="hidden" name="id" value="${admin.id}" />
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">用户名</label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="username" type="text" placeholder="用户名" value="${admin.username}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">密码</label>
                                <div class="col-md-6 col-sm-6">
                                    <input type="password" id="password" name="password" placeholder="密码" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">确认密码</label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="rePassword" type="password" placeholder="确认密码" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">邮箱</label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" id="email" name="email"  placeholder="邮箱" value="${admin.email}">
                                </div>
                            </div>

                           <div class="form-group roles">
                                <span class="col-md-2 col-sm-2 control-label">角色</span>

                                <div class="col-md-6 col-sm-6">
									[#list roles as role]
										<label>
											<input type="checkbox" name="roleIds" value="${role.id}"[#if admin.roles?seq_contains(role)] checked="checked"[/#if] />${role.name}
										</label>
									[/#list]

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">设置</label>
                                <div class="col-md-6 col-sm-6">
                                    <input type="checkbox" name="isEnabled" value="true" [#if admin.isEnabled] checked="checked" [/#if] /> 是否启用
                                	<input type="hidden" name="_isEnabled" value="false" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                    <a class="btn btn-danger" type="button" href="list.jhtml">返回</a>
                                    <button type="submit" class="btn btn-primary">确定</button>
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
                username: {
                    required: true,
                    minlength: 2,
                    maxlength: 20
                },
                email: {
                    required: true,
                    email: true
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