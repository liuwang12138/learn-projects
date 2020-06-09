package com.uzgf.leetcode;

import java.util.HashMap;

/**
 * @since 2020/06/09
 * 面试题46. 把数字翻译成字符串
 * 
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class F46_TranslateNumberToString {
	
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int translateNum(int num) {
    	
    	if (map.get(num) != null) {
    		return map.get(num);
    	}
    	
    	if (num / 10 == 0) {
    		// 只有1位
    		return 1;
    	}
    	if (num / 100 == 0 && num <= 25) {
    		// 有2位并且 <= 25, 这些都有两种
    		return 2;
    	}
    	
    	int bits = getBits(num);
    	int m = (int) Math.pow(10, bits - 1);

    	int result = 0;
    	int k2 = num % m;
    	
    	result += translateNum(k2);
    	
    	if (m > 10) {
    		m /= 10;
    		int k3 = num / m;
    		int k4 = num % m;
    		if (k3 <= 25) {
    			result += translateNum(k4);
    		}
    	}
    	
    	map.put(num, result);
    	
    	return result;
    }
    
    /**
     * 获取一个>=0的数字的位数
     */
    private int getBits(int num) {
    	int result = 0;
    	if (num == 0) {
    		return 1;
    	}
    	while (num != 0) {
    		num = num / 10;
    		result++;
    	}
    	return result;
    }
    
    private static HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    
    public int translateNum2(int num) {
    	
    	if (map2.get(num) != null) {
    		return map2.get(num);
    	}
    	
    	if (num / 10 == 0) {
    		// 递归中止条件
    		map2.put(num, 1);
    		return 1;
    	}
    	int result;
    	if (num % 100 < 26 && num % 100 > 9) {
    		result = translateNum2(num / 10) + translateNum2(num / 100);
    	} else {
    		result = translateNum2(num / 10);
    	}
    	
    	map2.put(num, result);
    	return result;
    }
    
    public static void main(String[] args) {
    	F46_TranslateNumberToString s = new F46_TranslateNumberToString();
    	
    	System.out.println(s.translateNum(12258));
//    	System.out.println(s.translateNum(258));
    }
}