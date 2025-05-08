package project;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class QA_Board_DTO {
    private int id;
    private String writer;
    private Date  createdDate;
    private String title;
    private String content;
    private String password;
    private String QAtype; // Q, A
	
    @Override
	public String toString() {
		return "| No." + id + " | 작성자 : " + writer + " | 게시 날짜 : " + createdDate + " | " + title
				+ " | 본문 : " + content + " |";
	}
    
    

}