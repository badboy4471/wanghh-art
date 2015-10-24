package com.whh.art.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.whh.art.service.IArtService;

@Controller
public class MuseumController {
	
	@Resource
	IArtService artService;

}
