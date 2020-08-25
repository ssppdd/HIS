package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.domain.Plan;
import com.his.service.IPlanService;

@Controller
public class ViewPlanController {
	
	@Autowired
	IPlanService service;
	
	@GetMapping("/viewPlan")
	public String viewPlan(Model model) {
		List<Plan> p = service.viewPlan();
		model.addAttribute("plans", p);
		return "viewplans";
	}
	
	@GetMapping("/editPlan")
	public String editPlan(@RequestParam("pid") Integer pid,Model model) {
		Plan p = service.findById(pid);
		model.addAttribute("plans", p);
		return "createPlan";
	}
	
	@GetMapping("/deletePlan")
	public String deletePlan(@RequestParam("pid") Integer pid, RedirectAttributes attribut) {
		boolean flag = service.deletePlan(pid);
		if(flag) {
			attribut.addFlashAttribute("msg", "Plan Deleted");
			return "redirect:/viewPlan";
		}else {
			attribut.addFlashAttribute("msg", "Plan Delete failed");
			return "redirect:/viewPlan";
		}
	}
	
	@GetMapping("/activatePlan")
	public String activatePlan(@RequestParam("pid") Integer pid, RedirectAttributes attribut) {
		boolean flag = service.activatePlan(pid);
		if(flag) {
			attribut.addFlashAttribute("msg", "Plan Activated");
			return "redirect:/viewPlan";
		}else {
			attribut.addFlashAttribute("msg", "Plan Activation failed");
			return "redirect:/viewPlan";
		}
	}

}
