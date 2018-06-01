package com.study.doa.login;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.study.dao.utility.DBUtility;
import com.study.model.login.Login;

@Repository
public class LoginDOA {

	public boolean login(String user, String pwd) {

		boolean userFlag = false;
		Session session = DBUtility.getConnection().openSession();
		String sql = "select * from emp_login as lg where lg.user=? and lg.password=?";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, user);
		query.setParameter(1, pwd);
		List list = query.list();
		session.close();

		if ((list != null) && (list.size() > 0)) {
			userFlag = true;
		}
		// System.out.println(userFlag);
		return userFlag;
	}

	public void loginSave(Login login) {
		Session session = DBUtility.getConnection().openSession();
		Transaction trx = session.beginTransaction();
		session.save(login);
		trx.commit();
		session.close();
	}
}
