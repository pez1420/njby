package com.njby.entity;


import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;

@EntityInfo("公司简介")
public class Firm  extends BaseEntity {


    /**
	 * 
	 */
	private static final long serialVersionUID = 8139550413542245547L;

	@Meaning("电话")
	private String telephone;
	@Meaning("手机")
    private String mobile;
	@Meaning("地址")
    private String address;
	@Meaning("email")
    private String email;
	@Meaning("图片")
    private String image;
	@Meaning("简介")
    private String brief;


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }
}