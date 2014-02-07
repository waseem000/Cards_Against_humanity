package clients;

import java.util.ArrayList;

public class player {
	
	private String name; 
	private Integer score;
	private Integer number_of_crads;
	private ArrayList<String> cards = new ArrayList<String>();
	private Integer player_State; //1player- 2-judge
	private Integer Player_turn; //for the server
	
	
	public player()
	{
		this.score=0;
		this.number_of_crads=0;
		this.player_State=1;
		this.Player_turn=0;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * @return the number_of_crads
	 */
	public Integer getNumber_of_crads() {
		return number_of_crads;
	}
	/**
	 * @param number_of_crads the number_of_crads to set
	 */
	public void setNumber_of_crads(Integer number_of_crads) {
		this.number_of_crads = number_of_crads;
	}
	/**
	 * @return the player_State
	 */
	public Integer getPlayer_State() {
		return player_State;
	}
	/**
	 * @param player_State the player_State to set
	 */
	public void setPlayer_State(Integer player_State) {
		this.player_State = player_State;
	}
	/**
	 * @return the cards
	 */
	public ArrayList<String> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}
	
	public void addCard(String card)
	{
		cards.add(card);
	}
	
	public void removeCard(String card)
	{
		Integer loc;
		loc = cards.indexOf(card);
		cards.remove(loc);
	}
	
	
	

}
