/*
118. Pascal's Triangle
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

/**
 Approach: 
 length = rowNum;
 for(int i = 0; i < length; i++) {
 	if(i-1 > 0) res[i] = array[i] + array[i-1];
 	if(i = 0) res[i] = array[i]
 	if(i = length-1) res[i] = array[0]
 }
 */

class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if(numRows == 0) return res;

		for(int i = 0; i < numRows; i++) {
			List<Integer> ans = new ArrayList<Integer>();
			ans.add(1);
			for(int j= 1; j < i; j++) {
				ans.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
			}
			if(i!=0) {
				ans.add(1);
			}
			res.add(ans);
		}
		return res;
	}
}