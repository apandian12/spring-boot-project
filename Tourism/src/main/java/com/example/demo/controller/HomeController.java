package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.List;
import com.example.demo.repository.ListRepository;
import com.example.demo.service.ListService;

@Controller
public class HomeController {
	
	@Autowired
	private ListRepository listRepository;
	
	@Autowired
	private ListService listService;
	
	
	
	public HomeController(ListRepository listRepository, ListService listService) {
		super();
		this.listRepository = listRepository;
		this.listService = listService;
	}

	@GetMapping("")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String AdminPage() {
		return "admin";
	}
	
	@GetMapping("/addpackage")
	public String AddPackage(Model model) {
		model.addAttribute("list", new List());
		return "addPackage";
	}
	@GetMapping("/editpackage")
	public String EditPackage(Model model) {
		model.addAttribute("lists", listService.getAllList());
		return "editPackage";
	}
	@GetMapping("/editPackage/update/{id}")
	public String editPackageForm(@PathVariable Long id, Model model) {
		model.addAttribute("list", listService.getListById(id));
		return"edit_package";
	}
	
	@PostMapping("/package")
	public String savePackage(List list) {
		listRepository.save(list);
		return "admin";
	}
	
	@GetMapping("/editPackage/{id}")
	public String deletePackage(@PathVariable Long id) {
		listService.deletePackageById(id);
		return "redirect:/editpackage";
	}
	
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("list") List list, Model model) {
		
		//get student from database by id
		List existingPackage = listService.getListById(id);
		existingPackage.setId(id);
		existingPackage.setPlace(list.getPlace());
		existingPackage.setAmount(list.getAmount());
		//save updated student object
		listService.updatePackage(existingPackage);
		return "redirect:/editpackage";
		
	}
	@GetMapping("/book/{id}")
	public String Book(@PathVariable Long id, Model model) {
		model.addAttribute("list", listService.getListById(id));
		return"Booking";
	}
	
	

}
