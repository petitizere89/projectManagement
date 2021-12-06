package com.izere.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.izere.pma.dao.EmployeeDAO;
import com.izere.pma.dao.ProjectRepository;
import com.izere.pma.entities.Employee;
import com.izere.pma.entities.Project;
//Project controller for routing and binding

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeDAO EmpDAO;
	
	@GetMapping
	public String displayEmployees(Model model) {
		
		List<Project> projects= proRepo.findAll();
		model.addAttribute("projects",projects);
		
		return"/projects/List-projects";
		
	}
	
	@GetMapping("/new")
	public String displayNewProjectHTML(Model model) {
		Project aproject = new Project();
		model.addAttribute("project",aproject);
		
		//Retrieving and displaying data on the website project tabs
		List<Project> projects = proRepo.findAll();
		model.addAttribute("dispProjects",projects);
		
		List<Employee> employees = EmpDAO.findAll();
		model.addAttribute("AllEmployees",employees);
		
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//this method is handled by saving to the database
		proRepo.save(project);

		//Redirect is needed to prevent duplicate submissions
		return"redirect:/projects/new";
	}
	
}
