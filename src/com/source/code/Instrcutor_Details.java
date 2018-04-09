package com.source.code;

import java.util.List;

import com.source.code.entity.Instructor;
import com.source.code.entity.Instructor_details;

public interface Instrcutor_Details {
	
	

	public void addinstructor(Instructor_details inst_det, Instructor inst);

	public List<Instructor> getAllInstructor();

	public CombinedCommand getInstructorDetail(int id);

	public void deleteInstructor(int id);

}
