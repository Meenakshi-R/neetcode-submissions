class Solution {

    public String encode(List<String> strs) {
        if (strs == null) {
            return null;
        }
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        if (str == null) {
            return null;
        }
        List<String> decoded = new ArrayList<>();
        int i=0, j=0;

        while (i<str.length()) {
            while (j<str.length() && str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+len;
            decoded.add(str.substring(i, j));
            i = j;
        }
        return decoded;
    }
}
