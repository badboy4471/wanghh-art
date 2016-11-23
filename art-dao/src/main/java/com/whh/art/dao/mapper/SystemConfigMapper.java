package com.whh.art.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whh.art.dao.model.SystemCmdModel;
import com.whh.art.dao.model.SystemConfigModel;

public interface SystemConfigMapper {

	SystemConfigModel getSystemConfig();

	void updateSystemConfig(SystemConfigModel config);

	List<SystemCmdModel> loadSystemCmds(@Param("cmdType") String cmdType,
			@Param("cmd") String cmd);
}
