//Word Ladder 2

//Tle Solution (passes 32/35)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        // Form the set of words in the list
        HashSet<String> set=new HashSet<>();
        for(String word:wordList) set.add(word);
        
        // list of list to be returned
        List<List<String>> ans=new ArrayList<>();
        
        // if the end word is absent from the set return an empty list, as the word cannot be formed
        if(!set.contains(endWord)) return ans;
        
        // Queue to implement the bfs traversal
        // Pair -> word + the sequence/list of words
        Queue<Pair> q=new LinkedList<>();
        
        // add the begin word to the queue and remove it from the set (if present)
        List<String> list=new ArrayList<>();
        list.add(beginWord);
        q.add(new Pair(beginWord,list));
        if(set.contains(beginWord)) set.remove(beginWord);
        
        // a flag to break the traversal when the end word has been found
        boolean found=false;
        
        // the traversal
        while(!q.isEmpty() && !found){
            
            // the size to mark the levels
            int size=q.size();
            
            HashSet<String> visited=new HashSet<>();
            while(size-->0){  
                Pair head=q.remove();
                
                // form a char array of the string for efficient swapping of characters
                char[] word=head.word.toCharArray();
                
                // change every character in the word
                for(int i=0;i<word.length;i++){
                    
                    // store the original charcter at i for future reference(backtracking) 
                    char initial=word[i];
                    
                    // each cahracter from a till z is an possible replacement
                    for(char ch='a';ch<='z';ch++){
                        
                        // replace char at i with ch
                        word[i]=ch;
                        String val=String.valueOf(word);
                        
                        // check if val is the end word, if so add to the list and mark flag true
                        if(endWord.equals(val)){
                            List<String> tmp=new ArrayList<>(head.seq);
                            tmp.add(val);
                            found=true;
                            ans.add(new ArrayList<>(tmp));
                        }
                        
                        // check if set contains the word and add it to the sequence
                        if(set.contains(val)){
                            List<String> tmp=new ArrayList<>(head.seq);
                            tmp.add(val);
                            
                            // add to the queue
                            q.add(new Pair(val,tmp));
                            
                            // remove val from the set for any future repetions
                            visited.add(val);
                        }   
                    }
                    
                    // set the original char back
                    word[i]=initial;
                }
            }
            set.removeAll(visited);
        }
        
        return ans;
    }
}

class Pair{
    String word;
    List<String> seq;
    Pair(){}
    Pair(String word,List<String> seq){
        this.word=word;
        this.seq=seq;
    }
}



class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        // Form the set of words in the list
        HashSet<String> set=new HashSet<>();
        for(String word:wordList) set.add(word);
        
        // Form the graph
        HashMap<String,List<String>> graph=formGraph(beginWord,new HashSet<>(set));
        
        // for (String name : graph.keySet()) 
        //     System.out.println("key: " + name+" -> "+graph.get(name));
        
        // list of list to be returned
        List<List<String>> ans=new ArrayList<>();
        
        // if the end word is absent from the set return an empty list, as the word cannot be formed
        if(!set.contains(endWord)) return ans;
        
        // dfs
        List<String> subans=new ArrayList<>();
        subans.add(beginWord);
        dfs(beginWord,endWord,graph,ans,subans);
        
        return ans;
    }
    public void dfs(String start,String end,HashMap<String,List<String>> graph,List<List<String>> ans,List<String> subans){
        if(start.equals(end)){
            ans.add(new ArrayList<>(subans));
            return;
        }
        else if(graph.containsKey(start)){
            for(String next:graph.get(start)){
                subans.add(next);
                dfs(next,end,graph,ans,subans);
                subans.remove(subans.size()-1);
            }
        }
    }
    
    public HashMap<String,List<String>> formGraph(String start,HashSet<String> words){
        HashMap<String,List<String>> map=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        q.add(start);
        words.remove(start);
        while(!q.isEmpty()){
            int size=q.size();
            HashSet<String> visited=new HashSet<>();
            while(size-->0){
                String head=q.remove();
                char[] word=head.toCharArray();
                List<String> tmp=new ArrayList<>();
                for(int i=0;i<word.length;i++){
                    char initial=word[i];
                    for(char ch='a';ch<='z';ch++){
                        word[i]=ch;
                        String val=String.valueOf(word);
                        if(words.contains(val)){
                            q.add(val);
                            tmp.add(val);
                            visited.add(val);
                        }
                    }
                    word[i]=initial;
                }
                map.put(head,tmp);
            }
            words.removeAll(visited);
        }
        return map;
    }
}

