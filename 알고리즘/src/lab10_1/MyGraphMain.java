package lab10_1;
import java.util.Scanner;
public class MyGraphMain {
	public static void main(String args[]) {
		System.out.print("lab10_1 : 정재완");
		
		//정점 수와 간선 수 입력받고 그래프 생성
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); //정점 수 입력
		int e = scanner.nextInt(); //간선 수 입력
		
		MyGraph graph = new MyGraph(n); // 무향 그래프 생성
		
		// e개의 간선을 입력받아 그래프에 간선 삽입
		for(int i=0; i<e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			graph.insertEdge(v1,v2);
		}
		
		// 각 정점에 인접한 정점 번호들을 출력
		for(int i=1; i <= n; i++) {
			System.out.print("\n" + i + "에 인접한 정점 = ");
			graph.printVertex(i);
		}
	}
}
