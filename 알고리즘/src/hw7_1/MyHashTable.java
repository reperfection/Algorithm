package hw7_1;
//정수형 key값을 저장하는 해시 테이블 클래스
//해시함수는 곱하기 방법(A=0.6180339887), 충돌 해결은 체이닝을 이용
public class MyHashTable {
	private class Node{	//연결리스트 노드 구조
		int key;
		Node link;
	}

	private Node[] table;	 // 테이블
	private int m;			//	테이블 크기
	private int n;			// 	원소 수
	private static final double A = 0.6180339887;	// 곱하기 방법에서 사용할 상수

	// (1) 테이블 크기를 매개 변수로 받아 공백 해시테이블을 생성
	public MyHashTable(int m) {
		this.m = m;
		table = new Node[m];
		n = 0;
	}
	// (2) 해시 함수 - 곱하기 방법을 이용하여 key의 해시값을 계산 : O(1)
	private int hash(int key) {
		return (int)(((key * A) % 1) * m); 
	}
	// (3) 테이블에 key를 삽입 - key 중복 여부는 검사하지 않아도 됨 : 평균 O(1)
	public void add(int key) {
		int hashKey = hash(key);			
		if(table[hashKey]!=null) {			// 만약 테이블에 삽입된 key가 있다면 
			Node newNode = new Node();		// 새 노드 생성
			newNode.key = key;				// 새 노드에 key값 저장
			newNode.link = table[hashKey];	// 새 노드 링크필드에 기존 연결리스트 맨 앞에 위치한 노드 값 저장
			table[hashKey] = newNode;		// 새 노드를 연결리스트 맨 앞으로
			n++;							// 테이블 원소 개수 1 증가
		}
		else {								// 테이블에 삽입된 key가 없다면
			table[hashKey] = new Node();	// 연결리스트 맨 앞에 새 노드 생성
			table[hashKey].key = key;		// 새 노드에 키값 저장
			table[hashKey].link = null;		// 새 노드의 링크 필드 null
			n++;							// 테이블 원소 개수 1 증가
		}
	}
	// (4) 적재율을 계산하여 리턴 : O(1)
	public double getLoadFactor() {
		return (double)n / m;
	}
	// (5) 테이블에서 key를 검색하여 존재하면 true 리턴 : 평균 O(1)
	public boolean contains(int key) {
		int hashKey = hash(key);
		Node searchKey = table[hashKey];	// searchKey 노드 생성 후 key의 해시값 구해 그 위치의 연결리스트에서 처음 노드를 가리킴
		while(searchKey != null) {			// searchKey가 null이 아닐때까지 반복
			if(searchKey.key == key)		// searchKey 노드의 key값이 매개변수 key값과 같다면 true 반환
				return true;
			else
				searchKey = searchKey.link;	//아니면 다음 노드로 넘어감
		}
		return false;		// 찾고자 하는 key가 없다면 false 반환
	}

	// 과제 수행시 키 값이 올바른 위치에 삽입되었는지 확인하기 위한 메소드
	public void printTable() {
		for(int i = 0; i < table.length; i++) {
			System.out.print("table[" + i + "] = ");
			Node temp = table[i];
			while(temp != null) {
				System.out.print(temp.key + " ");
				temp = temp.link;
			}
			System.out.println();
		}
	}
}
