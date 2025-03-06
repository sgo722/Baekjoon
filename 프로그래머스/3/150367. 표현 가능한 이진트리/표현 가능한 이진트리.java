class Solution {
    static boolean dfs(String num){
        if(num.length() == 1) return true;
        
        int mid = num.length() / 2;
        String left = num.substring(0,mid);
        String right = num.substring(mid+1);
        
        if(num.charAt(mid) == '0'){
            for(int i=0; i<left.length(); i++){
                if(left.charAt(i) != '0') return false;
            }
            for(int i=0; i<right.length(); i++){
                if(right.charAt(i) != '0') return false;
            }
            
            return true;
        }
        return dfs(left) && dfs(right);
    }
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            String binary = Long.toBinaryString(numbers[i]);
            int length = binary.length();
            int depth = 1;
            
            while((int)Math.pow(2,depth) - 1 < length) depth++;
            int want = (int)Math.pow(2,depth) - 1;
            while(length < want){
                binary = "0" + binary;
                length++;
            }
            if(dfs(binary)){
                answer[i] = 1;
            }
        }
        return answer;
    }
}