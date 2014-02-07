package application_GUI;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import clients.client;
import clients.initilaize;

public class newgame_Dialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text server_address;
	private Text player_name;
//	private client c = new client();
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public newgame_Dialog(Shell parent) {
		super(parent);
		setText("New Game");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent());
		shell.setSize(621, 204);
		shell.setText(getText());
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.setBounds(499, 141, 75, 25);
		btnSubmit.setText("Submit");
		
		server_address = new Text(shell, SWT.BORDER);
		server_address.setText("127.0.0.1");
		server_address.setBounds(193, 27, 180, 21);
		
		player_name = new Text(shell, SWT.BORDER);
		player_name.setText("waseem");
		player_name.setBounds(193, 77, 180, 21);
		
		Label lblEnterServerAddress = new Label(shell, SWT.NONE);
		lblEnterServerAddress.setBounds(31, 30, 169, 15);
		lblEnterServerAddress.setText("Enter server address");
		
		Label lblEnterUserName = new Label(shell, SWT.NONE);
		lblEnterUserName.setBounds(31, 80, 156, 15);
		lblEnterUserName.setText("Enter user name");
		
		final Button btnRunTheServer = new Button(shell, SWT.CHECK);
		btnRunTheServer.setSelection(true);
		btnRunTheServer.setBounds(31, 141, 93, 16);
		btnRunTheServer.setText("Run the server");
		
		
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(server_address.getText()==""||player_name.getText()=="")
				{
					MessageDialog.openError(shell, "Error", "Enter the Server address and the Plyer name");
				}
				else
				{
					initilaize.c.setServerAddress(server_address.getText());
					initilaize.p.setName(player_name.getText());
					//initilaize.c.getOut().print(player_name.getText());
				//	initilaize.setOpen_Server(btnRunTheServer.getSelection());
					shell.dispose();
				}
			
				
				
			}
		});

	}
}
