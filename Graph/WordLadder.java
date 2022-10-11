// Word Ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words=new HashSet<>();
        for(String word:wordList) words.add(word);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        if(words.contains(beginWord)) words.remove(beginWord);
        int level=1;
        if(!words.contains(endWord)) return 0;
        boolean found=false;
        while(!q.isEmpty() && !found){
            int size=q.size();
            while(size-->0 && !found){
                char[] head=q.remove().toCharArray();
                for(int i=0;i<head.length;i++){
                    char initial=head[i];
                    for(char ch='a';ch<='z';ch++){
                        head[i]=ch;
                        String val=String.valueOf(head);
                        if(words.contains(val)) {
                            q.add(val);
                            words.remove(val);
                        }
                        if(val.equals(endWord)) found=true;
                    }
                    head[i]=initial;
                }        
            }
            level++;    
        }
        return found?level:0;
    }
}