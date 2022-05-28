import java.util.*;
public class Recursive {
	public static void main(String[] args) {
		System.out.println("lab1_1 : 정재완");
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수값 입력 : ");	// 정수 값 입력받기
		int n = scanner.nextInt();

		System.out.print("반복 출력 = ");		// iterativePrint(n) 호출
		iterativePrint(n);

		System.out.print("재귀 출력 = ");		// recursivePrint(n) 호출
		recursivePrint(n);

		scanner.close();
	}
	// 반복문을 이용해 n을 매개변수로 받아 1부터 n까지의 정수값을 출력하는 메소드
	private static void iterativePrint(int n) {
		for(int i=1; i<=n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	// 재귀 호출을 이용해 n을 매개변수로 받아 1부터 n까지의 정수값을 출력하는 메소드
	private static void recursivePrint(int n) {
		if(n>0) {
			recursivePrint(n-1);
			System.out.print(n + " ");
		}
	}
}
