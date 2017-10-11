public class Main {
	static final double eps = 0.00001; // 10 ^ -5

    public static void main(String[] args) {
        double x = 0, prev = 0; // предположительное значение
        int apr = 63;
        double a = 4/5d;

        int i = 0;
        print(i, x, prev-x);
       do {
        	prev = x;
        	x = foo(x);
	        print(i, x, prev-x);
	        i++;
        }  while (!enough(x, prev, eps, a));
    }

	private static boolean enough(double x, double prev, double eps, double a) {
		return ((a / (1 - a)) * Math.abs(x - prev) < eps);
    }

	static double foo (double x) {
        return x - (1/5d) * (3 * x + Math.cos(x) + Math.sqrt(x * x + 1));
    }

    static void print (int i, double x, double diff) {
        System.out.println(
			i + ":\t" +
			String.format("%.7f", x) + "\t" +
			String.format("%.7f", diff)
		);
    }
}

/*

0: 	3,0000000	-3,0000000
1: 	0,7655430	2,2344570
2: 	-0,0898615	0,8554045
3: 	-0,4359435	0,3460820
4: 	-0,5738503	0,1379068
5: 	-0,6280944	0,0542441
6: 	-0,6492456	0,0211512
7: 	-0,6574613	0,0082157
8: 	-0,6606475	0,0031862
9: 	-0,6618824	0,0012349
10:	-0,6623610	0,0004785
11:	-0,6625464	0,0001854
12:	-0,6626182	0,0000718
13:	-0,6626460	0,0000278
14:	-0,6626568	0,0000108
15:	-0,6626610	0,0000042

*/
