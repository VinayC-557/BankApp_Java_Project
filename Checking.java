package bankaccountapp;

public class Checking extends Account implements IBaseRate {
	
	//List properties specific to the Checking account
	private int debitcardNumber;
	private int debitcardPIN;
	
	//Constructor to initialize checking account properties
	public Checking(String name,String sSN,double initDeposit) {
		super(name,sSN,initDeposit);
		//2 will be add at the beginning of account number to show that it's an CHECKING ACCOUNT  
		accountNumber= "2" + accountNumber;
		
		setDebitCardNumber();
	
	}
	@Override
	public void setRate() {
		rate= getBaseRate() * .15;
	}
	
	//List any methods specific to the checking account
		private void setDebitCardNumber() {
		 debitcardNumber = (int)(Math.random()*Math.pow(10, 12));	
		 debitcardPIN=(int)(Math.random()*Math.pow(10, 4));
		}
	
	
	
		public void showInfo() {    
			
			super.showInfo();
			System.out.println(
					" Your Checking Account Features"+
					"\n Debit Card Number: "+ debitcardNumber+
					"\n Debit Card PIN: "+ debitcardPIN 
					);

}
}
