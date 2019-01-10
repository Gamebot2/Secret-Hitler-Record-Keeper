package hello;

import java.util.Collection;
import java.util.List;

public interface PlayerService {
	public List<Player> getAllPlayers();
	public Collection<PlayerDisplayData> getAllPlayersDisplay();
	public int addPlayer(Player p);
	public int removePlayer(int id);
}
