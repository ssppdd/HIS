package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.domain.CreateAccount;
import com.his.service.ICreateACCService;

@Controller
public class CreateAccController {
	
	@Autowired
	ICreateACCService service;
	
	@GetMapping("/createAccount")
	public String loadform(Model model) {
		CreateAccount ca=new CreateAccount();
		model.addAttribute("createacc",ca);
		return "createaccform";
	}
	
	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam String email ){

	String emailStatus =  service.findByEmail(email);

	return emailStatus;

	}
	
	@PostMapping("/handlecreatebtn")
	public String createAcc(@ModelAttribute("create")CreateAccount ca,Model model, RedirectAttributes attribut) {
		if(ca.getUserId() != null) {
			service.updateAcc(ca);
			attribut.addFlashAttribute("msg", "User Updated");
			return "redirect:/viewAccInfo";
		}
		else {
			boolean isSaved=service.createAcc(ca);
		if(isSaved) {
			return "createsuccess";
		}else {
			attribut.addFlashAttribute("errMsg", "Account Creation Faild. Contact to your IT team.");
			return "redirect:/createAccount";
		}
		}
		
	}

}
