import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Task {

	/**
	 * https://www.e-olymp.com/ru/problems/3970
	 * Уже долгое время в Институте Искусств, Мутантов и Информационных Технологий разводят милых разноцветных зверюшек.
	 * Для удобства каждый цвет обозначен своим номером, всего цветов не более 10^9. В один из прекрасных дней в питомнике
	 * случилось чудо: все зверюшки выстроились в ряд в порядке возрастания цветов. Пользуясь случаем, лаборанты решили
	 * посчитать, сколько зверюшек разных цветов живёт в питомнике, и, по закону жанра, попросили вас написать программу,
	 * которая поможет им в решении этой нелёгкой задачи.
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
//		int[] arr = new int[N];
		ArrayList<Integer> colors = new ArrayList<>();
		ArrayList<Integer> counts = new ArrayList<>();

		int count = 1, current = sc.nextInt();
		for (int i = 0; i < N - 1; i++){
			int tmp = sc.nextInt();
			if (tmp == current) count++;
			else {
				colors.add(current);
				counts.add(count);
//				System.out.println(current + ":" + count);
				current = tmp;
				count = 1;
			}
		}
		colors.add(current);
		counts.add(count);

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int request = sc.nextInt();
			int tmp = Collections.binarySearch(colors, request);
//			System.out.println(request + " " + tmp);
			result.append(tmp < 0 ? 0 : counts.get(tmp)).append("\n");
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