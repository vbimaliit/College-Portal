package com.source.code;

import javax.validation.constraints.Size;

import com.source.code.entity.Instructor;
import com.source.code.entity.Instructor_details;

public class CombinedCommand {
	
	Instructor inst;
	
	Instructor_details inst_det;

	public Instructor getInst() {
		return inst;
	}
	
//    @Size(min=2,message="size should be greater than 1")
//	String lastname = inst.getLastname();
	
	public void setInst(Instructor inst) {
		this.inst = inst;
	}

	public Instructor_details getInst_det() {
		return inst_det;
	}

	public void setInst_det(Instructor_details inst_det) {
		this.inst_det = inst_det;
	}
	

}
