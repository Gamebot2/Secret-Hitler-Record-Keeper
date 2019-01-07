package hello;

public class PlayerDisplayData {
	private String name;
	private String desc;
	private String active;
	private int winCount;
	private int gamesPlayed;
	private double winPercentage;
	private int liberalWinCount;
	private int liberalGamesPlayed;
	private double liberalWinPercentage;
	private int fascistWinCount;
	private int fascistGamesPlayed;
	private double fascistWinPercentage;
	private int mvpCount;
	private int lvpCount;
	private int timesKilled;
	
	public PlayerDisplayData() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}





	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public double getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}

	public double getLiberalWinPercentage() {
		return liberalWinPercentage;
	}

	public void setLiberalWinPercentage(double liberalWinPercentage) {
		this.liberalWinPercentage = liberalWinPercentage;
	}

	public double getFascistWinPercentage() {
		return fascistWinPercentage;
	}

	public void setFascistWinPercentage(double fascistWinPercentage) {
		this.fascistWinPercentage = fascistWinPercentage;
	}

	public int getMvpCount() {
		return mvpCount;
	}

	public void setMvpCount(int mvpCount) {
		this.mvpCount = mvpCount;
	}

	public int getLvpCount() {
		return lvpCount;
	}

	public void setLvpCount(int lvpCount) {
		this.lvpCount = lvpCount;
	}

	public int getTimesKilled() {
		return timesKilled;
	}

	public void setTimesKilled(int timesKilled) {
		this.timesKilled = timesKilled;
	}

	public int getLiberalWinCount() {
		return liberalWinCount;
	}

	public void setLiberalWinCount(int liberalWinCount) {
		this.liberalWinCount = liberalWinCount;
	}

	public int getLiberalGamesPlayed() {
		return liberalGamesPlayed;
	}

	public void setLiberalGamesPlayed(int liberalGamesPlayed) {
		this.liberalGamesPlayed = liberalGamesPlayed;
	}

	public int getFascistWinCount() {
		return fascistWinCount;
	}

	public void setFascistWinCount(int fascistWinCount) {
		this.fascistWinCount = fascistWinCount;
	}

	public int getFascistGamesPlayed() {
		return fascistGamesPlayed;
	}

	public void setFascistGamesPlayed(int fascistGamesPlayed) {
		this.fascistGamesPlayed = fascistGamesPlayed;
	}
	
	public void incrementGamesPlayed() {
		this.gamesPlayed++;
	}
	
	public void incrementWinCount() {
		this.winCount++;
	}
	
	public void incrementLiberalGamesPlayed() {
		this.liberalGamesPlayed++;
	}
	
	public void incrementLiberalWinCount() {
		this.liberalWinCount++;
	}
	
	public void incrementFascistGamesPlayed() {
		this.fascistGamesPlayed++;
	}
	
	public void incrementFascistWinCount() {
		this.fascistWinCount++;
	}
	
	public void incrementMvpCount() {
		this.mvpCount++;
	}
	
	public void incrementLvpCount() {
		this.lvpCount++;
	}
	
	public void incrementTimesKilled() {
		this.timesKilled++;
	}
	
	public void calculateWinPercentages() {
		if(gamesPlayed > 0) {
			this.winPercentage = (double)winCount / (double)gamesPlayed;
		}
		
		if(liberalGamesPlayed > 0) {
			this.liberalWinPercentage = (double)liberalWinCount / (double)liberalGamesPlayed;
		}
		
		if(fascistGamesPlayed > 0) {
			this.fascistWinPercentage = (double)fascistWinCount / (double)fascistGamesPlayed;
		}
	}
}
