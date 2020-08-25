package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.domain.Unlock;
import com.his.service.ICreateACCService;

@Controller
public class ChangePwdController {
	
	@Autowired
	ICreateACCService service;
	
	@GetMapping("/unlockAcc")
	public String changePwd(@RequestParam("email") String email, Model model) {
		Unlock unlock= new Unlock();
		   unlock.setEmail(email);
		   model.addAttribute("unlock", unlock);
		   return "unlock";
		
	}
	
	 @PostMapping("/unlock")
	   public String unlock(@ModelAttribute("unlock") Unlock unlock, Model model, RedirectAttributes attribut) {
		   
		   boolean flag=service.validTempPwd(unlock);
		   if(flag==true) {
			   return "redirect:/login";
		   }
		   else {
			   attribut.addFlashAttribute("errMsg", "InCorrect Temporary Password");
			   return "redirect:/unlock";
		   }
	   }
	 @GetMapping("/login")
	 public String login(Model model) {
		 return "login";
	 }
	

}
