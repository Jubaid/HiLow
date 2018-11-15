import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;   // text field for the users guess
	private JLabel lblOutput;	   // label for too high/low output
	private int theNumber;         // the number we're trying to guess
	
	// checks the users guess if its too high or too low 
	public void checkGuess() {
		// get the users guess 
		String guessText = txtGuess.getText();
		String message = "";
		
		// check if the guess is too high or too low
		int guess = Integer.parseInt(guessText);	
		
		// too high
		if(guess > theNumber) 
		{
			message = guess + " was too high. Guess again!";
			lblOutput.setText(message);
		}
		// too low
		else if(guess < theNumber) 
		{
			message = guess + " was too low. Guess again!";
			lblOutput.setText(message);
		}
		else // guess correctly
		{
			message = guess + " was right! You Win! Lets play again!";
			lblOutput.setText(message);
			newGame();
		}
		
		txtGuess.requestFocus();
		txtGuess.selectAll();
	}
	
	public void newGame() { // create a new random number between 1 and 100 
		
		theNumber = (int)(Math.random() * 100 + 1); // 0 - 99
		
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblJubaidsHiloGuessing = new JLabel("Jubaids Hi-Lo Guessing Game");
		lblJubaidsHiloGuessing.setFont(new Font("Calibri", Font.BOLD, 20));
		lblJubaidsHiloGuessing.setBounds(-13, 20, 436, 58);
		lblJubaidsHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblJubaidsHiloGuessing);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 98, 361, 48);
		getContentPane().add(panel);
		panel.setLayout(null); 
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setBounds(33, 7, 219, 16);
		panel.add(lblGuessANumber);
		lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setBounds(257, 5, 96, 20);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(161, 166, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click guess");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(37, 209, 337, 31);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430, 330));
		theGame.setVisible(true);
		
	}
}
