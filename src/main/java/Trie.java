import java.util.*;

/**
 *
 * 字典树：LeetCode820、208、648
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 *
 */

class Trie {
    TrieNode node;
    public Trie() {
    node=new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            int index=word.charAt(i)-'a';
            if(cur.son[index]==null){
                cur.son[index]=new TrieNode();
            }
            cur=cur.son[index];

        }
        cur.is_end=true;
    }

    public boolean search(String word) {
        TrieNode cur=node;
        for (int i = 0; i <word.length(); i++) {
            int index=word.charAt(i)-'a';
            if(cur.son[index]!=null){
                cur=cur.son[index];
            }else{
                return false;
            }
        }
        return cur.is_end;

    }
    public String search_s(String word) {
        TrieNode cur=node;
        StringBuffer res=new StringBuffer();
        for (int i = 0; i <word.length(); i++) {
            int index=word.charAt(i)-'a';
            if(cur.son[index]!=null){
                res.append((word.charAt(i)));
                cur=cur.son[index];
                if(cur.is_end){
                    return new String(res);
                }
            }else {
                if(cur.is_end){
                    return new String(res);
                }else{
                    return "F";
                }

            }
        }
        if(cur.is_end){
            return new String(res);
        }else{
            return "F";
        }

    }

    public boolean startsWith(String prefix) {
        TrieNode cur=node;
        for (int i = 0; i <prefix.length(); i++) {
            int index=prefix.charAt(i)-'a';
            if(cur.son[index]!=null){
                cur=cur.son[index];
            }else{
                return false;
            }
        }
        return true;

    }
}
class TrieNode{
    boolean is_end;
    TrieNode [] son;
    public  TrieNode(){
        is_end=false;
        son=new TrieNode[26];
    }
}

class Solution {
    /**
    *
    * 字典树：LeetCode820、208、648
    * 208. 实现 Trie (前缀树)
    * https://leetcode.cn/problems/implement-trie-prefix-tree/
    *
    */
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        for (String s :dictionary) {
            trie.insert(s);
        }
        String[] sentences=sentence.split(" ");
        StringBuffer res=new StringBuffer();
        for (String s: sentences) {
            String t=trie.search_s(s);
            if(t.equals("F")){
                res.append(s+" ");
            }else {
                res.append(t+" ");
            }
        }
        String string=res.substring(0, res.length()-1);
        return string;

    }

    /**
     *
     * 字典树：LeetCode820、208、648
     * 820. 单词的压缩编码
     * https://leetcode.cn/problems/short-encoding-of-words/
     *
     */
    public int minimumLengthEncoding(String[] words) {
        Trie trie=new Trie();
        int res=0;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });

        for (String s: words) {
            StringBuffer t=new StringBuffer(s);
            t=t.reverse();
            if(!trie.search(new String(t))&&!trie.startsWith(new String(t))){
                trie.insert(new String(t));
                res+=t.length();
                res++;
            }
        }
        return res;
    }




}