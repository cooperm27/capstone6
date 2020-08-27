package com.example.capstone_6;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.example.capstone_6.dao.TaskDao;
import com.example.capstone_6.pojo.Task;
import com.example.capstone_6.pojo.User;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
