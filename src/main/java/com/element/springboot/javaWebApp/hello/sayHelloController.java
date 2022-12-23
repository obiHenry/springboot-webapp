package com.element.springboot.javaWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHelloController {

	// "say-hello" => "Hello! what are you learning today?"
	//http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "hello! what are you learning today?";
	}
	
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML page  -Changed</title>");
		sb.append("<body>");
		sb.append("My first html page with body - Changed ");
		sb.append("</body>");
		sb.append("</html>");
		
	
		return sb.toString();
	}
	
	
	// "say-hello-jsp" => sayHello.jsp
	// src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
