import java.io.*;
import java.util.Scanner;

public class Milk_cake {

	/**
	 * https://www.e-olymp.com/ru/problems/7365
	 *
	 * Ученикам первого класса дополнительно дают стакан молока и пирожок, если вес первоклассника менее 30 кг. В первых
	 * классах школы учится n учеников. Стакан молока имеет емкость 200 мл, а упаковки молока – 0,9 л. Определить
	 * количество дополнительных пакетов молока и пирожков, необходимых каждый день.
	 *
	 * В первой строке задано целое число n (0 < n ≤ 100). В следующей строке идут n положительных действительных
	 * чисел – массы первоклассников.
	 *
	 * В одной строе вывести два целых числа - количество дополнительных пакетов молока и пирожков, необходимых
	 * каждый день.
	 *
	 */

    public static void main(String[] args) {
        try (
			Scanner sc  = new Scanner    (new BufferedInputStream(new FileInputStream(new File("input.txt" ))));
			PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))))
			) {
				print(solve(sc), out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String solve(Scanner sc) {
    	long N = sc.nextLong();
    	long additional = 0;

		for (long i = 0; i < N; i++)
			if(sc.nextDouble() < 30)
				additional++;

    	long milk = (long) Math.ceil((additional) * 2d/9d);
    	long cakes = additional;

    	return milk + " " + cakes;
	}


	private static void print(String result, PrintStream out) {
		out.println(result);
	}
}

