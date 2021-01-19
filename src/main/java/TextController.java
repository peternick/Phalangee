import phalangee.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import phalangee.model.*;

/**
 * The controller for the Phalangee project; handles manipulations to the components of the main window
 *    
 * @author Peter Apazidis
 */
public class TextController {

	private static GUILogin loginWin;
	private static GUIInGame inGameWin;
	private static GUICreateAccount createAccountWin;
	private static CreateAccountLogic createAccountLogic;
	private static InGameLogic inGameLogic;
	private static LoginLogic loginLogic;
	private JTextPane paragraph;
	private JTextField typedWord;
	private String[] wordArr;
	
//	private static int numWordsEntered;
//	private static boolean typingStarted = false;
//	private final String fullParagraphStr;
//	private Timer timer;
//	private static int carot;
//	
	
	/**
	 * The constructor for the TextController class takes in the one instance of the MainView class that sets up the GUI of the application.
	 * This instance is used to reference the different components so that they can be manipulated accordingly. 
	 * 
	 * @param mainView the view of the application consisting of a JFrame containing JComponents
	 */
	public TextController() {
		this.paragraph = inGameWin.getParagraph();
		this.typedWord = inGameWin.getInputField();
		this.wordArr = paragraph.getText().split(" ");
		this.loginWin = GUILogin.getInstance();
		this.inGameWin = GUIInGame.getInstance();
		this.createAccountWin = GUICreateAccount.getInstance();
		this.inGameLogic = inGameLogic.getInstance(this.inGameWin);
		
//		fullParagraphStr = paragraph.getText();
//		numWordsEntered = 0;
//		carot = 0;
//		
		
	}
	
	
	public void start() {
		this.loginWin.setVisible(true);
	}
	
	/*
	 * When a word is fully typed into the text field of the GUIInGame window, this method listens to the keyboard for the spacebar. If the spacebar is 
	 * pressed, it will signify the end of the typed word and the InGameLogic classes handles whether to proceed to the next word in the paragraph
	 * or have the user type in the word again due to a misspelling
	 */
	public void txt_input_handler() {
		this.typedWord.addKeyListener(new KeyListener() {

			//invokes the enterWord method of the InGameLogic class to signify the end of a user typed word
			public void keyPressed(KeyEvent arg0) {
				if((inGameLogic.enterWord(arg0)) == 0) {
					inGameWin.setInputField(null);
				} else if((inGameLogic.enterWord(arg0)) == 1) {
					inGameWin.advanceWord(inGameLogic, inGameLogic.getNextWord());
				}
			}
			
			public void keyReleased(KeyEvent e) {

			}
			public void keyTyped(KeyEvent e) {

			}
			
		});
	}
	
	
	/**
	 * called when the user starts typing their first word of the entire execution of the program; initiates the timer 
	 */
	public void listenForStartInput() {
		JTextField typedWord = this.inGameWin.getInputField();
		typedWord.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
			}
	
			
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Boolean typingStarted = inGameLogic.getTypingStarted();
				if(typingStarted == false) {
					typingStarted = true;
					final int init_s = (int)System.currentTimeMillis() / 1000;
					Timer timer = inGameLogic.getTimer();
					timer = new Timer(1000, new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							int secs = ((int)System.currentTimeMillis() / 1000) - init_s;
							if(secs == 61) {
								inGameLogic.stopTimer();;
								inGameWin.displayTimeOrScore("WPM: " + inGameLogic.getNumWordsEntered());
								
							}
							else {
								inGameWin.displayTimeOrScore(secs);
							}
						}
					});	
					timer.start();
				}
			}
	
			public void removeUpdate(DocumentEvent e) {
			}
		});
	}
	
	
	
	
}
