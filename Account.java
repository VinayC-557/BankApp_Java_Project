package bankaccountapp;

public abstract class Account implements IBaseRate {
	
	// List common properties for savings and checking account
	private String name;
	private String sSN;
	private double balance;
	
	private static int index=10000;
	protected String accountNumber;
	protected double rate;
	
	//Constructor to set base properties and initialize the account 
	public Account(String name,String sSN,double initDeposit) {
		
		this.name=name;
		this.sSN=sSN;
		balance=initDeposit +550;
		
	
		//set account number
		index++;
		this.accountNumber=setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		
		String lastTwoOfSSN=sSN.substring(sSN.length()-2, sSN.length());
	int UniqueID = index;
	/*generates random number between 0 and 1 and multiplies with 
	 * 10 power 3 and generates random 3 digits PIN at the end of account number 
	 */
	int randomNumber= (int)(Math.random()*Math.pow(10, 3));
	
	//returns to accountNumber 
		return lastTwoOfSSN + UniqueID + randomNumber;
	}
	
	public void compound() {
		
		double accruedInterest=balance*(rate/100);
		balance=balance+accruedInterest;
		System.out.println("Accrued Interest $: " + accruedInterest);
		printBalance();
	}
	
	//List common methods-transactions
	
	public void deposit(double amount) {
		balance=balance+amount;
		System.out.println("Deposit amount $: "+amount);
		printBalance();
	}
	public void withDraw(double amount) {
		balance=balance-amount;
		System.out.println("withDraw amount $: "+amount);
		printBalance();
	}
	public void transfer(String toWhere,double amount) {
		balance=balance-amount;
		System.out.println("Transfer "+ amount + " to "+ toWhere);
		printBalance();
	}
	
	void printBalance() {
		System.out.println("Your Balance $ is: " + balance);
	}
	
	
	
	
	public void showInfo() {
		System.out.println(
				"NAME: "+name+
				"\nACCOUNT NUMBER: "+accountNumber+
				"\nBALANCE: "+balance +
				"\n RATE: "+ rate +"%"
				);
	}

}
