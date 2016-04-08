package processor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Manuser;

public class ProcessUser {
	private long userid=0;
	private String employee="";
	private String userName="";
	private String password="";
	public ProcessUser(){}
	public long userLogin(String name, String newpassword){
		this.userName=name;
		this.password=newpassword;
		EntityManager em=DBUtil.getEmFactory().createEntityManager();
		String qString="SELECT u FROM Manuser u where u.username = :username AND u.password = :userpassword";
		TypedQuery<Manuser> q=em.createQuery(qString, Manuser.class);
		q.setParameter("username", userName);
		q.setParameter("userpassword", password);
		List<Manuser> users;
		Manuser user;
		try{
			users=q.getResultList();
			if(users==null||users.isEmpty()){
				user=null;
				userid=0;
				}else{
				user=users.get(0);
				}
			}finally{
				em.close();
			} 		    
			return user.getUserid();
	}
}
