<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>模板编辑</title>

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
                    <li>编辑模板</li>
                </ul>
            </div>
        </div>


        <!-- 主题表格数据 -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-heading">
                        	模板内容
                    </div>
                    <div class="panel-body">
                        <form  class="form-horizontal" id="inputForm" action="update.jhtml" method="post" role="form">
                            <input type="hidden" name="id" value="${template.id}" />
                            <div class="form-group">
                                <div class="col-md-12">
                                    <textarea name="content" style="width: 100%; height: 500px; padding: 0px;">${content}</textarea>
                                 </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
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
<script src="${base}/resource/jquery-2.1.0.min.js"></script>
<script src="${base}/resource/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${base}/resource/jquery-migrate-1.2.1.min.js"></script>
<script src="${base}/uilib/bootstrap-3/js/bootstrap.min.js"></script>
<script src="${base}/uilib/sco-master/js/sco.message.js"></script>
<script src="${base}/resource/modernizr.min.js"></script>
<script src="${base}/resource/require/require.js"></script>

<script>
	$(function() {
		[@flash_message /]
	});
	
    require(["${base}/resource/js/admin/main.js"], function (main) {
        main.template_edit_page();
    });
</script>

</body>
</html>