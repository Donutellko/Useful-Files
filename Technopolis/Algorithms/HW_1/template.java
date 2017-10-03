import java.io.*;
import java.util.Scanner;

public class Task {

	/**
	 * 
	 *
	 */

	public static void main(String[] args) {
//    	File file = new File("input.txt");
//    	System.out.println(file.getAbsoluteFile());

		try (
				Scanner sc  = new Scanner    (new BufferedInputStream(new FileInputStream(new File("input.txt" ))));
				PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))))
		) {
			solve(sc, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	private static void solve(Scanner sc, PrintStream out) {
		StringBuilder result = new StringBuilder();
//		String result = "";
		
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++){
			
		}

		print(result.toString(), out);
//		print(result, out);
	}

	private static int[] getInputArray(int size, Scanner sc) {
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		return arr;
	}

	private static void print(String result, PrintStream out) {
		out.println(result);
	}
}