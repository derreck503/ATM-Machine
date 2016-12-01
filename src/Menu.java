import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Menu{
	private JFrame frame;
	private JTextField depositAmountField;
	private JTextField currentPasswordField;
	private JTextField newPasswordField;
	private JTextField btnWithdraw;
	private JTextField TransferField;
	private JTextField routingField;
	private JTextField accountField;
	private JTextField passwordField;
	public static int username;
	public static String password;
	public static String firstname; 
	public static String lastname; 
	public static double balance;
	public static String status;
		
	public static void main(String[] args) {
		
		File file = new File("Password.txt");
		
		try (Scanner scanner = new Scanner(file);){			
			username = scanner.nextInt();
			password = scanner.next();
			firstname = scanner.next();
			lastname = scanner.next();
			balance = scanner.nextDouble();
			status = scanner.next();
		}
		catch(FileNotFoundException a)
		{
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		initialize();
	}

	private void initialize() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
	
		final JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_11044714222710");
		panelLogin.setLayout(null);
		panelLogin.setVisible(true);
		
		final JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_11047080924008");
		panelMenu.setLayout(null);
		panelLogin.setVisible(false);
		panelMenu.setVisible(false);
		
		final JPanel panelDeposit = new JPanel();
		frame.getContentPane().add(panelDeposit, "name_11052924782971");
		panelDeposit.setLayout(null);
		panelDeposit.setVisible(false);
		
		final JPanel panelChangePassword = new JPanel();
		frame.getContentPane().add(panelChangePassword, "name_12345290882113");
		panelChangePassword.setLayout(null);
		panelChangePassword.setVisible(false);
		
		final JPanel panelWithdraw = new JPanel();
		frame.getContentPane().add(panelWithdraw, "name_12353097951397");
		panelWithdraw.setLayout(null);
		panelWithdraw.setVisible(false);
		
		final JPanel panelMakeTransfer = new JPanel();
		frame.getContentPane().add(panelMakeTransfer, "name_12356536444602");
		panelMakeTransfer.setLayout(null);
		panelMakeTransfer.setVisible(false);
		
		final JPanel Logout = new JPanel();
		frame.getContentPane().add(Logout, "name_12374939116510");
		Logout.setLayout(null);
		Logout.setVisible(false);
		
		JLabel lblBankOfHouston = new JLabel("Banking ATM");
		lblBankOfHouston.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankOfHouston.setBounds(173, 31, 236, 54);
		panelLogin.add(lblBankOfHouston);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setBounds(42, 124, 117, 25);
		panelLogin.add(lblAccountNumber);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(94, 168, 65, 16);
		panelLogin.add(lblPassword);
		
		accountField = new JTextField();
		accountField.setBounds(162, 122, 170, 29);
		panelLogin.add(accountField);
		accountField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(164, 161, 168, 30);
		panelLogin.add(passwordField);
		passwordField.setColumns(10);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String userNam = accountField.getText();
				int userName = Integer.parseInt(userNam);
			
				String userPass = passwordField.getText();
				
				if(userName == username && userPass.equals(password))
				{
					accountField.setText("");
					passwordField.setText("");
					panelLogin.setVisible(false);
					panelMenu.setVisible(true);
					panelDeposit.setVisible(false);
					panelChangePassword.setVisible(false);
					panelWithdraw.setVisible(false);
					panelMakeTransfer.setVisible(false);
					Logout.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Either your password or username is incorrect, so please try again!");
				}
			}
		}
				
		);
		LoginButton.setBounds(162, 205, 117, 29);
		panelLogin.add(LoginButton);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		label.setIcon(new ImageIcon(img)); 
		label.setBounds(75, 6, 91, 96);
		panelLogin.add(label);
		
		JLabel label_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/card.png")).getImage();
		label_1.setIcon(new ImageIcon(img1)); 
		label_1.setBounds(316, 196, 117, 76);
		panelLogin.add(label_1);
		
		JLabel lblCardIsInserted = new JLabel("Card is Inserted");
		lblCardIsInserted.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblCardIsInserted.setBounds(342, 177, 91, 16);
		panelLogin.add(lblCardIsInserted);
		
		JButton CheckButton = new JButton("Check Balance");
		CheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String balanceAmt = currency.format(balance);
				JOptionPane.showMessageDialog(null,"Your current balance is $" + balanceAmt);
				panelLogin.setVisible(false);
				panelMenu.setVisible(true);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		CheckButton.setBounds(44, 162, 129, 40);
		panelMenu.add(CheckButton);
		
		JButton MakeaTransferButton = new JButton("Make a Transfer");
		MakeaTransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelLogin.setVisible(false);
				panelMenu.setVisible(false);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(true);
				Logout.setVisible(false);
			}
		});
		MakeaTransferButton.setBounds(254, 162, 129, 40);
		panelMenu.add(MakeaTransferButton);
		
		JButton ChangePasswordButton = new JButton("Change Password");
		ChangePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelLogin.setVisible(false);
				panelMenu.setVisible(false);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(true);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		ChangePasswordButton.setBounds(44, 214, 129, 40);
		panelMenu.add(ChangePasswordButton);
		
		JButton DepositButton = new JButton("Deposit");
		
		DepositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelLogin.setVisible(false);
				panelMenu.setVisible(false);
				panelDeposit.setVisible(true);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		DepositButton.setBounds(44, 110, 129, 40);
		panelMenu.add(DepositButton);
		
		JButton WithdrawButton = new JButton("Withdraw");
		
		WithdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panelLogin.setVisible(false);
				panelMenu.setVisible(false);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(true);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		WithdrawButton.setBounds(254, 110, 129, 40);
		panelMenu.add(WithdrawButton);
		
		JButton LogoutButton = new JButton("Logout");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				File file = new File("Password.txt");

				try (PrintWriter printWriter = new PrintWriter(file);){			
					printWriter.print(username + " ");
					printWriter.print(password + " ");
					printWriter.print(firstname + " ");
					printWriter.print(lastname + " ");
					printWriter.print(balance + " ");
					printWriter.print(status);
					printWriter.close();
				}
				catch(FileNotFoundException a)
				{
					
				}
								
				panelLogin.setVisible(false);
				panelMenu.setVisible(false);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(true);
			}
		});
		
		LogoutButton.setBounds(254, 214, 129, 40);
		panelMenu.add(LogoutButton);
	
		JLabel lblSelectAnOption = new JLabel("Please select an option!");
		lblSelectAnOption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSelectAnOption.setBounds(124, 68, 251, 52);
		panelMenu.add(lblSelectAnOption);
		
		JLabel lblBankingAtm = new JLabel("Banking ATM");
		lblBankingAtm.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankingAtm.setBounds(165, 13, 200, 52);
		panelMenu.add(lblBankingAtm);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img2 = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2)); 
		lblNewLabel.setBounds(56, 6, 97, 78);
		panelMenu.add(lblNewLabel);
		
		depositAmountField = new JTextField();
		
		depositAmountField.setBounds(137, 156, 158, 36);
		panelDeposit.add(depositAmountField);
		depositAmountField.setColumns(10);
		
		JButton depositbutton = new JButton("Deposit");
		depositbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String depositAmount = depositAmountField.getText();
				double depositAmt = Double.parseDouble(depositAmount);
			
				depositAmountField.setText("");
				
				if(depositAmt > 0)
				{
					balance += depositAmt;
					String balanceAmt = currency.format(balance);
					JOptionPane.showMessageDialog(null,"Your new balance will be " + balanceAmt);

					panelLogin.setVisible(false);
					panelMenu.setVisible(true);
					panelDeposit.setVisible(false);
					panelChangePassword.setVisible(false);
					panelWithdraw.setVisible(false);
					panelMakeTransfer.setVisible(false);
					Logout.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Error: Please enter a valid deposit amount");
				}
			}
		}
		);
		
		depositbutton.setBounds(151, 204, 123, 36);
		panelDeposit.add(depositbutton);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the amount you wish to deposit.");
		lblPleaseEnterThe.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPleaseEnterThe.setBounds(44, 103, 387, 52);
		panelDeposit.add(lblPleaseEnterThe);
		
		JLabel lblBankingAtm_1 = new JLabel("Banking ATM");
		lblBankingAtm_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankingAtm_1.setBounds(172, 17, 229, 63);
		panelDeposit.add(lblBankingAtm_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img3)); 
		lblNewLabel_1.setBounds(65, 6, 113, 85);
		panelDeposit.add(lblNewLabel_1);
		
		JButton btnReturnToMain_1 = new JButton("Return to Main Menu");
		btnReturnToMain_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelMenu.setVisible(true);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		btnReturnToMain_1.setBounds(286, 236, 158, 36);
		panelDeposit.add(btnReturnToMain_1);
				
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblChangePassword.setBounds(151, 90, 159, 42);
		panelChangePassword.add(lblChangePassword);
		
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setBounds(38, 133, 114, 27);
		panelChangePassword.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(55, 172, 101, 21);
		panelChangePassword.add(lblNewPassword);
		
		currentPasswordField = new JPasswordField();
		
		currentPasswordField.setBounds(151, 133, 143, 26);
		panelChangePassword.add(currentPasswordField);
		
		newPasswordField = new JPasswordField();
		
		newPasswordField.setBounds(151, 169, 143, 26);
		panelChangePassword.add(newPasswordField);
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String currentPassword = currentPasswordField.getText();
				String newPassword = newPasswordField.getText();
				
				if(currentPassword.equals(password))
				{
					JOptionPane.showMessageDialog(null,"Successful password change!");
					password = newPassword;
					System.out.println(password);
					currentPasswordField.setText("");
					newPasswordField.setText("");
					panelLogin.setVisible(false);
					panelMenu.setVisible(false);
					panelDeposit.setVisible(false);
					panelChangePassword.setVisible(true);
					panelWithdraw.setVisible(false);
					panelMakeTransfer.setVisible(false);
					Logout.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The current password is incorrect. Please try again!");				
					currentPasswordField.setText("");
					newPasswordField.setText("");
				}
			}
		});
		btnEnter.setBounds(161, 205, 117, 29);
		panelChangePassword.add(btnEnter);
		
		JButton btnReturnToMain_4 = new JButton("Return to Main Menu");
		btnReturnToMain_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelMenu.setVisible(true);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		btnReturnToMain_4.setBounds(285, 230, 159, 36);
		panelChangePassword.add(btnReturnToMain_4);
		
		JLabel lblBankingAtm_2 = new JLabel("Banking ATM");
		lblBankingAtm_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankingAtm_2.setBounds(159, 23, 202, 59);
		panelChangePassword.add(lblBankingAtm_2);
		
		JLabel label_2 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		label_2.setIcon(new ImageIcon(img4)); 
		label_2.setBounds(51, 6, 101, 84);
		panelChangePassword.add(label_2);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount:");
		lblEnterAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEnterAmount.setBounds(38, 153, 115, 35);
		panelWithdraw.add(lblEnterAmount);
		
		btnWithdraw = new JTextField();
		
		btnWithdraw.setBounds(154, 153, 136, 35);
		panelWithdraw.add(btnWithdraw);
		btnWithdraw.setColumns(10);
		
		JButton btnWithdrawEnterButton = new JButton("Withdraw");
		btnWithdrawEnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String withdrawAmount = btnWithdraw.getText();
				double withdrawAmt = Double.parseDouble(withdrawAmount);
				
				btnWithdraw.setText("");
				
				if(withdrawAmt <= balance && balance > 0)
				{	
					balance -= withdrawAmt;
				
					btnWithdraw.setText("");
					String balanceAmt = currency.format(balance);
					JOptionPane.showMessageDialog(null,"Your new balance will be " + balanceAmt);			
					panelLogin.setVisible(false);
					panelMenu.setVisible(true);
					panelDeposit.setVisible(false);
					panelChangePassword.setVisible(false);
					panelWithdraw.setVisible(false);
					panelMakeTransfer.setVisible(false);
					Logout.setVisible(false);
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Error: Insufficient Balance");				
				}
			}
		});
		btnWithdrawEnterButton.setBounds(164, 198, 117, 29);
		panelWithdraw.add(btnWithdrawEnterButton);
		
		JButton button = new JButton("Return to Main Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(false);
				panelMenu.setVisible(true);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		button.setBounds(289, 222, 155, 35);
		panelWithdraw.add(button);
		
		JLabel lblPleaseEnterThe_1 = new JLabel("Please enter the amount you wish to withdraw.");
		lblPleaseEnterThe_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPleaseEnterThe_1.setBounds(38, 105, 373, 55);
		panelWithdraw.add(lblPleaseEnterThe_1);
		
		JLabel lblBankingAtm_3 = new JLabel("Banking ATM");
		lblBankingAtm_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankingAtm_3.setBounds(164, 25, 197, 72);
		panelWithdraw.add(lblBankingAtm_3);
		
		JLabel label_3 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		label_3.setIcon(new ImageIcon(img5)); 
		label_3.setBounds(50, 9, 115, 88);
		panelWithdraw.add(label_3);
	
		JLabel lblMakeATransfer = new JLabel("Make a Transfer");
		lblMakeATransfer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblMakeATransfer.setBounds(144, 123, 176, 33);
		panelMakeTransfer.add(lblMakeATransfer);
		
		JLabel lblEnterAmount_1 = new JLabel("Enter amount:");
		lblEnterAmount_1.setBounds(66, 168, 88, 16);
		panelMakeTransfer.add(lblEnterAmount_1);
		
		TransferField = new JTextField();
		
		TransferField.setBounds(170, 163, 130, 26);
		panelMakeTransfer.add(TransferField);
		TransferField.setColumns(10);
		
		JButton btnEnter_1 = new JButton("Transfer");
		btnEnter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String transferAmount = TransferField.getText();
				double transferAmt = Double.parseDouble(transferAmount);
				
				String routingNumber = routingField.getText(); 
				
				balance -= transferAmt;
				
				btnWithdraw.setText("");
				
				JOptionPane.showMessageDialog(null,"$" + transferAmt + " will be transfered to Account #" + routingNumber);	
				
				panelLogin.setVisible(false);
				panelMenu.setVisible(true);
				panelDeposit.setVisible(false);
				panelChangePassword.setVisible(false);
				panelWithdraw.setVisible(false);
				panelMakeTransfer.setVisible(false);
				Logout.setVisible(false);
			}
		});
		
		btnEnter_1.setBounds(183, 219, 117, 29);
		panelMakeTransfer.add(btnEnter_1);
		
		JLabel lblRoutingNumber = new JLabel("Routing Number:");
		lblRoutingNumber.setBounds(51, 195, 107, 16);
		panelMakeTransfer.add(lblRoutingNumber);
		
		routingField = new JTextField();
		
		routingField.setBounds(170, 190, 130, 26);
		panelMakeTransfer.add(routingField);
		routingField.setColumns(10);
		
		JLabel lblBankingAtm_4 = new JLabel("Banking ATM");
		lblBankingAtm_4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankingAtm_4.setBounds(170, 39, 204, 52);
		panelMakeTransfer.add(lblBankingAtm_4);
		
		JLabel label_4 = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		label_4.setIcon(new ImageIcon(img6)); 
		label_4.setBounds(66, 26, 102, 85);
		panelMakeTransfer.add(label_4);
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						panelLogin.setVisible(false);
						panelMenu.setVisible(true);
						panelDeposit.setVisible(false);
						panelChangePassword.setVisible(false);
						panelWithdraw.setVisible(false);
						panelMakeTransfer.setVisible(false);
						Logout.setVisible(false);
			}
		});
		btnReturnToMain.setBounds(277, 243, 167, 29);
		panelMakeTransfer.add(btnReturnToMain);
	
		JLabel lblThankYouFour = new JLabel("Thank you for Banking with us! Have a great day!");
		lblThankYouFour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblThankYouFour.setBounds(41, 113, 382, 91);
		Logout.add(lblThankYouFour);
		
		JLabel lblBankingAtm_5 = new JLabel("Banking ATM");
		lblBankingAtm_5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblBankingAtm_5.setBounds(157, 32, 193, 55);
		Logout.add(lblBankingAtm_5);
		
		JLabel label_5 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/uh.png")).getImage();
		label_5.setIcon(new ImageIcon(img7)); 
		label_5.setBounds(56, 16, 98, 85);
		Logout.add(label_5);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						panelLogin.setVisible(true);
						panelMenu.setVisible(false);
						panelDeposit.setVisible(false);
						panelChangePassword.setVisible(false);
						panelWithdraw.setVisible(false);
						panelMakeTransfer.setVisible(false);
						Logout.setVisible(false);
					}
				
		});
		btnNewButton.setBounds(302, 225, 117, 29);
		Logout.add(btnNewButton);
	}
}

