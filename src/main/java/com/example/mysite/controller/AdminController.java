package com.example.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mysite.service.SiteService;
import com.example.mysite.vo.SiteVo;
import com.example.security.Auth;
import com.example.security.Auth.Role;

@Auth(Role.ADMIN)
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private SiteService siteService;

	@RequestMapping({ "", "/main" })
	public String main(Model model) {
		SiteVo siteVo = siteService.getSiteInformation();
		model.addAttribute("site", siteVo);
		return "admin/main";
	}

	@RequestMapping(value="/main/update", method=RequestMethod.POST)
	public String update(@ModelAttribute SiteVo siteVo, Model model) {
		System.out.println(siteVo);
		boolean result = siteService.updateSiteInformation(siteVo);
		siteVo = siteService.getSiteInformation();
		model.addAttribute("site", siteVo);
		model.addAttribute("result", result);
		return "admin/main";
	}

	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	
	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}

	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
}
