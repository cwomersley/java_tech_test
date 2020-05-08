package app.testFiles;

public class isPrime {
	public static Boolean isNumberPrime(int number) {
		
	Boolean isPrime = true;

		//1 always prime
		if(number == 1){
			return true;
		}
		if(number == 0){
			return false;
		}

		for (int i = 2; i <= number; i ++)
    	{
			//Dont care if if it devides by self to a whole number
			if(i != number){
			if(number%i == 0)
			{  
			
				 return false;
			}
		 }
	    }
		return isPrime;
		
	}
       	
}

