package com.example.newsfeed;

import java.io.IOException;
import javax.servlet.http.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;

@SuppressWarnings("serial")
public class CNNnewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("CNN News");
		
		Connection.Response res2Jsoup =
		           
				Jsoup.connect("http://edition.cnn.com/services/rss").timeout(60*10000).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").
						     
				method(Method.GET).execute();

			// System.out.println("my response object is "+ req.getParameter("callback"));


			   String returnrss = res2Jsoup.body();
			   
			   
			System.out.println("my response object is " + returnrss);

			   resp.getWriter().println(returnrss);
				}

	}
