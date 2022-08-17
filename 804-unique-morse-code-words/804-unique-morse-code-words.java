class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String str : words){
            StringBuilder sb = new StringBuilder();
            for(char ch : str.toCharArray()){
                sb.append(map[ch - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}