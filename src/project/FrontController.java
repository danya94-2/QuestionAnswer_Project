package project;

import java.util.Scanner;

public class FrontController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isTrue = false;
		menuDisplay();
		while (!isTrue) {
			userDisplay();
			int userChoice = sc.nextInt();
			SelectController select = new SelectController();
			switch (userChoice) {
			
			case 1 -> {
				
				select.execute();
			}
			case 2 -> {
				InsertController insert = new InsertController();
				insert.execute();
			}
			case 3 -> {
				UpdateController update = new UpdateController();
				update.execute();
			}
			case 4 -> {
				DeleteController delete = new DeleteController();
				delete.execute();
			}
			case 5 -> {
				select.execute2();
			}
			case 6 -> {isTrue = true;}
			
			}

		}
		System.out.println("========프로그램 종료========");
	}

	private static void menuDisplay() {
		System.out.println("=======시작 화면=======");
		System.out.println("	   QA 게시판      ");
		System.out.println("=====================");
	}

	private static void userDisplay() {
		System.out.println("=======================메뉴=======================");
		System.out.println("1.전체 조회 2.작성 3.수정 4.삭제 5.상세 조회 6.실행 종료");
		System.out.println("=================================================");
		System.out.print("작업선택>");
	}
}
