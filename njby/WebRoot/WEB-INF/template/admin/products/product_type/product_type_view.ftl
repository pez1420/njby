<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>产品类别</title>

    <link href="${base}/resource/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resource/css/admin/style-responsive.css" rel="stylesheet">
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
                    <li>产品类别列表(共<span id="pageTotal">200</span>条记录)</li>
                </ul>
            </div>
        </div>

        <form id="listForm" action="product_type_view.jhtml" method="get">
            <!-- 主题表格数据 -->
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            	产品类别列表
                            <a href="add.jhtml" class="btn btn-xs btn-info">
                            	<i class="fa fa-plus-circle"></i> 添加</a>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-hover table-bordered" id="listTable">
                                <thead>
                                    <tr>
                                        <th>类别名称</th>
                                        <th>等级</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	[#list productTypeTree as productType]
											<tr>
												<td>
													<span style="margin-left: ${productType.grade * 20}px;[#if productType.grade == 0] color: #000000;[/#if]">
														${productType.name}
													</span>
												</td>
												<td>
													${productType.grade}
												</td>
												<td>
												    <a href="#" class="btn btn-search">
		                                                <i class="fa fa-search"></i>查看
		                                            </a>
		                                            <a href="edit.jhtml?id=${productType.id}" class="btn btn-info">
		                                            	<i class="fa fa-pencil-square"></i>编辑
		                                            </a>
		                                            <a href="#" class="btn btn-warning" val="${productType.id}">
		                                                <i class="fa fa-minus-circle"></i>删除
		                                            </a>
													<!--
														<a href="${base}${productType.path}" target="_blank">
															[${message("admin.common.view")}]
														</a>11
													-->
												</td>
											</tr>
									[/#list]
		
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </form>


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
        main.producttype_viewer_page();
    });
</script>

</body>
</html>