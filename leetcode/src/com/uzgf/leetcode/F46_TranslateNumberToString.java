package com.uzgf.leetcode;

import java.util.HashMap;

/**
 * @since 2020/06/09
 * ������46. �����ַ�����ַ���
 * 
 * ����һ�����֣����ǰ������¹����������Ϊ�ַ�����0 ����� ��a�� ��1 ����� ��b����������11 ����� ��l����������25 ����� ��z����һ�����ֿ����ж�����롣����ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 *
 * ʾ�� 1:
 *
 * ����: 12258
 * ���: 5
 * ����: 12258��5�ֲ�ͬ�ķ��룬�ֱ���"bccfi", "bwfi", "bczi", "mcfi"��"mzi"
 *  
 *
 * ��ʾ��
 *
 * 0 <= num < 231
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class F46_TranslateNumberToString {
	
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int translateNum(int num) {
    	
    	if (map.get(num) != null) {
    		return map.get(num);
    	}
    	
    	if (num / 10 == 0) {
    		// ֻ��1λ
    		return 1;
    	}
    	if (num / 100 == 0 && num <= 25) {
    		// ��2λ���� <= 25, ��Щ��������
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
     * ��ȡһ��>=0�����ֵ�λ��
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
    		// �ݹ���ֹ����
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