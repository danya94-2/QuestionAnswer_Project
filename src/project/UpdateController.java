package project;

import java.util.Scanner;

public class UpdateController implements CommControllerInterface{

	static Scanner sc = new Scanner(System.in);
	static QA_Board_Service qa_Board_Service = new QA_Board_Service(); 
	
	@Override
	public void execute() {
		f_update();
		
	}
	
	private static void f_update() {
		System.out.print("수정할 게시글 번호 >> ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 제목 입력 >> ");
		String title = sc.nextLine();
		System.out.print("수정할 본문 >> ");
		String content = sc.nextLine();
		QA_Board_DTO qa_board_DTO = QA_Board_DTO.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
		int result = qa_Board_Service.update(qa_board_DTO);
		QA_Board_View.display(result + "건 수정");

	}

	
}
