package phalangee.model;
import phalangee.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;



public class InGameLogic {
	
	private InGameLogic gameLogic;
	private int numWordsEntered;
	private boolean typingStarted;
	private String fullParagraphStr;
	private int mistypedWords;
	private int totalWords;
	private Timer timer;
	private int carot;
	private String[] wordArr;
	private String typedWord;
	private String gameMode;
	private int paragraphID;
	
	public InGameLogic(GUIInGame game){
		
		this.fullParagraphStr = game.getParagraph().getText();
		this.typedWord = game.getInputField().getText();
		this.carot = 0;
		this.wordArr = this.fullParagraphStr.split(" ");
		this.numWordsEntered = 0;
		this.typingStarted = false;
		this.mistypedWords = 0;
		this.totalWords = 0;
		this.gameMode = "";
		this.paragraphID = -1;
	}
	
	public InGameLogic getInstance(GUIInGame game) {
		if(gameLogic == null) {
			gameLogic = new InGameLogic(game);
		}
		return gameLogic;
	}
	
	public int getNumWordsEntered() {
		return this.numWordsEntered;
	}
	
	public boolean getTypingStarted() {
		return this.typingStarted;
	}
	
	public void setTypingStarted(boolean isStarted) {
		this.typingStarted = isStarted;
	}
	
	public void setTimer(Timer timer) {
		 this.timer = timer;
	}
	public Timer getTimer() {
		 return this.timer;
	}
	public int getMistypedWords() {
		return this.mistypedWords;
	}
	public void incrMistypedWords() {
		this.mistypedWords++;
	}
	public int getTotalWords() {
		return this.totalWords;
	}
	public void incrTotalWords() {
		this.totalWords++;
	}
	public void stopTimer() {
		this.timer.stop();
	}
	public void startTimer() {
		this.timer.start();
	}
	public void setGameMode(String mode) {
		 this.gameMode = mode;
	}
	public String getGameMode() {
		 return this.gameMode;
	}
	public void setParagraphID(int id) {
		 this.paragraphID = id;
	}
	public int getParagraphID() {
		 return this.paragraphID;
	}

	//called whenever a letter is typed in the text field of the GUIInGame window. Typing a space signifies that a user is done typing 
	//a word. This method returns a code:
	// 1: The user typed a space and the word in the text field corresponds to the bolded word in the paragraph pane
	// 0: The user typed a letter and is still typing
	// -1: The user typed an incorrect word
	public int enterWord(KeyEvent e) {
		//when the user types a space (key code = 32) checks whether the currently typed word is the same as the word that is bolded in the view
		if(e.getKeyCode() == 32) {
			String enteredStr = typedWord;
			if(enteredStr.charAt(0) == ' ') {
				enteredStr = enteredStr.substring(1);
			}
			if(enteredStr.equals(wordArr[numWordsEntered - 1]) && numWordsEntered > 0) {
				return 1;
			}
			return -1;
		}
		return 0;
	}
	
	
	
	/**
	 * advances the bolded word of the paragraph on the main view depending on if the user typed it in correctly or not
	 */
	public String[] getNextWord() {
		String[] paras = new String[2];  //stores 2 paragraphs: the subparagraph before the bolded word and the subparagraph after.
		//if no words were entered then the paras array at index 0 will be the whole paragraph
		if(numWordsEntered == 0) {
			String subPara = fullParagraphStr.substring(wordArr[0].length());
			carot = wordArr[numWordsEntered].length() + 1;
			paras[0] = subPara;
			paras[1] = "";
			
		}
		else {
			String followingText = fullParagraphStr.substring(carot);
			String precedingText = "";
			int i = 0;
			//iterates through the word array, the array of all words in the paragraph, and adds it to the preceding text until the 
			//index of the bolded word is found
			while(i < numWordsEntered) {
				precedingText = precedingText + wordArr[i] + " ";
				i++;
			}
			paras[0] = precedingText;
			paras[1] = followingText;
		}
		numWordsEntered++;
		carot = wordArr[numWordsEntered].length() + carot + 1;
		return paras;
	}
	
	//updates variables in this class that rely directly on GUI variables
	public void updateVars(GUIInGame game) {
		this.fullParagraphStr = game.getParagraph().getText();
		this.typedWord = game.getInputField().getText();
	}
	
}
