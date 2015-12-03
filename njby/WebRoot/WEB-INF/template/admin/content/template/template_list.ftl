<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>模板管理</title>

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
                    <li>模板列表</li>
                </ul>
            </div>
        </div>

        <form id="listForm" action="#" method="get">

            <!-- 主题表格数据 -->
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            	模板列表
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-hover table-bordered" id="listTable">
                                <thead>
	                                <tr>
	                                    <th>名称</th>
	                                    <th>类型</th>
	                                    <th>模板文件路径</th>
	                                    <th>描述</th>
	                                    <th>操作</th>
	                                </tr>
                                </thead>
                                <tbody>
                                [#list templates as template]
	                                <tr>
	                                    <td>${template.name}</td>
	                                    <td>[#if template.type == 0] 
	                                    			页面模板
	                                    	[#elseif template.type == 1]
	                                    			邮件模板
	                                    	[#else]
	                                    	   		打印模板
	                                    	 [/#if]             
	                                    </td>
	                                    <td>${template.templatePath}</td>
	                                    <td>
	                                    	[#if template.description??]
												<span title="${template.description}">${abbreviate(template.description, 50, "...")}</span>
											[/#if]
										</td>
	                                    <td>
	                                        <a href="edit.jhtml?id=${template.id}" class="btn btn-info"><i
	                                                class="fa fa-pencil-square"></i>编辑
	                                        </a>
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
        main.template_viewer_page();
    });
</script>

</body>
</html>