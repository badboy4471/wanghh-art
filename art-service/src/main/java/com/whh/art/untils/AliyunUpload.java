package com.whh.art.untils;

import java.io.InputStream;
import java.util.UUID;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class AliyunUpload {

	private static final String VIDEO_CONTENTTYPE = "video/mpeg";
	private static final String JPG_CONTENTTYPE = "image/jpeg";
	private static final String MP3_CONTENTTYPE = "audio/mpeg";

	private static final String image_bucket = "art-images";
	private static final String video_bucket = "art-videos";
	private static final String audio_bucket = "art-audios";

	private static final String OSS_ENDPOINT = "http://oss.aliyuncs.com/";
	private final static String ACCESS_ID = "9Tb73Z5yBv0u3A9m";
	private final static String ACCESS_KEY = "nRLgyCxVva1Qj6e2HiDrY00PjD0V1Q";
	private static OSSClient client = null;

	static {
		ClientConfiguration config = new ClientConfiguration();
		client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY, config);
	}

	public static String uploadArtImage(InputStream input, long length)
			throws Exception {

		ObjectMetadata objectMeta = new ObjectMetadata();
		objectMeta.setContentLength(length);
		objectMeta.setContentType(JPG_CONTENTTYPE);
		String fileName = UUID.randomUUID().toString();
		String key = fileName + ".jpg";
		return uploadVideoByKey(image_bucket, key, input, objectMeta);
	}

	public static String uploadAudio(InputStream input, long length)
			throws Exception {
		ObjectMetadata objectMeta = new ObjectMetadata();
		objectMeta.setContentLength(length);
		objectMeta.setContentType(MP3_CONTENTTYPE);
		String fileName = UUID.randomUUID().toString();
		String key = fileName + ".mp3";
		return uploadVideoByKey(audio_bucket, key, input, objectMeta);
	}

	public static String uploadVideo(InputStream input, long length)
			throws Exception {
		ObjectMetadata objectMeta = new ObjectMetadata();
		objectMeta.setContentLength(length);
		objectMeta.setContentType(VIDEO_CONTENTTYPE);
		String fileName = UUID.randomUUID().toString();
		String key = fileName + ".mp4";
		return uploadVideoByKey(video_bucket, key, input, objectMeta);
	}

	private static String uploadVideoByKey(String bucket, String key,
			InputStream input, ObjectMetadata objectMeta) throws Exception {
		PutObjectResult result = client.putObject(bucket, key, input,
				objectMeta);
		if (result != null && result.getETag() != null) {
			return key;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			/*File file = new File("/Users/tiger/Downloads/1111.mp4");
			InputStream input = new FileInputStream(file);

			String key = AliyunUpload.uploadArtImage(input, file.length());

			System.out.println(key);*/
			
			client.deleteObject("art-images", "711963eb-58c2-4ad7-b0fd-b023ef44f48f.jpg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
