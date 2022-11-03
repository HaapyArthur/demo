package intervive.leetcode;

import java.util.*;

public class TopHot {

    /**
     * 最长递增子序列
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
    static class LengthOfLIS {
//        public int lengthOfLIS(int[] nums) {
//            int[] dp = new int[nums.length];
//            dp[0] = 1;
//            int max = nums[0];
//            for (int i=1;i<nums.length;i++){
//                if (nums[i] >= max) {
//                    dp[i] = dp[i-1] + 1;
//                }else {
//                    dp[i] = dp[i-1];
//                }
//                max = Math.max(max,nums[i]);
//
//            }
//            return dp[nums.length-1];
//        }

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            // base case：dp 数组全都初始化为 1
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        public static void main(String[] args) {
//            int[] arr = {1,3,6,7,9,4,10,5,6};
//            LengthOfLIS lengthOfLIS = new LengthOfLIS();
//            int len = lengthOfLIS.lengthOfLIS(arr);
//            System.out.println(len);
            System.out.println(11112%32);
            System.out.println(11112&31);
        }
    }

//    static class CoinChange {
//        public  int coinChange(int[] coins, int amount) {
//            int[] dp = new int[amount + 1];
//            for (int i = 0; i < dp.length; i++) {
//                dp[i] = Integer.MAX_VALUE;
//            }
//            dp[0] = 0;
//            for (int i = 0; i < dp.length; i++) {
//                for (int coin : coins) {
//                    if (i - coin < 0) {
//                        continue;
//                    }
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
//            }
//            return (dp[amount] == amount + 1) ? -1 : dp[amount];
//
////            // 自底向上的动态规划
////            if(coins.length == 0){
////                return -1;
////            }
////
////            // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
////            int[] memo = new int[amount+1];
////            memo[0] = 0;
////            for(int i = 1; i <= amount;i++){
////                int min = Integer.MAX_VALUE;
////                for(int j = 0;j < coins.length;j++){
////                    if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
////                        min = memo[i-coins[j]] + 1;
////                    }
////                }
////                // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
////                memo[i] = min;
////            }
////
////            return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
//        }
//
//        public  void main(String[] args) {
//
//            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>{
//
//            });
//
//            int[] coins = {1, 2, 5};
//            int res = coinChange(coins, 11);
//            System.out.println(res);
//        }
//    }






    static class LetterCombinations {
        //最终输出结果的list
        static List<String> res = new ArrayList<>();
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        static String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public static List<String> letterCombinations(String digits) {
            //注意边界条件
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            iterStr(digits, new StringBuilder(), 0);
            return res;
        }


        //递归函数
        static void iterStr(String str, StringBuilder letter, int index) {
            //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
            //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
            //而用index记录每次遍历到字符串的位置，这样性能更好
            if (index == str.length()) {
                res.add(letter.toString());
                return;
            }
            //获取index位置的字符，假设输入的字符是"234"
            //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
            //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
            char c = str.charAt(index);
            //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
            //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
            int pos = c - '0';
            String map_string = letter_map[pos];
            //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
            for (int i = 0; i < map_string.length(); i++) {
                //调用下一层递归，用文字很难描述，请配合动态图理解
                letter.append(map_string.charAt(i));
                //如果是String类型做拼接效率会比较低
                //iterStr(str, letter+map_string.charAt(i), index+1);
                iterStr(str, letter, index + 1);
                letter.deleteCharAt(letter.length() - 1);
            }
        }


        public static void main(String[] args) {
            String digest = "23";
            List<String> list = letterCombinations(digest);
            for (String s : list) {
                System.out.println(s);
            }
        }

    }

    static class Permute {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            int[] visited = new int[nums.length];
            backtrack(res, nums, new ArrayList<Integer>(), visited);
            return res;

        }

        private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) continue;
                visited[i] = 1;
                tmp.add(nums[i]);
                backtrack(res, nums, tmp, visited);
                visited[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }

        public static void main(String[] args) {
            Permute permute = new Permute();
            int[] arr = {1, 2, 3};
            List<List<Integer>> list = permute.permute(arr);
            System.out.println();
        }

    }

    static class Subsets {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(0, nums, res, new ArrayList<Integer>());
            return res;

        }

        private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
            if (i > nums.length) {
                System.out.println("returning ....");
                return;
            }
            res.add(new ArrayList<>(tmp));
            for (int j = i; j < nums.length; j++) {
                tmp.add(nums[j]);
                backtrack(j + 1, nums, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3};
            List<List<Integer>> list = subsets(arr);
            System.out.println();
        }
    }



}

