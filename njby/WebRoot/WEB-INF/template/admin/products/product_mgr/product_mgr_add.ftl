<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>产品管理</title>

    <link href="${base}/resource/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resource/css/admin/style-responsive.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/scojs.css" rel="stylesheet">
    <link href="${base}/uilib/sco-master/css/sco.message.css" rel="stylesheet">
    <link href="${base}/uilib/bootstrap-fileupload/css/bootstrap-fileupload.min.css" rel="stylesheet">
        
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
                    <li><a href="#">添加产品</a></li>
                </ul>
            </div>
        </div>


        <!-- 主题表格数据 -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-heading ">
                            	产品基本信息
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" id="inputForm" action="save.jhtml" method="post"  role="form"
                              enctype="multipart/form-data">

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">产品分类</label>

                                <div class="col-md-6 col-sm-6">
                                    <select class="form-control" name="productTypeId">
										[#list productTypeTree as productType]
											<option value="${productType.id}">
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
                                <label class="col-md-2 col-sm-2 control-label">名称</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="name" placeholder="名称">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">编号</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="sn" placeholder="编号(留空系统自动生成)">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">销售价</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="price" placeholder="销售价">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">库存</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="stock" placeholder="库存">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">备注</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="remark" placeholder="备注">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">搜索关键词</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="keyword" placeholder="搜索关键词">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">页面标题</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="seoTitle" placeholder="页面标题">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">页面关键词</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="seoKeywords" placeholder="页面关键词">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">页面描述</label>

                                <div class="col-md-6 col-sm-6">
                                    <input class="form-control" type="text" name="seoDescription" placeholder="页面描述">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">设置</label>

                                <div class="col-md-6 col-sm-6">
                                    <input type="checkbox" name="isMarketable" value="true" checked="checked"> 是否上架
                                    <input type="hidden" name="_isMarketable" value="false">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">产品介绍</label>

                                <div class="col-md-6 col-sm-6">
                                    <textarea class="form-control" name="introduction"
                                              placeholder="产品介绍"></textarea>
                                </div>
                            </div>

							<!--
                            <div class="form-group ">
                                <label class="col-md-2 col-sm-2 control-label">产品图片</label>
                                <div class="col-md-6 col-sm-6">
                                    <div class="fileupload fileupload-new" data-provides="fileupload">
                                        <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                            <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image" alt="" />
                                        </div>
                                        <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                        <div>
                                                   <span class="btn btn-default btn-file">
                                                   <span class="fileupload-new"><i class="fa fa-paper-clip"></i>选择图片</span>
                                                   <span class="fileupload-exists"><i class="fa fa-undo"></i>修改</span>
                                                   <input class="default" id="imageFile" name="imageFile" type="file"  />
                                                   </span>
                                            <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash"></i>移除</a>
                                        </div>
                                    </div>

                                </div>
                            </div>
							-->
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">产品缩略图</label>

                                <div class="col-md-6 col-sm-6">
                                    <input id="imageFile" name="imageFile" type="file" multiple class="file" >
                                </div>
                            </div>
							<!-- 
                            <div class="form-group">
                                <label class="col-md-2 col-sm-2 control-label">产品大图</label>

                                <div class="col-md-6 col-sm-6">
                                    <input id="myfiles-2" name="myfiles" type="file" multiple class="file">
                                </div>
                            </div>
                            -->

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
<script src="${base}/uilib/bootstrap-fileupload/js/bootstrap-fileupload.min.js"></script>

<script>

	$(function() {
		[@flash_message /]
	});
	
    $(function(){
            var $inputForm = $("#inputForm");
            $inputForm.validate({
                rules: {
                    name: {
                        required: true
                    },
                    productTypeId: {
                        required: true
                    },
                    price: {
                        required : true
                    },
                    introduction : {
                        required : true
                    }

                },
                submitHandler:function(form){
                    //跳出验证对话框
                    bootbox.confirm({
                        //size: 'small',
                        message: "您确定操作吗?",
                        buttons: {
                            cancel: {
                                label: "取消",
                                className: "btn-default"
                            },
                            confirm : {
                                label: "确定",
                                className: "btn-primary"
                            }
                        },
                        callback: function(result){
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