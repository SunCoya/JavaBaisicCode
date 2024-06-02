package solved;

public class Test13 {
    public static void main(String[] args) {
        String str = "LVIII";
        System.out.println(romanToInt(str));
    }

    //不使用hashmap：使用switch即可
    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        //一个一个往后看,可以简化书写
        for (int i = 0; i < n; i++) {
            int a = getNum(s.charAt(i));
            //可以只判断当前数字：小于前面的就减去当前数字：后面会加回来
            if(i<n-1&&a<getNum(s.charAt(i+1))) ans-=a;
            else ans+=a;
        }
        return ans;
    }
    public static int getNum(char c){
        switch (c){
            case 'I'-> { return 1; }
            case 'V'-> { return 5; }
            case 'X'-> { return 10; }
            case 'L'-> { return 50; }
            case 'C'-> { return 100; }
            case 'D'-> { return 500; }
            case 'M'-> { return 1000; }
            default -> { return 0;}
        }
    }
}
