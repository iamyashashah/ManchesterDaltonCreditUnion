import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Manaccount;
import processor.ProcessAccount;

public class TestUpdate {
	@Test
	   public void test_updateaccount() {
		Manaccount account=new Manaccount();
	      System.out.println("Test if table has been sucessfully updated") ;
	      ProcessAccount.inactivateAccount(1);
	      System.out.println("Account is inactivated");
	      ProcessAccount.activateAccount(1);
	      System.out.println("Account is reactivated");
	      account=ProcessAccount.getAccountById(1);
	      assertEquals(account.getActive(),"1") ;
	   }
}
