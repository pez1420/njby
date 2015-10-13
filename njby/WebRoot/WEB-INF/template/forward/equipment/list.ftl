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
[#include "/forward/include/header.ftl"]


<div class="section_header">
    <div class="container">
        <h2><span>生产设备</span>|Equipments</h2>
    </div>
</div>
<div id="services">
    <div class="container">
        <div class="row">

            <div class="col-md-12">
               [#if page.content?has_content]
					[#list page.content?chunk(4) as row]	
		                <div class="row">
		                	[#list row as equipment]
		                    <div class="col-lg-3 service">
		                        <h3>${equipment.name}</h3>
		                        <p>${equipment.introduction}</p>
		                        <img src="${base}${equipment.thumbnailPath}" class="img-responsive" alt="${equipment.name}">
		                        </div>
		                	[/#list]
		                </div>
	                [/#list]
                [/#if]
                <form id="listForm" action="${base}/equipment/list.jhtml"}" method="get">
	                <input type="hidden" id="pageSize" name="pageSize" value="8" />
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



<script src="${base}/resource/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="${base}/resources/less-1.7.5.min.js" type="text/javascript"></script>
<script src="${base}/uilib/bootstrap-3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${base}/resources/admin/list.js" type="text/javascript"></script>

</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             