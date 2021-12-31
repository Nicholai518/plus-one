import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		// Example 1
		// Input: digits = [1,2,3]
		// Output: [1,2,4]
		int[] exampleOne = new int[]{1,2,3};
		System.out.println("Example 1 should return [1,2,4] : " + Arrays.toString(plusOne(exampleOne)));

		// Example 2
		// Input: digits = [4,3,2,1]
		// Output: [4,3,2,2]
		int[] exampleTwo = new int[]{4,3,2,1};
		System.out.println("Example 2 should return [4,3,2,2] : " + Arrays.toString(plusOne(exampleTwo)));


		// Example 3
		// Input: digits = [9]
		// Output: [1,0]
		int[] exampleThree = new int[]{9};
		System.out.println("Example 3 should return [1,0] : " + Arrays.toString(plusOne(exampleThree)));

		// failed example
		// Input: digits = [9,9]
		// output: [1,0,0]
		int[] failedExample = new int[]{9,9};
		System.out.println("Failed example should return [1,0,0] : " + Arrays.toString(plusOne(failedExample)));

		// failed example
		// Input: digits = [9,9,9]
		// output: [1,0,0,0]
		int[] failedExampleTwo = new int[]{9,9,9};
		System.out.println("Failed example should return [1,0,0,0] : " + Arrays.toString(plusOne(failedExampleTwo)));

	}



	// Example 2
	// Input: digits = [9,9,9]
	// Output: [1,0,0,0]
	public static int[] plusOne(int[] digits) {
		 boolean carryFlag = false;

		 boolean allNumbersAreNine = true;

		 // iterate through the array, if all numbers are 9, just return
		for(int k = 0; k < digits.length; k++) {
			if (digits[k] != 9) {
				allNumbersAreNine = false;
			}
		}

		if(allNumbersAreNine){
			int[] allNumbersAreNineArray = new int[digits.length+1];
			allNumbersAreNineArray[0] = 1;

			for(int n = 1; n <allNumbersAreNineArray.length; n++){
				allNumbersAreNineArray[n] = 0;
			}
			return allNumbersAreNineArray;
		}

		 // edge case
		// there is only 1 number and that number is 9

		if(digits.length == 1 && digits[0] == 9){
			return new int[]{1, 0};
		}

		 // start at end and work towards beginning
		for(int i = digits.length -1; i>=0; i--){


			// currently at the last index
			if(i == digits.length-1){

				// if not a 9, add 1 and return the int[]  - we are done.
				if(i == digits.length-1 && digits[i] != 9){
					// add one to the element and return int[]
					digits[i] = digits[i] + 1;

					return digits;
				}

				// if 9, you need to change to a 0 and carry a 1
				else {
					// change to zero
					digits[i] = 0;
					carryFlag = true;
				}
			}

			// somewhere in the "middle" and element is a 9, and we are not at index 0
			// todo: updated this to else if
			else if(digits[i] == 9 && i !=0 ){
				// the current element is 9, check for a carry value
				if(carryFlag){
					// set element to zero
					digits[i] = 0;
					// we used the carry, set carryFlag to false
					carryFlag = false;
				}
				// if the carry flag is false, do not do anything
			}
			// somewhere in the "middle" and element is not a 9, and we are not at index 0
			else if(digits[i] != 9 && i !=0 ) {
				// the current element is not a 9, check for a carry value
				if(carryFlag){
					// add 1 to the current element
					digits[i] = digits[i] + 1;
					// we used the carry, set carryFlag to false
					carryFlag = false;
				}
				// if the carry flag is false, do not do anything
			}

			// we have reached index 0, we need to either return the updated array
			// or we need to create a new array
			if(i == 0 ){
				// there is no carry, return the updated array
				if(!carryFlag){
					return digits;
				}
				// there is a carry value
				else {
					// if the element is not a 9, add 1 to the value and return the updated array
					if(digits[0] != 9){
						// add 1
						digits[0] = digits[0] + 1;
						// set carry flag to false
						carryFlag = false;
						// return the updated array
						return digits;
					}

					// this is the toughest part
					// there is a carry and index 0 is 9
					// we need to make a new array
					else {
						// update element 0 to be zero
						digits[0] = 0;
						// update carry flag
						carryFlag = false;

						// create a new array to be returned
						// size is digits.length + 1
						int[] updatedDigits = new int[digits.length + 1];

						// set index 0 to 1
						updatedDigits[0] = 1;

						// iterate through digits and add elements to updatedDigits
						for(int j = 0; j < digits.length; j++){
							// updatedDigits is 1 index value ahead of digits
							updatedDigits[j+1] = digits[j];
						}

						// return updatedDigits
						return updatedDigits;

					}
				}
			}

		}  // end of for loop

		// if we make it this far, just return digits
		return digits;
	}
}


