package solutions;

public class LicenseFormatting {

	/**
	 * %(k+1) == k is to stop 0%k == k then add '-'
	 * @param s
	 * @param k
	 * @return
	 */
	public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
        
    }
}
