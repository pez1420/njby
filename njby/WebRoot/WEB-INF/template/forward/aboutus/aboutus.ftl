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

<!--公司概况-->
<div class="section_header">
  <div class="container">
    <h2><span>公司概况</span>|About our company</h2>
  </div>
</div>
<div id="about_section_1">
  <div class="container">
    <div class="row">
      <div class="col-lg-6"> <img src="${base}/resources/images/about2.jpg" class="img-responsive" alt=" "> </div>
      <div class="col-lg-6">
        <h3>公司简介</h3>
          <p> 苏州建峰印业有限公司注册资金300万元人民币主要经营范围是不干胶印刷、印刷、广告制作，纸制包装用品、工艺美术品、办公用品、日用百货等，公司位于苏州高新区浒墅关镇青花路26号。</p>

          <p>本公司生产印刷不干胶及特种不干胶。 出售丝网耗材（丝印油墨、慢干783、稀释水、丝网及晒绷）。 标贴、人像卡、工作卡、图文设计、台历，挂历等。 本公司秉承“我顾客至上，锐意进取”的经营理念，坚持“客户第一”的原则为广大客户提供优质的服务。欢迎广大客户惠顾！.</p>
      </div>
    </div>
  </div>
</div>


<!-- 选择我们的原因 -->
<div class="section_header">
	<h2><span>选择我们的原因</span>|Why choose us</h2>
</div>
<div id="about_section_2">
  <div class="container">
    <div class="row">
     [@culture_list count=4]
		[#list cultures as culture]
		    <div class="col-lg-6">
		        <h4>${culture.icon} ${culture.title}</h4>
		        <p> ${culture.detail}</p>
      		</div>
		[/#list]
	 [/@culture_list]
    </div>
  </div>
</div>

<!-- 我们的客户 -->
<div class="section_header">
    <h2><span>我们的客户</span>|Our Clients</h2>
</div>
<div id="clients">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <p>与国内外多家不干胶生产厂家建立了长期紧密合作，能够更好的了解材料求.</p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-2"><img src="${base}/resources/images/client1.jpg" class="img-responsive"></div>
            <div class="col-lg-2"><img src="${base}/resources/images/client2.jpg" class="img-responsive"></div>
            <div class="col-lg-2"><img src="${base}/resources/images/client3.jpg" class="img-responsive"></div>
            <div class="col-lg-2"><img src="${base}/resources/images/client4.jpg" class="img-responsive"></div>
            <div class="col-lg-2"><img src="${base}/resources/images/client5.jpg" class="img-responsive"></div>
            <div class="col-lg-2"><img src="${base}/resources/images/client6.jpg" class="img-responsive"></div>
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
<script src="${base}/resources/less-1.7.5.min.js"></script>
<script src="${base}/uilib/bootstrap-3/js/bootstrap.min.js"></script>
</body>
</html>