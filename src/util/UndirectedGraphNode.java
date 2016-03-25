package util;

import java.util.*;

public class UndirectedGraphNode {
	public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { 
    	label = x; 
    	neighbors = new ArrayList<UndirectedGraphNode>(); 
	 }
}
