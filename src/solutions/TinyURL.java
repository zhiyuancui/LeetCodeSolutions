package solutions;

import java.util.HashMap;

public class TinyURL {

	HashMap<String, String> longToShort = new HashMap<String,String>();
	HashMap<String, String> shortToLong = new HashMap<String,String>();
	
	char[] tokens = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
	                 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
	                 '0','1','2','3','4','5','6','7','8','9'};
			
	int count=0;
	
	public String encode(String longUrl) {
		String encoded = generateTinyURL();
		longToShort.put(longUrl, encoded);
		shortToLong.put(encoded, longUrl);
		
		return encoded;
	}
	
	public String decode(String shortUrl) {
		return shortToLong.get( shortUrl );
	}
	
	private String generateTinyURL(){
		count++;	
		return convertToTinyURL( count );
	}
	
	private String convertToTinyURL(int number){
		
		StringBuilder res = new StringBuilder();
		
		while( number > 0 ){
			res = res.append( tokens[ number % 62 ] );
			number = number / 62;
		}
		
		return res.toString();
	}
	
	public String encode(int i ) {
		StringBuilder sb = new StringBuilder();
		
		while( i > 0 ) {
			sb.insert(0, tokens[i%62] );
			i = i / 62;
		}
		return sb.toString();
	}
	
	public int toInt(String s) {
		int i = 0;
		for(char c : s.toCharArray() ) {
			int index = 0;
			for(; index < tokens.length; index++ ) {
				if( tokens[index] == c ) {
					break;
				}
			}
			i = i * 62 + (index);
		}
		return i;
	}
}
