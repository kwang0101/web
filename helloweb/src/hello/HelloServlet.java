package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *	Servlet 클래스 구현 
 * 	1. public class로 선언
 * 	2. javax.servlet.http.HttpServlet을 상속(extends) - Java EE (core API가 아니기 때문에 jdk를 깐다고 해서 있는 건 아님)
 * 	3. 매개변수 없는 생성자 (no-argument 생성자) => 생성자는 default 생성자
 * 	4. doGet() 또는 doPost() 메소드를 오버라이딩 => 서블릿이 서비스할 내용을 구현
 * 		doGet() => GET 방식 요청을 처리
 * 		doPost() => POST 방식 요청을 처리
 * 	5. 구현한 Servlet class를 톰켓에 등록
 * 		=> 	1. web.xml
 * 			2. Annotation을 이용해 등록 (서블릿 3.0부터(톰켓7))
 */	

public class HelloServlet extends HttpServlet {
	//클라이언트의 요청을 처리해주는 서비스 (사용자의 요청이 있을 때 실행됨)
	//container는 사용자의 요청이 들어오면 Servlet을 실행시키면서 doGet()를 호출한다 (약속된 메소드이기 때문에 마음대로 변경 불가능)
	//실행환경(container)이 호출하는 메소드 = callback 메소드
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Date date = new Date();	//실행 시점의 일시
		String current = String.format("%tY-%<tm-%<td %<tH:%<tM:%<tS", date); //jdk1.5이상부터 가능
		
		//SimpleDateFormat : java.util.Date <==> String (-> : format(), <- : parse())
		//yyyy : 년도 (4자리), MM : 월 (2자리), dd : 일 (2자리), HH : 시간 (24시간제-2자리), mm : 분 (2자리), ss : 초 (2자리)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current2 = sdf.format(date);
		//Date dd = sdf.parse("2011-11-20 23:22:05");
		
		response.setContentType("text/html;charset=UTF-8"); //=앞뒤에 공백 넣으면 안됨
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head><title>현재 시간</title></head>");
		out.println("<body>");
		out.printf("현재 시간1 : %s<br>", current);
		out.printf("현재 시간2 : %s<br>", current2);
		out.println("</body></html>");
		
		
		
	}
}
