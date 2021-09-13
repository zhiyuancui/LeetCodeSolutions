package solutions;

/**
 * 299 Bulls and Cows
 */
public class BullsAndCows {
	public String getHint(String secret, String guess) {
        if( secret == null || guess == null || secret.length() == 0 || guess.length() == 0 || 
            secret.length() != guess.length() ){
            return "";
        }
        
        int len = secret.length();
        
        int[] secretarr = new int[10];
        int[] guessarr = new int[10];
        
        int bull = 0;
        int cow = 0;
        
        for(int i = 0; i < len; i++){
            if( secret.charAt(i) == guess.charAt(i) ){
                bull++;
            }else{
                secretarr[ secret.charAt(i) - '0']++;
                guessarr[ guess.charAt(i) - '0']++;
            }
        }
        
        for(int i = 0; i < 10; i++){
            cow += Math.min(secretarr[i], guessarr[i]);
        }
        
        return bull +"A" + cow + "B";
    }
}
