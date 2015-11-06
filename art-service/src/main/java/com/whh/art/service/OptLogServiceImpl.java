package com.whh.art.service;

import java.util.Date;

import com.whh.art.dao.mapper.OptLogMapper;
import com.whh.art.dao.model.ArtOutModel;
import com.whh.art.dao.model.OptLogModel;

public class OptLogServiceImpl implements IOptLogService {
	
	OptLogMapper optLogMapper;

	@Override
	public void insert(int adminId, String url) {
		
		try{
			OptLogModel opt = new OptLogModel();
			
			opt.setAdminId(adminId);
			opt.setUrl(url);
			opt.setTime(new Date());
			
			optLogMapper.insert(opt);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertArtOut(ArtOutModel out) {
		optLogMapper.insertArtOut(out);
	}

	public void setOptLogMapper(OptLogMapper optLogMapper) {
		this.optLogMapper = optLogMapper;
	}

	
	
}
