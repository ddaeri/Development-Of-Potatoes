package game.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import game.conn.db.DBConn;
import game.vo.GameVo;

public class GameDAO {
	private DBConn db;

	public GameDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 게임 DAO
	 */
	
	// 게임 등록
	public boolean addGame(GameVo data) {
		String query = "INSERT INTO GAME_ADMIN VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setInt(1, data.getGameid());
			pstat.setString(2, data.getTitle());
			pstat.setString(3, data.getGenre());
			pstat.setString(4, data.getDeveloper());
			pstat.setString(5, data.getReleasdate());
			pstat.setInt(6, data.getPrice());
		
			int rs = db.sendInsertQuery();
			if(rs == 1) {
				db.commit();
				return true;
			}
				db.rollback();
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 게임 수정
	public boolean updateGame(GameVo data) {
		String query = "UPDATE GAME_ADMIN"
				+ "        SET gameid = ?"
				+ "          , title = ?"
				+ "          , genre = ?" 
				+ "          , developer = ?" 
				+ "          , releasdate = ?" 
				+ "          , price = ?" 
				+ "      WHERE gameid = ?";
		try {	
			PreparedStatement pstat = db.getPstat(query); 
			pstat.setInt(1, data.getGameid());
			pstat.setString(2, data.getTitle());
			pstat.setString(3, data.getGenre());
			pstat.setString(4, data.getDeveloper());
			pstat.setString(5, data.getReleasdate());
			pstat.setInt(6, data.getPrice());
			pstat.setInt(7, data.getGameid());
			
			int rs = db.sendUpdateQuery();
			if(rs >= 1) {
				db.commit();
				return true;
			}
			db.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 게임 정보 삭제
	public boolean removeGame(GameVo data) {
		String query = "DELETE FROM GAME_ADMIN WHERE gameid = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setInt(1, data.getGameid());
			
			int rs = db.sendDeleteQuery();
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 게임 전체 정보
	public GameVo GameList() {
		try {
			String query = "SELECT * FROM GAME_ADMIN";
			PreparedStatement pstat = db.getPstat(query);
			ResultSet rs = db.sendSelectQuery();
			int count = 0;
			
			System.out.println("+-------------------------------------------------------------+");
			while(rs.next()) {
				GameVo data = new GameVo();
				int gameid = rs.getInt("gameid");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				String developer = rs.getString("developer");
				String releasdate = rs.getString("releasdate");
				int price = rs.getInt("price");

                System.out.println("게임번호\t" + "게임제목\t" + "장  르\t" + "개발사 \t" + "\t출시일자\t"+ "가  격\t");
                System.out.print(gameid+"\t");
                System.out.print(title+"\t");
                System.out.print(genre+"\t");
                System.out.print(developer+"\t");
                System.out.print(releasdate+"\t");
                System.out.println(price);
                count = count + 1; 
			}
			System.out.println("+-------------------------------------------------------------+");
			System.out.println("\n총 " + count + " 개의 목록이 있습니다.\n");
			System.out.println("+-------------------------------------------------------------+");
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게임제목에 해당되는 정보 반환
	public GameVo getTitle(String title) {
		String query = "SELECT * FROM GAME_ADMIN WHERE TITLE LIKE ? ";
		try {
			PreparedStatement pstat = db.getPstat(query);
			String titles = '%' + title + '%';
			pstat.setString(1, titles);
			
			ResultSet rs = db.sendSelectQuery();
			if(rs.next()) {
				GameVo data = new GameVo();
				System.out.println("+-------------------------------------------------------------+");
				data.setGameid(rs.getInt("gameid"));
				data.setTitle(rs.getString("title"));
				data.setGenre(rs.getString("genre"));
				data.setDeveloper(rs.getString("developer"));
				data.setReleasdate(rs.getString("releasdate"));
				data.setPrice(rs.getInt("price"));
				System.out.println("+-------------------------------------------------------------+");

				return data;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
