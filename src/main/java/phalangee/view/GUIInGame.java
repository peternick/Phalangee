package phalangee.view;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import phalangee.controller.TextController;
import phalangee.model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peternick
 */
public class GUIInGame extends javax.swing.JFrame {

	private GUIInGame game;
	private TextController controller;
	private javax.swing.JPanel BPBPSep;
    private javax.swing.JSeparator BPLPBPSep;
    private javax.swing.JSeparator BPLPLPSep;
    private javax.swing.JPanel BPLPMenuBtn;
    private javax.swing.JSeparator BPLPTPSep;
    private javax.swing.JPanel BPMPtxtArea;
    private javax.swing.JPanel BPRPRestartBtn;
    private javax.swing.JPanel BPTPSep;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JSeparator ParagraphLeftSep;
    private javax.swing.JSeparator ParagraphRightSep;
    private javax.swing.JLabel TPAcc;
    private javax.swing.JLabel TPTimeLbl;
    private javax.swing.JLabel TPmissedWrdsLbl;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JSeparator TopSep1;
    private javax.swing.JSeparator TopSep2;
    private javax.swing.JSeparator TopSep3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton menuBtn;
    private javax.swing.JTextPane paragraphPane;
    private javax.swing.JButton restartBtn;
    private javax.swing.JTextField typeField;
    private javax.swing.JLabel typeFieldDesc1;
    private javax.swing.JLabel typeFieldDesc2;
    
    /**
     * Creates new form GUIInGame
     */
    public GUIInGame(TextController controller) {
    	this.controller = controller;
        initComponents();
        
    }

    /**
	 * @return the GUI component that holds the paragraph that the user types out
	 */
    public JTextPane getParagraph() {
		return paragraphPane;
	}
    
    /**
	 * @return JTextField the GUI component that the user uses to type text
	 */
	public JTextField getInputField() {
		return typeField;
	}
	/**
	 * @param String text to set the input field to
	 */
	public void setInputField(String text) {
		this.typeField.setText(text);
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
		return Integer.parseInt(TPTimeLbl.getText());
	}
	
	/**
	 * @param time displays the time elapsed since the user first started typing on the GUI or if one minute has passed the score is shown
	 */
	public void displayTimeOrScore(Object time) {
		TPTimeLbl.setText("timer: " + time); 
		
	}
	public GUIInGame getInstance() {
		if(game == null) {
			game = new GUIInGame(controller);
		}
		return game;
	}
	
