package management.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import management.model.dto.BookDto;

@NoArgsConstructor
public class ManagementDao extends Dao {
	
	// singleton start
	@Getter
	private static ManagementDao instance = new ManagementDao();
	// singleton end
	
	/** 전체 도서 현황 출력 */
	public ArrayList<BookDto> findAll() {
		ArrayList<BookDto> result = new ArrayList<BookDto>();
		try {
			String sql = "select * from books;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setPublisher(rs.getString("publisher"));
				bookDto.setName(rs.getString("name"));
				bookDto.setAuthor(rs.getString("author"));
				bookDto.setId(rs.getInt("id"));
				bookDto.setCdate(rs.getString("cdate"));
				bookDto.setUdate(rs.getString("udate"));
				result.add(bookDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/** 도서 등록 */
	public boolean write(BookDto bookDto) {
		try {
			String sql = "insert into books(publisher, name, author) values (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookDto.getPublisher());
			ps.setString(2, bookDto.getName());
			ps.setString(3, bookDto.getAuthor());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 도서 삭제 */
	public boolean delete(int id) {
		try {
			String sql = "delete from books where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 도서 수정 */
	public boolean update(BookDto bookDto) {
		LocalDateTime time = LocalDateTime.now();
		String udate = time.toString();
		try {
			String sql = "update books set publisher = ?, name = ?, author = ?, udate = ? where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bookDto.getPublisher());
			ps.setString(2, bookDto.getName());
			ps.setString(3, bookDto.getAuthor());
			ps.setString(4, udate);
			ps.setInt(5, bookDto.getId());
			int count = ps.executeUpdate();
			if(count == 1) { return true; }
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	/** 개별 도서 현황 출력 */
	public BookDto find(int id) {
		BookDto result = new BookDto();
		try {
			String sql = "select * from books where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result.setPublisher(rs.getString("publisher"));
				result.setName(rs.getString("name"));
				result.setAuthor(rs.getString("author"));
				result.setId(rs.getInt("id"));
				result.setCdate(rs.getString("cdate"));
				result.setUdate(rs.getString("udate"));
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
}
