import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static BufferedReader br;
	static StringBuilder sb;
	
	static StringTokenizer st;
	
	static Country[] countries;
	
	static boolean isPossible;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		OuterLoop:
		for(int i=0; i<4; i++) {
			init();
			for(int idx=0; idx<6; idx++) {
				Country country = countries[idx];
				if(country.win + country.draw + country.lose != 5) {
					System.out.println(0);
					continue OuterLoop;
				}
			}
			
			dfs(0,1);
			System.out.println(isPossible? 1 : 0);
			
		}
	}
	
	private static void dfs(int idx1, int idx2) {
		if(isPossible) {
			return;
		}
		
		if(idx1 == 6) {
			isPossible = true;
			return;
		}
		
		if(idx2 >= 6) {
			dfs(idx1+1, idx1+2);
			return;
		}
		
		Country country1 = countries[idx1];
		Country country2 = countries[idx2];
		
		if(country1.win > 0 && country2.lose > 0) {
			country1.win--;
			country2.lose--;
			dfs(idx1,idx2+1);
			country1.win++;
			country2.lose++;
		}
		
		if(country1.draw > 0 && country2.draw > 0) {
			country1.draw--;
			country2.draw--;
			dfs(idx1,idx2+1);
			country1.draw++;
			country2.draw++;
		}
		
		
		if(country1.lose > 0 && country2.win > 0) {
			country1.lose--;
			country2.win--;
			dfs(idx1,idx2+1);
			country1.lose++;
			country2.win++;
		}
		
	}
	
	private static void init() throws IOException {
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		countries = new Country[6];
		
		for(int i=0; i<6; i++) {
			int win = Integer.parseInt(st.nextToken());
			int draw = Integer.parseInt(st.nextToken());
			int lose = Integer.parseInt(st.nextToken());
			countries[i] = new Country(win,draw,lose);
		}
		isPossible = false;
	}
}


class Country{
	int win;
	int draw;
	int lose;
	
	public Country(int win, int draw, int lose) {
		super();
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}
}