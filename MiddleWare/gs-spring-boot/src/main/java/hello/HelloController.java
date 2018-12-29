package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private GameService gameService;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    //Retrieves all games in the database
    @RequestMapping("/games")
    public List<Game> getAllGames() {
    	System.out.println("method getAllGames() called");
    	return gameService.getAllGames();
    }
    
    

}