package com.uzgf.leetcode;

import java.util.HashMap;

/**
 * @since 2020/6/8
 * 
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 算法思想：并查集
 */
public class Q0990_SatisifiabilityOfEqualityEquations_NotSolved {
	
	public boolean equationsPossible(String[] equations) {
		return false;
	}

	/**
	 * 把a所在的集合和b所在的集合合并起来
	 */
	private void union(Character a, Character b) {
	}
	
	/**
	 * 判断a和b是否在同一个集合内
	 */
	private boolean isSameSet(Character a, Character b) {
		return false;
	}
	

    public boolean equationsPossibleWrong(String[] equations) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	int k = 0;
    	
    	for (String str : equations) {
    		// v1 -> 第一个变量
    		Character v1 = str.charAt(0);
    		Integer value1 = map.get(v1);
    		if (value1 == null) {
    			map.put(v1, ++k);
    			value1 = map.get(v1);
    		}
    		
    		// v2 -> 第二个变量
    		Character v2 = str.charAt(3);
    		Integer value2 = map.get(v2);
    		
    		// type = 0	->	!=
    		// type = 1 ->	==
    		int type = str.charAt(1) == '!' ? 0 : 1;
    		
    		if (type == 0) {
    			// 看是否不等于
    			if (value2 == null) {
    				map.put(v2, ++k);
    			} else if (value2 == value1) {
    				// value2 != null && value2 == value1
    				return false;
    			} else {
    				// value2 != null && value2 != value1
    				continue;
    			}
    		} else {
    			// 看是否等于
    			if (value2 == null) {
    				map.put(v2, value1);
    			} else if (value2 == value1) {
    				// value2 != null && value2 == value1
    				continue;
    			} else {
    				// value2 != null && value2 != value1
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	Q0990_SatisifiabilityOfEqualityEquations_NotSolved s = new Q0990_SatisifiabilityOfEqualityEquations_NotSolved();
    	
    	String[] param1 = {"a==b","b!=a"};
    	// false
    	System.out.println(s.equationsPossibleWrong(param1));
    	
    	String[] param2 = {"b==a","a==b"};
    	// true
    	System.out.println(s.equationsPossibleWrong(param2));
    	
    	String[] param3 = {"a==b","b==c","a==c"};
    	// true
    	System.out.println(s.equationsPossibleWrong(param3));
    	
    	String[] param4 = {"a==b","b!=c","c==a"};
    	// false
    	System.out.println(s.equationsPossibleWrong(param4));
    	
    	String[] param5 = {"c==c","b==d","x!=z"};
    	// true
    	System.out.println(s.equationsPossibleWrong(param5));
    	
    	// wrong ! expected true, but output false
    	String[] param6 = {"c==c","f!=a","f==b","b==c"};
    	System.out.println(s.equationsPossibleWrong(param6));
    	
    }
	
}

