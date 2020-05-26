package com.gf.algorithm.class02;

/**
 * 用 O(1) 的时间复杂度，获取栈中的最小值：
 * 
 * 	（一）
 * 		准备两个栈，一个data栈，一个min栈
 * 		两个栈同步上升，data栈入栈，min栈将data栈中入栈的元素和栈顶元素对比，将较小值入栈
 * 		弹栈的时候同步弹出
 * 		要获取最小值，只需要获取min栈的最小值即可
 * 	
 * 	（二）
 * 		<=的时候压入，>不压入
 * 		弹出的时候当data栈弹出的元素和min栈的元素相等的时候，min栈弹出，否则不弹出
 *
 */
public class G05_GetMinValueInStackWithO1 {

}
