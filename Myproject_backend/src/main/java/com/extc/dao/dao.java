package com.extc.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.extc.entity.Empolyeesdetails;
import com.extc.entity.Managerdetails;
@Repository
public class dao {
	@Autowired
	SessionFactory sessionfactory;
//login check
	public boolean checklogin(Managerdetails manager) {
		String email=manager.getEmail();
		String password=manager.getPassword();
		System.out.println("221");
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Managerdetails.class);
		criteria.add(Restrictions.eq("email",email));
		criteria.add(Restrictions.eq("password",password));
		
		List<Managerdetails> listmag=criteria.list();
		if(!listmag.isEmpty())
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	//list of employee will be iterate
		public List<Empolyeesdetails> empolyees(Empolyeesdetails emp) {
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Empolyeesdetails.class);
		List<Empolyeesdetails>listempolyee=criteria.list();
			return listempolyee;
		}
		
		
		//delete employee id
		public boolean deleteempolyee(int empNo) {
			Session session=sessionfactory.openSession();
			Transaction transcation=session.beginTransaction();
			Empolyeesdetails user=session.get(Empolyeesdetails.class, empNo);
			session.delete(user);
			//session.delete("id",SrNO);
			transcation.commit();
			
			return true;
		}
//for empolyee list config
		public List<Empolyeesdetails> getempolyees(int empNo) {
			Session session=sessionfactory.openSession();
			session.beginTransaction();
			
			Criteria criteria=session.createCriteria(Empolyeesdetails.class);
			criteria.add(Restrictions.eq("SrNo", empNo));
			
			List<Empolyeesdetails>listempolyee=criteria.list();
		
			return listempolyee;
		}
		
		
		//add empolyee config
		public boolean addempolyee(Empolyeesdetails empolyee) {
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.save(empolyee);
			transaction.commit();
			
			return true;
		}
		public boolean updateuser(Empolyeesdetails empolyee) {
			Session session=sessionfactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			session.saveOrUpdate(empolyee);
			transaction.commit();
			
			return true;
		}


}
