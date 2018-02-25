/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.chelp.oop.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.ParseException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.ehcache.search.impl.BaseResult;

/**
 * 图片压缩工具类

 * @ClassName: ImageUtils

 * @Description: TODO

 * @author: zhonghui.geng

 * @date: 2017年7月10日 上午10:12:11
 */
public class ImageUtils{
	
	/**
     * 
     * @Description:保存图片并且生成缩略图
     * @param imageFile 图片文件
     * @param request 请求对象
     * @param uploadPath 上传目录
     * @return
     */
    public static InputStream uploadFileAndCreateThumbnail(MultipartFile imageFile) {
    	String originalFilename = imageFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String tempExt = ext.toUpperCase();
        try {
    	InputStream  inputStream = imageFile.getInputStream();
        long size = imageFile.getSize();
        double scale = 1.0d ;
        if(size >= 100*1024){
            if(size > 0){
                scale = (10*1024f) / size  ;
            }
        }
        if(size < 100*1024){
        	BufferedImage bf = Thumbnails.of(inputStream).scale(1f).outputFormat(tempExt).asBufferedImage();
        	ByteArrayOutputStream os = new ByteArrayOutputStream();  
        	ImageIO.write(bf, tempExt, os);  
        	InputStream is = new ByteArrayInputStream(os.toByteArray()); 
        	return is;
        }else{
        	BufferedImage bf = Thumbnails.of(inputStream).scale(0.2f).outputQuality(scale).asBufferedImage();
        	ByteArrayOutputStream os = new ByteArrayOutputStream();  
        	ImageIO.write(bf, tempExt, os);  
        	InputStream is = new ByteArrayInputStream(os.toByteArray()); 
        	return is;
        }
            
        } catch (Exception e1) {
            return null;
        }
        /**
         * 缩略图end
         */
     
    }
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
	}
}
