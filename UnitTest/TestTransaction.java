import static org.junit.Assert.*;

import org.junit.Test;

import model.Manuser;
import processor.ProcessTransaction;


public class TestTransaction {
public void seeTransaction(){
	
	
}
@Test
public void test_balance() {
	
	double balance = 0;
	
	
   System.out.println("Test if table has been sucessfully imported") ;
   
   balance = ProcessTransaction.getBalance(1);
  

   assertTrue(balance == 62.43) ;
}


}
