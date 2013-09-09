package math;


public class Test {
	public static void main(String[] args) {
		String toParse = args[0];
		String[] div = toParse.split("[-.]");
		System.out.println("mv "+args[0]+div[0]+"-"+div[2]+"-"+div[1]+"."+div[3]);
	}
}
