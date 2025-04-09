class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);  
        }
        
        return sb.toString();
    }

    // using string builder an array of strings is combined 
    // separated by #

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String nextString = str.substring(j + 1, j + 1 + length);
            result.add(nextString);

            i = j + 1 + length;
        }
        
        return result;
    }

    // tracks count of characters prior to #
    // gets a substring from start to #
    // adds it to result
    // result is returned at the end
}
