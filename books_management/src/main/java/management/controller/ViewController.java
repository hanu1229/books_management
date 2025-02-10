package management.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import management.model.dao.ManagementDao;
import management.model.dto.BookDto;

@WebServlet("/books/view")
public class ViewController extends HttpServlet {

	/** 개별 도서 현황 출력 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> ViewController 개별 도서 현황 출력(doGet) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(">> id : " + id);
		BookDto result = ManagementDao.getInstance().find(id);
		System.out.println(">> result : " + toString());
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		System.out.println(">> jsonResult : " + jsonResult);
		
		System.out.println(">> ViewController 개별 도서 현황 출력(doGet) 종료\n");
	}
	
}
