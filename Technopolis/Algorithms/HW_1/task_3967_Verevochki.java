import java.io.*;
import java.util.*;

public class Task {

	/** https://www.e-olymp.com/ru/problems/3967
	 *С утра шел дождь, и ничего не предвещало беды. Но к обеду выглянуло солнце, и в лагерь заглянула СЭС. Пройдя по
	 * всем домикам и корпусам, СЭС вынесла следующий вердикт: бельевые верёвки в жилых домиках не удовлетворяют нормам
	 * СЭС. Как выяснилось, в каждом домике должно быть ровно по одной бельевой верёвке, и все верёвки должны иметь
	 * одинаковую длину. В лагере имеется N бельевых верёвок и K домиков. Чтобы лагерь не закрыли, требуется так
	 * нарезать данные верёвки, чтобы среди полученных верёвочек было K одинаковой длины. Размер штрафа обратно
	 * пропорционален длине бельевых верёвок, которые будут развешены в домиках. Поэтому начальство лагеря стремится
	 * максимизировать длину этих верёвочек.
	 *
	 *Входные данные
	 *В первой строке заданы два числа - N (1 ≤ N≤ 10001) и K (1≤ K≤ 10001). Далее в каждой из последующихN строк записано
	 *по одному числу - длине очередной бельевой верёвки. Длина верёвки задана в сантиметрах. Все длины лежат в интервале
	 *от 1 сантиметра до 100 километров включительно.
	 *
	 *Выходные данные
	 *В выходной файл следует вывести одно целое число - максимльную длину верёвочек, удовлетворяющих условию, в
	 *сантиметрах. В случае, если лагерь закроют, выведите 0.
	 *
	 */

	public static void main(String[] args) {
		try (
				Scanner sc  = new Scanner (new BufferedInputStream(new FileInputStream(new File("input.txt" ))));
				PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))))
		) {
			solve(sc, out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void solve(Scanner sc, PrintStream out) {
		int N = sc.nextInt(), K = sc.nextInt();
		HashMap<Integer, Integer> counts = new HashMap<>();
		int max = 0, sum = 0;

		for (int i = 0; i < N; i++) {
			int len = sc.nextInt();
			sum += len;
			if (len > max) max = len;

			int count = counts.getOrDefault(len, 0);
			count++;
			counts.put(len, count);
		}
		if (K > sum) {
			print("0", out);
			return;
		}

		int[] lens = new int[max + 1];
		for (int i = 1; i <= max; i++) {
			lens[i] = counts.getOrDefault(i, 0);
			for (int j = 1; j < i + 1; j++)
				lens[j] += lens[i] * (i / j);
		}
		int i = max;
		while (i > 0 && lens[i] < K) i--;

		print(i + "", out);
	}

	private static void print(String result, PrintStream out) {
		out.println(result);
	}

	private static int[] getInputArray(int size, Scanner sc) {
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		return arr;
	}
}