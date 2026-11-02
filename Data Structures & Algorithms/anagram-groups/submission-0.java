class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

       Map<String, List<String>> map = new HashMap<>();
       for(String s: strs){
        //count frequency of each characters a-z
        char [] count = new char[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        //Convert the 26 element count array into a unique String key 
        String key =new String(count);

        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(s);
       } 
       return new ArrayList<>(map.values());
    }
}
