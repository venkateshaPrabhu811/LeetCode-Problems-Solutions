class Solution {
    public int calPoints(String[] ops) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<ops.length;i++){
            String str = ops[i];
            if(str.equals("C")){
                res.remove(res.size()-1);
            }
            else if(str.equals("D")){
                int temp = res.get(res.size()-1);
                res.add(temp*2);
            }
            else if(str.equals("+")){
                int a = res.get(res.size()-1);
                int b = res.get(res.size()-2);
                res.add(a+b);
            }
            else{
                res.add(Integer.parseInt(str));
            }
        }
        int sum = 0;
        for(int i = 0;i<res.size();i++){
            sum += res.get(i);
        }
        return sum;
    }
}