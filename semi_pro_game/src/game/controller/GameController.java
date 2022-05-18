package game.controller;

import game.dao.GameDAO;
import game.vo.GameVo;

public class GameController {
	private GameDAO dao = new GameDAO();
	
	// 게임 등록
	public boolean addGame(GameVo data) {
		return dao.addGame(data);
	}
	
	// 게임 수정
	public boolean update(GameVo data) {
		return dao.updateGame(data);
	}
	
	// 게임 삭제
	public boolean remove(GameVo data) {
		return dao.removeGame(data);
	}
	
	// 제목으로 정보검색
	public GameVo selectTitle(String title) {
		GameVo data = dao.getTitle(title);
		
		if(data.getTitle().equals(title)) {
			return data;
		}
		
		return null;
	}
	
	
	

}
