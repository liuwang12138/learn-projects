package com.gf.dp.cor2;

import java.util.ArrayList;
import java.util.List;

/**
 * a, b, c, d四个filter处理请求，
 * 	要求：
 * 		处理request的顺序是a, b, c, d, 
 * 		处理response是顺序是d, c, b, a
 */
public class Main {
	public static void main(String[] args) {
		
		AFilter a = new AFilter("a");
		AFilter b = new AFilter("b");
		AFilter c = new AFilter("c");
		AFilter d = new AFilter("d");
		
		FilterChain fc = new FilterChain();
		fc.add(a).add(b).add(c).add(d);
		
		Request req = new Request();
		Response resp = new Response();
		
		fc.doFilter(req, resp);
		
	}
}


class Request {
}

class Response {
}

interface Filter {
	
	void doFilter(Request request, Response response, FilterChain filterChain);
}

class FilterChain {
	List<Filter> list = new ArrayList<>();
	int index = 0;
	
	FilterChain add(Filter f) {
		list.add(f);
		return this;
	}
	
	public void doFilter(Request request, Response response) {
		if (index >= list.size()) {
			return;
		}
		list.get(index++).doFilter(request, response, this);
	}
}

class AFilter implements Filter {
	
	String name;

	@Override
	public void doFilter(Request request, Response response, FilterChain filterChain) {
		System.out.println(name + " do request");
		filterChain.doFilter(request, response);
		System.out.println(name + " do response");
	}
	
	public AFilter(String name) {
		this.name = name;
	}
	
}

