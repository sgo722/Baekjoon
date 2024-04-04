
import java.io.*;
import java.util.*;

/***
 * 문제 : 색종이 붙이기 아이디어 : 완탐
 * 
 * @param args
 * @throws IOException
 */

public class Main {

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[][] map;
	static ArrayList<Point> arr;
	static int ans;
	static int[] paper;

	public static void main(String[] args) throws IOException {
		input();
		dfs(0, 0, 0);
		printAns();
	}

	static void printAns() {
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static void dfs(int y, int x, int depth) {
//		print(map);

		if (ans <= depth) {
			return;
		}

		if (x == 10) {
			dfs(y + 1, 0, depth);
			return;
		}

		if (y == 10) {
			ans = Math.min(ans, depth);
			return;
		}

		if (map[y][x] == 0) {
			dfs(y, x + 1, depth);
			return;
		}

		for (int size = 5; size >= 1; size--) {
			if (paper[size] == 5) continue;
			if (isPossible(y, x, size)) {
				paper[size]++;
				attach(y, x, size);
				dfs(y, x+size, depth + 1);
				detach(y, x, size);
				paper[size]--;
			}
		}
	}
	static boolean isPossible(int y, int x, int size) {
		if(y+size > 10 || x+size > 10) return false;

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}

		return true;
	}

	static void attach(int y, int x, int size) { // 붙이기

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = 0;
			}
		}

	}

	static void detach(int y, int x, int size) { // 뗴기

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = 1;
			}
		}
	}

	static void input() throws IOException { // 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = Integer.MAX_VALUE;
		map = new int[10][10];
		paper = new int[6];
		arr = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					arr.add(new Point(i, j));
				}
			}
		}

//		print(map);
	}

	static void print(int[][] arr) { // 디버깅 코드
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}