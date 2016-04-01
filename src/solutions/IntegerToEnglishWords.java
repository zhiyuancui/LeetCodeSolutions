package solutions;

public class IntegerToEnglishWords {
	private String[] oneToNineteen = new String[]{
	        "",
	        "One",
	        "Two",
	        "Three",
	        "Four",
	        "Five",
	        "Six",
	        "Seven",
	        "Eight",
	        "Nine",
	        "Ten",
	        "Eleven",
	        "Twelve",
	        "Thirteen",
	        "Fourteen",
	        "Fifteen",
	        "Sixteen",
	        "Seventeen",
	        "Eighteen",
	        "Nineteen"
	    };

	    private String[] twentyToNinety = new String[]{
	        "",
	        "Ten",
	        "Twenty",
	        "Thirty",
	        "Forty",
	        "Fifty",
	        "Sixty",
	        "Seventy",
	        "Eighty",
	        "Ninety"
	    };

	    private String[] hunderedToBillion = new String[]{
	        "Hundred",
	        "Thousand",
	        "Million",
	        "Billion"
	    };
	    
	    public String numberToWords(int num) {
	        if(num == 0){
	            return "Zero";
	        }

	        StringBuilder builder = new StringBuilder();
	        convert(num, builder);
	        return builder.toString().trim();
	    }
	    
	    private void convert(int n, StringBuilder builder){
	        if( n == 0 ){
	            return;
	        }
	        
	        if(n < 20){
	            builder.append(oneToNineteen[n]);
	            builder.append(" ");
	        }else if(n < 100){
	            builder.append(twentyToNinety[n/10]);
	            builder.append(" ");
	            convert(n%10, builder);
	        }else if(n<1000){
	            convert(n/100, builder);
	            builder.append(hunderedToBillion[0]);
	            builder.append(" ");
	            convert(n%100, builder);
	        }else if(n<1000000){
	            convert(n/1000, builder);
	            builder.append(hunderedToBillion[1]);
	            builder.append(" ");
	            convert(n%1000, builder);
	        }else if(n<1000000000){
	            convert(n/1000000, builder);
	            builder.append(hunderedToBillion[2]);
	            builder.append(" ");
	            convert(n%1000000, builder);
	        }else{
	            convert(n/1000000000, builder);
	            builder.append(hunderedToBillion[3]);
	            builder.append(" ");
	            convert(n%1000000000, builder);
	        }
	    }
}
