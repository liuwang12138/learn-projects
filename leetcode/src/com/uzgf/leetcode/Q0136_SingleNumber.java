package com.uzgf.leetcode;

/**
 * @since 2020/06/09
 * 
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 算法思想：a ^ a == 0
 * 		   全部异或
 */
public class Q0136_SingleNumber {
	
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int n : nums) {
			result ^= n;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Q0136_SingleNumber s = new Q0136_SingleNumber();
//		int[] arr = {2, 2, 1};
		int[] arr = {4, 1, 2, 1, 2};
		System.out.println(s.singleNumber(arr));	
	}	
}