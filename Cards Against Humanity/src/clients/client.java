package clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;

import application_GUI.app_screen;

/**
 * A simple Swing-based client for the chat server.  Graphically
 * it is a frame with a text field for entering messages and a
 * textarea to see the whole dialog.
 *
 * The client follows the Chat Protocol which is as follows.
 * When the server sends "SUBMITNAME" the client replies with the
 * desired screen name.  The server will keep sending "SUBMITNAME"
 * requests as long as the client submits screen names that are
 * already in use.  When the server sends a line beginning
 * with "NAMEACCEPTED" the client is now allowed to start
 * sending the server arbitrary strings to be broadcast to all
 * chatters connected to the server.  When the server sends a
 * line beginning with "MESSAGE " then all characters following
 * this string should be displayed in its message area.
 */
public class client implements Runnable {


	private   BufferedReader in;
	private   PrintWriter out;
   // JFrame frame = new JFrame("Chatter");
  //  JTextField textField = new JTextField(40);
  //  JTextArea messageArea = new JTextArea(8, 40);
    private String server_address;
   // private  String name;
   // private app_screen Game_GUI = app_screen.getInstance();
	private String MsgText;
	private static Thread t = new Thread();
	private ArrayList<String> player_cards;
    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Return in the
     * listener sends the textfield contents to the server.  Note
     * however that the textfield is initially NOT editable, and
     * only becomes editable AFTER the client receives the NAMEACCEPTED
     * message from the server.
     */
   /* public client() {

        // Layout GUI
        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        // Add Listeners
        textField.addActionListener(new ActionListener() {
            *//**
             * Responds to pressing the enter key in the textfield by sending
             * the contents of the text field to the server.    Then clear
             * the text area in preparation for the next message.
             *//*
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }*/
	public client() 
	{
		   // Make connection and initialize streams
	      
		  String serverAddress = getServerAddress();
	        Socket socket = null;
			try {
				socket = new Socket(serverAddress, 9001);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				in = new BufferedReader(new InputStreamReader(
				    socket.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				out = new PrintWriter(socket.getOutputStream(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

    /**
     * Prompt for and return the address of the server.
     */
    public String getServerAddress() {
       return server_address;
    }

    public void setServerAddress(String address)
    {
    	this.server_address=address;
    }
  /*  *//**
     * Prompt for and return the desired screen name.
     *//*
    public void setName(String player_name) {
     
    	this.name =player_name;
    }
    public  String getName() {
        return name;
     }*/
 
    /**
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(BufferedReader in) {
		this.in = in;
	}

	/**
	 * @return the out
	 */
	public PrintWriter getOut() {
		return out;
	}

	/**
	 * @param out the out to set
	 */
	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public void setMsg(String Msg)
    {
    	this.MsgText=Msg;
    }
	public String getMsg()
	{
		return this.MsgText;
	}
    public void sendMsg(String MsgText)
    {
    	System.out.println("in send Msg           -->"+MsgText);
    	out.println(MsgText);
    	out.flush();
    }
    
   
    /**
     * Connects to the server then enters the processing loop.
     */
   
    public  void run()  {

    //	System.out.println("In the run");
        // Process all messages from server, according to the protocol.
    	 String line = null;
        while (true) {
        	//System.out.println("in while loop");
           
			try {
				line = in.readLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println("in while loop : "+line);
			/*if(line ==null)
			{
				System.out.println("in line == null"+line);
				try {
					Thread.currentThread();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else */
			if (line.startsWith("SUBMITNAME")) {
              // out.println(getName());
			//	System.out.println("in line == SUBMITNAME"+line);
				//sendMsg(initilaize.p.getName());
			//	System.out.println("in line == SUBMITNAME"+name);
			//	Game_GUI.setChat(line);
            } else if (line.startsWith("NAMEACCEPTED")) {
              //  textField.setEditable(true); 
            	System.out.println("in line == NAMEACCEPTED"+line);
            	
            } else if (line.startsWith("MESSAGE")) {
          //      messageArea.append(line.substring(8) + "\n");
            	System.out.println("Client ===>"+initilaize.p.getName()+line.substring(8) + "\n");
            	setMsg(line.substring(8));
            	//initilaize.screen.setChat();
            	//app_screen.btnHidden.notifyListeners(SWT.Selection, new Event());
            	//Game_GUI.setChat("this is a text");
            	 initilaize.screen.display.asyncExec(new Runnable() {
            		 
            		 public void run() {
            			 initilaize.screen.setChat(/*name*//*line.substring(8)*/ );
            		 }
            	
            	  });
            	//dispaly_Msg(name);
            	//Game_GUI.setChat("this is a text2");
            	//Game_GUI.setChat("this is a text3");
            }
            else if(line.startsWith("white"))
            {

            	initilaize.assignPlayerCards(initilaize.p,line.substring(5));
            }
            else if(line.startsWith("black"))
            {

            	//initilaize.screen.set_Black_Card(line.substring(8));
            	initilaize.setBlack_card(line.substring(5));
            }
        }
    }
  

    /**
     * Runs the client as an application with a closeable frame.
     */
   /* public static void main(String[] args) throws Exception {
        client client = new client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }*/
    
   /* public void start()
    {
    	
    	//Thread t2 = new Thread();
    	System.out.println(t.getName());
		t.start();
    }*/

}

