package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.model.SystemCmdModel;
import com.whh.art.dao.model.SystemConfigModel;

public interface ISystemConfigService {

	SystemConfigModel getSystemConfig();
	
	void updateSystemConfig(SystemConfigModel config);
	
	List<SystemCmdModel> loadSystemCmds(String cmdType,String cmd);
}
