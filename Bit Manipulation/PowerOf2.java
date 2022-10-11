/**
 * The and of the a power of 2 and its previous number is always zero
 * this is because the power of 2 has only 1 set bit
**/
class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();	
		boolean ans=(n & (n-1)==0);
		System.out.println(ans);
	}
}

/**
 * The power of 2 has only 1 set bit
 * Therefore we can count the total number of set bits
**/