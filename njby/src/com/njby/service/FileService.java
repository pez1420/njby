package com.njby.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.system.FileInfo;

public interface FileService {
	
	public boolean isValid(FileInfo.FileType fileType, MultipartFile multipartFile);
	
	public String upload(HttpServletRequest request, FileInfo.FileType fileType, MultipartFile multipartFile);
	
}
