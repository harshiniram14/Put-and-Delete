package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

@RestController
public class ApiController {
	@Autowired
	StudentService stuService;
	
	@PostMapping("/addDetails")
	public Student addInfo(@RequestBody Student st) {
		return stuService.saveDetails(st);
	}
	@PutMapping("/updateDetails")
	public Student updateInfo(@RequestBody Student st1)
	{
		return stuService.updateDetails(st1);
	}
	@DeleteMapping("/deleteDetails/{id}")
	public String deleteInfo(@PathVariable("id") int id)
	{
		stuService.deleteDetails(id);
		return "Deleted details";
		
	}
	@GetMapping("showDetails")
	public List<Student> fetchDetails()
	{
		return stuService.getDetails();
	}
}
