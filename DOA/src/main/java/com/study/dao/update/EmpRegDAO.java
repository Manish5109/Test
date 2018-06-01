package com.study.dao.update;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.study.dao.utility.DBUtility;
import com.study.model.registration.EmployeeRegistration;

@Repository
public class EmpRegDAO {

	public void saveRegistration(EmployeeRegistration er) {
		Session session = DBUtility.getConnection().openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(er);
		tr.commit();
		session.close();
	}

	public EmployeeRegistration getReg(String id) {
		Session session = DBUtility.getConnection().openSession();
		//EmployeeRegistration empReg = (EmployeeRegistration) session.load(EmployeeRegistration.class, id);
		EmployeeRegistration empReg = (EmployeeRegistration) session.get(EmployeeRegistration.class, id);
		session.close();
		
		
		return empReg;
	}
	
	public void deleteRegistration(String id){
		Session session = DBUtility.getConnection().openSession();
		EmployeeRegistration empReg = new EmployeeRegistration();
		empReg.setId(id);
		Transaction trx = session.beginTransaction();
		//session.delete(session.load(EmployeeRegistration.class, id));
		session.delete(empReg);
		trx.commit();
		session.close();
	}

}
