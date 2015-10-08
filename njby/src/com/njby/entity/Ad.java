package com.njby.entity;

import java.util.Date;


import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;


@EntityInfo("广告实体")
public class Ad extends OrderEntity{
	private static final long serialVersionUID = -6922059606923961621L;
	
	@Meaning("标题")
	private String title;
	@Meaning("类型0=text, 1=image, 2=flash")
	private Integer adType;
	@Meaning("内容")
	private String content;
	@Meaning("图片路径")
	private String path;
	@Meaning("开始日期")
	private Date beginDate;
	@Meaning("结束日期")
	private Date endDate;
	@Meaning("链接地址")
	private String url;
	
	@Meaning("广告位")
	private AdPosition adPosition;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAdType() {
		return adType;
	}

	public void setAdType(Integer adType) {
		this.adType = adType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AdPosition getAdPosition() {
		return adPosition;
	}

	public void setAdPosition(AdPosition adPosition) {
		this.adPosition = adPosition;
	}
	
	
/*	public enum AdType {
		text, image, flash;
	}
	public AdType getAdType() {
		return adType;
	}

	public void setAdType(AdType adType) {
		this.adType = adType;
	}	
*/	
	
}
