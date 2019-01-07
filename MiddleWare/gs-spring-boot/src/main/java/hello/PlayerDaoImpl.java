package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Player> getAllPlayers() {
		String sql = "SELECT * FROM players";
		RowMapper<Player> rowMapper = new PlayerRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
