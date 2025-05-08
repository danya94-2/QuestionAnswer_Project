package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertController implements CommControllerInterface {

	static Scanner sc = new Scanner(System.in);
	static QA_Board_Service qa_Board_Service = new QA_Board_Service();

	@Override
	public void execute() {
		f_insert();
	}

	private static void f_insert() {
		System.out.print("게시글 ID>>");
		int id = sc.nextInt();
		System.out.print("작성자>>");
		String writer = sc.next();
		System.out.print("제목>>");
		String title = sc.next();
		System.out.print("내용>>");
		String content = sc.next();

		QA_Board_DTO qa_board_dto = QA_Board_DTO.builder()
				.content(content)
				.id(id)
				.title(title)
				.writer(writer)
				.build();
	}
}
