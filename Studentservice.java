package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentEntity;
import com.example.demo.repository.Studentrepo;

@Service
public class Studentservice{
	
	@Autowired
	Studentrepo sr;
	 
	public StudentEntity saveinfo(StudentEntity pp)
	{
		return sr.save(pp);
	}
	
	public List<StudentEntity> showinfo()
	{
		return sr.findAll();
	}
	
	public List<StudentEntity> savedetails(List<StudentEntity> pp)
	{
		return sr.saveAll(pp);
	}
	public StudentEntity changeinfo(StudentEntity ss)
	{
		return sr.saveAndFlush(ss);
	}
	public String updateinfobyid(int id,StudentEntity ss)
	{
		sr.saveAndFlush(ss);
		if(sr.existsById(id))
		{
			return "updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	public Optional<StudentEntity> showbyid(int id)
	{
		return sr.findById(id);
	}
	public void deleteinfo(StudentEntity ss)
	{
		sr.delete(ss);
	}
	public void deleteid(int id)
	{
		sr.deleteById(id);
	}
} 