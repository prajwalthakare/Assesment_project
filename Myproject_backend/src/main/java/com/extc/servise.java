package com.extc;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extc.dao.dao;
import com.extc.entity.Empolyeesdetails;
import com.extc.entity.Managerdetails;



@Service
public class servise {
	SessionFactory sessionfactory;
	@Autowired
	dao mvcd;
//all servises
	public boolean checklogin(Managerdetails manager) {
		// TODO Auto-generated method stub
		System.out.println("8888");
		boolean result = mvcd.checklogin(manager);
		return result;
	}

	public List<Empolyeesdetails> getempolyee(Empolyeesdetails emp) {
		List<Empolyeesdetails> listempolyee = mvcd.empolyees(emp);
		return listempolyee;

	}

	public boolean deleteempolyee(int empNo) {

		// TODO Auto-generated method stub
		return mvcd.deleteempolyee(empNo);
	}

	public ArrayList<Empolyeesdetails> getempl(int empNo) {
		return (ArrayList<Empolyeesdetails>)mvcd.getempolyees(empNo);
		
	}

	

	public boolean addempolyee(Empolyeesdetails empolyee) {
		// TODO Auto-generated method stub
		return mvcd.addempolyee(empolyee);
	}

	public boolean updateempolyee(Empolyeesdetails empolyee) {
		// TODO Auto-generated method stub
		return mvcd.updateuser(empolyee);
	}

	
	}

