package com.uzgf.leetcode;

/**
 * @since 2020/06/09
 * 
 * 136. ֻ����һ�ε�����
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 *
 * ˵����
 *
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 *
 * ʾ�� 1:
 *
 * ����: [2,2,1]
 * ���: 1
 * ʾ�� 2:
 *
 * ����: [4,1,2,1,2]
 * ���: 4
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/single-number
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * 
 * �㷨˼�룺a ^ a == 0
 * 		   ȫ�����
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