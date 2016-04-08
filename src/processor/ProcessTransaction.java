package processor;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Manaccount;
import model.Mantransaction;


public class ProcessTransaction {

	public ProcessTransaction() {
	}

	public static double getBalance(long _accountid) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select sum(t.amount) from Mantransaction t where t.manaccount.accountid = :accountid";
		Mantransaction mt = new Mantransaction();

		Query q = em.createQuery(qString, model.Mantransaction.class);
		q.setParameter("accountid", _accountid);
		double balance = 0;

		try {
			// trans.begin();
			System.out.println("accountid = " + _accountid);
			balance = (double) q.getSingleResult();

			System.out.println("balance = " + balance);
			// trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			// trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");
			return balance;
		}

	}

	public static List<Mantransaction> getTransListById(long _accountid) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select t from Mantransaction t where t.manaccount.accountid = :accountid";
		TypedQuery<Mantransaction> q = em.createQuery(qString, model.Mantransaction.class);
		q.setParameter("accountid", _accountid);

		List<Mantransaction> translist = null;


		try {

			translist = q.getResultList();
			if (translist == null || translist.isEmpty())
				translist = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return translist;
		}

	}	


	public static void insertTransaction(long _accountid, String _transtype, double _amount)  {
		//
		Date today = new Date();
		System.out.println("today " + today);

		long maxid = getNewId();
		
		Mantransaction mt = new Mantransaction();
			
		Manaccount ma = new Manaccount();
		
			
		ma.setAccountid(_accountid);
				
					
		mt.setTransid(maxid);			
		mt.setTranstype(_transtype);
		mt.setAmount(_amount);
		mt.setTransdate(today);
				
		mt.setManaccount(ma);
		
		

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();


		int count = 0;

		try {
			trans.begin();
			em.persist(mt);

			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");

		}

	}

	public static long getNewId() {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select (max(t.todoid) + 1) from Todo t";


		Query q = em.createQuery(qString, model.Mantransaction.class);
		long newId = 0;

		try {
			//		trans.begin();
			newId = (long) q.getSingleResult();
			//			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			//			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");
			return newId;
		}
	}


	
}
