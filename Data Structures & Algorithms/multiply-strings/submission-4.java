class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] product = new int[n1+n2];

        for (int i=n1-1; i>=0; i--) {
            for (int j=n2-1; j>=0; j--) {
                product[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        int carry = 0;
        for (int i=product.length-1; i>=0; i--){
            int temp = (carry+product[i])%10;
            carry = (carry+product[i])/10;
            product[i] = temp;
        }
        StringBuilder result = new StringBuilder();
        for (int prod : product) {
            if (prod != 0 || result.length() != 0) {
                result.append(prod);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
