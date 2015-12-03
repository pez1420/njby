<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>南京秦淮区碧源礼品文化经营部|联系我们</title>
    <link href="${base}/uilib/bootstrap-3/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="${base}/uilib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${base}/resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
        }

        .iw_poi_title {
            color: #CC5522;
            font-size: 14px;
            font-weight: bold;
            overflow: hidden;
            padding-right: 13px;
            white-space: nowrap
        }

        .iw_poi_content {
            font: 12px arial, sans-serif;
            overflow: visible;
            padding-top: 4px;
            margin-bottom: 30px;
            white-space: -moz-pre-wrap;
            word-wrap: break-word
        }
    </style>
</head>
<body>


<!-- 网页头部 -->
[#include "/forward/include/header.ftl"]

<div class="section_header">
    <div class="container">
        <h2><span>联系我们</span>|Contact us</h2>
    </div>
</div>
<div class="contact">
    <div class="container">
        <div class="row centered">
            <!--百度地图容器-->
            <div style="height:270px;border:#ccc solid 1px;margin-bottom: 30px;" id="dituContent"></div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <h3>联系信息</h3>

                <p><span>地址:</span> 江苏南京市秦淮区柳叶街双乐园12幢50号</p>

                <p><span>Email:</span> info@companyname.com</p>

                <p><span>电话:</span> +13625689205</p>
            </div>
            <div class="col-md-6">
                <h3><i class="fa fa-envelope-o"></i>&nbsp;<a href="contactdetails.html">留言板块</a></h3>

                <form class="form-horizontal" id="inputForm" action="save.jhtml" method="post" role="form">
                    <div class="form_details">
                        <input class="text form-control" type="text" name="name" placeholder="名称">
                        <input class="text form-control" type="text" name="phone" placeholder="联系电话(手机)">
                        <input class="text form-control" type="text" name="title" placeholder="标题">
                        <textarea class="form-control" name="content" placeholder="留言详细内容"></textarea>

                        <div class="clearfix"></div>
                        <button class="btn" type="submit">发送留言</button>
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
<script src="${base}/resources/less-1.7.5.min.js"></script>
<script src="${base}/uilib/bootstrap-3/js/bootstrap.min.js"></script>
<script src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>

<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap() {
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }

    //创建地图函数：
    function createMap() {
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(118.786122, 32.028998);//定义一个中心点坐标
        map.centerAndZoom(point, 17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }

    //地图事件设置函数：
    function setMapEvent() {
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }

    //地图控件添加函数：
    function addMapControl() {
        //向地图中添加缩放控件
        var ctrl_nav = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, type: BMAP_NAVIGATION_CONTROL_LARGE});
        map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
        var ctrl_ove = new BMap.OverviewMapControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT, isOpen: 1});
        map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
        var ctrl_sca = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT});
        map.addControl(ctrl_sca);
    }

    //标注点数组
    var markerArr = [{
        title: "碧源不干胶",
        content: "地址：江苏南京市秦淮区柳叶街双乐园12幢50号<br/>电话：13868587032",
        point: "118.784434|32.027812",
        isOpen: 1,
        icon: {w: 21, h: 21, l: 0, t: 0, x: 6, lb: 5}
    }
    ];
    //创建marker
    function addMarker() {
        for (var i = 0; i < markerArr.length; i++) {
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0, p1);
            var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point, {icon: iconImg});
            var iw = createInfoWindow(i);
            var label = new BMap.Label(json.title, {"offset": new BMap.Size(json.icon.lb - json.icon.x + 10, -20)});
            marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                borderColor: "#808080",
                color: "#333",
                cursor: "pointer"
            });

            (function () {
                var index = i;
                var _iw = createInfoWindow(i);
                var _marker = marker;
                _marker.addEventListener("click", function () {
                    this.openInfoWindow(_iw);
                });
                _iw.addEventListener("open", function () {
                    _marker.getLabel().hide();
                })
                _iw.addEventListener("close", function () {
                    _marker.getLabel().show();
                })
                label.addEventListener("click", function () {
                    _marker.openInfoWindow(_iw);
                })
                if (!!json.isOpen) {
                    label.hide();
                    _marker.openInfoWindow(_iw);
                }
            })()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i) {
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>" + json.content + "</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json) {
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w, json.h), {
            imageOffset: new BMap.Size(-json.l, -json.t),
            infoWindowOffset: new BMap.Size(json.lb + 5, 1),
            offset: new BMap.Size(json.x, json.h)
        })
        return icon;
    }

    initMap();//创建和初始化地图
</script>

</body>
</html>
