package com.source.code;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.source.code.entity.Instructor;
import com.source.code.entity.Instructor_details;

@Controller
@RequestMapping("/mainclass")
public class mainClass {
	
	@Autowired
	private Instrcutor_Details instdet;
	
	@RequestMapping("/showallinstructor")
	public String showallinstructor(Model themodel)
	{
	
		List <Instructor>  inst = instdet.getAllInstructor();
		
		themodel.addAttribute("allinstructor",inst);
		
		return "all-instructor";
		
	}
	
	
	
	
	
	
	@RequestMapping("/addinstructor")
	public String addinstructor(Model themodel)
	{
		
	   CombinedCommand cmd = new CombinedCommand();
	   themodel.addAttribute("combinedobject",cmd);
		
	  return "addinstructor";
	  
	  }
	
	@RequestMapping("/processinstructor")
	public String processInstructor(@ModelAttribute("combinedobject") CombinedCommand cmd)
	{
		Instructor_details inst_det = cmd.getInst_det();
		
		Instructor inst = cmd.getInst();
		
		instdet.addinstructor(inst_det,inst);
		
		return "redirect:/mainclass/showallinstructor";
	}
	
	
	@RequestMapping("/updateinstructor")
	public String updateInstructor(@RequestParam("tempinstructor_id") int id,Model themodel)
	{
		
		CombinedCommand cmd = instdet.getInstructorDetail(id);
		
		themodel.addAttribute("combinedobject",cmd);
		
		return "addinstructor";
	}

	
	 @RequestMapping("/delete")
	 public String DeleteInstructor(@RequestParam("tempinstructor_id") int id)
	 {
		 instdet.deleteInstructor(id);
		 
		 return "redirect:/mainclass/showallinstructor";
	 }
}
