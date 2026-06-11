class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        if (strs == null || strs.isEmpty()) {
            return null;
        }
        for (String word : strs) {
            encoded.append(word.length()).append("#").append(word);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        if (str == null) {
            return decoded;
        }
        int index = 0, length = str.length(), j=0;;
        while (index < length) {
            while (str.charAt(j) != '#') {
                j++;
            }
            int wordLength = Integer.parseInt(str.substring(index, j));
            index = j+1;
            j = index + wordLength;
            decoded.add(str.substring(index, j));
            index = j;
        }
        return decoded;
    }
}
