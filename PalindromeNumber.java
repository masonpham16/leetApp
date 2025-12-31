public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
		if(x < 0){
			return false;
		}
		int reversed = 0;
		int normal = x;
		while(x != 0){
			reversed = reversed*10 + x%10;
			x = x/10;
		}
		if(reversed == normal){
			return true;
		} else{
			return false;
		}
	}
}
