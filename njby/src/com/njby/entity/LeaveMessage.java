package com.njby.entity;

import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;

@EntityInfo("留言管理")
public class LeaveMessage extends BaseEntity {

	private static final long serialVersionUID = 1338387202643173522L;
	@Meaning("用户名")
	private String name;
	@Meaning("联系电话手机")
	private String phone;
	@Meaning("标题")
	private String title;
	@Meaning("标题")
	private String content;
	
	@Meaning("管理员回复")
	private String reply;
	
	@Meaning("是否已读")
    private Boolean isReaded;
	@Meaning("是否关闭")
    private Boolean isReplyed;
	@Meaning("是否展示在页面")
    private Boolean isShowed;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	public Boolean getIsReaded() {
		return isReaded;
	}
	
	public void setIsReaded(Boolean isReaded) {
		this.isReaded = isReaded;
	}
	

	public Boolean getIsReplyed() {
		return isReplyed;
	}

	public void setIsReplyed(Boolean isReplyed) {
		this.isReplyed = isReplyed;
	}

	public Boolean getIsShowed() {
		return isShowed;
	}
	
	public void setIsShowed(Boolean isShowed) {
		this.isShowed = isShowed;
	}
	
	
	
}
