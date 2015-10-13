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