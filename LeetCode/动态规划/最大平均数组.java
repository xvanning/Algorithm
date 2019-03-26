/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        double maxSum = maxAverage(nums, 3);
        System.out.println(maxSum);
    }

    // 暴力解法，模仿LCS
    private static Double maxAverage(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        double maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int l = 0, r = nums.length - 1 - i; r <= nums.length - 1; l++, r++) {
                if (r - l + 1 < k) {
                    continue;
                }
                double curSum = 0;
                for (int j = l; j <= r; j++) {
                    curSum += nums[j];
                }

                curSum = curSum / (r - l + 1);
                maxSum = Math.max(curSum, maxSum);
            }
        }
        return maxSum;
    }

    // 长度等于4的最大平均子数组： https://www.jiuzhang.com/solution/maximum-average-subarray/#tag-highlight
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            ans = Math.max(ans, sum[i] - sum[i - k]);
        }
        return ans * 1.0 / k;
    }

    // 小红书笔试题，滑动窗口： https://blog.csdn.net/smile_YangYue/article/details/78230074
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());
        int[] arr = new int[N];
        String str = in.nextLine();
        String[] str1 = str.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str1[i]);
        }
        int K = Integer.parseInt(in.nextLine());
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = 1; i <= N - K; i++) {
            sum = sum + arr[i + K - 1] - arr[i - 1];
            max = Math.max(sum, max);
        }

        System.out.println((float) max / K);
    }

}