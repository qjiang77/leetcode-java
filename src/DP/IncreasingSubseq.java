package DP;

import java.util.*;
/*
Leetcode 491: Increasing Subsequence
 */
public class IncreasingSubseq {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // HashSet 去重
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return new ArrayList<List<Integer>>(res);
    }

    public void helper(Set<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        if(subList.size() >= 2) {
            res.add(new ArrayList<Integer>(subList));
        }
        for(int i = start; i < nums.length; i++) {
            if(subList.size() == 0 || subList.get(subList.size()-1) <= nums[i]) {
                subList.add(nums[i]);
                helper(res, subList, nums, i+1);
                subList.remove(subList.size()-1);
            }
        }
    }

    //TODO: Need exercise once more
}
