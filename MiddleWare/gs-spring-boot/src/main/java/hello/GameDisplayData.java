package hello;

import java.sql.Date;

public class GameDisplayData {
	private int playerNumber;
	private Date gameDate;
	private String victory;
	private String victoryStyle;
	private String fascists;
	private String hitler;
	private String liberals;
	private String kill1;
	private String kill2;
	private String mvp;
	private String lvp;
	private String notes;
	
	public GameDisplayData() {
		super();
	}

	public GameDisplayData(int playerNumber, Date gameDate,  String victory, String victoryStyle, String fascists, String hitler,
			String liberals, String kill1, String kill2, String mvp, String lvp, String notes) {
		super();
		this.playerNumber = playerNumber;
		this.gameDate = gameDate;
		this.victory = victory;
		this.victoryStyle = victoryStyle;
		this.fascists = fascists;
		this.hitler = hitler;
		this.liberals = liberals;
		this.kill1 = kill1;
		this.kill2 = kill2;
		this.mvp = mvp;
		this.lvp = lvp;
		this.notes = notes;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	public Date getGameDate() {
		return gameDate;
	}
	
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public String getVictory() {
		return victory;
	}

	public void setVictory(String victory) {
		this.victory = victory;
	}

	public String getVictoryStyle() {
		return victoryStyle;
	}

	public void setVictoryStyle(String victoryStyle) {
		this.victoryStyle = victoryStyle;
	}

	public String getFascists() {
		return fascists;
	}

	public void setFascists(String fascists) {
		this.fascists = fascists;
	}

	public String getHitler() {
		return hitler;
	}

	public void setHitler(String hitler) {
		this.hitler = hitler;
	}

	public String getLiberals() {
		return liberals;
	}

	public void setLiberals(String liberals) {
		this.liberals = liberals;
	}

	public String getKill1() {
		return kill1;
	}

	public void setKill1(String kill1) {
		this.kill1 = kill1;
	}

	public String getKill2() {
		return kill2;
	}

	public void setKill2(String kill2) {
		this.kill2 = kill2;
	}

	public String getMvp() {
		return mvp;
	}

	public void setMvp(String mvp) {
		this.mvp = mvp;
	}

	public String getLvp() {
		return lvp;
	}

	public void setLvp(String lvp) {
		this.lvp = lvp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
