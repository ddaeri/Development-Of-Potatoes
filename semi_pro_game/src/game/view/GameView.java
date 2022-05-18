package game.view;

import java.util.Scanner;

import game.controller.GameController;
import game.dao.GameDAO;
import game.menu.GameMenu;
import game.vo.GameVo;


public class GameView {
	private Scanner sc = new Scanner(System.in);
	private GameController gc = new GameController();
	private GameMenu menu = new GameMenu();
	private GameDAO dao = new GameDAO();
	
	public void show() {
		while(true) {
			System.out.print(menu.getMain());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1":
					this.addMenu();		break;
				case "2":
					this.inputTitle();	break;
				case "3":
					dao.GameList();		break;
				case "4":
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default:
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
				}
			}
		}
	
	public void addMenu() {
		GameVo data = new GameVo();
		
		System.out.print("게임번호 : ");
		data.setGameid(sc.nextLine());
		System.out.print("게임제목 : ");
		data.setTitle(sc.nextLine());
		System.out.print("장  르 : ");
		data.setGenre(sc.nextLine());
		System.out.print(" 개발사 : ");
		data.setDeveloper(sc.nextLine());
		System.out.print("출시일자 : ");
		data.setReleasdate(sc.nextLine());
		System.out.print("가  격 : ");
		data.setPrice(sc.nextLine());
		
		boolean result = gc.addGame(data);
		
		if(result) {
			System.out.println("게임을 등록 하였습니다.");
		} else {
			System.out.println("게임을 등록하지 못하였습니다. 다시 확인해 주십시오.");
		}
	}
	
	// 게임 제목으로 검색하기 위한 화면과 기능 연결
	public void inputTitle() {
		System.out.println("게임 제목을 입력해주세요.");
		System.out.print(">>> ");
		String inputtitle = sc.nextLine();
		
		GameVo search = gc.selectTitle(inputtitle);
		
		if(search != null) {
			System.out.printf("%s 게임을 검색 하셨습니다.\n", search.getTitle());
			gameManagement(search);
		} else {
			System.out.println("검색에 실패하였습니다.");
		}
	}

	
	
	public void gameManagement(GameVo search) {
		while(true) {
			System.out.print(menu.getManagement(search.getTitle()));
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				System.out.println(search.getGameid());
				System.out.println(search.getTitle());
				System.out.println(search.getGenre());
				System.out.println(search.getDeveloper());
				System.out.println(search.getReleasdate());
				System.out.println(search.getPrice());
				break;
			
			case "2":
				System.out.println("아무것도 입력을 하지 않으면 이전 값을 유지 합니다.");
				System.out.println("변경 할 게임제목을 입력하세요.");
				System.out.print(">>> ");
				input = sc.nextLine();
				input = input.isEmpty() ? search.getTitle() : input;
				search.setTitle(input);
				
				System.out.println("변경 할 게임장르를 입력하세요.");
				System.out.print(">>> ");
				input = sc.nextLine();
				input = input.isEmpty() ? search.getGenre() : input;
				search.setGenre(input);
				
				System.out.println("변경 할 개발사를 입력하세요.");
				System.out.print(">>> ");
				input = sc.nextLine();
				input = input.isEmpty() ? search.getDeveloper() : input;
				search.setDeveloper(input);
				
				System.out.println("변경 할 출시날짜를 입력하세요.");
				System.out.print(">>> ");
				input = sc.nextLine();
				input = input.isEmpty() ? search.getReleasdate() : input;
				search.setReleasdate(input);
				
				System.out.println("변경 할 가격을 입력하세요.");
				System.out.print(">>> ");
				input = sc.nextLine();
				input = input.isEmpty() ? Integer.toString(search.getPrice()) : input;
				search.setPrice(input);
				
				
				boolean result = gc.update(search);
				
				if(result) {
					System.out.println("변경이 완료되었습니다.");
				} else {
					System.out.println("변경이 실패하였습니다.");
				}
				
				break;
			case "3":
				if(gc.remove(search)) {
					System.out.println("게임이 삭제되었습니다.");
					return;
				} else {
					System.out.println("ERROR : 게임을 삭제할 수 없습니다.");
				}
				break;
			case "4":
				show();
				break;
			default:
				System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}

}
