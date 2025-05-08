package project;

import java.util.List;
import java.util.Scanner;


public class SelectController implements CommControllerInterface{
	static Scanner sc = new Scanner(System.in);
	static QA_Board_Service qa_Board_Service = new QA_Board_Service();
	
	public static void main(String[] args) {
		f_selectAll();
	}
	
	private static List<QA_Board_DTO> f_selectAll() {
		System.out.println("==selectAll==");
		List<QA_Board_DTO> list = qa_Board_Service.selectAll();
		QA_Board_View.display(list);
		return list;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
