import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

public class MainCTest {

	@Test
	public void testAddAccount() {

		MemberInfo mInfo = new MemberInfo();
		mInfo.setFName("anurag");
		mInfo.setLName("Singh");
		mInfo.setId(12345);
		mInfo.setBalance(21.34);

		MainC.addAccount(mInfo);

		assertTrue(MainC.hashT1.containsKey(mInfo.getId()));
	}

	@Test
	public void testDeleteAccount() {
		MemberInfo mInfo = new MemberInfo();
		mInfo.setFName("anurag");
		mInfo.setLName("Singh");
		mInfo.setId(12346);
		mInfo.setBalance(21.34);
		MainC.addAccount(mInfo);
		MainC.deleteAccount(12346);
		assertFalse(MainC.hashT1.contains(mInfo.getId()));
	}

	@Test
	public void testupdateBalance() {
		MemberInfo mInfo = new MemberInfo();
		mInfo.setFName("anurag");
		mInfo.setLName("Singh");
		mInfo.setId(12345);
		mInfo.setBalance(21.34);
		MainC.addAccount(mInfo);
		MainC.updateBalance(12345, "A", 500);

		MemberInfo updatedAccount = MainC.hashT1.get(12345);

		assertEquals(521.34, updatedAccount.getBalance(), 0.00);

	}

	@Test
	public void testModifyAccount() {
		MemberInfo mInfo = new MemberInfo();
		mInfo.setFName("anurat");
		mInfo.setLName("Singh");
		mInfo.setId(12345);
		mInfo.setBalance(21.34);
		MainC.addAccount(mInfo);
		MainC.updateAccount(12345, 1, "Anurag", "Rawat");
		MemberInfo updatedAccountDetails = MainC.hashT1.get(12345);
		assertFalse("anurat".equals(updatedAccountDetails.getFName()));

	}

}
