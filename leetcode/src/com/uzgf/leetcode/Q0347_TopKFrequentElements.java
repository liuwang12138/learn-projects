package com.uzgf.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * @since 2020/6/8
 * 
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 解题思路：利用PriorityQueue，重写对Integer的比较器
 * 			PriorityQueue的底层是堆排序
 */
public class Q0347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for (int n : nums) {
    		Integer count = map.get(n);
    		if (count == null) {
    			map.put(n, 1);
    		} else {
    			map.put(n, count + 1);
    		}
    	}
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer k1, Integer k2) {
				return map.get(k2) - map.get(k1);
			}
    	});
    	
    	for (Integer i : map.keySet()) {
    		queue.add(i);
    	}
    	
    	int[] result = new int[k];
    	for (int i=0; i<k; i++) {
    		result[i] = queue.poll();
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
    	int[] nums = {1, 1, 1, 2, 2, 3};
    	Q0347_TopKFrequentElements s = new Q0347_TopKFrequentElements();
    	int[] result1 = s.topKFrequent(nums, 2);
    	
    	int[] nums2 = {1};
    	int[] result2 = s.topKFrequent(nums2, 1);
    	for (int k : result1) {
    		System.out.println(k);
    	}
    	
    	System.out.println("======================");
    	
    	for (int k : result2) {
    		System.out.println(k);
    	}
    }
}

