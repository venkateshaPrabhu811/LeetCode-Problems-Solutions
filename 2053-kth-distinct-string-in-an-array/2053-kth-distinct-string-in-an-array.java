class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> en : map.entrySet()){
            if(en.getValue() == 1){
                count++;
            }
            if(count == k){
                return en.getKey();
            }
        }
        return "";
    }
}