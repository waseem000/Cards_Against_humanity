package application_GUI;


import java.util.ArrayList;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import clients.initilaize;

public class app_screen {

	protected  Shell shlCradsAginstHumanity;
	
	private ArrayList<Button> buttonArray;
	
	private Text message_text;
	private StyledText styledText;
	
	private String selected_card="";
	public static Button btnHidden;
	public static Button btnCard1;
	public static Button btnCard2;
	public static Button btnCard3;
	public static Button btnCard4;
	public static Button btnCard5;
	public static Button btnNewButton;
	public static Button btnblack_card;
	public Display display;
	//	private static client client_obj = new client();
	/**
	 * Launch the application.
	 * @param args
	 */
	private newgame_Dialog NewGame_D;


	//private   app_screen screen_obj =this;

	/*public static void main(String[] args) {


		try {
			app_screen window = new app_screen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}*/
	public  app_screen()
	{
		createContents();
		//enforcing Singleton pattern
	}
	/*	public  app_screen getObject()
	{
		return this;//screen_obj;
	}
	private  app_screen getobj()
	{
		return screen_obj;
	}*/
	/*
	 public static app_screen getInstance()
	 {
		 if(screen_obj== null)
		 {
			 screen_obj= new app_screen();
			 return screen_obj;
		 }
		 else
		 {
			 return screen_obj;
		 }


	 }*/
	/**
	 * Open the window.
	 */
	public void open() {

		shlCradsAginstHumanity.open();
		shlCradsAginstHumanity.layout();
	
		button_Array(initilaize.getNumber_of_cards_player());
		assign_Cards_Buttons();
		set_Black_Card();

		//client_obj.start();
		while (!shlCradsAginstHumanity.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCradsAginstHumanity = new Shell();

		display = Display.getDefault();//.asyncExec(runnable);

		NewGame_D= new newgame_Dialog(shlCradsAginstHumanity);
		//createContents();

		NewGame_D.open();//check the placement
		shlCradsAginstHumanity.setSize(1272, 597);
		shlCradsAginstHumanity.setText("Crads Aginst Humanity");

		Menu menu = new Menu(shlCradsAginstHumanity, SWT.BAR);
		shlCradsAginstHumanity.setMenuBar(menu);


		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");

		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);

		MenuItem mntmConnect = new MenuItem(menu_1, SWT.NONE);
		mntmConnect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NewGame_D.open();
			}
		});
		mntmConnect.setText("Connect");

		MenuItem mntmExit = new MenuItem(menu, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				initilaize.Exit();
				shlCradsAginstHumanity.dispose();
			}
		});
		mntmExit.setText("Exit");

		Composite composite_6 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_6.setBounds(795, 220, 151, 172);

		Composite composite_7 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_7.setBounds(954, 220, 151, 172);

		Composite composite_8 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_8.setBounds(1111, 220, 151, 172);

		Composite composite_9 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_9.setBounds(211, 10, 151, 172);
		
		btnNewButton = new Button(composite_9, SWT.WRAP);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 151, 172);

		Composite composite_10 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_10.setBounds(368, 10, 151, 172);

		Composite composite_11 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_11.setBounds(528, 10, 151, 172);

		Composite composite_12 = new Composite(shlCradsAginstHumanity, SWT.NONE);
		composite_12.setBounds(685, 10, 151, 172);

		Label label = new Label(shlCradsAginstHumanity, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 198, 1236, 2);

		Label label_1 = new Label(shlCradsAginstHumanity, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(183, 0, 2, 199);

		Button btnConfiremCard = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnConfiremCard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				btnNewButton.setText(selected_card);
			}
		});
		btnConfiremCard.setBounds(10, 437, 107, 25);
		btnConfiremCard.setText("Confirem Card");

		message_text = new Text(shlCradsAginstHumanity, SWT.BORDER);
		message_text.setBounds(907, 494, 258, 21);

		Button btnSendMessage = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnSendMessage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				initilaize.c.sendMsg(message_text.getText());
				message_text.setText("");
				//setChat();
			}
		});
		btnSendMessage.setBounds(1171, 492, 75, 25);
		btnSendMessage.setText("Send");

		styledText = new StyledText(shlCradsAginstHumanity, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		styledText.setText("");
		styledText.setEditable(false);
		styledText.setBounds(907, 406, 339, 82);

		btnHidden = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnHidden.setBounds(10, 490, 75, 25);
		btnHidden.setVisible(false);
		
		btnblack_card = new Button(shlCradsAginstHumanity, SWT.WRAP);
		btnblack_card.setEnabled(false);
		btnblack_card.setBounds(10, 10, 167, 172);
		create_Button(initilaize.getNumber_of_cards_player());
		
		/*btnCard1 = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnCard1.setBounds(10, 220, 151, 172);
		
		btnCard2 = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnCard2.setBounds(167, 220, 151, 172);
		
		btnCard3 = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnCard3.setBounds(324, 220, 151, 172);
		
		btnCard4 = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnCard4.setBounds(480, 220, 151, 172);
		
		btnCard5 = new Button(shlCradsAginstHumanity, SWT.NONE);
		btnCard5.setBounds(637, 220, 151, 172);*/
		
		btnHidden.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setChat();
			}	
		});

		btnCard1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				selected_card=btnCard1.getText();
			}
		});
		btnCard2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selected_card=btnCard2.getText();
			}
		});
		btnCard3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				selected_card=btnCard3.getText();
			}
		});
		btnCard4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				selected_card=btnCard4.getText();
			}
		});
		btnCard5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				selected_card=btnCard5.getText();
			}
		});

	}

	public void setChat()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!(styledText.getText()==""))
		{
			styledText.append("\n");
		}
		styledText.append(initilaize.c.getMsg());
	}
	private void create_Button(Integer num_buttons)
	{
		if(num_buttons==5)
		{
			btnCard1 = new Button(shlCradsAginstHumanity, SWT.WRAP);
			btnCard1.setBounds(10, 220, 151, 172);
			
			btnCard2 = new Button(shlCradsAginstHumanity, SWT.WRAP);
			btnCard2.setBounds(167, 220, 151, 172);
			
			btnCard3 = new Button(shlCradsAginstHumanity, SWT.WRAP);
			btnCard3.setBounds(324, 220, 151, 172);
			
			btnCard4 = new Button(shlCradsAginstHumanity, SWT.WRAP);
			btnCard4.setBounds(480, 220, 151, 172);
			
			btnCard5 = new Button(shlCradsAginstHumanity, SWT.WRAP);
			btnCard5.setBounds(637, 220, 151, 172);
		}
	}
	private void button_Array(Integer num_buttons)
	{
		buttonArray= new ArrayList<Button>();
		if(num_buttons==5)
		{
			buttonArray.add(btnCard1);
			buttonArray.add(btnCard2);
			buttonArray.add(btnCard3);
			buttonArray.add(btnCard4);
			buttonArray.add(btnCard5);
		}
	}
	
	private void assign_Cards_Buttons()
	{
		ArrayList<String> cards_arr= initilaize.p.getCards();
		
		for(int i=0; i<cards_arr.size();i++)
		{
			buttonArray.get(i).setText(cards_arr.get(i));
		}
		
		if(initilaize.p.getPlayer_State()==2)
		{
			for(int i=0; i<cards_arr.size();i++)
			{
				buttonArray.get(i).setVisible(false);
			}
		}
		else
		{
			for(int i=0; i<cards_arr.size();i++)
			{
				buttonArray.get(i).setVisible(true);
			}
		}
	}
	
	public void set_Black_Card()
	{
		/*Integer cards_arr_size=initilaize.getBlack_cards().size();
		Integer loc;
		Random r_loc = new Random();
		loc= r_loc.nextInt(cards_arr_size)+1;*/
		//btnblack_card.setText(initilaize.getBlack_cards().get(loc));
		btnblack_card.setText(initilaize.getBlack_card());
	}
}
