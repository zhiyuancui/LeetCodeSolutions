package solutions;

import java.util.*;

/**
 * 336 Palindrome Pairs
 */
public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> result = new ArrayList<>(); 
	    if (words == null || words.length < 2){
	      return result;  
	    } 
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i<words.length; i++){ 
	        map.put(words[i], i);
	    }
	    for (int i=0; i<words.length; i++) {
	        
	        for (int j=0; j<=words[i].length(); j++) { 
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);
	            if (isPalindrome(str1)) {
	                String str2rvs = new StringBuilder(str2).reverse().toString();
	                if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(map.get(str2rvs));
	                    list.add(i);
	                    result.add(list);
	                    
	                }
	            }
	            if (isPalindrome(str2)) {
	                String str1rvs = new StringBuilder(str1).reverse().toString();
	               
	                if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(i);
	                    list.add(map.get(str1rvs));
	                    result.add(list);
	                }
	            }
	        }
	    }
	    return result;
	}

	private boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length() - 1;
	    while (left <= right) {
	        if (str.charAt(left++) !=  str.charAt(right--)) return false;
	    }
	    return true;
	}

	/**
	 *
	 * https://leetcode-cn.com/problems/palindrome-pairs/solution/java-trie-yi-yu-li-jie-by-copyreadmachine/
	 */
	
	class TrieNode {
		TrieNode[] children;
		int index;
		List<Integer> list;
		public TrieNode() {
			children = new TrieNode[26];
			index = -1;
			list = new ArrayList<>();
		}
	}

	//把前半部分reverse加进入，或者是把后半部分reverse加起来
	public List<List<Integer>> palindromePairs2(String[] words) {
		List<List<Integer>> result = new ArrayList<>();

		TrieNode root = new TrieNode();

		for(int i = 0; i < words.length; i++) {
			addWord(root, words[i], i);
		}

		for(int i = 0; i < words.length; i++) {
			search(root, words[i], i, result);
		}

		return result;
	}

	public void addWord(TrieNode root, String word, int index) {
		for(int i = word.length() - 1; i >= 0; i--) {
			char c = word.charAt(i);
			if(root.children[c-'a'] == null) {
				root.children[c-'a'] = new TrieNode();
			}

			if(isPalindrome(word, 0, i)) {
				root.list.add(index);
			}

			root = root.children[c-'a'];
		}

		root.index = index;
		root.list.add(index);
	}

	private void search(TrieNode root, String word, int k, List<List<Integer>> result) {
		for(int i = 0; i < word.length(); i++) {
			if(root.index >= 0 && root.index != k && isPalindrome(word, i, word.length() -1)) {
				result.add(Arrays.asList(k, root.index));
			}

			root = root.children[word.charAt(i) - 'a'];
			if(root == null) {
				return;
			}
		}

		for(int i : root.list) {
			if(i != k) {
				result.add(Arrays.asList(k, i));
			}
		}
	}

	private boolean isPalindrome(String word, int l, int r) {
		while (l < r) {
			if (word.charAt(l++) != word.charAt(r--)) return false;
		}
		return true;
	}
	
}
