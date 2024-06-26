package solved;
//回文数

public class Test9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        if (x<0||(x%10==0&&x!=0)) return false;
        //现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
        //由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
        int sum=0;
        //主要是这里的条件可以精简！
        while (x>sum){
            sum = sum*10+(x%10);
            x/=10;
        }
        //为奇数时比较少一位
        return x==sum||x==sum/10;
    }
}
