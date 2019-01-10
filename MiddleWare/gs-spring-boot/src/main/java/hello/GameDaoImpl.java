package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class GameDaoImpl implements GameDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Game> getAllGames() {
		String sql = "SELECT * FROM games";
		RowMapper<Game> rowMapper = new GameRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public Game getGameById(int gameId) {
		String sql = "SELECT * FROM games WHERE gameId = ?";
		RowMapper<Game> rowMapper = new BeanPropertyRowMapper<Game>(Game.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, gameId);
		
	}

	public int addGame(Game g) {
		String sql = "INSERT INTO games (date, playerNumber, victory, victoryStyle, fascist1, fascist2, fascist3, hitler, liberal1, liberal2, liberal3, liberal4, liberal5, liberal6, kill1, kill2, mvp, lvp, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		return this.jdbcTemplate.update(sql, g.getGameDate(), g.getPlayerNumber(), g.getVictory(), g.getVictoryStyle(), g.getFascist1(), g.getFascist2(), g.getFascist3(), g.getHitler(), g.getLiberal1(), g.getLiberal2(), g.getLiberal3(), g.getLiberal4(), g.getLiberal5(), g.getLiberal6(), g.getKill1(), g.getKill2(), g.getMvp(), g.getLvp(), g.getNotes());
	}

}
