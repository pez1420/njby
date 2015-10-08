<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>角色新增</title>

    <link href="${base}/resources/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resources/css/admin/style-responsive.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/scojs.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/sco.message.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${base}/resources/html5shiv.js"></script>
    <script src="${base}/resources/respond.min.js"></script>
    <![endif]-->

    <style type="text/css">
        .authorities label {
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
                    <li>添加角色</li>
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
                                <label class="col-md-2 col-sm-2 control-label">角色名</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="name" type="text" placeholder="角色名称">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">描述</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="description" type="text" placeholder="角色描述">
                                </div>
                            </div>

                            <div class="form-group authorities">
                                <label class="col-md-2 col-sm-2 control-label">
                                    <a href="#" class="selectAll" title="系统设置全选">系统设置</a>
                                </label>

                                <div class="col-md-6 col-sm-6">
                                    <label><input type="checkbox" name="authorities" value="admin:admin"> 管理员管理
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:role"> 角色管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:log"> 日志管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:sysemset"> 系统设置
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:11"> 管理员管理
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:12"> 角色管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:13"> 日志管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:14"> 系统设置
                                    </label>

                                </div>
                            </div>


                            <div class="form-group authorities">
                                <label class="col-md-2 col-sm-2 control-label">
                                    <a href="#" class="selectAll" title="系统设置全选">內容管理</a>
                                </label>

                                <div class="col-md-6 col-sm-6">
                                    <label><input type="checkbox" name="authorities" value="admin:15"> 管理员管理
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:16"> 角色管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:17"> 日志管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:18"> 系统设置
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:19"> 管理员管理
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:20"> 角色管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:21"> 日志管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:22"> 系统设置
                                    </label>

                                </div>
                            </div>

                            <div class="form-group authorities">
                                <label class="col-md-2 col-sm-2 control-label">
                                    <a href="#" class="selectAll" title="系统设置全选">內容管理</a>
                                </label>

                                <div class="col-md-6 col-sm-6">
                                    <label><input type="checkbox" name="authorities" value="admin:51"> 管理员管理
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:61"> 角色管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:71"> 日志管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:81"> 系统设置
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:91"> 管理员管理
                                    </label>
                                    <label><input type="checkbox" name="authorities" value="admin:80"> 角色管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:81"> 日志管理 </label>
                                    <label><input type="checkbox" name="authorities" value="admin:82"> 系统设置
                                    </label>

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
    var private_validate_input = function () {
        $(function () {
            var $inputForm = $("#inputForm");
            $inputForm.validate({
                rules: {
                    name: {
                        required: true
                    },
                    authorities: {
                        required: true
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

    };

    $(document).ready(function () {
        var $inputForm = $("#inputForm");
        var $selectAll = $("#inputForm .selectAll");
		
		[@flash_message /]
	
        //角色某项全选
        $selectAll.click(function () {
            var $this = $(this);
            /*closest() 方法获得匹配选择器的第一个祖先元素，
            	从当前元素开始沿 DOM 树向上closest() 方法获得匹配选择器的第一个祖先元素，
             	从当前元素开始沿 DOM 树向上*/
            var $thisCheckbox = $this.closest("div").find(":checkbox");
            if ($thisCheckbox.filter(":checked").size() > 0) {
                $thisCheckbox.prop("checked", false);
            } else {
                $thisCheckbox.prop("checked", true);
            }
            return false;
        });

        private_validate_input();
        //表单验证
    });

</script>

</body>
</html>