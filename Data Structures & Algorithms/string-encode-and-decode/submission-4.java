class Solution {

    public String encode(List<String> strs) {
        if(strs==null || strs.size()==0) {
            return null;
        }
        StringBuilder encoded = new StringBuilder();
        for (String word : strs) {
            encoded.append(word.length()).append("#").append(word);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return decoded;
        }
        int i=0, j=0, length=0;
        while (i<str.length()) {
            j=i;
            while (str.charAt(j) != '#') {
                j++;
            }
            length = Integer.parseInt(str.substring(i, j));
            i=j+1;
            j=i+length;
            decoded.add(str.substring(i, j));
            i=j;
        }
        return decoded;
    }
}
