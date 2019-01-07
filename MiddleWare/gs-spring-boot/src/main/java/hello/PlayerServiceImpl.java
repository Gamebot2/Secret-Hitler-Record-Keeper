package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerDao playerDao;
	
	@Autowired
	GameDao gameDao;
	
	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}
	
	public Collection<PlayerDisplayData> getAllPlayersDisplay() {
		List<Player> playerList = this.getAllPlayers();
		
		List<Game> gameList = gameDao.getAllGames();
		
		Map<Integer, PlayerDisplayData> idMap = new HashMap<Integer, PlayerDisplayData>();
		
		for(Player p: playerList) {
			
			int i = p.getPlayerId();
			String s = p.getName();
			String d = p.getDesc();
			String a = p.getActive();
			PlayerDisplayData pd = new PlayerDisplayData();
			pd.setName(s);
			pd.setDesc(d);
			pd.setActive(a);
			idMap.put(i, pd);
		}
		
		for(Game g: gameList) {
			int fascist1 = g.getFascist1();
			int fascist2 = g.getFascist2();
			int fascist3 = g.getFascist3();
			int hitler = g.getHitler();
			int liberal1 = g.getLiberal1();
			int liberal2 = g.getLiberal2();
			int liberal3 = g.getLiberal3();
			int liberal4 = g.getLiberal4();
			int liberal5 = g.getLiberal5();
			int liberal6 = g.getLiberal6();
			int kill1 = g.getKill1();
			int kill2 = g.getKill2();
			int mvp = g.getMvp();
			int lvp = g.getLvp();
			
			if(mvp != 0) {
				idMap.get(mvp).incrementMvpCount();
			}
			if(lvp != 0) {
				idMap.get(lvp).incrementLvpCount();
			}
			if(kill1 != 0) {
				idMap.get(kill1).incrementTimesKilled();
			}
			if(kill2 != 0) {
				idMap.get(kill2).incrementTimesKilled();
			}
			if(fascist1 != 0) {
				idMap.get(fascist1).incrementFascistGamesPlayed();
				idMap.get(fascist1).incrementGamesPlayed();
			}
			if(fascist2 != 0) {
				idMap.get(fascist2).incrementFascistGamesPlayed();
				idMap.get(fascist2).incrementGamesPlayed();
			}
			if(fascist3 != 0) {
				idMap.get(fascist3).incrementFascistGamesPlayed();
				idMap.get(fascist3).incrementGamesPlayed();
			}
			if(hitler != 0)
			{			
				idMap.get(hitler).incrementFascistGamesPlayed();
				idMap.get(hitler).incrementGamesPlayed();
			}
			if(liberal1 != 0) {
				idMap.get(liberal1).incrementLiberalGamesPlayed();
				idMap.get(liberal1).incrementGamesPlayed();
			}
			if(liberal2 != 0) {
				idMap.get(liberal2).incrementLiberalGamesPlayed();
				idMap.get(liberal2).incrementGamesPlayed();
			}
			if(liberal3 != 0) {
				idMap.get(liberal3).incrementLiberalGamesPlayed();
				idMap.get(liberal3).incrementGamesPlayed();
			}
			if(liberal4 != 0) {
				idMap.get(liberal4).incrementLiberalGamesPlayed();
				idMap.get(liberal4).incrementGamesPlayed();
			}
			if(liberal5 != 0) {
				idMap.get(liberal5).incrementLiberalGamesPlayed();
				idMap.get(liberal5).incrementGamesPlayed();
			}
			if(liberal6 != 0) {
				idMap.get(liberal6).incrementLiberalGamesPlayed();
				idMap.get(liberal6).incrementGamesPlayed();
			}
			if(g.getVictory().equals("Fascists")) { //Fascist Victory
				if(fascist1 != 0) {
					idMap.get(fascist1).incrementFascistWinCount();
					idMap.get(fascist1).incrementWinCount();
				}
				if(fascist2 != 0) {
					idMap.get(fascist2).incrementFascistWinCount();
					idMap.get(fascist2).incrementWinCount();
				}
				if(fascist3 != 0) {
					idMap.get(fascist3).incrementFascistWinCount();
					idMap.get(fascist3).incrementWinCount();
				}
				if(hitler != 0)
				{			
					idMap.get(hitler).incrementFascistWinCount();
					idMap.get(hitler).incrementWinCount();
				}
			} else { //Liberal Victory
				if(liberal1 != 0) {
					idMap.get(liberal1).incrementLiberalWinCount();
					idMap.get(liberal1).incrementWinCount();
				}
				if(liberal2 != 0) {
					idMap.get(liberal2).incrementLiberalWinCount();
					idMap.get(liberal2).incrementWinCount();
				}
				if(liberal3 != 0) {
					idMap.get(liberal3).incrementLiberalWinCount();
					idMap.get(liberal3).incrementWinCount();
				}
				if(liberal4 != 0) {
					idMap.get(liberal4).incrementLiberalWinCount();
					idMap.get(liberal4).incrementWinCount();
				}
				if(liberal5 != 0) {
					idMap.get(liberal5).incrementLiberalWinCount();
					idMap.get(liberal5).incrementWinCount();
				}
				if(liberal6 != 0) {
					idMap.get(liberal6).incrementLiberalWinCount();
					idMap.get(liberal6).incrementWinCount();
				}
			}
			
		}
		
		//Write the code here to compute the winPercentages
		for(PlayerDisplayData p: idMap.values()) {
			p.calculateWinPercentages();
		}
		
		//Filters out the inactive players
		Collection<PlayerDisplayData> toReturn = new ArrayList<PlayerDisplayData>();
		for(PlayerDisplayData p: idMap.values()) {
			if(p.getActive() != null && p.getActive().equalsIgnoreCase("active")) {
				toReturn.add(p);
			}
		}
		return toReturn;
	}

}
