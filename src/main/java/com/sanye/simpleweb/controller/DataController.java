package com.sanye.simpleweb.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class DataController {

	@RequestMapping("/goods")
	public String goods(Integer pageNo,Integer pageSize) throws IOException {
		if(pageNo == null) {
			pageNo = 1;
		}
		if(pageSize == null) {
			pageSize = 20;
		}
		File file = org.springframework.util.ResourceUtils.getFile("classpath:goods/page"+pageNo+".json");	
		String data = FileUtils.readFileToString(file);
		return data;

	}

}