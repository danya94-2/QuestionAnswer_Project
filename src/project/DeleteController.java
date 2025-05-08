package project;

import java.util.Scanner;

public class DeleteController implements CommControllerInterface{

	static Scanner sc = new Scanner(System.in);
	static QA_Board_Service qa_Board_Service = new QA_Board_Service();
	
	@Override
	public void execute() {
		f_deleteById();
	}

	private void f_deleteById() {
		System.out.print("삭제할 게시글 번호>>");
		int id = sc.nextInt();
		int result = qa_Board_Service.deleteById(id);
		QA_Board_View.display(result + "건 삭제");
	}
}
