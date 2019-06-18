package com.chungfung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot文件上传
 * 表示该类下的方法的返回值会自动做json格式的转换
 */
@Controller
public class FileUploadController {

	@RequestMapping("/upload")
	public String upload(){
		return "upload";
	}

	@RequestMapping("/fileUploadController")
	@ResponseBody
	public Map<String, Object> fileUpload(MultipartFile filename)throws Exception{
		System.out.println(filename.getOriginalFilename());
		filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		return map;
	}
}
