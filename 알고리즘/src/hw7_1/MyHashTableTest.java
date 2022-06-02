package hw7_1;

//정수형 해시 테이블인 MyHashTable 클래스를 정의하고 사용하는 프로그램
public class MyHashTableTest {
	public static void main(String args[]) {
		System.out.println("hw7_1 : 정재완");

		// 입력 없이 실행하기 위해 해시 테이블에 저장할 key들을 배열에 다음과 같이 수록
		int[] addArray = {1, 5, 7, 9, 2, 4, 6, 8, 10, 30, 40};
		int[] searchArray = {4, 6, 8, 10, 30, 40, 1, 5, 7, 9, 2, 111, 333};

		// 테이블 크기가 8인 MyHashTable 객체 생성(hashTable)
		MyHashTable hashTable = new MyHashTable(8);

		// hashTable에 addArray의 key 모두 삽입
		for(int key: addArray) {
			hashTable.add(key);
		}

		// hashTable에 제대로 삽입되었는지 확인하기 위해 현재 테이블 상태와 적재율 출력
		hashTable.printTable();
		System.out.println("load factor = " + hashTable.getLoadFactor());

		// hashTable에서 searchArray의 각 key를 조회하여 결과 true/false를 출력
		for(int key: searchArray) {
			System.out.print(hashTable.contains(key) + " ");
		}
	}
}
