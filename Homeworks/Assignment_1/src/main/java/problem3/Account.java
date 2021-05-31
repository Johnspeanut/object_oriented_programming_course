package problem3;

/**
 * Account is a simple object that has amount, firstName, and lastName.
 * */
public class Account {
    private Amount amount;
    private String firstName;
    private String lastName;

    /**
     * Constructor that creates a new Account object with the specified amount, firstName, and lastName.
     * @param amount - amount of the new Amount object.
     * @param firstName - first name of the new Amount object.
     * @param lastName - last name of the new Amount object.
     * */
    public Account(Amount amount, String firstName, String lastName) {
        this.amount = amount;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the balance amount of the Account
     * @return the balance amount of the Account
     * */
    public Amount getBalance() {
        return amount;
    }

    /**
     * Returns the first name of the Account
     * @return the first name of the Account
     * */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the Account
     * @return the last name of the Account
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Deposite amount of money into account.
     * @param amount - amount of the deposit.
     * @return the new Account object with the updated balance.
     * */
    public Account deposit(Amount amount){
        Amount amountUpdated = amount.add(this.amount, amount);
        return new Account(amountUpdated, this.firstName, this.lastName);
    }

    /**
     * Withdrawal amount of money from account.
     * @param amount - amount of the withdrawal.
     * @return the new Account object with the updated balance.
     * */
    public Account withdrawal(Amount amount){
        Amount amountUpdated = amount.minus(this.amount,amount);
        return new Account(amountUpdated, this.firstName, this.lastName);
    }
}
