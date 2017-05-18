package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import logic.CprControlTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	CprControlTest.class, DBTest.class, newCustomerTest.class
})

public class AllTest {

}