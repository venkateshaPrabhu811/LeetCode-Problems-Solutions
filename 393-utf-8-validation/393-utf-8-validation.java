class Solution {
    public boolean validUtf8(int[] data) {
        String[] arr = new String[data.length];
        for(int i = 0;i<data.length;++i){
            arr[i] = generateBinary(data[i]);
            
        }
        if(arr.length == 1) return arr[0].charAt(0) == '0';
        int i = 0;
        for(;i<arr.length;++i){
            if(arr[i].substring(0,2).equals("10")) return false;
            int count = findOne(arr[i]);
            if(count == 0) continue;
            if(count > 4) return false;
            if(!checkSeq(i,count,arr)) return false;
            i = i + count - 1;
        }
        return true;
    }
    private String generateBinary(int val){
        StringBuilder sb = new StringBuilder();
        while(val > 0){
            sb.append(val%2);
            val = val >> 1;
        }
        String temp = "0";
        for(int i = 0;i<8 - sb.length() - 1;++i){
            temp += '0';
        }
        String res = sb.reverse().toString();
        return sb.length() == 8 ? res : temp + res;
    }
    private int findOne(String str){
        int ptr = 0;
        int count = 0;
        for(int i = 0;i<str.length();++i){
            if(str.charAt(i) == '0') return count;
            ++count;
        }
        return count;
    }
    private boolean checkSeq(int index,int len,String[] arr){
        int start = index+1;
        for(;start < arr.length && start < index + len;++start){
            if(!arr[start].substring(0,2).equals("10")) return false;
        }
        return start == index + len;
    }
}