package com.whh.art.dao.mapper;

import com.whh.art.dao.model.SystemConfigModel;

public interface SystemConfigMapper {
	
	SystemConfigModel getSystemConfig();
	
	void updateSystemConfig(SystemConfigModel config);
}
