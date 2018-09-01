package String;

public class ReverseString {
    public static String reverseString(String s) {
        if(s == null || s.length() ==0) return s;

        int left = 0;
        int right = s.length()-1;
        char[] str = s.toCharArray();
        while(left < right) {
            char temp = str[left];
            str[left] = str[right];
            left++;
            str[right] = temp;
            right--;
        }
        return new String(str);
    }
}
