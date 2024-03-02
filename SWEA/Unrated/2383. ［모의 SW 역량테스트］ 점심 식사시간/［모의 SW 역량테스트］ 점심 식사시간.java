import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Solution{

    static class Node{
        int r;
        int c;

        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static class Stair extends Node{
        int k;

        public Stair(int r, int c, int k){
            super(r,c);
            this.k = k;
        }
    }

    static int[][] map;
    static BufferedReader br;
    static StringTokenizer st;

    static ArrayList<Node> persons;

    static ArrayList<Stair> stairs;

    static int[] team;

    static int ans;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            input();
            combi(0);
            System.out.println("#" + tc + " " + ans);
        }
    }


    static void combi(int idx){
        if(idx == persons.size()){

            ArrayList<Integer> s1 = new ArrayList<>();
            ArrayList<Integer> s2 = new ArrayList<>();
            for(int i=0; i<idx; i++){
                if(team[i] == 0){
                    int r = Math.abs(persons.get(i).r - stairs.get(0).r);
                    int c = Math.abs(persons.get(i).c - stairs.get(0).c);
                    s1.add(r+c);
                }else{
                    int r = Math.abs(persons.get(i).r - stairs.get(1).r);
                    int c = Math.abs(persons.get(i).c - stairs.get(1).c);
                    s2.add(r+c);
                }
            }

            Collections.sort(s1);
            Collections.sort(s2);


            int s1OutTime = calTime(s1, 0);
            if(s1OutTime != 0){
                s1OutTime += stairs.get(0).k;
            }
            int s2OutTime = calTime(s2, 1);
            if(s2OutTime != 0){
                s2OutTime += stairs.get(1).k;
            }


            ans = Math.min(ans, Math.max(s1OutTime, s2OutTime));
            return;
        }

        team[idx] = 1;
        combi(idx+1);
        team[idx] = 0;
        combi(idx+1);
    }


    static int calTime(ArrayList<Integer> s, int stairIdx){
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        int length = stairs.get(stairIdx).k;
        int time = 0;
        while(idx < s.size()){

            while(q.size() > 0 && q.peek()+length <= time){ // 내려간다.
                q.poll();
            }

            while(idx < s.size()){
                if(q.size() < 3 && s.get(idx) <= time){
                    q.add(s.get(idx));
                    idx++;
                }
                if(idx < s.size() && (q.size() == 3 || s.get(idx) > time)){
                    break;
                }
            }

            time++;
        }
        return time;
    }



    static void input() throws IOException{

        persons = new ArrayList<>();
        stairs = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            map = new int[n][n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    persons.add(new Node(i,j));
                }else if(map[i][j] != 0){
                    stairs.add(new Stair(i,j,map[i][j]));
                }
            }
        }

        team = new int[persons.size()];
        ans = Integer.MAX_VALUE;
    }
}