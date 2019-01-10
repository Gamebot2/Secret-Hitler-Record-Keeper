package hello;

import java.util.List;

public interface PlayerDao {
	public List<Player> getAllPlayers();
	public int addPlayer(Player p);
	public int removePlayer(int id);
}
