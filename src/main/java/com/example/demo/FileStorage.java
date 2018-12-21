package com.example.demo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {
	public void init();
	public List<RowInfo> storeFile(MultipartFile multipartFile);
	public void deleteAll();
}
