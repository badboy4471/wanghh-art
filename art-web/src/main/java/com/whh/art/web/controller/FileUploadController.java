package com.whh.art.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.whh.art.untils.AliyunUpload;
import com.whh.art.web.form.Result;

@Controller
public class FileUploadController {

	/*private static String FILE_ROOT = "artFiles/";
	private static String IMAGE_FOLDER = "images/";
	private static String AUDIO_FOLDER = "audios/";
	private static String VIDEO_FOLDER = "videos/";
	private static String OTHER = "other/";*/

	@RequestMapping(value = "admin/art/file/upload", method = { RequestMethod.POST }, produces = "application/json")
	public @ResponseBody
	Result uploadFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam(value = "type", required = false, defaultValue = "image") String type,
			HttpServletRequest request) {
		Result result = new Result(null);

		if (file.isEmpty()) {
			result.setCode(-1);
			result.setData("失败！");
			return result;
		}
		String fileName = "";
		String fullUrl = "";
		if (FileType.IMAGE.toString().equalsIgnoreCase(type)) {
			try {
				fileName = AliyunUpload.uploadArtImage(file.getInputStream(), file.getBytes().length);
				fullUrl = "http://art-images.oss-cn-hangzhou.aliyuncs.com/"+fileName;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (FileType.AUDIO.toString().equalsIgnoreCase(type)) {
			
			try {
				fileName = AliyunUpload.uploadAudio(file.getInputStream(), file.getBytes().length);
				fullUrl = "http://art-audios.oss-cn-hangzhou.aliyuncs.com/"+fileName;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (FileType.VIDEO.toString().equalsIgnoreCase(type)) {
			try {
				fileName = AliyunUpload.uploadVideo(file.getInputStream(), file.getBytes().length);
				fullUrl = "http://art-videos.oss-cn-hangzhou.aliyuncs.com/"+fileName;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("fullUrl", fullUrl);
		map.put("url", fileName);
		result.setData(map);
		return result;
	}

	private static enum FileType {
		IMAGE, AUDIO, VIDEO
	}

	private String getFileType(String fileFullName) {
		return fileFullName.substring(fileFullName.lastIndexOf("."));// 取文件格式后缀名

	}
}
