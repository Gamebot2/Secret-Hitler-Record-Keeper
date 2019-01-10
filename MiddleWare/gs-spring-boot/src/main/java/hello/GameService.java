package hello;

import java.util.List;

public interface GameService {
	List<Game> getAllGames();
	Game getGameById(int GameId);
	List<GameDisplayData> getAllGamesDisplay();
	public int addGame(Game game);
}
