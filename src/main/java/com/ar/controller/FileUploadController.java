package com.ar.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	
	
	private static final String UPLOAD_DIRECTORY="/images";
	@RequestMapping(value="uploadform")
	public ModelAndView uploadform() {
		return new ModelAndView("uploadform");
	}
	
	@RequestMapping(value="savefile",method=RequestMethod.POST)
	public ModelAndView save(@RequestParam CommonsMultipartFile file,HttpSession session ) throws Exception {
		System.out.println("**********SAVE**************");
		ServletContext context=session.getServletContext();
		String path=context.getRealPath(UPLOAD_DIRECTORY);
		String filename=file.getOriginalFilename();
		System.out.println(path+" "+filename);
		BufferedOutputStream outstream=new BufferedOutputStream(new FileOutputStream(new File(path+ File.separator+filename)));
		byte[] bytes=file.getBytes();
		outstream.write(bytes);
		outstream.flush();
		outstream.close();
		System.out.println("save successful");
		
		return new ModelAndView("uploadform", "filesuccess", "Image is successfully uploaded");
	}

}
