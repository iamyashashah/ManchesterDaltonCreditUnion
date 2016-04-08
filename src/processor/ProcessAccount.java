package processor;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Manaccount;


public class ProcessAccount {
	private static Manaccount account=new Manaccount();
	private static Date now;
	public ProcessAccount(){}
	public static List<Manaccount> getAccounts(long userid){
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="SELECT a FROM Manaccount a where a.userid = :userid";
		TypedQuery<Manaccount> q=em.createQuery(qString, Manaccount.class);
		q.setParameter("userid", userid);
		List<Manaccount> accounts=null;
		try{
			accounts=q.getResultList();
			if(accounts==null||accounts.isEmpty()){
				account=null;
				}
			}finally{
				em.close();
			} 		    
			return accounts;
	}
	public static void addAccount(long userid,String accounttype){
		Manaccount newacc=new Manaccount();
		newacc.setAccountid(getAccountid());
		newacc.setAccounttype(accounttype);
		newacc.setActive("1");
		now=new Date();
		newacc.setCreatedate(now);
		newacc.setModdate(now);;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
		em.persist(newacc);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
	}
	public static Manaccount getAccountById(long accountid){
		Manaccount account=new Manaccount();
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="SELECT a FROM Manaccount a where a.accountid= :accountid";
		Query q=em.createQuery(qString,model.Manaccount.class);
		q.setParameter("accountid", accountid);
		try{
			account=(Manaccount) q.getSingleResult();
			}catch(Exception e){
				System.out.println(e);
			}finally{
				em.close();
				return account;
			} 
	}
	public static long getAccountid(){
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="SELECT (max(a.accountid)+1) FROM Manaccount a";
		Query q=em.createQuery(qString,model.Manaccount.class);
		long newid=0;
		try{
			newid=(long)q.getSingleResult();
			}catch(Exception e){
				System.out.println(e);
			}finally{
				em.close();
				return newid;
			} 
	}
	public static void inactivateAccount(long accountid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		String qString = "update Manaccount a set a.active = :active , a.moddate = :moddate "
				+ "where a.accountid = :accountid";
		TypedQuery<Manaccount> q = em.createQuery(qString, model.Manaccount.class);
		q.setParameter("active", "0");
		now=new Date();
		q.setParameter("moddate", now);
		q.setParameter("accountid", accountid);
		int count = 0;

		try {
			trans.begin();
			count = q.executeUpdate();
			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {

			em.close();
		}
	}
    public static void activateAccount(long accountid){
    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		String qString = "update Manaccount a set a.active = :active , a.moddate = :moddate "
				+ "where a.accountid = :accountid";
		TypedQuery<Manaccount> q = em.createQuery(qString, model.Manaccount.class);
		q.setParameter("active", "1");
		now=new Date();
		q.setParameter("moddate", now);
		q.setParameter("accountid", accountid);
        int count=0;
		try {
			trans.begin();
			count = q.executeUpdate();
			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
           System.out.println(count);
			em.close();
		}
	}
    
}
