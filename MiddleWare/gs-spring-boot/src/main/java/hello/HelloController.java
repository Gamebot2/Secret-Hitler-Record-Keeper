package hello;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	public final String webOrigin = "http:localhost:8080";
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayerService playerService;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Deez Boot!";
    }
    
    //Retrieves all pure game data in the database
    @RequestMapping("/games")
    public List<Game> getAllGames() {
    	System.out.println("method getAllGames() called");
    	return gameService.getAllGames();
    }
    
    //Retrieves a game by its id number
   @RequestMapping("/game")
   public Game getGameById(@RequestParam("Id") int GameId) {
	   System.out.println("method getGameById() called on id " + GameId);
	   return gameService.getGameById(GameId);
   }
   
   //Retrieves modified game data from the database for displaying
   @RequestMapping("/gamesDisplay")
   public List<GameDisplayData> getAllGamesDisplay() {
	   System.out.println("method getAlGamesDisplay() called");
	   return gameService.getAllGamesDisplay();
   }
   
   //Retrives Raw Player Data
   @RequestMapping("/players")
   public List<Player> getAllPlayers() {
	   System.out.println("method getAllPlayers() called");
	   return playerService.getAllPlayers();
   }
   
   //Retrieves Player Display Data
   @RequestMapping("/playersDisplay")
   public Collection<PlayerDisplayData> getAllPlayersDisplay() {
	   System.out.println("method getAllPlayersDisplay() Called");
	   return playerService.getAllPlayersDisplay();
   }
   
   
    
    

}