import java.io.*;
import java.util.Scanner;

public class Task {

	/**
	 * https://www.e-olymp.com/ru/problems/3966
	 *
	 * Как известно, Андрй Сергеевич - ярый коллекционер бабочек. Он имеет огромную коллекцию, экспонаты которой собраны
	 * со всего мира. Будем считать, что в мире существует 2000000000 видов бабочек. Чтобы не запутаться,
	 * Андрей Сергеевич присвоил каждому виду уникальный номер. Нумерация бабочек всегда начинается с единицы. Теперь
	 * он хочет знать, есть ли бабочка с видом K в его коллекции, или же её придётся добывать, затрачивая уйму сил и денег.
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

		int[] arr = getInputArray(sc.nextInt(), sc);

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			result.append(binaryContains(arr, sc.nextInt()) ? "YES" : "NO").append("\n");
		}

		print(result.toString(), out);
	}

	/*
	private static boolean binaryContains(int[] arr, int a) {
		int step = (arr.length + 1) / 2, i = step;

		if (arr[0] == a) return true;
		if (arr[arr.length - 1] < a) return false;
		while (arr[i] != a && step != 0) {
			step /= 2;
			i += step * (arr[i] > a ? -1 : 1);
		}

		return arr[i] == a;
	}
	*/

	static boolean binaryContains(int[] arr, int x) {
		if (x < arr[0] || x > arr[arr.length - 1]) return false;

		int i = -1;
			int low = 0, high = arr.length, mid;
			while (low < high) {
				mid = (low + high)/2; // Можно заменить на: (low + high) >>> 1, чтоб не возникло переполнение целого
				if (x == arr[mid]) {
					i = mid;
					break;
				} else {
					if (x < arr[mid]) {
						high = mid;
					} else {
						low = mid + 1;
					}
				}
			}
		return i != -1;
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