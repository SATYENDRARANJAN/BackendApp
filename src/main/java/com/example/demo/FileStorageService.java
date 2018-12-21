package com.example.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements FileStorage {

	public  Path path =Paths.get("filesfolder");
	
	@Override
	public void init() {
		try {
			if(!Files.exists(path))
				Files.createDirectory(path.getFileName());
		} catch (IOException e) {
			System.out.println("Couldnt create"+ e.getMessage());
		}
	}

	@Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(path.toFile());
    }

	
	@Override
	public List<RowInfo>  storeFile(MultipartFile multipartFile) {
		List<RowInfo> rowList = null;
		try {
			//Files.delete(this.path.resolve(multipartFile.getOriginalFilename()));
			Files.copy(multipartFile.getInputStream(), this.path.resolve(multipartFile.getOriginalFilename()));
			rowList = ApachePOIExcelRead.readXLS(this.path.resolve(multipartFile.getOriginalFilename()).toString());
			System.out.println("path "+this.path.resolve(multipartFile.getOriginalFilename()).toString());

		} catch (IOException e) {
        	throw new RuntimeException("FAILssss! -> message = " + e.getMessage());
		}
		return rowList;
	}
	
	
	public Resource loadFile(String fileName) {
		try {
			Path file = path.resolve(fileName);
			Resource resource = new UrlResource (file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource ;
			}else {
				throw new RuntimeException("FAIL! ");
			}
		}catch(MalformedURLException e) {
			throw new RuntimeException("FAIL");
		}
	}
	
    

}
