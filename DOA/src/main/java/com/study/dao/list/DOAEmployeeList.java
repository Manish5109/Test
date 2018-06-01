package com.study.dao.list;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.study.dao.utility.DBUtility;
import com.study.model.registration.EmployeeRegistration;

@Repository
public class DOAEmployeeList {
	
	public List<EmployeeRegistration> employeeList(){
		List<EmployeeRegistration> list = null;
		Session session = DBUtility.getConnection().openSession();
		Transaction tr = session.beginTransaction();
		list = session.createQuery("from EmployeeRegistration").list();
		return list;
	}

}
