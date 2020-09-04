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

	private static int numWordsEntered;
	private static boolean typingStarted = false;
	private JTextPane paragraph;
	private final String fullParagraphStr;
	private JTextField typedWord;
	private MainView view;
	private Timer timer;
	private static int carot;
	private String[] wordArr;
	
	/**
	 * The constructor for the TextController class takes in the one instance of the MainView class that sets up the GUI of the application.
	 * This instance is used to reference the different components so that they can be manipulated accordingly. 
	 * 
	 * @param mainView the view of the application consisting of a JFrame containing JComponents
	 */
	public TextController(MainView mainView) {
		paragraph = mainView.getParagraph();
		fullParagraphStr = paragraph.getText();
		typedWord = mainView.getInputField();
		numWordsEntered = 0;
		carot = 0;
		wordArr = paragraph.getText().split(" ");
		this.view = mainView;
		
	}
	
	public void start() {
		listenForStartInput();
		input_handler();
		getNextWord();
	}
	
	/**
	 * handles text input from the user 
	 */
	public void input_handler() {
		typedWord.addKeyListener(new KeyListener() {

			//when the user types a space (key code = 32) checks whether the typed word is the same as the word that is bolded in the view
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 32) {
					String enteredStr = typedWord.getText();
					if(enteredStr.charAt(0) == ' ') {
						enteredStr = enteredStr.substring(1);
					}
					if(enteredStr.equals(wordArr[numWordsEntered - 1]) && numWordsEntered > 0) {
						getNextWord();
					}
					typedWord.setText(null);
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {

			}
			@Override
			public void keyTyped(KeyEvent e) {

			}
			
		});
	}
	
	/**
	 * called when the user starts typing their first word of the entire execution of the program; initiates the timer 
	 */
	public void listenForStartInput() {
		typedWord.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
			}
	
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(typingStarted == false) {
					typingStarted = true;
					int init_s = (int)System.currentTimeMillis() / 1000;
					timer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							int secs = ((int)System.currentTimeMillis() / 1000) - init_s;
							if(secs == 61) {
								timer.stop();
								view.displayTimeOrScore("WPM: " + numWordsEntered);
								
							}
							else {
								view.displayTimeOrScore(secs);
							}
						}
					});	
					timer.start();
				}
			}
	
			@Override
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
	
}
