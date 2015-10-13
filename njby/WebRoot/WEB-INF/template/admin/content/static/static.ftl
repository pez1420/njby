<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>生成静态页面</title>

    <link href="${base}/resources/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resources/css/admin/style-responsive.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/scojs.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/sco.message.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${base}/resource/html5shiv.js"></script>
    <script src="${base}/resource/respond.min.js"></script>
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
                    <li><a href="../../system_overview/overview.html"><i class="fa fa-home"></i> 首页</a></li>
                    <li>生成静态</li>
                </ul>
            </div>
        </div>


        <!-- 主题表格数据 -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-heading">
                       	 生成静态页面
                    </div>
                    <div class="panel-body">
                        <form  class="form-horizontal" id="inputForm" action="build.jhtml" method="post" role="form">

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">生成类型</label>
                                <div class="col-md-6 col-sm-6">
                                    <select class="form-control input-sm" id="buildType" name="buildType">
                                        <option value="0">首页</option>
                                        <option value="1">关于我们</option>
                                        <option value="2">联系我们</option>
                                        <option value="-1">所有</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">每次生成数</label>
                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" name="count" type="text" placeholder="生成数目" value="50">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                    <a class="btn btn-danger" type="button" href="adminer_view.html">返回</a>
                                    <button  class="btn btn-primary"  type="submit" >确定</button>
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

<script src="${base}/uilib/sco-master/js/sco.message.js"></script>

<script>
	$(function() {
		[@flash_message /]
	});

</script>

</body>
</html>