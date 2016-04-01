package solutions;

public class ReverseWords {

	public String reverseWords(String s) {
        
		s = s.trim();
        String[] parts = s.split("\\s+");
        if(parts.length == 0 ){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = parts.length - 1; i >= 0; i--){
            sb.append( parts[i] + "");
        }
        
        return sb.toString().trim();
    }
	
	public static void main(String[] args){
		ReverseWords r = new ReverseWords();
		r.reverseWords("   a   b   ");
	}
}
