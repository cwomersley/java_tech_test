package app.testFiles;

public class longestPalindrome {
	public String testData;

	public longestPalindrome(String data){
		this.testData = data;
	}

	public String returnLongestPalindrome(){
		

		String longest = testData.substring(0, 1);

		for (int i = 0; i < testData.length(); i++) {
		
			String pal = findEqualSubstring(testData, i, i);
			//Need to take into account even and odd lengths
			pal = findEqualSubstring(testData, i, i + 1);
			if (pal.length() > longest.length()) {
				longest = pal;
			}

			pal = findEqualSubstring(testData, i, i);
			if (pal.length() > longest.length()) {
				longest = pal;
			}
		}
		
		longest = longest.trim();
		return longest;
	}

	public String findEqualSubstring(String string, int start, int end) {
		//Loop while start and end chars match 
	
		//Make lowercase while comparing to avoid modifing original input
		while(start >= 0 && end < string.length() && string.toLowerCase().charAt(start) == string.toLowerCase().charAt(end)) 
		{	//itterate each position, moving backwards with start and forwards with end
			start--;
			end++;
		}
			
		String result = string.substring(start +1 , end); 

        return result;   
    }
}