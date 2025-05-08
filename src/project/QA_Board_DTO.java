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

}