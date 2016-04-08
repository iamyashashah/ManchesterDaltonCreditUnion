package processor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Manuser;

public class ProcessUser {
	private static Manuser user=null;
	public ProcessUser(){}
	public static Manuser userLogin(String name, String newpassword){
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="SELECT u FROM Manuser u where u.username = :username AND u.password = :userpassword";
		TypedQuery<Manuser> q=em.createQuery(qString, Manuser.class);
		q.setParameter("username", name);
		q.setParameter("userpassword", newpassword);
		List<Manuser> users;
		try{
			users=q.getResultList();
			if(users==null||users.isEmpty()){
				user.setUserid(0);
				user.setEmployee("0");
				user.setUsername("");
			    user.setPassword("");
				}else{
				user=users.get(0);
				}
			}finally{
				em.close();
			} 		    
			return user;
	}
	public static long getNewid(){
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="SELECT (max(u.userid)+1) FROM Manuser u";
		Query q=em.createQuery(qString,model.Manuser.class);
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
	public static void addUser(String name, String password){
		Manuser newuser=new Manuser();
		newuser.setUserid(getNewid());
		newuser.setEmployee("0");
		newuser.setPassword(password);
		newuser.setUsername(name);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
		em.persist(newuser);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
	}
	public static long getUserid(){
		return user.getUserid();
	}
	public static String getUsername(){
		return user.getUsername();
	}
	public static String getPassword(){
		return user.getPassword();
	}
	public static String getEmployee(){
		return user.getEmployee();
	}
}
