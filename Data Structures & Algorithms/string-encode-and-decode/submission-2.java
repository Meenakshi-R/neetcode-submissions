class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return decoded;
        }
        
        int length=0, i=0;
        while(i<str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
               j++;
            }
            length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+length;
            decoded.add(str.substring(i, j));
            i = j;
        }
        return decoded;
    }
}
