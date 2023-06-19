package telran.addTasks;

public class AddTasks {
	public static int maxSubsequenceLength(int[] array) {
		int res = 0, counter = 1;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] == array[i]) {
				counter++;
			} else {
				counter = 1;
			}
			if (counter > res) {
				res = counter;
			}
			if (res > array.length / 2)
				break;
		}
		return res;
	}

// not working properly with negative numbers
	public static String myDecimalToBinary(int number) {
		if (number == 0) {
			return "0";
		}
		String res = "";
		boolean negativeNum = false;
		if (number < 0) {
			number = -number;
			negativeNum = true;
		}
		while (number > 0) {
			res = (number % 2) + res;
			number /= 2;
		}
		res = negativeNum ? 1 + res : res + 1;

//		String reversedRes = "";
//		for (int i = res.length() - 1; i >= 0; i--) {
//			reversedRes += res.charAt(i);
//		}
//		String reversedRes = new StringBuilder(res).reverse().toString();
//		return 1 + reversedRes;
		return res;
	}
	
	
}
