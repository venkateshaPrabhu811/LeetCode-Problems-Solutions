class Solution {
    //Backtracking Approach
    //List<String> ans = new ArrayList<>();
    //HashMap<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        /*if(digits.length() == 0){
            return ans;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        helper(0,new String(),digits);
        return ans;*/
        
        
        //To reduce Time Complexity
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        String[] letters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(0,ans,letters,new StringBuilder(),digits);
        return ans;
    }
    //Slightly Optimized
    private void helper(int curr,List<String> ans,String[] letters,StringBuilder sb,String digits){
        if(curr == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(curr) - '0' - 2];
        for(int i = 0;i<str.length();i++){
            sb.append(str.charAt(i));
            helper(curr+1,ans,letters,sb,digits);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    
    /*private void helper(int curr,String res,String digits){
        if(curr == digits.length()) return;
        String str = map.get(digits.charAt(curr));
        for(int i = 0;i<str.length();i++){
            res += str.charAt(i);
            helper(curr+1,res,digits);
            if(res.length() == digits.length())
                ans.add(res);
            res = res.substring(0,res.length()-1);
        }
    }*/
}