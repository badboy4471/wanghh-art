package com.whh.art.web.controller;

import java.util.Map;

import com.whh.art.web.form.JSONParam;

public abstract class BaseController {
	
	public void convert2Map(Map map, JSONParam[] params) {
		for (JSONParam param : params) {
			map.put(param.getName(), param.getValue());
		}
	}

}
