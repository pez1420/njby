<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>南京碧源文化礼品经营部管理平台</title>

    <link href="${base}/resources/css/admin/style.css" rel="stylesheet">
    <link href="${base}/resources/css/admin/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${base}/resources/html5shiv.js"></script>
    <script src="${base}/resources/respond.min.js"></script>
    <![endif]-->
</head>

<body class="sticky-header">

<section>
<!-- 页面左部开始 -->
<div class="left-side sticky-left-side">
    <!-- 左上角logo部分 -->
    <div class="logo">
        <a href="main.html"><img src="${base}/resources/images/admin/logo.png" alt=""></a>
    </div>
    <div class="logo-icon text-center">
        <a href="main.html"><img src="${base}/resources/images/admin/logo_icon.png" alt=""></a>
    </div>

    <div class="left-side-inner">
        <!-- visible to small devices only -->
        <div class="visible-xs hidden-sm hidden-md hidden-lg">
            <div class="media logged-user">
                <img alt="" src="${base}/resources/images/admin/photos/user-avatar.png" class="media-object">

                <div class="media-body">
                    <h4><a href="#">John Doe</a></h4>
                    <span>"Hello There..."</span>
                </div>
            </div>

            <h5 class="left-nav-title">Account Information</h5>
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
                <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
                <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
            </ul>
        </div>

        <!-- 侧边导航栏 -->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="overview.jhtml" target="iframe"><i class="fa fa-home"></i> <span>系统概况</span></a></li>
            <li class="menu-list nav-active"><a href=""><i class="fa fa-laptop"></i> <span>系统设置</span></a>
                <ul class="sub-menu-list">
                    <li class="active"><a href="login.html" target="iframe"> 系统设置</a></li>
                    <li><a href="../admin/list.jhtml" target="iframe"> 管理人员</a></li>
                    <li><a href="../role/list.jhtml" target="iframe"> 角色管理</a></li>
                    <li><a href="../log/list.jhtml" target="iframe"> 日志管理</a></li>

                </ul>
            </li>

            <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>内容管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="../navigation/list.jhtml" target="iframe"> 导航管理</a></li>
                    <li><a href="../ad_position/list.jhtml" target="iframe"> 广告位置</a></li>
                    <li><a href="../ad/list.jhtml" target="iframe"> 广告管理</a></li>
                    <li><a href="../template/list.jhtml" target="iframe"> 模板管理</a></li>
                    <li><a href="../cache/clear.jhtml" target="iframe"> 缓存管理</a></li>
                    <li><a href="../static/build.jhtml" target="iframe"> 静态页面</a></li>
                </ul>
            </li>
            
            <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>企业首页</span></a>
                <ul class="sub-menu-list">
                    <li><a href="../notice/list.jhtml" target="iframe"> 通告管理</a></li>
                    <li><a href="#" target="iframe"> 其他设置</a></li>
                </ul>
            </li>

            <li class="menu-list"><a href=""><i class="fa fa-tasks"></i> <span>公司概况</span></a>
                <ul class="sub-menu-list">
                        <li><a href="../firm/list.jhtml" target="iframe"> 公司简介</a></li>
						<li><a href="../culture/list.jhtml" target="iframe"> 公司文化</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-bar-chart-o"></i> <span>产品管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="../product_type/list.jhtml" target="iframe"> 产品分类</a></li>
                    <li><a href="../product/list.jhtml" target="iframe"> 产品管理</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href="#"><i class="fa fa-th-list"></i> <span>生产设备</span></a>
                <ul class="sub-menu-list">
                    <li><a href="#" target="iframe"> 设备分类</a></li>
                    <li><a href="#" target="iframe"> 设备管理</a></li>
                </ul>
            </li>

            <li class="menu-list"><a href="#"><i class="fa fa-map-marker"></i> <span>客户留言</span></a>
                <ul class="sub-menu-list">
                    <li><a href="../leave_message/list.jhtml" target="iframe"> 留言管理</a></li>
                    <li><a href="vector_map.html" target="iframe"> 百度地图</a></li>
                </ul>
            </li>
            
            <li class="menu-list"><a href="#"><i class="fa fa-map-marker"></i> <span>统计分析</span></a>
                <ul class="sub-menu-list">
                    <li><a href="google_map.html" target="iframe"> 来客分析</a></li>
                    <li><a href="vector_map.html" target="iframe"> 图形分析</a></li>
                </ul>
            </li>
            
            <li><a href="login.html"><i class="fa fa-sign-in"></i> <span>登陆页面</span></a></li>

        </ul>
    </div>
