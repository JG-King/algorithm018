class Solution {
    public String getHint(String secret, String guess) {
        int[] cache = new int[10];
        int bulls = 0, cows = 0;
        for(int i = 0; i < secret.length(); i++){
           char ce = secret.charAt(i);
           char cg = guess.charAt(i);
           if(ce == cg){
               bulls++;
           }else{
               if(cache[ce - '0']++ < 0){
                   cows++;
               }
               if(cache[cg - '0']-- > 0){
                   cows++;
               }
           }
        }
        return bulls + "A" + cows + "B";

    }
}