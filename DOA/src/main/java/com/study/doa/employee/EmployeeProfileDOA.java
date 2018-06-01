package com.study.doa.employee;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.study.dao.utility.DBUtility;
import com.study.model.employee.EmployeeProfileModel;

@Repository
public class EmployeeProfileDOA {

	public void saveProfileDOA(EmployeeProfileModel epm){
		Session session = DBUtility.getConnection().openSession();
		Transaction trx = session.beginTransaction();
		session.save(epm);
		trx.commit();
		session.close();
	}
	
}
