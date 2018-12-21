package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.FileStorage;
import com.example.demo.RowInfo;

@Controller
public class FileController {

	@Autowired
	public FileStorage fileStorage;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/")
//	@ModelAttribute("rowList")
	public ModelAndView uploadFile(@RequestParam("uploadfile")  MultipartFile multipartFile,Model model){

    	ModelAndView modelnView = new ModelAndView();
    	modelnView.setViewName("index");
    	List<RowInfo> rowList = new ArrayList<>();
		try {
			rowList = fileStorage.storeFile(multipartFile);
			modelnView.addObject("message",  "Success! -> uploaded filename: " + multipartFile.getOriginalFilename());
			modelnView.addObject("rowList", rowList);
		}catch(Exception e) {
			modelnView.addObject("message", "Fail! -> fileName :"+multipartFile.getOriginalFilename());
			System.out.println("Error is  "+ e.getMessage() );
		}
		System.out.println("List  is  "+rowList );
		return modelnView;
	}

	
	
	/*@GetMapping("/files")
	public String getListFiles(Model model) {
		List<FileInfo> fileInfos = fileStorage.loadFiles().map(
					path ->	{
						String filename = path.getFileName().toString();
						String url = MvcUriComponentsBuilder.fromMethodName(DownloadFileController.class,
		                        "downloadFile", path.getFileName().toString()).build().toString();
						return new FileInfo(filename, url); 
					} 
				)
				.collect(Collectors.toList());
		
		model.addAttribute("files", fileInfos);
		return "multipartfile/listfiles";
	}*/
 
	
	
	
}
