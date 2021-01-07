package com.extc.controller;




import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.extc.servise;
import com.extc.entity.Empolyeesdetails;
import com.extc.entity.Managerdetails;

@ComponentScan("com.extc")
@Controller
@EnableWebMvc
public class controller {
	@Autowired
	servise mvcser;
	   //login Mapping
	@RequestMapping("/loginpage")
	public String openloginpage() {
		System.out.println("done lg");
		return "login";
	}
	
	
	@RequestMapping("/login")
	public ModelAndView checkloging(@ModelAttribute Managerdetails manager){
		ModelAndView mv=new ModelAndView();
		System.out.println("2");
		boolean result=mvcser.checklogin(manager);
		if(result){
			System.out.println("3");
			System.out.println(manager.getEmail());
			System.out.println(manager.getPassword());
			mv.setViewName("redirect:/home");
		}
		else{
			mv.setViewName("login");
		}
		return mv;
	}
	//for homepage Mapping
	@RequestMapping("/home")
	public  ModelAndView openhomepage(@ModelAttribute Empolyeesdetails emp){
		ModelAndView mv=new ModelAndView();
		List<Empolyeesdetails> listempolyee=mvcser.getempolyee(emp);
		if(!listempolyee.isEmpty()){
			System.out.println("home12");
			mv.addObject("list",listempolyee);
			mv.setViewName("home");
		}
		else{
			mv.addObject("msg", "somthing get wrong");
			mv.setViewName("login");
		}
	
		return mv;
		
	}
	//delete Mapping
	@RequestMapping("/deleteempolyee")
	public ModelAndView deleteempolyee(@RequestParam("SrNo") String SrNo){
		
		ModelAndView mv=new ModelAndView();
		int empNo=Integer.parseInt(SrNo);
		//mvcser.deleteuser(SrNo);
		
		if(mvcser.deleteempolyee(empNo)){
			
			List<Empolyeesdetails> listempolyee=mvcser.getempolyee(null);
			mv.addObject("list",listempolyee);
			mv.setViewName("home");
			//mv.addObject("msg", "delete sucessfully");
		}
		else{
			mv.addObject("msg", "something wnt wrong");
		}
		
		
		return mv;
		
		
	}
	//for update Mapping
	@RequestMapping("/update")
	public ModelAndView getUpdate(@RequestParam("SrNo") String SrNo)
	{
		
		ModelAndView mv=new ModelAndView();
		int empNo=Integer.parseInt(SrNo);
		ArrayList<Empolyeesdetails>listuser=mvcser.getempl(empNo);
	
		if(!listuser.isEmpty())
		{
			mv.addObject("list", listuser);
			mv.setViewName("update");
		}
		else
		{
			mv.addObject("msg", "Something went wrong!");
			mv.setViewName("home");
		}
		return mv;
	}
	@RequestMapping("/updatepage")
	public ModelAndView updateempolyee(@ModelAttribute Empolyeesdetails empolyee)
	{
		ModelAndView mv=new ModelAndView();
		if(mvcser.updateempolyee(empolyee))
		{
			ArrayList<Empolyeesdetails> listempolyee=(ArrayList<Empolyeesdetails>) mvcser.getempolyee(null);
			mv.addObject("list",listempolyee);
			mv.setViewName("home");
		}
		else
		{
			mv.addObject("msg", "something Went Wrong!");
		}
		return mv;
	}
	
	
	//Add Employee Mapping
	@RequestMapping("/addempolyee")
	public String openAddempolyee()
	{
		System.out.println("adduser///");
		return "addemp";
	}
	
	
	@RequestMapping("/addemp")
	public ModelAndView addemp(@ModelAttribute Empolyeesdetails empolyee)
	{
		System.out.println("ad12222");
		ModelAndView mv=new ModelAndView();
		if(mvcser.addempolyee(empolyee))
		{
			 List<Empolyeesdetails> listemp=mvcser.getempolyee(null);
			 mv.addObject("list", listemp);
			 mv.setViewName("redirect:/home");
		}
		else
		{
			mv.addObject("msg", "something Went Wrong!");
		}
		return mv;
	}
	

}

