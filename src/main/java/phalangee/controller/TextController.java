package phalangee.controller;
import phalangee.view.*;
import phalangee.model.*;
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



/**
 * The controller for the Phalangee project; handles manipulations to the components of the main window
 *    
 * @author Peter Apazidis
 */
public class TextController {

	private static GUILogin loginWin;
	private static GUIInGame inGameWin;
	private static GUICreateAccount createAccountWin;
	private static GUIGameModes gameModesWin;
	private static CreateAccountLogic createAccountLogic;
	private static InGameLogic inGameLogic;
	private static LoginLogic loginLogic;
	private JTextPane paragraph;
	private JTextField typedWord;
	private String[] wordArr;
	private JButton createAccountBtn;
	private JButton confirmAccountBtn;
	
	
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
		
		this.loginWin = new GUILogin(this);
		this.inGameWin = new GUIInGame(this);
		this.createAccountWin = new GUICreateAccount(this);
		this.gameModesWin = new GUIGameModes(this);
		this.inGameLogic = new InGameLogic(this.inGameWin);
		
		this.paragraph = inGameWin.getParagraph();
		this.typedWord = inGameWin.getInputField();
		this.wordArr = paragraph.getText().split(" ");
		
		this.createAccountBtn = this.loginWin.getCreateAccountBtn();
		
		this.confirmAccountBtn = this.createAccountWin.getConfBtn();

//		fullParagraphStr = paragraph.getText();
//		numWordsEntered = 0;
//		carot = 0;
//		
		
	}
	
	/*
	 * opens up the Login Window for the user to interact with
	 */
	public void start() {
//		inGameWin.advanceWord(0, getNextBold());
//		inGameWin.setVisible(true);
		this.loginWin.setVisible(true); //uncomment this part for the program to run as intended
	}
	
	
	public void listenCreateAccountBtn(){
		loginWin.setVisible(false);
    	createAccountWin.setVisible(true);
	}
	
	public void listenBackBtn() {
		this.createAccountWin.setVisible(false);
		this.loginWin.setVisible(true);
	}
	
	
	public void listenConfirmAccountBtn(){
		String username = createAccountWin.getUsernameField().getText();
		String password = createAccountWin.getPasswordField().getText();
    	int createAccountResultCode = PhalangeeMongoDB.createAccount(username, password);
    	
    	if(createAccountResultCode == 1) {
    		loginWin.setVisible(true);
	    	createAccountWin.setVisible(false);
    	}else if(createAccountResultCode == 0) {
    		createAccountWin.setUserInputLbl("An account with the same user name already exists");
    	} else if(createAccountResultCode == -1) {
    		createAccountWin.setUserInputLbl("Invalid user name or password supplied");
    	}else {
    		System.out.println("ERROR: createAccountResultCode HAS AN INCORRECT VALUE");
    	}
	}
	public void listenLoginBtn() {
		String username = loginWin.getUsernameInputTxt().getText();
		String password = String.valueOf(loginWin.getPasswordInputTxt().getPassword());
		boolean validLogin = PhalangeeMongoDB.userLogin(username, password);
		if(validLogin) {
			loginWin.setVisible(false);
			gameModesWin.setVisible(true);
		}
	}
	
	
	public void listenNormalGamemodeBtn() {
		gameModesWin.setVisible(false);
		
		inGameWin.advanceWord(0, getNextBold());
		inGameWin.setVisible(true);
	}
	
	/*
	 * When a word is fully typed into the text field of the GUIInGame window, this method listens to the keyboard for the spacebar. If the spacebar is 
	 * pressed, it will signify the end of the typed word and the InGameLogic classes handles whether to proceed to the next word in the paragraph
	 * or have the user type in the word again due to a misspelling
	 */
	public void listenTypedWord(KeyEvent arg0) {
		inGameLogic.updateVars(inGameWin);
		int enterWordCode = inGameLogic.enterWord(arg0);
		if(enterWordCode != 0) {
			inGameWin.setInputField(null);
			if(enterWordCode == -1) {
				inGameLogic.incrMistypedWords();
				inGameLogic.incrTotalWords();
				inGameWin.setMistypedLbl(inGameLogic.getMistypedWords());
			}else if(enterWordCode == 1) {
				inGameWin.advanceWord(inGameLogic.getNumWordsEntered(), inGameLogic.getNextWord());
				inGameLogic.incrTotalWords();
			}
		} 
		if(!(inGameLogic.getTotalWords() == 0)) {
			double total = inGameLogic.getTotalWords();
			double missed = inGameLogic.getMistypedWords();
			double accuracy = Math.round(((total - missed)  / total) * 100);
			inGameWin.setAccuracyLbl(accuracy);
		}

	}
	
	public String[] getNextBold() {
		
		inGameLogic.updateVars(inGameWin);
		return inGameLogic.getNextWord();
	}
	
	/**
	 * called when the user starts typing their first word of the entire execution of the program; initiates the timer 
	 */
	public void listenForStartInput() {
		inGameLogic.updateVars(inGameWin);
		Boolean typingStarted = inGameLogic.getTypingStarted();
		if(typingStarted == false) {
			inGameLogic.setTypingStarted(true);
			final int init_s = (int)System.currentTimeMillis() / 1000;
			inGameLogic.setTimer(new Timer(1000, new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int secs = ((int)System.currentTimeMillis() / 1000) - init_s;
					if(secs >= 61) {
						inGameLogic.stopTimer();
						inGameWin.displayTimeOrScore("WPM: " + inGameLogic.getNumWordsEntered());
						String username = loginWin.getUsernameInputTxt().getText();
						int mistyped = inGameLogic.getMistypedWords();
						int numWordsEntered = inGameLogic.getNumWordsEntered();
						//TODO make it so "normal" isnt hard coded as the game mode value
						PhalangeeMongoDB.recordEndGameData(username, numWordsEntered, "normal", mistyped);
						
					}
					else {
						inGameWin.displayTimeOrScore(secs);
					}
				}
			}));
			inGameLogic.startTimer();
		}
	}
	
	
	
	
	
	
}
