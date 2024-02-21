import java.io.*;
import java.util.*;

public class Main{
	
	static class Node{
		int next;
		int prev;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[1000001];
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());

		nodes[start] = new Node();
		int prev = start;
		int next;
		for(int i=1; i<n-1; i++) {
			int here = Integer.parseInt(st.nextToken());
			nodes[here] = new Node();
			nodes[here].prev = prev;
			nodes[prev].next = here;
			prev = here;
		}
		int end = Integer.parseInt(st.nextToken());
		nodes[prev].next = end;
		
		nodes[end] = new Node();
		nodes[end].prev = prev;
		nodes[end].next = start;
		
		
		nodes[start].prev = end;
		
//		for(int x=0; x<10; x++) {
//			if(nodes[x] == null) continue;
//			System.out.println("nodes[" + x + "].prev = " + nodes[x].prev + " nodes[" + x + "].next = " + nodes[x].next);
//		}
//		System.out.println();
		
		
		for(int t=0; t<m; t++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int i = Integer.parseInt(st.nextToken());
			if(op.equals("BN")) { 
				int j = Integer.parseInt(st.nextToken());
				
				// 고유 번호가 j인 역을 생성한다.
				if(nodes[j] == null) {
					nodes[j] = new Node();
				}
				// 고유번호 i를 가진 역의 다음 역의 고유번호를 출력한다.
//				System.out.println(nodes[i].next);
				sb.append(nodes[i].next).append("\n");
				// 그 사이에 고유 번호를 j인 생성한다. ( == 여기서는 연결한다.)
				
				// 
				
				next = nodes[i].next;
				nodes[j].prev = i;
				nodes[j].next = next;
				
				
				nodes[next].prev = j;
				nodes[i].next = j;
				
				
				
//				for(int x=0; x<10; x++) {
//					if(nodes[x] == null) continue;
//					System.out.println("nodes[" + x + "].prev = " + nodes[x].prev + " nodes[" + x + "].next = " + nodes[x].next);
//				}
			}
			else if(op.equals("BP")) {
				
				int j = Integer.parseInt(st.nextToken());
				
				// 고유 번호가 j인 역을 생성한다.
				if(nodes[j] == null) {
					nodes[j] = new Node();
				}
				// 고유번호 i를 가진 역의 이전 역의 고유번호를 출력한다.
//				System.out.println(nodes[i].prev);
				sb.append(nodes[i].prev).append("\n");
				// 그 사이에 고유 번호를 j인 생성한다. ( == 여기서는 연결한다.)
				prev = nodes[i].prev;
				
				nodes[j].prev = prev;
				nodes[j].next = i;
				// 
				nodes[prev].next = j;
				nodes[i].prev = j;
				
//				for(int x=0; x<15; x++) {
//					if(nodes[x] == null) continue;
//					System.out.println("nodes[" + x + "].prev = " + nodes[x].prev + " nodes[" + x + "].next = " + nodes[x].next);
//				}
				
			}else if(op.equals("CN")) {
				
				next = nodes[i].next;
				sb.append(next).append("\n");
				
				// 고유번호 i를 가진 다음 역을 폐쇄한다.
				
				
				nodes[nodes[next].next].prev = i;
				nodes[i].next = nodes[next].next;
				
				// 그 역의 고유번호를 출력한다.
//				System.out.println(nodes[i].next);
				
//				for(int x=0; x<15; x++) {
//					if(nodes[x] == null) continue;
//					System.out.println("nodes[" + x + "].prev = " + nodes[x].prev + " nodes[" + x + "].next = " + nodes[x].next);
//				}
				
			}else {
				
				prev = nodes[i].prev;
				sb.append(prev).append("\n");
				// 고유번호 i를 가진 이전 역을 폐쇄한다.
				nodes[nodes[prev].prev].next = i; // 이전역의 이전 역으로 가서 이전 역을 폐쇄해야한다.
				nodes[i].prev = nodes[prev].prev;
				// 그 역의 고유번호를 출력한다.
				
//				System.out.println(nodes[i].prev);
				
				
//				for(int x=0; x<15; x++) {
//					if(nodes[x] == null) continue;
//					System.out.println("nodes[" + x + "].prev = " + nodes[x].prev + " nodes[" + x + "].next = " + nodes[x].next);
//				}
			}
		}
		
		System.out.println(sb);
	}
}