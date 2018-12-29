package hello;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GameRowMapper implements RowMapper<Game>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
		Game game = new Game();
		game.setGameId(rs.getInt("gameId"));
		game.setPlayerNumber(rs.getInt("playerNumber"));
		game.setVictory(rs.getString("victory"));
		game.setVictoryStyle(rs.getString("victoryStyle"));
		game.setFascist1(rs.getInt("fascist1"));
		game.setFascist2(rs.getInt("fascist2"));
		game.setFascist3(rs.getInt("fascist3"));
		game.setHitler(rs.getInt("hitler"));
		game.setLiberal1(rs.getInt("liberal1"));
		game.setLiberal2(rs.getInt("liberal2"));
		game.setLiberal3(rs.getInt("liberal3"));
		game.setLiberal4(rs.getInt("liberal4"));
		game.setLiberal5(rs.getInt("liberal5"));
		game.setKill1(rs.getInt("kill1"));
		game.setKill2(rs.getInt("kill2"));
		game.setMvp(rs.getInt("mvp"));
		game.setLvp(rs.getInt("lvp"));
		game.setNotes(rs.getString("notes"));
		return game;
	}
	
}
