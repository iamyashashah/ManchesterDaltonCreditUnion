package processor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Mantransaction;
import model.Mantransaction;

public class ProcessTransaction {
	
public ProcessTransaction(){}

public static double getBalance(long _accountid) {
	//
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select sum(t.amount) from Mantransaction t where t.manaccount.accountid = :accountid";
    Mantransaction mt = new Mantransaction();

	Query q = em.createQuery(qString, model.Mantransaction.class);
	q.setParameter("accountid", _accountid);
	double balance = 0;

		
	try {
		//		trans.begin();
		System.out.println("accountid = " + _accountid);
		balance =  (double) q.getSingleResult();

		System.out.println("balance = " + balance );
		//			trans.commit();

	} catch (Exception e) {
		System.out.println(e);
		//			trans.rollback();
	} finally {

		em.close();
		System.out.println("Finished");
		return balance;
	}


}


}
