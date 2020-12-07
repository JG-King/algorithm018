class Solution {
    /**
     * 单词接龙
     * https://leetcode-cn.com/problems/word-ladder/
     * 广度优先搜索
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(wordList.size() == 0 || !set.contains(endWord)){
            return 0;
        }

        //被访问过的数据
        Set<String> visited = new HashSet<>();


        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int step = 1;
        while(!beginVisited.isEmpty() && !endVisited.isEmpty()){
            if(beginVisited.size() > endVisited.size()){
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextVisited = new HashSet<>();
            for(String word : beginVisited){
                if(convert(word, endVisited, nextVisited, set, visited)){
                    return step + 1;
                }
            }
            beginVisited = nextVisited;
            step++;
        }

        return 0;
    }

   
    private boolean convert(String word, Set<String> endVisited, Set<String> nextVisited, Set<String> set, Set<String> visited){

        char[] wordArr = word.toCharArray();

        for(int i = 0;i < word.length(); i++){
            char temp = wordArr[i];

            for(char c = 'a'; c <= 'z'; c++){

                wordArr[i] = c;
                String currWords = String.valueOf(wordArr);

                if(set.contains(currWords)){

                    if(endVisited.contains(currWords)){
                        return true;
                    }

                    if(!visited.contains(currWords)){
                        nextVisited.add(currWords);
                        visited.add(currWords);
                    }


                }


            }

            wordArr[i] = temp;

        }




        return false;
    }



}