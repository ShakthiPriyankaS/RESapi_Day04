package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentEntity;
import com.example.demo.service.Studentservice;

@RestController
public class ApiController {
	
	@Autowired
	Studentservice sser;
	
	@PostMapping("addstudent")
	public StudentEntity add(@RequestBody StudentEntity ss) {		
		return sser.saveinfo(ss);
	}
	
	@PostMapping("addnstudent")
	public List<StudentEntity> addndetails(@RequestBody List<StudentEntity> ss)
	{
		return sser.savedetails(ss);
	}
	@GetMapping("showdetails")
	public List<StudentEntity> show()
	{
		return sser.showinfo();
	}
	@PutMapping("update")
	public StudentEntity modify(@RequestBody StudentEntity ss)
	{
		return sser.changeinfo(ss);
	}
	@PutMapping("updatebyid/{id}")
	public String modeifybyId(@PathVariable int id,@RequestBody StudentEntity pp)
	{
		return sser.updateinfobyid(id,pp);
	}
@DeleteMapping("deleteDetails")
	
	public String delete(@RequestBody StudentEntity ss)
	{
		sser.deleteinfo(ss);
		return "Deleted successfully";
		
	}
@GetMapping("showId/{id}")
public Optional<StudentEntity> getbyId(@PathVariable int id )
{
	return sser.showbyid(id);

}
@DeleteMapping("delId/{id}")
public void deleteById(@PathVariable int id)
{
	sser.deleteid(id);

}
}
