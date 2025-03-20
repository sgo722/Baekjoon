import java.util.*;

class Solution {
    static final long MAX_NUM = Long.MAX_VALUE;
    
    // 24^11 < 2 ^ 55
    // 2^10 = 10^3 = 10 ^ 15;
    // long 범위가 2
    // x번 뽑아서 x보다 작은 수의 개수? a
    // x - a == n이면 출력
    // 10^15 < 2^60 == 60 * 30만 == 1800만
    //
    static ArrayList<Long> banNumbers = new ArrayList<>();
    
    static long checkNumber(long number){
        long count = number;
        
        for(long banNumber : banNumbers){
            if(banNumber > number){
                break;
            }
            count--;
        }
        
        return count;
    }
    
    static String changeAnswer(long number){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        
        while(number > 0){
            if(number % 26 == 0){
                stk.add('z');
                number /= 26;
                number -= 1;
            }else{
                stk.add((char)((number % 26) + 'a' - 1));
                number /= 26;
            }
        }
        // 33 % 26 = 7
        // 33/26 = 1;
        
        while(stk.size() > 0){
            sb.append(stk.pop().toString());
        }
        
        
        return sb.toString();
    }
    public String solution(long n, String[] bans) {
        String answer = "";
        
        for(String number : bans){
            long banNumber = 0;
            for(int i=0; i<number.length(); i++){
                long plus = number.charAt(i) - 'a' + 1;
                banNumber *= 26;
                banNumber += plus;
            }
            banNumbers.add(banNumber);
        }
        
        Collections.sort(banNumbers);
        
        // for(int i=0; i<banNumbers.size(); i++){
        //     System.out.print(banNumbers.get(i) + " ");
        // }
        
        long l = 0;
        long r = MAX_NUM;
        long ans = MAX_NUM;
        
        while(l<=r){
            long mid = (l+r) / 2;
            long count = checkNumber(mid);
            if(count >= n){
                r = mid - 1;
                ans = Math.min(ans, mid);
            }else{
                l = mid + 1;
            }
        }
        
        answer = changeAnswer(ans);
        
        return answer;
    }
}