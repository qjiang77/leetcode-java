package Array;

import java.util.HashMap;

public class TwoSum {
    // 每个值只用于计算一次
    // time：O(n)， space：O(n)
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;

        int[] res = new int[]{-1,-1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // 看之前当前的之前是否有成立的值
            // 一边检查一边添加
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);
        }

        return res;
    }
}
