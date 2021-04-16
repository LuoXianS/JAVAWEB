import java.util.Scanner;

class Base {
    public String solve(int M, int N){
        if (M==0){
            return  "0";
        }
        boolean flag = true;
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
