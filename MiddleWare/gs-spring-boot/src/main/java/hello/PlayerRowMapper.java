package hello;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayerRowMapper implements RowMapper<Player> {

	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player = new Player();
		player.setPlayerId(rs.getInt("playerId"));
		player.setName(rs.getString("playerName"));
		player.setDesc(rs.getString("playerDesc"));
		player.setActive(rs.getString("active"));
		return player;
	}

}
