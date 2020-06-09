package com.uzgf.leetcode;

import java.util.*;

/**
 * @since 2020/06/09
 *
 * 137. 只出现一次的数字 II
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 算法思想： 	 1. HashSet
 *           2. HashMap
 *           3. XOR
 *              once  = ~twice & (once ^ x)
 *              twice = ~once  & (twice ^ x)
 *              
 */
public class Q0137_SingleNumberII {
	
	/**
	 * HashSet
	 * 
	 * 执行用时 :3 ms, 在所有 Java 提交中击败了52.99%的用户
	 * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了14.29%的用户
	 * 
	 * (a + b + c) * 3 - (3 * a + 3 * b + 1 * c) = 2 * c
	 */
    public int singleNumber1(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	long n1 = 0L, n2 = 0L;
    	for (int n : nums) {
    		n2 += n;
    		set.add(n);
    	}
    	
    	for (Integer n : set) {
    		n1 += n;
    	}
    	
    	return (int) ((n1 * 3 - n2) / 2);
    }
    
    /**
     * HashMap
     * 纯暴力
     * 
     * 执行用时 :6 ms, 在所有 Java 提交中击败了25.27%的用户
	 * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了14.29%的用户
     */
    public int singleNumber2(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int n : nums) {
    		Integer times = map.get(n);
    		if (times == null) {
    			map.put(n, 1);
    		} else {
    			map.put(n, times + 1);
    		}
    	}
    	
    	for (Integer key : map.keySet()) {
    		if (map.get(key) == 1) {
    			return key;
    		}
    	}
    	
    	return -1;
    }
    
    /**
     * 通过位运算
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
	 * 内存消耗 :39.5 MB, 在所有 Java 提交中击败了14.29%的用户
	 * 
	 * x第一次出现：seenOnce = ~0 & (0 ^ x) = 1 & x = x
	 * 			  seenTwice = ~x & (0 ^ x) = ~x & x = 0
	 * 
	 * x第二次出现：seenOnce = ~0 & (~x ^ x) = 1 & 0 = 0
	 * 			  seenTwice = ~0 & (0 ^ x) = 1 & x = x
	 * 
	 * x第三次出现：seenOnce = ~x & (0 ^ x) = ~x & x = 0
	 * 			  seenTwice = ~0 & (x ^ x) = 1 & 0 = 0
     */
    public int singleNumber3(int[] nums) {
    	int seenOnce = 0, seenTwice = 0;
    	for (int n : nums) {
    		seenOnce = ~seenTwice & (seenOnce ^ n);
    		seenTwice = ~seenOnce & (seenTwice ^ n);
    	}
    	
    	return seenOnce;
    }
    
    public static void main(String[] args) {
    	int[] arr = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
    	
    	Q0137_SingleNumberII s = new Q0137_SingleNumberII();
    	System.out.println(s.singleNumber3(arr));
    	Arrays.sort(arr);
    	for (int i : arr) {
    		System.out.print(i + ", ");
    	}
    	
    }
}