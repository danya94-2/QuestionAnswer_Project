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
    private Date  createdate;
    private String title;
    private String content;
    private String password;
    private String QAtype; // Q, A
    @Override
    public String toString() {
        return "QA_Board_DTO [id=" + id + ", writer=" + writer + ", createdate=" + createdate + ", title=" + title
                + ", content=" + content + ", password=" + password + ", QAtype=" + QAtype + "]";
    }
    
    
}