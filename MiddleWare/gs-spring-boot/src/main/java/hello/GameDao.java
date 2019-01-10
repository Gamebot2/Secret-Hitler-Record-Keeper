package hello;

import java.util.List;

public interface GameDao {
	List<Game> getAllGames();
	Game getGameById(int GameId);
	int addGame(Game g);
}
