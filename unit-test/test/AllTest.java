package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import database.DBTest;
import logic.CprControlTest;
import logic.newCustomerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	CprControlTest.class, DBTest.class, newCustomerTest.class
})

public class AllTest {

}