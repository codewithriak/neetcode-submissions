class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str == null || str.isEmpty()){
            return result;
        }
        int i = 0;
        while(i < str.length()){
            int delimiterIdx = str.indexOf('#', i);

            int length = Integer.parseInt(str.substring(i, delimiterIdx));

            i = delimiterIdx + 1;

            String s = str.substring(i, i + length);
            result.add(s);

            i+=length;
        }
        return result;
    }
}
