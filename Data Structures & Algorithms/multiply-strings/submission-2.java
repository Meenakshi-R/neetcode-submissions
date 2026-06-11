class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] product = new int[n1+n2];

        for (int i = n1-1; i>=0; i--) {
            for (int j=n2-1; j>=0; j--) {
                product[i+j+1] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i=product.length-1; i>=0; i--) {
            int temp = (product[i]+carry)%10;
            carry = (product[i]+carry)/10;
            product[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int element : product) {
            if (element != 0 || sb.length() != 0) {
                 sb.append(element);
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}
