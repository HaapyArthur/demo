package intervive.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HWString {

    static class HJ1 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine().toLowerCase();
            String target = br.readLine();
            int num1 = str.length();
            int num2  = str.replace(target,"").length();
            System.out.println(num1);
            System.out.println(num2);
        }
    }

    static class HJ3 {
//        public static void main(String[] args) throws IOException {
//            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//            Integer num = Integer.parseInt(br.readLine());
//
//            Set<Integer> set = new HashSet<>();
//            for (int i= 0;i<num;i++){
//                Random random = new Random();
//                set.add(random.nextInt(500));
//            }
//            int[] arr = new int[set.size()];
//
//
//        }
//
//        public static int[] mergeSort(int[] arr){
//
//        }
//
//        private static int[] sort(int[] arr,int l,int r){
//
//            int mid = (l+r)/2;
//
//            int[] left = sort()
//        }
    }

    static class HJ4 {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);

            while(sc.hasNext()){
                String str = sc.nextLine();
                StringBuilder sb = new StringBuilder();//牢记字符串缓冲区的建立语法
                sb.append(str);//字符串缓冲区的加入
                int size = str.length();
                int addZero = 8 - size%8;//addzero的可能值包括8
                while((addZero > 0)&&(addZero<8)){//注意边界调节，避免addzero=8
                    sb.append("0");//使用‘’或“”都可
                    addZero--;
                }
                String str1 = sb.toString();
                while(str1.length()>0){
                    System.out.println(str1.substring(0,8));
                    str1 = str1.substring(8);
                }

            }
        }
    }

    static class HJ5{
        private final static int BASE = 16;
        private static Map<Character, Integer> map = new HashMap<Character, Integer>()
        {{
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('A', 10);
            put('B', 11);
            put('C', 12);
            put('D', 13);
            put('E', 14);
            put('F', 15);
            put('a', 10);
            put('b', 11);
            put('c', 12);
            put('d', 13);
            put('e', 14);
            put('f', 15);
        }};

        public static int getDecimal(String number) {
            int res = 0;
            for (char ch : number.toCharArray()) {
                res = res * BASE + map.get(ch);
            }
            return res;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                String number = in.next();
                int res = getDecimal(number.substring(2));
                System.out.println(res);
            }
        }
    }



}
