package com.njby.entity;

import com.system.ananotation.EntityInfo;

@EntityInfo("公司文化")
public class Culture extends BaseEntity {

	private static final long serialVersionUID = 5202784556106017132L;

	private String title;

    private String icon;

    private String detail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}