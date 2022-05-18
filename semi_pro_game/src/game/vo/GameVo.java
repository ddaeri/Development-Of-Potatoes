package game.vo;


public class GameVo {

	/*
	   CREATE TABLE GAME_ADMIN(
	   gameid			NUMBER			PRIMARY KEY
	 , title			VARCHAR2(50)	NOT NULL
	 , genre			VARCHAR2(80)	NOT NULL
	 , developer		VARCHAR2(40)	NOT NULL
	 , releasdate		DATE			NOT NULL
	 , price			NUMBER			NOT NULL
	);
	
	 */
	
	private int gameid;			// 게임번호
	private String title;		// 게임제목
	private String genre;		// 장르
	private String developer;	// 개발사
	private String releasdate;	// 출시일자
	private int price;			// 가격
	
	
	public int getGameid() {
		return gameid;
	}
	
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public void setGameid(String gameid) {
		this.gameid = Integer.parseInt(gameid);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String getReleasdate() {
		return releasdate;
	}
	
	public void setReleasdate(String releasdate) {
		this.releasdate = releasdate;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	
}
