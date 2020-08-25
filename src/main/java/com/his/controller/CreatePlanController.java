package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.domain.Plan;
import com.his.service.IPlanService;

@Controller
public class CreatePlanController {
	
	@Autowired
	IPlanService service;
	
	@GetMapping("/createPlan")
	public String createPlan(Model model) {
		Plan p = new Plan();
		model.addAttribute("plans", p);
		return "createPlan";
		
	}
	
	@PostMapping("/handlecreateplan")
	public String createPlan(@ModelAttribute("plans")Plan p, RedirectAttributes attribut) {
		if(p.getPlanId() != null) {
			boolean flag=service.updatePlan(p);
			if(flag) {
				attribut.addFlashAttribute("msg", "Plan Updated");
				return "redirect:/viewPlan";
			}else {
				attribut.addFlashAttribute("msg", "Plan Update failed");
				return "redirect:/createPlan";
			}
		}else {
			boolean flag=service.createPlan(p);
			if(flag) {
				attribut.addFlashAttribute("msg", "Plan Created");
				return "redirect:/createPlan";
			}else {
				attribut.addFlashAttribute("msg", "Plan Create failed");
				return "redirect:/createPlan";
			}
		}
	}
	
	

}
