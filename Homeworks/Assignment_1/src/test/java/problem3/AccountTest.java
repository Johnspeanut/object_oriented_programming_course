package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account;
    Amount amount;
    Amount amount2;

    public static boolean accountEquals(Account accountA, Account accountB){
        if (accountA == accountB) return true;
        return accountA.getFirstName() == accountB.getFirstName() && accountA.getLastName() == accountB.getFirstName()
                && AmountTest.amountEquals(accountA.getBalance(),accountB.getBalance());
    }

    @Before
    public void setUp() throws Exception {
        amount = new Amount(100,50);
        amount2 = new Amount(20,10);
        account = new Account(amount,"John","Lee");
    }

    @Test
    public void getBalance() {
        AmountTest.amountEquals(new Amount(100,50), account.getBalance());
    }


    @Test
    public void getFirstName() {
        assertEquals("John", account.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Lee",account.getLastName());
    }

    @Test
    public void deposit() {
        Account updatedAccount = account.deposit(amount2);
        AccountTest.accountEquals(new Account(new Amount(120,60),"John","Lee"),updatedAccount);
    }

    @Test
    public void withdrawal() {
        Account updatedAccount = account.withdrawal(amount2);
        AccountTest.accountEquals(new Account(new Amount(80,40),"John","Lee"),updatedAccount);
    }
}