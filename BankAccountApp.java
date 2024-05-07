package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts=new LinkedList<Account>();
		
		
		String file="C:\\Users\\KCM\\eclipse-workspace\\BankApplication\\src\\CSV\\NewBankAccounts.csv";
		
		
		/*
		
		Checking chkacct1=new Checking("Vinay","635728909",1000);
		Savings svngs1=new Savings("Rahul","335626743",2400);
		
		svngs1.compound();
	
		svngs1.showInfo();
		System.out.println("**************");
		chkacct1.showInfo();
	
		
		svngs1.deposit(5000);
		svngs1.withDraw(400);
		svngs1.transfer("Vinay Chandra", 4000);
		
		*/
		
		//Read a CSV File then create new accounts based on the data
		
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for(String[] accountholder : newAccountHolders) {
			
			String name=accountholder[0];
			String sSN=accountholder[1];
			String accountType=accountholder[2];
			double initDeposit=Double.parseDouble(accountholder[3]);
			
//			System.out.println(name+ " "+sSN+ " "+accountType+" $"+initDeposit);
			if(accountType.equals("Savings")) {
//				System.out.println("OPEN A SAVINGS ACCOUNT");
				accounts.add(new Savings(name,sSN,initDeposit));
			}
			
			else if(accountType.equals("Checking")) {
//				System.out.println("OPEN A CHECKING ACCOUNT");
				accounts.add(new Checking(name,sSN,initDeposit));
			}
			
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
//		accounts.get(5).showInfo();
		
		for(Account acc:accounts) {
			System.out.println("\n**********************");
			acc.showInfo();
		}
	}

}
