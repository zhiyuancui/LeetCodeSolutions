package util;

import java.util.*;

public class UndirectedGraphNode {
	int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
    	label = x; 
    	neighbors = new ArrayList<UndirectedGraphNode>(); 
	 }
}
