class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer,Long> map = new HashMap<>();
        Arrays.sort(arr);
        long count = 1;
        map.put(arr[0],count);
        for(int i = 1;i<arr.length;++i){
            count = 1;
            for(Integer key : map.keySet()){
                if(arr[i] % key == 0 && map.containsKey(arr[i] / key)){
                    count += (map.get(key) *  map.get(arr[i]/key));
                }
            }
            map.put(arr[i],count);
        }
        long sum = 0;
        int mod = 1000000007;
        for(Map.Entry<Integer,Long> entry : map.entrySet()){
            sum = (sum + entry.getValue()) % mod;
        }
        return (int)sum;
    }
}