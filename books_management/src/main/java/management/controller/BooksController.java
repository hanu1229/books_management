package management.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import management.model.dao.ManagementDao;
import management.model.dto.BookDto;


@WebServlet("/books")
public class BooksController extends HttpServlet {
	
	/** 전체 도서 현황 출력 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BooksController 전체 도서 현황 출력(doGet) 실행");
		
		ArrayList<BookDto> result = ManagementDao.getInstance().findAll();
		System.out.println(">> result : " + result);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		System.out.println(">> jsonResult : " + jsonResult);
		
		System.out.println(">> BooksController 전체 도서 현황 출력(doGet) 종료\n");
	}
	
	/** 도서 등록 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BooksController 도서 등록(doPost) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		BookDto bookDto = mapper.readValue(req.getReader(), BookDto.class);
		System.out.println(">> bookDto : " + bookDto.toString());
		boolean result = ManagementDao.getInstance().write(bookDto);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BooksController 도서 등록(doPost) 종료\n");
	}
	
	/** 도서 삭제 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BooksController 도서 삭제(doDelete) 실행");
		
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(">> id : " + id);
		boolean result = ManagementDao.getInstance().delete(id);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BooksController 도서 삭제(doDelete) 종료\n");
	}
	
	/** 도서 수정 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">> BooksController 도서 수정(doPut) 실행");
		
		ObjectMapper mapper = new ObjectMapper();
		BookDto bookDto = mapper.readValue(req.getReader(), BookDto.class);
		System.out.println(">> bookDto : " + bookDto);
		boolean result = ManagementDao.getInstance().update(bookDto);
		System.out.println(">> result : " + result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println(">> BooksController 도서 수정(doPut) 종료\n");
	}

	
}
