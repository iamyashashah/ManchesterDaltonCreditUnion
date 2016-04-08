import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Manaccount;
import processor.ProcessAccount;

public class TestAccount {
	@Test
	   public void test_getAccount() {
		Manaccount account=new Manaccount();
	      System.out.println("Test if table has been sucessfully imported") ;
	      account=ProcessAccount.getAccountById(1);
	      assertEquals(account.getAccounttype(),"CHECK") ;
	   }
	
}
