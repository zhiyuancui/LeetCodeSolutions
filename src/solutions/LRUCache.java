package solutions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    /**
     * Reference to :http://www.cnblogs.com/lzrabbit/p/3734850.html
     * @param capacity
     */
    public LRUCache(int capacity) {
      cache = new LinkedHashMap<Integer, Integer>(){

      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        if(cache.size() > capacity) {
          return true;
        }
        return false;
      }
    };
   }
    
    private void printMap() {
    	for(int key : cache.keySet() ) {
    		System.out.print(key+", ");
    	}
    	System.out.println();
    }

    public int get(int key) {
      if(cache.containsKey(key)) {
        int value = cache.get(key);
        moveToFront(key);
        printMap();
        return value;
      }
      
      printMap();
      return -1;
    }

    void moveToFront(int key) {

      int val = cache.get(key);
      cache.remove(key);
      cache.put(key,val);
    }

    public void put(int key, int value) { 
    	cache.put(key, value);
    	moveToFront(key);
    	printMap();
    }

}


class LRUCache2{
    class DoubleLinkedNode {
		int key;
		int value;
		DoubleLinkedNode pre;
		DoubleLinkedNode post;
	}
        
    private void addNode(DoubleLinkedNode node) {
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
        
    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;
    }
        
    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
        
    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
        
    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DoubleLinkedNode head, tail;
        
    private LRUCache2(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DoubleLinkedNode();
        head.pre = null;
        
        tail = new DoubleLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
        
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if( node == null ) {
            return -1;
        } else {
            this.moveToHead(node);
            return node.value;
        }
    }
        
    public void set(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if( node == null ) {
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode( newNode );
            count++;
            
            if( count > capacity ) {
                DoubleLinkedNode tail = this.popTail();
                this.cache.remove( tail.key );
                count--;
            }
        } else{
            node.value = value;
            this.moveToHead(node);
        }
    }
}