	public void advanceWord(int numWordsEntered, String[] subParagraphs) {
		String[] wordArr = paragraphPane.getText().split(" ");
		
		if(subParagraphs.length == 2) {
			if(subParagraphs[1] == "") {
				paragraphPane.setText(subParagraphs[0]);
				StyledDocument doc = paragraphPane.getStyledDocument();
				SimpleAttributeSet attr = new SimpleAttributeSet();
				StyleConstants.setBold(attr, true);
				try {
					doc.insertString(0, wordArr[numWordsEntered], attr);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}else {
				paragraphPane.setText(subParagraphs[0] + " " + subParagraphs[1]);
				StyledDocument doc = paragraphPane.getStyledDocument();
				SimpleAttributeSet attr = new SimpleAttributeSet();
				StyleConstants.setBold(attr, true);
				try {
					doc.insertString(subParagraphs[0].length(), wordArr[numWordsEntered], attr);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void setMistypedLbl(int numMistypedWords){
    	TPmissedWrdsLbl.setText("Mistyped Words: " + numMistypedWords);
    }
	
	public void setAccuracyLbl(double decimalPercentage){
		TPAcc.setText("% accuracy: " + decimalPercentage);
    }
    
	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	TopPanel = new javax.swing.JPanel();
        TopSep1 = new javax.swing.JSeparator();
        TPTimeLbl = new javax.swing.JLabel();
        TopSep2 = new javax.swing.JSeparator();
        TPmissedWrdsLbl = new javax.swing.JLabel();
        TopSep3 = new javax.swing.JSeparator();
        TPAcc = new javax.swing.JLabel();
        BottomPanel = new javax.swing.JPanel();
        BPBPSep = new javax.swing.JPanel();
        BPLPMenuBtn = new javax.swing.JPanel();
        BPLPLPSep = new javax.swing.JSeparator();
        BPLPTPSep = new javax.swing.JSeparator();
        BPLPBPSep = new javax.swing.JSeparator();
        menuBtn = new javax.swing.JButton();
        BPRPRestartBtn = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        restartBtn = new javax.swing.JButton();
        BPMPtxtArea = new javax.swing.JPanel();
        typeFieldDesc1 = new javax.swing.JLabel();
        typeFieldDesc2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        typeField = new javax.swing.JTextField();
        BPTPSep = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paragraphPane = new javax.swing.JTextPane();
        ParagraphLeftSep = new javax.swing.JSeparator();
        ParagraphRightSep = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(700, 500));
        centreWindow(this);

        TopPanel.setBackground(new java.awt.Color(203, 203, 203));
        TopPanel.setFocusTraversalPolicyProvider(true);
        TopPanel.setFocusable(false);
        TopPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        TopSep1.setBackground(new java.awt.Color(203, 203, 203));
        TopSep1.setForeground(new java.awt.Color(203, 203, 203));
        TopSep1.setMinimumSize(new java.awt.Dimension(100, 10));
        TopSep1.setOpaque(true);
        TopSep1.setPreferredSize(new java.awt.Dimension(30, 0));
        TopPanel.add(TopSep1);

        TPTimeLbl.setForeground(new java.awt.Color(60, 60, 60));
        TPTimeLbl.setText("Time:");
        TopPanel.add(TPTimeLbl);

        TopSep2.setBackground(new java.awt.Color(203, 203, 203));
        TopSep2.setForeground(new java.awt.Color(203, 203, 203));
        TopSep2.setMinimumSize(new java.awt.Dimension(150, 10));
        TopSep2.setOpaque(true);
        TopSep2.setPreferredSize(new java.awt.Dimension(150, 0));
        TopPanel.add(TopSep2);

        TPmissedWrdsLbl.setForeground(new java.awt.Color(60, 60, 60));
        TPmissedWrdsLbl.setText("Mistyped Words: 0");
        TPmissedWrdsLbl.setMaximumSize(new java.awt.Dimension(100, 30));
        TPmissedWrdsLbl.setMinimumSize(new java.awt.Dimension(130, 18));
        TPmissedWrdsLbl.setPreferredSize(new java.awt.Dimension(170, 30));
        TopPanel.add(TPmissedWrdsLbl);

        TopSep3.setBackground(new java.awt.Color(203, 203, 203));
        TopSep3.setForeground(new java.awt.Color(203, 203, 203));
        TopSep3.setMinimumSize(new java.awt.Dimension(80, 10));
        TopSep3.setOpaque(true);
        TopSep3.setPreferredSize(new java.awt.Dimension(100, 0));
        TopPanel.add(TopSep3);

        TPAcc.setForeground(new java.awt.Color(60, 60, 60));
        TPAcc.setText("% accuracy:");
        TPAcc.setMaximumSize(new java.awt.Dimension(90, 18));
        TPAcc.setMinimumSize(new java.awt.Dimension(90, 18));
        TPAcc.setPreferredSize(new java.awt.Dimension(140, 20));
        TopPanel.add(TPAcc);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);

        BottomPanel.setBackground(new java.awt.Color(203, 203, 203));
        BottomPanel.setMinimumSize(new java.awt.Dimension(10, 50));
        BottomPanel.setPreferredSize(new java.awt.Dimension(600, 100));
        BottomPanel.setLayout(new java.awt.BorderLayout());

        BPBPSep.setPreferredSize(new java.awt.Dimension(100, 20));
        BottomPanel.add(BPBPSep, java.awt.BorderLayout.PAGE_END);

        BPLPMenuBtn.setLayout(new java.awt.BorderLayout());

        BPLPLPSep.setMaximumSize(new java.awt.Dimension(32767, 0));
        BPLPLPSep.setMinimumSize(new java.awt.Dimension(50, 0));
        BPLPLPSep.setPreferredSize(new java.awt.Dimension(20, 0));
        BPLPMenuBtn.add(BPLPLPSep, java.awt.BorderLayout.LINE_START);

        BPLPTPSep.setOrientation(javax.swing.SwingConstants.VERTICAL);
        BPLPTPSep.setMaximumSize(new java.awt.Dimension(0, 32767));
        BPLPTPSep.setMinimumSize(new java.awt.Dimension(0, 10));
        BPLPTPSep.setPreferredSize(new java.awt.Dimension(0, 20));
        BPLPMenuBtn.add(BPLPTPSep, java.awt.BorderLayout.PAGE_START);

        BPLPBPSep.setOrientation(javax.swing.SwingConstants.VERTICAL);
        BPLPBPSep.setMaximumSize(new java.awt.Dimension(0, 32767));
        BPLPBPSep.setMinimumSize(new java.awt.Dimension(0, 10));
        BPLPBPSep.setPreferredSize(new java.awt.Dimension(0, 20));
        BPLPMenuBtn.add(BPLPBPSep, java.awt.BorderLayout.PAGE_END);

        menuBtn.setText("Main Menu");
        BPLPMenuBtn.add(menuBtn, java.awt.BorderLayout.CENTER);

        BottomPanel.add(BPLPMenuBtn, java.awt.BorderLayout.LINE_START);

        BPRPRestartBtn.setMaximumSize(new java.awt.Dimension(1000, 1000));
        BPRPRestartBtn.setMinimumSize(new java.awt.Dimension(70, 10));
        BPRPRestartBtn.setPreferredSize(new java.awt.Dimension(120, 100));
        BPRPRestartBtn.setLayout(new java.awt.BorderLayout(30, 20));
        BPRPRestartBtn.add(jSeparator2, java.awt.BorderLayout.LINE_END);
        

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        BPRPRestartBtn.add(jSeparator3, java.awt.BorderLayout.PAGE_END);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        BPRPRestartBtn.add(jSeparator4, java.awt.BorderLayout.PAGE_START);

        restartBtn.setText("Restart");
        restartBtn.setAlignmentX(0.1F);
        restartBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        restartBtn.setPreferredSize(new java.awt.Dimension(50, 30));
        restartBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controller.listenRestartBtn();
            }
        });
        
