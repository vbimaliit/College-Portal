package com.source.code;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.source.code.entity.Instructor;
import com.source.code.entity.Instructor_details;

@Controller
@RequestMapping("/mainclass")
public class mainClass {
	
	@Autowired
	private Instrcutor_Details instdet;
	@Autowired
    private JavaMailSender mailSender;
	
	@RequestMapping("/showallinstructor")
//	public String showallinstructor(Model themodel)
	public ModelAndView howallinstructor()
	{
	
		List <Instructor>  inst = instdet.getAllInstructor();
		
	//	themodel.addAttribute("allinstructor",inst);
		
	//	return "all-instructor";
		
		return new ModelAndView ("all-instructor","allinstructor",inst );
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
		
		String recipientAddress = "vbimal@hawk.iit.edu";
		String subject = "you are added as intructor";
		String message = "Welcome";
		
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
		
        mailSender.send(email);
		
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
	 
	 @RequestMapping("/searchinstructor")
	 public String searchInstructor(@RequestParam("instructorname") String searchname,Model model)
	 {
		 
		 List<Instructor> inst = instdet.searchInstructor(searchname);
		 
		 model.addAttribute("allinstructor",inst);
		 
		 return  "all-instructor";
	 }
}
