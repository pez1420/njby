<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>南京秦淮区碧源礼品文化经营部</title>
    <link href="${base}/uilib/bootstrap-3/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="${base}/uilib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${base}/resources/css/googleapifont.css" rel="styleshee" type="text/css">
    <link href="${base}/uilib/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" rel="stylesheet" type="text/css" />
    <link href="${base}/uilib/fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" rel="stylesheet" type="text/css" />
    <link href="${base}/resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>

<!-- 网页头部 -->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"><i class="fa fa-sun-o"></i>碧源礼品文化经营部</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
            	[@navigation_list position=1]
	            	[#list navigations as navigation]
	            		[#if navigation_index == 0]
	            			<li class="active">
	            				<a href="${navigation.url}" [#if navigation.isBlankTarget] target="_blank"[/#if]>${navigation.name}</a>
	            			</li>
	            		[#else]
	            			<li>
	            				<a href="${navigation.url}" [#if navigation.isBlankTarget] target="_blank"[/#if]>${navigation.name}</a>
	            			</li>
	            		[/#if]
	            	[/#list]
            	[/@navigation_list]
            </ul>
        </div>
    </div>
</nav>


<div class="section_header">
    <div class="container">
        <h2><span>产品中心</span>|Services</h2>
    </div>
</div>
<div id="services">
    <div class="container">
        <div class="row">
        
            <div class="col-md-2">
	            [@product_type_root_list]
	            	[#list productTypes as productType]
		                <div class="panel-group" id="service-panel">
		                    <div class="panel panel-primary">
				                        <div class="panel-heading">
				                            <div class="panel-title">
				                                <a data-toggle="collapse" data-parent="service-panel" href="#item${productType_index}">
				                                	<i class="fa fa-sun-o"></i>&nbsp;${productType.name}
				                                </a>
				                            </div>
				                        </div>
				                        <div id="item${productType_index}" class="panel-collapse collapse in">
			                            	<ul class="list-group">
					                        	[@product_type_children_list productTypeId = productType.id count = 10]
													[#list productTypes as productType]					
					                                	<li class="list-group-item">
					                                		<a href="${base}${productType.path}">
					                                			<i class="fa fa-star"></i>&nbsp;${productType.name}
					                                		</a>
					                                	</li>
													[/#list]
												[/@product_type_children_list]
				                            </ul>
				                        </div>  
		                    </div>
		                </div>
	                [/#list]
	        	[/@product_type_root_list]
            </div>

            <div class="col-md-10">
				[#if page.content?has_content]
					[#list page.content?chunk(4) as row]			
		                <div class="row">
		                	[#list row as product]
			                    <div class="col-lg-3 service">
			                        <h3>${product.name}</h3>
			                        <p>${product.introduction}</p>
			                        <img src="${base}${product.path}" class="img-responsive" alt=" ">
			                    </div>
		                    [/#list]
		                </div>
	                [/#list]
                [/#if]
                
                <form id="listForm" action="${base}${(productType.path)!"/product/list.jhtml"}" method="get">
	                <input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}" />
	                <div class="row">
	                    <!-- 分页信息 -->
							[@pagination pageNumber = page.pageNumber totalPages = page.totalPages]
								[#include "/forward/include/pagination.ftl"]
							[/@pagination]
						<!-- 分页信息 -->
	                </div>
                </form>
                
                
            </div>
        </div>
    </div>
</div>


<!-- Footer -->
<div id="footerwrap">
    <div class="container">
        <div class="row">
            <div class="col-md-8"><span class="copyright">Copyright &copy; 2015 Your Website Name. Design by <a
                    href="#" rel="nofollow">pez1420</a></span></div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>



<script src="${base}/resources/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/less-1.7.5.min.js"></script>
<script type="text/javascript" src="${base}/uilib/bootstrap-3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${base}/resources/admin/list.js"></script>

</body>
</html>