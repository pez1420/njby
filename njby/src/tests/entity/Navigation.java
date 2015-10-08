package tests.entity;

import java.util.Date;

public class Navigation {
    private String id;

    private Date createDate;

    private Date modifyDate;

    private Integer orders;

    private String name;

    private Integer position;

    private String url;

    private Boolean isBlankTarget;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Boolean getIsBlankTarget() {
        return isBlankTarget;
    }

    public void setIsBlankTarget(Boolean isBlankTarget) {
        this.isBlankTarget = isBlankTarget;
    }
}