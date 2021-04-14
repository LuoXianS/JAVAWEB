import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

class Solution {
    //求字符串中出现次数超过一半的
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        int length = array.length/2;
        for (int i = 0; i <array.length; i++) {
            if (array[i] ==array[length]){
                count++;
            }
        }
        if (count > length) {
            return array[length ];
        }
        return 0;

    }

}
public class Main{
    public static void main(String[] args) {
        Solution Solution = new Solution();
        int[] arr = {1,1,2,3,5,5,5,5,5};
        int a= Solution.MoreThanHalfNum_Solution(arr);
        System.out.println(a);
    }
    //输出最长连续数字
    public static void main6(String[] args) {
    Scanner sc = new Scanner(System.in);
        String str = null;
        while (sc.hasNext()){
         str = sc.nextLine();
    }
    int max = 0;
    int count = 0;
    int end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                count++;
                if (max < count){
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        System.out.println(str.substring(end-max+1,end+1));
    }
    //翻转字符串
    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split(" ");
        for (int i = str1.length - 1; i >= 0; i--) {
            System.out.print(str1[i] + " ");

        /*int left = 0;
        int right = str1.length-1;
        while(left<right){
            String tmp = str1[left];
            str1[left] = str1[right];
            str1[right] = tmp;
            left++;
            right--;
            System.out.println(str1[left]+" ");*/
        }
    }
    //牛牛的排序子序列
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = sc.nextInt();
        }
        int flag = 0;
        int count = 1;
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]>arr[i-1]){
                if (flag == 0){
                    flag = 1;
                }
                if (flag == -1){
                    flag = 1;
                    count++;
                }
            }else if (arr[i]<arr[i-1]){
                if (flag ==0){
                    flag = -1;
                }
                if (flag ==1){
                    flag = -1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    //输入两个字符串,删除第一个字符串里,所有的第二个字符串有的;
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] str = s1.split("");
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < str.length ;i++) {
            if (!s2.contains(str[i])){
                str1.append(str[i]);
            }
        }
        System.out.println(str1.toString());
    }
    //贪心算法求 每组中间值得总和
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num*3];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int j = 1; j <=num ; j++) {
            sum+=arr[arr.length-(j*2)];
        }
        System.out.println(sum);
    }
    //输入两个字符串,删除第一个字符串里,所有的第二个字符串有的;

}
