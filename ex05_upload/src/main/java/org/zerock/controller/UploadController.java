package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j

public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form.....................");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormActionPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("---------------------------------");
			log.info("upload file Name : " + multipartFile.getOriginalFilename()); // 업로드되는 파일의 이름
			log.info("upload file Size: " + multipartFile.getSize()); // 업로드되는 파일의 크기
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename()); // 저장 대상
			
			try {
				multipartFile.transferTo(saveFile);	// 파일 저장
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} // End for문
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax..............");
	}
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public void uploadAjaxAction(MultipartFile[] uploadFile) {

		String uploadFolder = "C:\\upload";
		
		// 폴더 만들기
		File uploadPath = new File(uploadFolder, getFolder());	//C:\\upload\2024\04\29
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();	// 폴더 or 디렉토리 생성
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("---------------uploadAjaxAction------------------");
			log.info("upload file Name : " + multipartFile.getOriginalFilename()); // 업로드되는 파일의 이름
			log.info("upload file Size: " + multipartFile.getSize()); // 업로드되는 파일의 크기
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			log.info(uploadFileName);
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			log.info(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			log.info("uuid : " + uuid);
			
			// 파일명 앞에 랜덤한 영문자 32자를 붙인다.	ex) saasdifawrygsadfhwsfasd_01Apple.jpg
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			// File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename()); // 저장 대상
			File saveFile = new File(uploadPath, uploadFileName); // 저장 대상
			
			try {
				multipartFile.transferTo(saveFile);	// 파일 저장
				
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(
							new File(uploadPath, "s_" + uploadFileName)
							);
					// Thumbnailator는 InputStream과 java.io.File객체를 이용해서 파일 생성, 뒤는 사이즈(width,height)에 대한 부분
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} // End for문
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);		// 2024-04-29
		
		return str.replace("-", File.separator);	// 2024/04/29
		
	}
	
	// 썸네일 이미지 생성
	private boolean checkImageType(File file) {
		
		try {
			
		String contentType = Files.probeContentType(file.toPath());
		log.info("=============================>>>>>>>>>");
		log.info(file);
		log.info(contentType);
		
		return contentType.startsWith("image");	// 이미지파일 O
		
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return false;	// 이미지파일 X
	}
}
