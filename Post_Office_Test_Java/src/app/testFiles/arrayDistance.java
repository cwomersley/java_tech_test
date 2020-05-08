package app.testFiles;
import java.util.Arrays;

public class arrayDistance {

	private int[] testArray;

	public arrayDistance(int[] testData) {
		this.testArray = testData;
	}

    // Returns the distance between the two closest numbers.
    public int distClosestNumbers() { 

		//Order the elements in the array 
		Arrays.sort(testArray);

		int dist;
		int miDist = Integer.MAX_VALUE;
		//Loop through comparing difference between current and next item

		for (int i = 0; i < testArray.length; i++) {

			if(i < testArray.length - 1 ){
			 dist = Math.abs(testArray[i+1] - testArray[i]);
			 if(dist < miDist)
			 miDist = dist;
			}
		}

		
		return miDist; 
    }
}