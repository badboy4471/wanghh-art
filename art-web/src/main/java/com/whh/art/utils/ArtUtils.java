package com.whh.art.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArtUtils {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	public static Date getDate(String dateStr){
		try{
			return sdf.parse(dateStr);
		}catch(Exception e){
			return null;
		}
	}

}
