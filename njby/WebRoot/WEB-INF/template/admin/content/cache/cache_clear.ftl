<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>清空缓存</title>

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
                    <li><a href="../../../common/overview.jhtml"><i class="fa fa-home"></i> 首页</a></li>
                    <li>清空缓存</li>
                </ul>
            </div>
        </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" id="inputForm" action="clear.jhtml" method="post" role="form">
                                <table class="table table-striped table-hover table-bordered">
                                    <tr>
                                        <th>
                                            	缓存数:
                                        </th>
                                        <td>
                                            ${cacheSize}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            	可用内存:
                                        </th>
                                        <td>
											[#if maxMemory?? && totalMemory?? && freeMemory??]
												${(maxMemory - totalMemory + freeMemory)?string("0.##")}MB
											[#else]
												-
											[/#if]
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                                                                                            缓存文件路径:
                                        </th>
                                        <td>
                                            ${diskStorePath}
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            &nbsp;
                                        </th>
                                        <td>
                                            <button  class="btn btn-primary"  type="submit" >确定</button>
                                            <a class="btn btn-danger" href="../../../common/overview.jhtml">返回</a>

                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>

            </div>



    </div>
</div>

<!-- Placed js at the end of the document so the pages load faster -->
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
        //main.adminer_viewer_page();
    });
</script>

</body>
</html>


