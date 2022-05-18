package game.menu;

public class GameMenu {
	public String getMain() {
		String s = "";
		s += " ▒▒ 게임 관리자님 환영 합니다. ▒▒\n";
		s += "+- - - - - - - - - - - -+\n";
		s += "|      게임 관리 프로그램     |\n";
		s += "+- - - - - - - - - - - -+\n";
		s += "| 1. 게임 등록		|\n";
		s += "| 2. 관리할 게임 검색		|\n";
		s += "| 3. 게임 전체 목록		|\n";
		s += "| 4. 프로그램 종료		|\n";
		s += "+- - - - - - - - - - - -+\n";
		
		return s;
	}
	
	public String getManagement(String search) {
		String s = "";
		s += "▒▒ " + search + " 게임을 관리합니다. ▒▒\n";
		s += "+- - - - - - - - - - - -+\n";
		s += "| 1. 정보 조회		|\n";
		s += "| 2. 게임 수정		|\n";
		s += "| 3. 게임 삭제		|\n";
		s += "| 4. 뒤로가기		|\n";
		s += "+- - - - - - - - - - - -+\n";
		
		return s;
	}
}
