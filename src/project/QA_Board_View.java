package project;

import java.util.List;

public class QA_Board_View {
	public static void display(List<QA_Board_DTO> list) {
		if(list.size() == 0) {
			System.out.println("해당하는 게시글 없음");
			return;
		}
		list.stream().forEach(gitList -> System.out.println(gitList));
	}
	
	public static void display (String message) {

		System.out.println("알림 : " + message);
	}
}
