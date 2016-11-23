package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.mapper.SystemConfigMapper;
import com.whh.art.dao.model.SystemCmdModel;
import com.whh.art.dao.model.SystemConfigModel;

public class SystemConfigServiceImpl implements ISystemConfigService {
	
	
	SystemConfigMapper systemConfigMapper;

	@Override
	public SystemConfigModel getSystemConfig() {
		
		return systemConfigMapper.getSystemConfig();
	}

	@Override
	public void updateSystemConfig(SystemConfigModel config) {
		systemConfigMapper.updateSystemConfig(config);

	}
	
	@Override
	public List<SystemCmdModel> loadSystemCmds(String cmdType,String cmd) {
		return systemConfigMapper.loadSystemCmds(cmdType,cmd);
	}

	public void setSystemConfigMapper(SystemConfigMapper systemConfigMapper) {
		this.systemConfigMapper = systemConfigMapper;
	}

}
