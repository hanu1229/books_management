package management.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class BookDto {
	// 출판사
	private String publisher;
	// 도서명
	private String name;
	// 저자
	private String author;
	// 책번호(자동)
	private int id;
	// 생성일
	private String cdate;
	// 수정일
	private String udate;
	
}
