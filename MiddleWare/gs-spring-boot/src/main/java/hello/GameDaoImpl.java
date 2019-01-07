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

}
