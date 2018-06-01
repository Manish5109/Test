package com.study.doa.study;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.study.dao.utility.DBUtility;
import com.study.study.StudyModel;

@Repository
public class Study {

	public void studySave(StudyModel study) {
		Session session = DBUtility.getConnection().openSession();
		Transaction tx = session.beginTransaction();
		session.save(study);
		tx.commit();
		session.close();

	}

	public void delete(String id) {
		Session session = DBUtility.getConnection().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery("delete from Study where id='" + id + "'");
		query.executeUpdate();
		tx.commit();
		session.close();

	}
}
