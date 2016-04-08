import static org.junit.Assert.* ;

import org.junit.Test;

import model.Manuser;
import processor.ProcessUser;

public class TestUser {
	
	@Test
	   public void test_loginuser() {
		Manuser user=new Manuser();
	      System.out.println("Test if table has been sucessfully imported") ;
	      user=ProcessUser.userLogin("user1", "password");
	     // Subscription S = new Subscription(200,2) ;
	      assertEquals(user.getUserid(),1) ;
	   }

}
