import java.util.*;
public class ArraySum {
	public static void main(String[] args) {
		System.out.println("hw1_1 : 정재완");
		// 배열 array를 다음과 같이 초기화
		int [] array = {-10, -20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20};
		// 배열 인덱스 하한(lb)과 상한(ub)을 입력받는다
		Scanner scanner = new Scanner(System.in);
		System.out.print("하한 입력(0~11) : ");
		int lb = scanner.nextInt();
		System.out.print("상한 입력(0~11) : ");
		int ub = scanner.nextInt();
		
		// 반복 알고리즘을 이용해 iterativeArrayPrint(array, lb, ub)호출하여 배열 원소 array[lb..ub]를 출력
		System.out.print("출력 = ");
		iterativeArrayPrint(array, lb, ub);
		
		// 재귀 알고리즘 이용해 배열 원소 array[lb..ub]합 구해서 출력, recursiveArraySum(array, lb, ub)호출하여 리턴값 출력
		int sum = recursiveArraySum(array, lb, ub);
		System.out.print("합 = " + sum);
		
		scanner.close();
	}
	// iterativeArrayPrint 메소드. array, lb, ub 매개변수로 받아 배열 차례대로 출력, 반복문 이용
	private static void iterativeArrayPrint(int[] array, int lb, int ub) {
		for(; lb<=ub; lb++) {
			System.out.print(array[lb]+ " ");
		}
		System.out.println();
	}
	// recursiveArraySum 메소드. array, lb, ub를 매개변수로 받아 배열의 합을 리턴.
	private static int recursiveArraySum(int[] array, int lb, int ub) {
		if(lb>ub)
			return 0;
		else if(lb==ub)
			return array[lb];
		else {
			return array[ub] + recursiveArraySum(array, lb, ub-1);
		}
	}
}
