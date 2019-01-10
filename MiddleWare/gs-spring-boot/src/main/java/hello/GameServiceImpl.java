package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private PlayerDao playerDao;
	
	public List<Game> getAllGames() {
		return gameDao.getAllGames();
	}
	
	public Game getGameById(int GameId) {
		return gameDao.getGameById(GameId);
	}

	public List<GameDisplayData> getAllGamesDisplay() {
		List<Player> playerList = playerDao.getAllPlayers();
		Map<Integer, String> nameMap = new HashMap<Integer, String>();
		
		for(Player p: playerList) {
			int i = p.getPlayerId();
			String s = p.getName();
			nameMap.put(i, s);
		}
		
		List<Game> gameList = gameDao.getAllGames();
		List<GameDisplayData> toReturn = new ArrayList<GameDisplayData>();
		
		for(int i = 0; i < gameList.size(); i++) {
			Game g = gameList.get(i);
			GameDisplayData toAdd = new GameDisplayData();
			toAdd.setPlayerNumber(g.getPlayerNumber());
			toAdd.setGameDate(g.getGameDate());
			toAdd.setVictory(g.getVictory());
			toAdd.setVictoryStyle(g.getVictoryStyle());
			
			//String contains only the first fascist name
			String fascists = nameMap.get(g.getFascist1());
			
			if(g.getFascist2() != 0) {
				fascists += ", " + nameMap.get(g.getFascist2());
				if(g.getFascist3() != 0) {
					fascists += ", " + nameMap.get(g.getFascist3());
				}
			}
			
			toAdd.setFascists(fascists);
			
			toAdd.setHitler(nameMap.get(g.getHitler()));
			
			String liberals = nameMap.get(g.getLiberal1()) + ", " + nameMap.get(g.getLiberal2()) + ", " + nameMap.get(g.getLiberal3());
			if(g.getLiberal4() != 0) {
				liberals += ", " + nameMap.get(g.getLiberal4());
				if(g.getLiberal5() != 0) {
					liberals += ", " + nameMap.get(g.getLiberal5());
					if(g.getLiberal6() != 0) {
						liberals += ", " + nameMap.get(g.getLiberal6());
					}
				}
			}
			
			toAdd.setLiberals(liberals);
			
			if(g.getKill1() != 0) {
				toAdd.setKill1(nameMap.get(g.getKill1()));
			}
			
			if(g.getKill2() != 0) {
				toAdd.setKill2(nameMap.get(g.getKill2()));
			}
			
			if(g.getMvp() != 0) {
				toAdd.setMvp(nameMap.get(g.getMvp()));
			}
			
			if(g.getLvp() != 0) {
				toAdd.setLvp(nameMap.get(g.getLvp()));
			}
			
			toAdd.setNotes(g.getNotes());
			
			toReturn.add(toAdd);
			
		}
		
		return toReturn;
		
	}

	public int addGame(Game game) {
		return gameDao.addGame(game);
	}

}
