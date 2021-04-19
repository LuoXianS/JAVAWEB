import java.util.Scanner;

class Base {
    //字符串转化整数
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        Boolean flag = true;
        if (str.charAt(0) == '+') {
            i++;
        }
        if (str.charAt(0) == '-') {
            i++;
            flag = false;
        }
        int sum = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum *= 10;
                sum +=( str.charAt(i) - '0');
            }else{
                return 0;
            }
        }
        return flag?sum:-sum;
    }


    //进制转换
    public String solve(int M, int N){
        if (M==0){
            return  "0";
        }
        Boolean flag = true;
        if (M<0){
            flag = false;
            M = -M;
        }
        String map = "0123456789ABCDEF";
        StringBuffer str = new StringBuffer();
        while(M!=0){
            str.append(map.charAt(M%N));
            M = M / N;
        }
        return flag?str.reverse().toString():"-"+str.reverse().toString();
    }
}
