package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDao gameDao;
	
	public List<Game> getAllGames() {
		return gameDao.getAllGames();
	}

}
