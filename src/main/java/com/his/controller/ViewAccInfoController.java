package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.domain.CreateAccount;
import com.his.service.ICreateACCService;

@Controller
public class ViewAccInfoController {
	
	@Autowired
	ICreateACCService service;
	
	@GetMapping("/viewAccInfo")
	public String ViewAccInfo(Model model) {
		List<CreateAccount> list=service.viewAccInfo();
		model.addAttribute("accinfo", list);
		return "viewAllAcc";
	}
	@GetMapping("/getacc")
	@ResponseBody
	public List<CreateAccount> ViewAccInfo(@RequestParam("urole") String role,Model model) {
		List<CreateAccount> list =  service.viewAccInfo1(role);
		
		model.addAttribute("accinfo", list);
		
		return list;
		
	
	}
	
	@GetMapping("/editUser")
	public String editUser(@RequestParam("uid")Integer uid,Model model) {
		
		CreateAccount ca=service.getUserById(uid);
		model.addAttribute("createacc", ca);
		return "createaccform";
		}
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("uid")Integer uid,RedirectAttributes attribut) {
		
		boolean ca=service.deleteUserById(uid);
		if(ca) {
			attribut.addFlashAttribute("msg", "User deleted successfully");
			return "redirect:/viewAccInfo";
		}
		else {
			attribut.addFlashAttribute("msg", "User deletion failed");
			return "redirect:/viewAccInfo";
		}
		
	}
	@GetMapping("/activateUser")
	public String activateUser(@RequestParam("uid")Integer uid,Model model,RedirectAttributes attribut) {
		
		boolean ca=service.activateUserById(uid);
		if(ca) {
			attribut.addFlashAttribute("msg", "User Activated successfully");
			return "redirect:/viewAccInfo";
		}
		else {
			attribut.addFlashAttribute("msg", "User Activation failed");
			return "redirect:/viewAccInfo";
		}
		
	}

}
