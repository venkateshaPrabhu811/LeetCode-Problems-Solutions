class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for(int i = 0;i<n;i++){
            arr[i] = 'a';
        }
        k = k-n;
        for(int i = n-1;i>=0;i--){
            if(k == 0){
                break;
            }
            else if(k < 25){
                arr[i] = (char)('a' + k);
                k = 0;
            }
            else{
                arr[i] = (char)('a' + 25);
                k -= 25;
            }
        }
        return String.valueOf(arr);
    }
}