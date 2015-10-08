<!-- 分页信息 -->
[#if totalPages > 1]
	<div class="pagination pagination-right pull-right">
	    <!-- 跳转到第一页 -->
		[#if isFirst]
	    	<li><a href="#"><i class="fa fa-step-backward"></i></a></li>
	    [#else]
	    	<li><a class="pageno" href="#" skip="${firstPageNumber}"><i class="fa fa-step-backward"></i></a></li>
	    [/#if]
	    <!-- 跳转到前一页 -->
	    [#if hasPrevious]
	    	<li><a class="pageno" href="#" skip="${previousPageNumber}"><i class="fa fa-caret-left"></i></a></li>
	    [#else]
	    	<li><a href="#"><i class="fa fa-caret-left"></i></a></li>
	    [/#if]

		
		[#list segment as segmentPageNumber]
			[#if segmentPageNumber_index == 0 && segmentPageNumber > firstPageNumber + 1]
				<li><a href="#">...</a></li>
			[/#if]
			[#if segmentPageNumber != pageNumber]
			<li><a class="pageno" href="#" skip="${segmentPageNumber}">${segmentPageNumber}</a></li>
			[#else]
				<li class="active"><a href="#" >${segmentPageNumber}</a></li>	
			[/#if]
			[#if !segmentPageNumber_has_next && segmentPageNumber < lastPageNumber - 1]
				<li><a href="#">...</a></li>
			[/#if]
		[/#list]
			    
	    [#if hasNext]
	    	<li><a class="pageno" href="#" skip="${nextPageNumber}"><i class="fa fa-caret-right"></i></a></li>
	    [#else]
	    	<li><a href="#"><i class="fa fa-caret-right"></i></a></li>
	    [/#if]
	    
	    [#if isLast]
	    	<li><a href="#"><i class="fa fa-step-forward"></i></a></li>
		[#else]
			<li><a class="pageno" href="#" skip="${lastPageNumber}"><i class="fa fa-step-forward"></i></a></li>
		[/#if]
	    <span class="pageSkip">
			&nbsp; 共(<b>${totalPages}</b>)页 到第 &nbsp;
	        <input class="input-sm" id="pageNumber" name="pageNumber" value="${pageNumber}"
	              	maxlength="9" onpaste="return false;" style="width:40px">
	        &nbsp;页<button type="submit" class="btn-sm btn btn-info"><i class="fa fa-step-forward"></i></button>
	     </span>
	</div>
[/#if]