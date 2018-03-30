package com.project.frontend.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.project.frontend.controller.ProductController;

public class FileUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(FileUtil.class);
	private static final String imageDirectory ="ShoppingCartImages";
	private static String rootPath = System.getProperty("catalina.home");
	public static boolean copyFileNIO(MultipartFile file, String fileName){
		File dest = new File(rootPath +File.separator+imageDirectory+File.separator+fileName);{
			if (!dest.exists()) {
				dest.mkdir();
			}
			try {
				file.transferTo(dest);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}

}
