package com.njby.entity;

import javax.persistence.Transient;


public class Equipment extends BaseEntity{

	private static final long serialVersionUID = 2395071636669536428L;

	private String name;

    private String introduction;

    private String thumbnailImage;

    private String largeImage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	
	@Transient
	public String getThumbnailPath() {
		if (getId() != null)
			return "/upload/" +  this.getThumbnailImage();
		
		return null;
	}

	@Transient
	public String getLargePath() {
		if (getId() != null)
			return "/upload/" +  this.getLargeImage();
		
		return null;
	}
}