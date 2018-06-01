package com.study.doa.study;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.study.dao.utility.DBUtility;
import com.study.study.TestTable;

public class TestTableDOA {

	
	public void test(){
		TestTable tt = new TestTable();
		tt.setId(101);
		tt.setFname("manish");
		tt.setLname("kumar");
		Session session = DBUtility.getConnection().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tt);
		tx.commit();
		session.close();
		
		
	}
	
	public static void main(String args[]){
		TestTableDOA t = new TestTableDOA();
		t.test();
	}

}
