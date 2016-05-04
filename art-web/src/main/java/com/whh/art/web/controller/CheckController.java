package com.whh.art.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.whh.art.service.ICheckService;

@Controller
public class CheckController extends BaseController {
	

	@Resource
	ICheckService checkService;
	
	
}
