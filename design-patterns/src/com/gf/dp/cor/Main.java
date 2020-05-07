package com.gf.dp.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * Chain Of Responsibility
 */
public class Main {
	public static void main(String[] args) {
		Msg m = new Msg("Hello everyone :), I am <script>Chain Of Responsibility</script>, We Are All 996, Welcome to github.com/liuwang12138");
		
		FilterChain fc = new FilterChain();
		fc.add(new ScriptFilter())
		  .add(new SensitiveFilter());
		
		FilterChain fc2 = new FilterChain();
		
		fc2.add(new FaceFilter())
		   .add(new UrlFilter());
		fc.add(fc2);
		fc.doFilter(m);
		
		System.out.println("m = " + m);
	}
}

class Msg {
	private String message;
	
	public Msg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Msg [message=" + message + "]";
	}
	
}

class FilterChain implements Filter {
	List<Filter> list = new ArrayList<>();
	
	FilterChain add(Filter f) {
		list.add(f);
		return this;
	}
	
	@Override
	public boolean doFilter(Msg msg) {
		for (Filter f : list) {
			if (!f.doFilter(msg)) return false;
		}
		return true;
	}
}

interface Filter {
	boolean doFilter(Msg msg);
}

class ScriptFilter implements Filter {

	@Override
	public boolean doFilter(Msg msg) {
		String m = msg.getMessage();
		m = m.replace("<", "[");
		m = m.replace(">", "]");
		
		msg.setMessage(m);
		return true;
	}
	
}

class SensitiveFilter implements Filter {

	@Override
	public boolean doFilter(Msg msg) {
		String m = msg.getMessage();
		m = m.replace("996", "955");
		msg.setMessage(m);
		return false;
	}
}

class FaceFilter implements Filter {

	@Override
	public boolean doFilter(Msg msg) {
		String m = msg.getMessage();
		m = m.replace(":)", "^_^");
		msg.setMessage(m);
		return true;
	}
	
}

class UrlFilter implements Filter {

	@Override
	public boolean doFilter(Msg msg) {
		String m = msg.getMessage();
		m = m.replace("github.com/liuwang12138", "http://www.github.com/liuwang12138");
		msg.setMessage(m);
		return true;
	}
	
}
