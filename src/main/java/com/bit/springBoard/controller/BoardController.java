package com.bit.springBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.springBoard.command.BoardCommand;
import com.bit.springBoard.command.BoardListCommand;
import com.bit.springBoard.command.BoardWriteCommand;

@Controller
public class BoardController {
	BoardCommand command;
	
	@RequestMapping(value="writeView")
	public String writeView() {
		return "writeView";
	}
	
	@RequestMapping(value="write")
	public String write(HttpServletRequest req, Model model) {
		model.addAttribute("request", req);
		command = new BoardWriteCommand();
		command.execute(model);
		return "redirect:list";
	}

	@RequestMapping(value="list")
	public String list(Model model) {
		command = new BoardListCommand();
		command.execute(model);
		return "list";
	}
}
