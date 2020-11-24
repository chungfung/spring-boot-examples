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
	public Map<String, Object> fileUpload(MultipartFile fileName)throws Exception{
		System.out.println("aaaaa");
		System.out.println(fileName.getOriginalFilename());
		fileName.transferTo(new File("e:/"+fileName.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");

		String str = streamToString(fileName.getBytes());
		System.out.println(str);

		String str1 = streamToString(fileName.getBytes());
		System.out.println(str1);
		return map;
	}

	public static String streamToString(byte[] bytes){
		String out = new String(bytes);
		return out;
	}
}
