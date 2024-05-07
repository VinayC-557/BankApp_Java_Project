package bankaccountapp;

public interface IBaseRate {
	
	//write a method that returns a Base Rate
	default double getBaseRate(){
		return 2.5;
	}

}