        BPRPRestartBtn.add(restartBtn, java.awt.BorderLayout.CENTER);

        BottomPanel.add(BPRPRestartBtn, java.awt.BorderLayout.LINE_END);

        BPMPtxtArea.setMaximumSize(new java.awt.Dimension(400, 400));
        BPMPtxtArea.setMinimumSize(new java.awt.Dimension(26, 20));
        BPMPtxtArea.setPreferredSize(new java.awt.Dimension(100, 20));
        BPMPtxtArea.setLayout(new javax.swing.BoxLayout(BPMPtxtArea, javax.swing.BoxLayout.Y_AXIS));

        typeFieldDesc1.setText("Type the paragraph by each bolded word. Pressing space");
        typeFieldDesc1.setAlignmentX(0.5F);
        typeFieldDesc1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BPMPtxtArea.add(typeFieldDesc1);

        typeFieldDesc2.setText("will end the word. To start the timer, type a letter.");
        typeFieldDesc2.setAlignmentX(0.5F);
        BPMPtxtArea.add(typeFieldDesc2);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMaximumSize(new java.awt.Dimension(0, 20));
        jSeparator1.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 20));
        BPMPtxtArea.add(jSeparator1);

        typeField.setMaximumSize(new java.awt.Dimension(150, 20));
        typeField.setMinimumSize(new java.awt.Dimension(100, 24));
        typeField.setPreferredSize(new java.awt.Dimension(100, 24));
        typeField.addKeyListener(new KeyListener() {
			//invokes the enterWord method of the InGameLogic class to signify the end of a user typed word
			public void keyPressed(KeyEvent arg0) {
				controller.listenTypedWord(arg0);
			}
			public void keyReleased(KeyEvent e) {

			}
			public void keyTyped(KeyEvent e) {

			}
			
		});
        typeField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
			}
	
			
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				controller.listenForStartInput();
			}
	
			public void removeUpdate(DocumentEvent e) {
			}
		});
        typeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        BPMPtxtArea.add(typeField);

        BottomPanel.add(BPMPtxtArea, java.awt.BorderLayout.CENTER);
        BottomPanel.add(BPTPSep, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setBackground(new java.awt.Color(163, 86, 168));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(800, 800));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 500));
        jScrollPane1.setViewportView(paragraphPane);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ParagraphLeftSep.setBackground(new java.awt.Color(255, 255, 255));
        ParagraphLeftSep.setForeground(new java.awt.Color(255, 255, 255));
        ParagraphLeftSep.setPreferredSize(new java.awt.Dimension(30, 10));
        getContentPane().add(ParagraphLeftSep, java.awt.BorderLayout.LINE_START);

        ParagraphRightSep.setPreferredSize(new java.awt.Dimension(30, 10));
        getContentPane().add(ParagraphRightSep, java.awt.BorderLayout.LINE_END);

        pack();
        
        paragraphPane.setText(ParagraphGenerator.generate_paragraph());
        paragraphPane.setEditable(false); 
     
    }// </editor-fold>  
                       
    
    public void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

   
    
    
}