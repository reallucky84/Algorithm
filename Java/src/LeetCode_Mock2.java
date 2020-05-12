import java.util.HashMap;
import java.util.Map;

public class LeetCode_Mock2 {

    public Node root;

    /** Initialize your data structure here. */
    public LeetCode_Mock2() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        int len = word.length();
        for(int i = 0; i < len; i++){
            node = node.add(word.charAt(i));
        }
        node.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        int len = word.length();
        for(int i = 0; i < len; i++){
            node = node.get(word.charAt(i));
            if(node == null){
                return false;
            }
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        int len = prefix.length();
        for(int i = 0; i < len; i++){
            node = node.get(prefix.charAt(i));
            if(node == null){
                return false;
            }
        }
        return true;
    }

    public class Node{
        public boolean isWord = false;
        public Map<Character, Node> children = new HashMap<>();

        public Node get(char val){
            return children.getOrDefault(val, null);
        }

        public Node add(char val){
            if(!children.containsKey(val)){
                children.putIfAbsent(val, new Node());
            }
            return get(val);
        }
    }
}
