package hans.algorithm.recursive;

import hans.algorithm.utils.Logger;

public class ClassicRecursive {

	public static void main(String[] args) {
//		int factorial = factorial(6);
//		// 5*4*3*2
//		Logger.log("factorial={}", factorial);

		long fabonacci = fibonacci(15);
		Logger.log(fabonacci);
	}
	/**
	 * 阶乘问题
	 * n! = n*(n-1)!
	 * factorial
	 * @return
	 */
	public static int factorial(int num) {

		if (num==1) {
			return 1;
		}
		if (num==0) {
			return 1;
		}
		return num*factorial(num-1);
	}

	public static int print(int num) {
		if (num==0) {
			Logger.log("return 0");
			return 0;
		}
		Logger.log(num);
		return print(num-1);
	}
	//Fibonacci sequence

	/**
	 * F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
	 * @param num
	 * @return
	 */
	public static int fibonacci(int num) {

		if(num < 1)
			return 0;
		if(num < 3)
			return 1;

		return fibonacci(num - 1) + fibonacci(num - 2);
	}
	public static long fibRec(int num) {
		if(num < 1)
			return 0;
		if(num < 3)
			return 1;
		return fibRec(num - 1) + fibRec(num - 2);
	}
}