</div>

<!-- 页面右部开始 -->
<div class="main-content">
    <!-- 搜索框 -->
    <div class="header-section">
        <!-- 左变页面隐藏按钮 -->
        <a class="toggle-btn"><i class="fa fa-bars"></i></a>

        <!-- 搜索框 -->
        <form class="searchform" action="#" method="post">
            <input type="text" class="form-control" name="keyword" placeholder="搜索"/>
        </form>
        <!-- 头部右边用户菜单 -->
        <div class="menu-right">
            <ul class="notification-menu">
                <li>
                    <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                        <span class="badge">5</span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-head pull-right">
                        <h5 class="title">您有5条留言 </h5>
                        <ul class="dropdown-list normal-list">
                            <li class="new">
                                <a href="">
                                    <span class="thumb"><img src="${base}/resources/images/admin/photos/user1.png" alt=""/></span>
                                                    <span class="desc">
                                                      <span class="name">John Doe <span
                                                              class="badge badge-success">new</span></span>
                                                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="thumb"><img src="${base}/resources/images/admin/photos/user2.png" alt=""/></span>
                                                    <span class="desc">
                                                      <span class="name">Jonathan Smith</span>
                                                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="thumb"><img src="${base}/resources/images/admin/photos/user3.png" alt=""/></span>
                                                    <span class="desc">
                                                      <span class="name">Jane Doe</span>
                                                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="thumb"><img src="${base}/resources/images/admin/photos/user4.png" alt=""/></span>
                                                    <span class="desc">
                                                      <span class="name">Mark Henry</span>
                                                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="thumb"><img src="${base}/resources/images/admin/photos/user5.png" alt=""/></span>
                                                    <span class="desc">
                                                      <span class="name">Jim Doe</span>
                                                      <span class="msg">Lorem ipsum dolor sit amet...</span>
                                                    </span>
                                </a>
                            </li>
                            <li class="new"><a href="">Read All Mails</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                        <i class="fa fa-bell-o"></i>
                        <span class="badge">4</span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-head pull-right">
                        <h5 class="title">消息通知</h5>
                        <ul class="dropdown-list normal-list">
                            <li class="new">
                                <a href="">
                                    <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                    <span class="name">Server #1 overloaded.  </span>
                                    <em class="small">34 mins</em>
                                </a>
                            </li>
                            <li class="new">
                                <a href="">
                                    <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                    <span class="name">Server #3 overloaded.  </span>
                                    <em class="small">1 hrs</em>
                                </a>
                            </li>
                            <li class="new">
                                <a href="">
                                    <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                    <span class="name">Server #5 overloaded.  </span>
                                    <em class="small">4 hrs</em>
                                </a>
                            </li>
                            <li class="new">
                                <a href="">
                                    <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                    <span class="name">Server #31 overloaded.  </span>
                                    <em class="small">4 hrs</em>
                                </a>
                            </li>
                            <li class="new"><a href="">See All Notifications</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user"></i> &nbsp;admin <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                        <li><a href="#"><i class="fa fa-user"></i> 用户信息</a></li>
                        <li><a href="#"><i class="fa fa-cog"></i> 基本设置</a></li>
                        <li><a href="../logout.jsp"><i class="fa fa-sign-out"></i> 注销</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <iframe id="iframe" name="iframe" src="overview.jhtml" frameborder="0" scrolling="no"  width="100%" height="1000px">
    </iframe>

</div>
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="${base}/resources/jquery-2.1.0.min.js"></script>
<script src="${base}/resources/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${base}/resources/jquery-migrate-1.2.1.min.js"></script>
<script src="${base}/uilib/bootstrap-3/js/bootstrap.min.js"></script>
<script src="${base}/resources/modernizr.min.js"></script>
<script src="${base}/resources/admin/jquery.nicescroll.js"></script>
<!-- 所有页面共同脚本  -->
<script src="${base}/resources/admin/scripts.js"></script>

</body>
</html>
