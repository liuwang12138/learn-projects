package com.gf.algorithm.class02;

/**
 * 递归获取数组上的最大值
 * 
 * 
 * Master公式
 * 对于这一类的递归：
 * 		子问题的规模是一致的，即
 * 	T(N) = a * T(N / b) + O(N ^ d)
 *		if log(b,a) > d		->		O(N ^ log(b,a))
 *		if log(b,a) < d		->		O(N ^ d)
 *		if log(b,a) = d		->		O(N ^ d * log N)
 */
public class G08_RecursionGetMax {

}
