class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) return new ArrayList<>();

        if (strs.length == 1) {
            result.add(new ArrayList<>(Arrays.asList(strs[0])));
            return result;
        }

        for(int i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }

        result.addAll(map.values());
        return result;
    }
}

// result must be in the form of a list
// the edge cases are taking care of first
// in this solution I created a map:
// String of the sorted anagram: Key
// Array List of of values when sorted eqauls the key: Value
// Loops looks at elements as a string converts it to a char array
// Sorts it and converts it to a string this is the key
// adds key in condition if it does not exist
// adds value to key's arraylist 
// returns all values that exist in the map at the end