// accepted
class Solution {
    
    private final List<List<String>> res = new ArrayList<>();
    private List[] parent;
    private List<String> wordList;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        this.wordList = wordList;
        wordList.add(beginWord);
        
        final int wordLength = beginWord.length();
        final int totalWords = wordList.size();
        final boolean[] visited = new boolean[totalWords];
        visited[totalWords-1] = true;
        
        this.parent = new List[totalWords];
        
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(totalWords-1);
        
        int endWordIndex = -1;
        
        outerloop : while (!queue.isEmpty()) {
            final Set<Integer> newIndices = new HashSet<>();
            for (int i=0, n = queue.size(); i<n; i++) {
                Integer currIndex = queue.poll();
                String currWord = wordList.get(currIndex);
                for (int j=0; j<totalWords; j++) {
                    if (!visited[j] && isSequence(currWord, wordList.get(j))) {
                        if (!newIndices.contains(j)) queue.offer(j);
                        if (parent[j] == null) parent[j] = new LinkedList<Integer>();
                        parent[j].add(currIndex);
                        newIndices.add(j);
                    }
                }
            }
            
            for (Integer seq : newIndices) {
                if (wordList.get(seq).equals(endWord)) {
                    endWordIndex = seq;
                    break outerloop;
                }
                visited[seq] = true;
            }
        }
        
        if (endWordIndex == -1) return res;
        
        backTrackResult(endWordIndex, new LinkedList<>());
        
        return res;
    }
    
    private void backTrackResult(int index, LinkedList<String> list) {
        list.addFirst(wordList.get(index));
        if (parent[index] == null) {
            res.add(list);
        }
        else {
            for (Object i : parent[index]) {
                backTrackResult((Integer)i, new LinkedList<>(list));
            }
        }
    }
    
    private boolean isSequence(final String a, final String b) {
        int mismatchCount = 0;
        for (int i=0, n = a.length(); i<n; i++) {
            if (a.charAt(i) != b.charAt(i) && mismatchCount++ > 0) return false;
        }
        return true;
    }
}


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return new ArrayList<>();
        }

        words.add(beginWord);

        HashMap<String, List<String>> adjList = new HashMap<>();

        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = getPattern(word, i);
                adjList.putIfAbsent(pattern, new ArrayList<>());
                adjList.get(pattern).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> levels = new HashMap<>();

        queue.add(beginWord);
        levels.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int curLevel = levels.get(cur);
            graph.putIfAbsent(cur, new HashSet<>());

            for (int i = 0; i < cur.length(); i++) {
                String pattern = getPattern(cur, i);

                for (String nei: adjList.get(pattern)) {
                    
                    graph.get(cur).add(nei);
                    if (!levels.containsKey(nei)) {
                        levels.put(nei, curLevel + 1);
                        queue.add(nei);
                    }
                }
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        if (!graph.containsKey(endWord)) {
            return ans; 
        }

        backtracking(endWord, beginWord, new ArrayList<>(), ans, graph, levels);

        return ans;
    }

    private void backtracking(String start, String endWord,
                              List<String> path, List<List<String>> ans,
                              HashMap<String, Set<String>> graph,
                              Map<String, Integer> levels) {
        path.add(start);

        if (start.equals(endWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
        } else {
            for (String next : graph.get(start)) {
                if (levels.get(next) == levels.get(start) - 1) {
                    backtracking(next, endWord, path, ans, graph, levels);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    private String getPattern(String word, int i) {
        return word.substring(0, i) + "*" + word.substring(i + 1);
    }
}