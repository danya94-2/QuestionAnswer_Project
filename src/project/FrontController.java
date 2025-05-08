package project;

import java.util.Scanner;

public class FrontController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isstop = false;
		while (!isstop) {
			menuDisplay();
			int choice = sc.nextInt();
			switch (choice) {
			case 1 -> {
				SelectController select = new SelectController();
				select.execute();
				userDisplay();
				int userChoice = sc.nextInt();
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
				}
				break;
			}
			case 2 -> {
				isstop = true;
			}
			}
		}
		System.out.println("========프로그램 종료========");
	}

	private static void menuDisplay() {
		System.out.println("=======시작 화면=======");
		System.out.println("1.고객센터 2.실행 종료");
		System.out.println("=====================");
		System.out.print("작업선택>");
	}

	private static void userDisplay() {
		System.out.println("===========메뉴===========");
		System.out.println("1.조회 2.작성 3.수정 4.삭제");
		System.out.println("=========================");
		System.out.print("작업선택>");
	}
}
