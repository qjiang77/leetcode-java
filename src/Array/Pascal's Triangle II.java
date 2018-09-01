/*
118. Pascal's Triangle II
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]

Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */

/**
 Approach: 
 new ArrayList<Integer> to store the res
 use iterate: from right to left
 eg. 1 0 0 0 k=0
	 1 1 0 0 k=1
	 1 1 1 0
	 1 2 1 0 k=2
	 1 2 1 1
	 1 2 3 1
	 1 3 3 1 k=3
 */

 class Solution {
 	public List<Integer> getRow(int rowIndex) {
 		List<Integer> res = new ArrayList<Integer>();

 		for(int i = 0; i <= rowIndex; i++) {
 			res.add(0);
 		}
 		res.set(0, 1);
 		for(int i = 1; i <= rowIndex; i++) {
 			res.set(i, 1);
 			for(int j = i - 1; j > 0; j--) {
 				res.set(j,res.get(j)+res.get(j-1));
 			}
 		}
 		return res;
 	}
 }


/**
Approach2:
Change the ArrayList to Array could accelerate
*/
 class Solution {
 	public List<Integer> getRow1(int rowIndex) {
 		int[] res = new int[rowIndex+1];
 		res[0] = 1;

 		int i = 0;
 		while(i < rowIndex) {
 			for(int j = rowIndex; j > 0; j--) {
 				res[j] = res[j] + res[j-1];
 			}
 			i++;
 		} 

 		List<Integer> ans = new ArrayList<Integer>();
 		for(i = 0; i < res.length; i++) {
 			ans.add(res[i]);
 		}
 		return ans;
 	}
 }

