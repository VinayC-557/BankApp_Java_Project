package bankaccountapp;

public class Savings extends Account implements IBaseRate {
	
	//List properties specific to the savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKEY;
	
	//Constructor to initialize settings for the Savings account properties
	public Savings(String name,String sSN,double initDeposit) {
		super(name,sSN,initDeposit);
		
		//1 will be add at the beginning of account number to show that it's an SAVINGS ACCOUNT 
		accountNumber= "1" + accountNumber;
		
	setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate=getBaseRate() - .25;
	}
	
	//List any methods specific to the savings account	
	private void setSafetyDepositBox() {
		
		safetyDepositBoxID= (int)(Math.random()*Math.pow(10,3));
		
		safetyDepositBoxKEY= (int)(Math.random()*Math.pow(10,4));
	}
	
	

	public void showInfo() {
		
		super.showInfo();
		System.out.println(
				" Your Savings Account Features"+
				"\n Safety Deposit Box ID: "+safetyDepositBoxID+
				"\n Safety Deposit Box KEY: "+safetyDepositBoxKEY
				);
		
	}
}
