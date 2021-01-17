import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import javax.swing.text.Highlighter.HighlightPainter;
/**
 * The main view of the application that displays the GUI
 *    
 * @author Peter Apazidis
 */
public class MainView extends JFrame{
	private static MainView mainView;
	private final static int FRAME_TOP_X = 200;
	private final static int FRAME_TOP_Y = 30;
	private final static int FRAME_BOTTOM_X = 1200;
	private final static int FRAME_BOTTOM_Y = 800;
	private JTextField typeField = new JTextField();
	private JTextPane paragraphPane = new JTextPane();  
	private JLabel timer = new JLabel("0");
	private JTextPane inputTextLabel = new JTextPane();
	private JPanel pan = new JPanel();
	
	/**
	 * the MainView object holds the components that the user sees in the JFrame window and sets their values
	 */
	private MainView() {
		this.setTitle("Phalangee: type tester");
		if(mainView != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
	
		/* initializes the pane holding the paragraph with contents and dimensions */
		paragraphPane.setPreferredSize(new Dimension(100, 600));
		paragraphPane.setMaximumSize(new Dimension(2000, 800));
		paragraphPane.setText(ParagraphGenerator.generate_paragraph());
		paragraphPane.setEditable(false);
		paragraphPane.setBackground(Color.YELLOW);
		
		/* initializes the pane holding the type field with contents and dimensions */
		typeField.setMinimumSize(new Dimension(100, 20));
		typeField.setPreferredSize(new Dimension(150, 30));
		typeField.setMaximumSize(new Dimension(200, 30));
		inputTextLabel.setText("Type the paragraph by each bolded word. Pressing space will end the word. To start the timer, type a letter.");
		inputTextLabel.setEditable(false);
		inputTextLabel.setMinimumSize(new Dimension(100, 20));
		inputTextLabel.setPreferredSize(new Dimension(200, 20));
		inputTextLabel.setMaximumSize(new Dimension(590, 20));
		
	    this.setBounds(FRAME_TOP_X, FRAME_TOP_Y, FRAME_BOTTOM_X, FRAME_BOTTOM_Y);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pan.add(paragraphPane);
	    pan.add(Box.createVerticalGlue());
	    pan.add(inputTextLabel);
	    pan.add(Box.createRigidArea(new Dimension(0, 10)));
	    pan.add(typeField);
	    pan.add(Box.createVerticalGlue());
	    pan.add(timer);
	    pan.add(Box.createRigidArea(new Dimension(15, 30)));
	    
	    this.add(pan);
	    this.setVisible(true);
	}
	
	/**
	 * @return JTextField the GUI component that the user uses to type text
	 */
	public JTextField getInputField() {
		return typeField;
	}
	
	/**
	 * @return the GUI component that holds the paragraph that the user types out
	 */
	public JTextPane getParagraph() {
		return paragraphPane;
	}
	
	/**
	 * @param newParagraph a randomly generated paragraph to be displayed on the GUI
	 */
	public void setParagraph(String newParagraph) {
		paragraphPane.setText(newParagraph);
	}
	
	/**
	 * @return the number of seconds that have elapsed since the user first started typing
	 */
	public int get_time() {
		return Integer.parseInt(timer.getText());
	}
	
	/**
	 * @param time displays the time elapsed since the user first started typing on the GUI or if one minute has passed the score is shown
	 */
	public void displayTimeOrScore(Object time) {
			timer.setText(time + ""); 
		
	}
	
	/**
	 * @return the single instance of the MainView class
	 */
	public static MainView getInstance() {
		if(mainView == null) {
			mainView = new MainView();
		}
		return mainView;
	}
}
