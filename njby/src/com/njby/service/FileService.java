package com.njby.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.system.FileInfo;

public interface FileService {
	
	/***
	 * 上次文件有效性检查
	 * 
	 * @param fileType  文件类型
	 * 
	 * @param multipartFile  上传的文件
	 * 
	 * @return 是否有效
	 */
	public boolean isValid(FileInfo.FileType fileType, MultipartFile multipartFile);
	
	/**
	 * 上传文件
	 * 
	 * @param request
	 * 
	 * @param fileType
	 * 
	 * @param multipartFile
	 * 
	 * @return 
	 */
	public String upload(HttpServletRequest request, FileInfo.FileType fileType, MultipartFile multipartFile);
	
}
