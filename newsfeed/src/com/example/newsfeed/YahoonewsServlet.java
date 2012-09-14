package com.example.newsfeed;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

@SuppressWarnings("serial")
public class YahoonewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("xml;charset=UTF-8");
		//resp.getWriter().println("Yahoo News");
		String url = req.getParameter("feed");
		
Connection.Response res1Jsoup =
		           
	Jsoup.connect(url).timeout(60*10000).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
			     
	method(Method.GET).execute();

    System.out.println("my response object is "+ url);


    String returnrss = res1Jsoup.body();
   
   
    System.out.println("my response object is " + returnrss);

    resp.getWriter().println(returnrss);
	}
}
