package com.whh.art.service;

import com.whh.art.dao.model.SystemConfigModel;

public interface ISystemConfigService {

	SystemConfigModel getSystemConfig();
	
	void updateSystemConfig(SystemConfigModel config);
}
