package com.uzgf.leetcode;

import java.util.*;

/**
 * @since 2020/06/09
 *
 * 137. ֻ����һ�ε����� II
 *
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ����������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 *
 * ˵����
 *
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 *
 * ʾ�� 1:
 *
 * ����: [2,2,3,2]
 * ���: 3
 * ʾ�� 2:
 *
 * ����: [0,1,0,1,0,1,99]
 * ���: 99
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/single-number-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * �㷨˼�룺 	 1. HashSet
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
	 * ִ����ʱ :3 ms, ������ Java �ύ�л�����52.99%���û�
	 * �ڴ����� :39.2 MB, ������ Java �ύ�л�����14.29%���û�
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
     * ������
     * 
     * ִ����ʱ :6 ms, ������ Java �ύ�л�����25.27%���û�
	 * �ڴ����� :39.1 MB, ������ Java �ύ�л�����14.29%���û�
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
     * ͨ��λ����
     * ִ����ʱ :0 ms, ������ Java �ύ�л�����100.00%���û�
	 * �ڴ����� :39.5 MB, ������ Java �ύ�л�����14.29%���û�
	 * 
	 * x��һ�γ��֣�seenOnce = ~0 & (0 ^ x) = 1 & x = x
	 * 			  seenTwice = ~x & (0 ^ x) = ~x & x = 0
	 * 
	 * x�ڶ��γ��֣�seenOnce = ~0 & (~x ^ x) = 1 & 0 = 0
	 * 			  seenTwice = ~0 & (0 ^ x) = 1 & x = x
	 * 
	 * x�����γ��֣�seenOnce = ~x & (0 ^ x) = ~x & x = 0
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