package Array;

import java.util.*;
/*
3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

/**
 * Approach: Sorted array && Two pointers
 * Two pointers 
 * 
Arrays.sort() " sort the array
List<List<Integer>> res = new ArrayList<>();
List<Integer> ans = new ArrayList<Integer>();
// ArrayList
ans.add()
ans.add(index, element)
ans.contains(object)
ans.get(index)
ans.indexOf(object) "return the index where first occur the object
ans.lastIndexOf(object)
ans.removeRange(index, index)
ans.toArray()
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            while(start<end) {
                if(nums[i]+nums[start]+nums[end]==0) {
                    List<Integer> ans = new ArrayList<Integer>();
                    ans.add(nums[i]);
                    ans.add(nums[start]);
                    ans.add(nums[end]);
                    res.add(ans);
                    start++;
                    end--;
                    while(start<end && nums[start]==nums[start-1]) {
                        start++;
                    }
                    while(start<end && nums[end]==nums[end+1]) {
                        end--;
                    }
                }else if(nums[i]+nums[start]+nums[end]>0) {
                    end--;
                }else if(nums[i]+nums[start]+nums[end]<0) {
                    start++;
                }
            }
        }
        return res;
    }
}