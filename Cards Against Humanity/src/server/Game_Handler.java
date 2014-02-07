package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import clients.player;


public class Game_Handler {
	

	private static ArrayList<String> white_cards;

	private static ArrayList<String> black_cards;

	
	public Game_Handler()
	{
		initilaize_Cards();
	}
    /**
	 * @return the white_cards
	 */
	public static ArrayList<String> getWhite_cards() {
		return white_cards;
	}


	/**
	 * @param white_cards the white_cards to set
	 */
	public static void setWhite_cards(ArrayList<String> white_Cd) {
		white_cards = white_Cd;
	}
	
	public void initilaize_Cards() {

        white_cards= new ArrayList<String>();
      
		black_cards= new ArrayList<String>();
		
		try {
			set_White_Cards(white_cards);
			  System.out.println("------------------------------------------------------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			set_black_Cards(black_cards);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void set_White_Cards(ArrayList<String> wCards) throws IOException
	{
		String file= "res/WCards.txt";//"res/white_cards.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
	    try {
	        String line = br.readLine();
	      //  System.out.println(line);
	        while (line != null) {
	        	wCards.add(line);
	            line = br.readLine();
	            System.out.println(line);
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
	
	public static String get_Card()
	{
		String card;
		Integer num_of_cards=white_cards.size();
		Random R = new Random();
		Integer card_location;
		
			card_location= R.nextInt(num_of_cards);
			card=white_cards.get(card_location);
			System.out.println(white_cards.get(card_location));
			white_cards.remove(white_cards.get(card_location));
		
			return card;

		
	}
}
