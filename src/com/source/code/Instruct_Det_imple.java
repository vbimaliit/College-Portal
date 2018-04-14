package com.source.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.source.code.entity.Instructor;
import com.source.code.entity.Instructor_details;

@Component

public class Instruct_Det_imple implements Instrcutor_Details {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Instructor> getAllInstructor() {
		// TODO Auto-generated method stub
		
				
		Session session = sessionFactory.getCurrentSession();
		
		Query <Instructor> query = session.createQuery("from Instructor",Instructor.class);
		
		List<Instructor> inst = query.getResultList();
		
	//	session.getTransaction().commit();
		
		
		
		return inst;
		
		
		
	}

	@Override
	@Transactional
	public void addinstructor(Instructor_details inst_det, Instructor inst) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		inst.setInstdetails(inst_det);
		
		System.out.println("Inserting data");
		
		session.saveOrUpdate(inst);
		
	}

	@Override
	@Transactional
	public CombinedCommand getInstructorDetail(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Query <Instructor> query = session.createQuery("select i from Instructor i"
				+ " JOIN fetch i.instdetails"
				+ " where i.id=:theid",Instructor.class);
		
		query.setParameter("theid",id);
		
		Instructor inst = query.getSingleResult();
		
		Instructor_details inst_det = inst.getInstdetails();
		
		CombinedCommand cmd = new CombinedCommand ();
		
		cmd.setInst(inst);
		
		cmd.setInst_det(inst_det);
		
		
		return cmd;
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from  Instructor where id=:theid");
		
		query.setParameter("theid", id);
		
		query.executeUpdate();
		
		
	}

	@Override
	@Transactional
	public List<Instructor> searchInstructor(String searchname) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Query <Instructor> query = session.createQuery("from Instructor where lower(firstname) like :thename or lower(lastname) like :thename",Instructor.class );
		
		query.setParameter("thename", searchname)
;
		List <Instructor> list = query.getResultList();
		
		
		
		return list;
	}

	


}
