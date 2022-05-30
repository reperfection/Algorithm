package hw4_1;
import java.util.Random;
public class Main {
	public static void main(String args[]) {
		System.out.println("hw4_1 : 정재완");
		Random random = new Random();
		int n =10;
		//Reservation 형의 n크기 배열 생성
		Reservation [] array = new Reservation[n];
		for(int i=0; i<array.length; i++) {	// 예약 번호가 1, 2, 3.., 시작시간, 종료시간 랜덤 값인 예약 객체를 배열에 저장
			int startTime = random.nextInt(5)+1;	//시작 시간 1~5 랜덤 생성
			//종료 시간 랜덤 생성(6:최댓값 startTime 최솟값, ()연산으로 나올 개수 조정, 난수 산출 후 +1로 shift
			int endTime = random.nextInt(6-startTime)+startTime + 1;	// +1이 없으면 0~startTime 난수 생성
			array[i] = new Reservation((i+1), startTime, endTime);
			System.out.println(array[i].toString());	// n개의 예약 각각에 대해 시작시간, 종료시간, 길이 출력
		}
		countingSort(array);	// 예약 길이를 기준으로 오름차순 정렬하는 정렬 메소드 호출
		System.out.println("길이 오름차순 정렬 결과 =");
		for(int i=0; i<array.length; i++) {	// 정렬된 n 개의 예약 각각에 대해 시작시간, 종료시간, 길이를 출력함
			System.out.println(array[i].toString());
		}
	}
	/* Reservation 형 배열을 매개변수로 받아 예약 길이(1~5시간)를 기준으로 
	  계수 정렬 알고리즘을 이용해 시간 복잡도가 O(n)인 정렬 메소드로 오름차순 정렬 */
	private static void countingSort(Reservation[] list) {
		int n = list.length;	// list 길이만큼 n에 초기화
		// 매개변수로 받은 Reservation형 배열을 오름차순으로 정렬하기 위해 Reservation 형의 n크기 배열 생성, 예약 객체의 내용 똑같이 배열에 저장
		Reservation [] sort = new Reservation[n];
		for(int i=0; i<list.length; i++) {
			sort[i] = new Reservation((i+1), list[i].getStartTime(), list[i].getEndTime());
		}
		int [] count = new int [5]; //예약 길이에 해당하는 count 배열 생성
		for(int i=0; i<count.length; i++)
			count[i] = 0;	// count 배열 모두 0으로 초기화
		for(int i=0; i<list.length; i++) 
			// list 배열의 i번째 길이를 -1 한 뒤 얼마나 나타나는지 count 배열에 저장
			count[list[i].getLength()-1]++;	
		for(int i=1; i<count.length; i++) {
			count[i] = count[i] + count[i-1];	// count[i]가 값이 i보다 작거나 같은 원소의 총수를 갖고 있도록 초기화
		}
		// count배열의 정보를 이용해 list 객체 배열과 똑같은 sort 객체 배열의 각 원소를 배열 list의 몇 번째 자리에 들어갈지 판단해서 초기화
		for(int i=1; i<=n; i++) {	
			list[count[sort[n-i].getLength()-1]-1] = sort[n-i];
			count[sort[n-i].getLength()-1]--;	// list 배열에 저장 후 그 길이의 -1에 해당하는 count 배열 값 -1씩 초기화
		}
	}
}

