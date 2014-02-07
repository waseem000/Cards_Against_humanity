package clients;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import server.Game_server;

import application_GUI.app_screen;

public class initilaize {

	//public static app_screen scr=null;
	public static app_screen screen =null;
	public static client c=null;
	public static player p=null;
	private static ArrayList<String> white_cards;
	private static ArrayList<String> black_cards;
	private static boolean open_Server=false;
	/**
	 * @return the black_cards
	 */
	public static ArrayList<String> getBlack_cards() {
		return black_cards;
	}
	private static Integer number_of_cards_player=5; //number of cards for each player
	public initilaize() throws IOException, InterruptedException
	{
	/*	white_cards= new ArrayList<String>();
		black_cards= new ArrayList<String>();
		
		set_White_Cards(white_cards);
		set_black_Cards(black_cards);*/
		p = new player();
		c = new client();
		screen= new app_screen();
		
		
		//Thread.sleep(5000);
		
	
		
/*		if(open_Server)
		{
			Game_server S = new Game_server();
			new Thread(S).start();
		}*/
	//	c.connect();
	
	//new app_screen();
		
		new Thread(c).start();
	
		//c.sendMsg("GetCards");
		getPlayerCards();
		

	}

	/**
	 * @return the open_Server
	 */
	public static boolean isOpen_Server() {
		return open_Server;
	}

	/**
	 * @param open_Server the open_Server to set
	 */
	public static void setOpen_Server(boolean use_Server) {
		open_Server = use_Server;
	}

	/**
	 * @return the number_of_cards_player
	 */
	public static Integer getNumber_of_cards_player() {
		return number_of_cards_player;
	}

	/**
	 * @param number_of_cards_player the number_of_cards_player to set
	 */
	public static void setNumber_of_cards_player(Integer number_of_cards_player) {
		initilaize.number_of_cards_player = number_of_cards_player;
	}

	public static void Exit()
	{
		System.exit(0);
	}
	
	/*private static void set_White_Cards(ArrayList<String> wCards) throws IOException
	{
		String file= "res/white_cards.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
	    try {
	        String line = br.readLine();
	      //  System.out.println(line);
	        while (line != null) {
	        	wCards.add(line);
	            line = br.readLine();
	          //  System.out.println(line);
	        }
	      
	    } finally {
	        br.close();
	    }
	}
	
	private static void set_black_Cards(ArrayList<String> bCards) throws IOException
	{
		String file= "res/black_cards.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
	    try {
	        String line = br.readLine();
	      //  System.out.println(line);
	        while (line != null) {
	        	bCards.add(line);
	            line = br.readLine();
	        //    System.out.println(line);
	        }
	      
	    } finally {
	        br.close();
	    }
	}
	*/
	public static void getPlayerCards() throws InterruptedException
	{
/*		Integer num_of_cards=arr.size();
		Random R = new Random();
		Integer card_location;
		for(int i=p.getNumber_of_crads(); i<number_of_cards_player;i++)
		{
			card_location= R.nextInt(num_of_cards);
			p.addCard(arr.get(card_location));
			System.out.println(arr.get(card_location));
			arr.remove(arr.get(card_location));
			num_of_cards=arr.size();
		}
		Game_server.setWhite_cards(arr);*/
		for(int i=p.getNumber_of_crads(); i<=number_of_cards_player;i++)
		{
			c.sendMsg("GetCards");
			Thread.sleep(1000);
		}
		
	}
	
	public static void assignPlayerCards(player P, String s)
	{
		p.addCard(s);
	}
		/**
	 * @param args
	 * @throws IOException 
		 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	
		
		 
		
		 
		initilaize ini= new initilaize();
		screen.open();

	}

}
