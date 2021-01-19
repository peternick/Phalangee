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
	private GUIInGame gameGUI;
	private int numWordsEntered;
	private boolean typingStarted;
	private String fullParagraphStr;
	private Timer timer;
	private int carot;
	private String[] wordArr;
	private JTextPane paragraph;
	private JTextField typedWord;
	
	
	private InGameLogic(GUIInGame game){
		this.paragraph = game.getParagraph();
		this.fullParagraphStr = paragraph.getText();
		this.typedWord = game.getInputField();
		this.carot = 0;
		this.wordArr = paragraph.getText().split(" ");
		this.gameGUI = game;
		this.numWordsEntered = 0;
		this.typingStarted = false;
	}
	
	public InGameLogic getInstance(GUIInGame game) {
		if(gameLogic == null) {
			gameLogic = new InGameLogic(game);
		}
		return gameLogic;
	}

	public void enterWord(KeyEvent e) {
		//when the user types a space (key code = 32) checks whether the currently typed word is the same as the word that is bolded in the view
		if(e.getKeyCode() == 32) {
			String enteredStr = typedWord.getText();
			if(enteredStr.charAt(0) == ' ') {
				enteredStr = enteredStr.substring(1);
			}
			if(enteredStr.equals(wordArr[numWordsEntered - 1]) && numWordsEntered > 0) {
				this.getNextWord();
			}
			typedWord.setText(null);
		}
	}
	
	/**
	 * called when the user starts typing their first word of the entire execution of the program; initiates the timer 
	 */
	public void listenForStartInput() {
		typedWord.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
			}
	
			
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(typingStarted == false) {
					typingStarted = true;
					final int init_s = (int)System.currentTimeMillis() / 1000;
					timer = new Timer(1000, new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							int secs = ((int)System.currentTimeMillis() / 1000) - init_s;
							if(secs == 61) {
								timer.stop();
								gameGUI.displayTimeOrScore("WPM: " + numWordsEntered);
								
							}
							else {
								gameGUI.displayTimeOrScore(secs);
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
	
	
	/**
	 * advances the bolded word of the paragraph on the main view depending on if the user typed it in correctly or not
	 */
	public void getNextWord() {
		if(numWordsEntered == 0) {
			String subPara = fullParagraphStr.substring(wordArr[numWordsEntered].length());
			paragraph.setText(subPara);
			StyledDocument doc = paragraph.getStyledDocument();
			SimpleAttributeSet attr = new SimpleAttributeSet();
			StyleConstants.setBold(attr, true);
			try {
				doc.insertString(0, wordArr[numWordsEntered], attr);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			carot = wordArr[numWordsEntered].length() + 1;
		}
		else {
			String followingText = fullParagraphStr.substring(carot);
			String precedingText = "";
			int i = 0;
			while(i < numWordsEntered) {
				precedingText = precedingText + wordArr[i] + " ";
				i++;
			}
			paragraph.setText(precedingText + " " + followingText);
			StyledDocument doc = paragraph.getStyledDocument();
			SimpleAttributeSet attr = new SimpleAttributeSet();
			StyleConstants.setBold(attr, true);
			try {
				doc.insertString(precedingText.length(), wordArr[numWordsEntered], attr);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
		numWordsEntered++;
		carot = wordArr[numWordsEntered].length() + carot + 1;
	}
	
	
	public JTextField getMainTextField() {
		return this.typedWord;
	}
}
