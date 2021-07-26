import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAccountTest {
    @Test
    // we will be depositing $5 and then $7 to make sure deposit (and balance) is working correctly
    public void testDeposit() {
        //Set up
        BankAccount b = new BankAccount();
        b.deposit(5);
        b.deposit(5);

        //expected value
        Float expectedResult = 12f;

        //assertEquals to get actual value
        assertEquals((Float) expectedResult, (Float) b.balance);
    }

    @Test
    // we will be depositing $5 and then withdrawing $5 to make sure withdraw (and balance) is working correctly
    public void testWithdraw() {
        //Set up
        BankAccount b = new BankAccount();
        b.deposit(5);
        b.withdraw(5);

        //expected value
        Float expectedResult = 0f;

        //assertEquals to get actual value
        assertEquals((Float) expectedResult, (Float) b.balance);
    }
}