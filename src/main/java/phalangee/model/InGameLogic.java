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
	private Timer timer;
	private int carot;
	private String[] wordArr;
	private String typedWord;
	private String[] paragraphs;
	
	
	public InGameLogic(GUIInGame game){
		
		this.fullParagraphStr = game.getParagraph().getText();
		this.typedWord = game.getInputField().getText();
		this.carot = 0;
		this.wordArr = this.fullParagraphStr.split(" ");
		this.numWordsEntered = 0;
		this.typingStarted = false;
		this.paragraphs = new String[2];
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
	
	public Timer getTimer() {
		return this.timer;
	}
	
	public void stopTimer() {
		this.timer.stop();
	}

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
			return 0;
		}
		return -1;
	}
	
	
	
	/**
	 * advances the bolded word of the paragraph on the main view depending on if the user typed it in correctly or not
	 */
	public String[] getNextWord() {
		String[] paras = new String[2];
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
	
	
	public void updateVars(GUIInGame game) {
		this.fullParagraphStr = game.getParagraph().getText();
		this.typedWord = game.getInputField().getText();
	}
	
}
