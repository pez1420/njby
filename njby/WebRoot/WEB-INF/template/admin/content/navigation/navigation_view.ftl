<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>导航管理</title>

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
                    <li>导航列表((共<span id="pageTotal">${page.total}</span>条记录)</li>                    
                </ul>
            </div>
        </div>
        <form id="listForm" action="list.jhtml" method="get">
            <!-- 搜索条件  -->
            <div class="row clearfix">
                <div class="col-md-12">
                    <div class="clearfix">
                        <label>
                            <span style="margin-right: 15px;">导航名称</span>
                            <input type="text" class="form-control input-sm" placeholder="导航名称"
                                   name="name" value="${search.name}"
                                   style="width: 150px; display: inline-block; margin-right: 30px;">
                        </label>
                        <!--
                        <label>
                            <span style="margin-right: 15px;">位置</span>
                            <select class="form-control input-sm" style="width: 150px; display: inline-block; " name="position">
                                <option [#if search.position??] selected="true"[/#if]>所有</option>
                                <option value="0" [#if search.position == 0] selected="true"[/#if]>顶部</option>
                                <option value="1" [#if search.position == 1] selected="true"[/#if]>中间</option>
                                <option value="2" [#if search.position == 2] selected="true"[/#if]>底部</option>
                            </select>
                        </label>-->
                        <button type="submit" class="btn-sm btn btn-info" style="margin-left: 30px;"><i
                                class="fa fa-search"></i>
                           		 查询
                        </button>
                    </div>
                </div>
            </div>

            <!-- 主题表格数据 -->
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            	导航列表
                            <a href="#" class="btn btn-xs btn-warning disabled" id="deleteButton" data-toggle="modal"
                               data-target="#deleteModal" style="margin-left: 30px;">
                                <i class="fa fa-minus-circle"></i> 删除
                            </a>
                            <a href="add.jhtml" class="btn btn-xs btn-info"><i class="fa fa-plus-circle"></i> 添加</a>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-hover table-bordered" id="listTable">
                                <thead>
                                <tr>
                                    <th>
                                        <input type="checkbox" id="selectAll">
                                    </th>
                                    <th>名称</th>
                                    <th>位置</th>
                                    <th>是否新窗口打开</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                [#list page.content as navigation]
	                                <tr>
	                                    <td><input type="checkbox" name="ids" value="${navigation.id}"></td>
	                                    <td>${navigation.name}</td>
	                                    <td>
	                                    	[#if navigation.position == 0]
	                                    		顶部
	                                    	[#elseif navigation.position == 1]
	                                    		中间
	                                    	[#else]
	                                    		底部
	                                    	[/#if]
	                                    
	                                    </td>
	                                    <td>
	                                    	[#if navigation.isBlankTarget]
	                                    		是
	                                    	[#else]
	                                    		否
	                                    	[/#if]
	                                    </td>
	                                    <td>${navigation.orders}</td>
	                                    <td>
	                                        <a href="edit.jhtml?id=${navigation.id}" class="btn btn-info"><i class="fa fa-pencil-square"></i>编辑
	                                        </a>
	                                    </td>
	                                </tr>
	                              [/#list]
                                </tbody>
                            </table>
                            <!-- 分页信息 -->
							[@pagination pageNumber = page.pageNumber totalPages = page.totalPages]
								[#include "/admin/include/pagination.ftl"]
							[/@pagination]

                        </div>
                    </div>
                </div>

            </div>

        </form>



        <!-- 删除记录确认模态框（Modal） -->
        <div class="modal fade" id="deleteModal" aria-hidden="true" aria-labelledby="deleteModalLabel" role="dialog"
             tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal" type="button" aria-hidden="true">×</button>
                        <h4 class="modal-title">
                            <i class="fa fa-exclamation-triangle"></i>
                        </h4>
                    </div>
                    <div class="modal-body">
                         	您确定要删除吗?
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default" data-dismiss="modal" type="button">关闭</button>
                    	<button class="btn btn-warning" id="modalDeleteButton" data-dismiss="modal" type="button"> 确定</button>
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

<script src="${base}/resources/admin/list.js"></script>
<script src="${base}/uilib/sco-master/js/sco.message.js"></script>

<script>

	$(document).ready(function() {
		[@flash_message /]
	});
	
    
</script>

</body>
</html>


