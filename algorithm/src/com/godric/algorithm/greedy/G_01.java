package com.godric.algorithm.greedy;

/**
 * Question Description:
 * 	给定一个由字符串组成的数组strs, 必须把所有的字符串拼接起来，返回所有可能的拼接结果中，字典序最小的结果
 * 
 * 	字典序：如果两个字符串一样长，则把字符串当作26进制的数字
 * 			如果不一样长，则短的字符串后面补0
 * 
 * 1.0 			x, y
 * 		if (x字典序 < y字典序)	x在前	else y在前
 * 		错误：ba, b				b < ba		-> bba  >  bab
 * 
 * 2.0			x, y
 * 		if (x,y <= y,x)			x在前	else y在前
 * 
 * 	证明排序具有传递性，即 		a,b <= b,a
 * 							b,c <= c,b
 * 						=>	(1). a,c <= c,a
 *						=>  (2). [前, ... , 后]		=> 前 后  <=  后  前
 *	
 *
 *  (1)证明：
 * 
 *
 *
 */
public class G_01 {

}
