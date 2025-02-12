class Solution {
    static final int MAX_N = 500000;
    
    static long[] pSumA = new long[MAX_N + 1];
    static long[] pSumB = new long[MAX_N + 1];
    
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        
        int value = 1;
        
        for(int i=1; i<=len; i++){
            pSumA[i] = Math.max(pSumA[i-1] + sequence[i-1] * value, pSumA[i]);
            pSumA[i] = Math.max(pSumA[i], sequence[i-1] * value);
            value *= -1;
        }
        
        value = -1;
        for(int i=1; i<=len; i++){
            pSumB[i] = Math.max(pSumB[i-1] + sequence[i-1] * value, pSumB[i]);
            pSumB[i] = Math.max(pSumB[i], sequence[i-1] * value);
            value *= -1;
        }
        
        System.out.println(pSumB[4]);
        for(int i=1; i<=len; i++){
            answer = Math.max(answer, pSumB[i]);
            answer = Math.max(answer, pSumA[i]);
        }
        
        return answer;
    }
}