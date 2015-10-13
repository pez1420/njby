package temp.entity;

import java.util.Date;

public class Equipment {
    private String id;

    private Date createDate;

    private Date modifyDate;

    private String name;

    private String introduction;

    private String thumbnailimage;

    private String largeimage;

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

    public String getThumbnailimage() {
        return thumbnailimage;
    }

    public void setThumbnailimage(String thumbnailimage) {
        this.thumbnailimage = thumbnailimage == null ? null : thumbnailimage.trim();
    }

    public String getLargeimage() {
        return largeimage;
    }

    public void setLargeimage(String largeimage) {
        this.largeimage = largeimage == null ? null : largeimage.trim();
    }
}