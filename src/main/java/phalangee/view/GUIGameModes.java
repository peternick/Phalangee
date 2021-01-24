package phalangee.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import phalangee.controller.TextController;

/**
 *
 * @author Peter Apazidis
 */
public class GUIGameModes extends javax.swing.JFrame {

	private TextController controller;
	private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel BtnsPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton blindBtn;
    private javax.swing.JSeparator btnSep1;
    private javax.swing.JSeparator btnSep2;
    private javax.swing.JSeparator btnSep3;
    private javax.swing.JSeparator btnSep4;
    private javax.swing.JButton normalBtn;
    private javax.swing.JButton quizBtn;
    
    /**
     * Creates new form GUIMainMenu
     */
    public GUIGameModes(TextController controller) {
    	this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        BtnsPanel = new javax.swing.JPanel();
        btnSep1 = new javax.swing.JSeparator();
        normalBtn = new javax.swing.JButton();
        btnSep2 = new javax.swing.JSeparator();
        blindBtn = new javax.swing.JButton();
        btnSep3 = new javax.swing.JSeparator();
        quizBtn = new javax.swing.JButton();
        btnSep4 = new javax.swing.JSeparator();
        backBtn = new javax.swing.JButton();
        TopPanel = new javax.swing.JPanel();
        BottomPanel = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phalangee - Game Modes");   
        setMinimumSize(new java.awt.Dimension(300, 350));
        setPreferredSize(new java.awt.Dimension(300, 300));
        centreWindow(this);
        setResizable(false);

        BtnsPanel.setMaximumSize(new java.awt.Dimension(150, 252));
        BtnsPanel.setMinimumSize(new java.awt.Dimension(70, 132));
        BtnsPanel.setName(""); // NOI18N
        BtnsPanel.setPreferredSize(new java.awt.Dimension(120, 162));
        BtnsPanel.setLayout(new javax.swing.BoxLayout(BtnsPanel, javax.swing.BoxLayout.Y_AXIS));

        btnSep1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        btnSep1.setMaximumSize(new java.awt.Dimension(0, 40));
        btnSep1.setMinimumSize(new java.awt.Dimension(20, 10));
        btnSep1.setPreferredSize(new java.awt.Dimension(40, 0));
        btnSep1.setVerifyInputWhenFocusTarget(false);
        BtnsPanel.add(btnSep1);

        normalBtn.setText("Normal");
        normalBtn.setAlignmentX(0.5F);
        normalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controller.listenNormalGamemodeBtn();
            }
        });
        BtnsPanel.add(normalBtn);

        btnSep2.setForeground(new java.awt.Color(207, 207, 207));
        btnSep2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        btnSep2.setMaximumSize(new java.awt.Dimension(0, 40));
        btnSep2.setMinimumSize(new java.awt.Dimension(80, 40));
        btnSep2.setName(""); // NOI18N
        btnSep2.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnsPanel.add(btnSep2);

        blindBtn.setText("Blind");
        blindBtn.setAlignmentX(0.5F);
        blindBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blindBtnMouseClicked(evt);
            }
        });
        BtnsPanel.add(blindBtn);

        btnSep3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        btnSep3.setMaximumSize(new java.awt.Dimension(0, 40));
        btnSep3.setPreferredSize(new java.awt.Dimension(20, 40));
        BtnsPanel.add(btnSep3);

        quizBtn.setText("Quiz");
        quizBtn.setAlignmentX(0.5F);
        quizBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                controller.listenBackBtn();
            }
        });
        BtnsPanel.add(quizBtn);

        btnSep4.setMaximumSize(new java.awt.Dimension(0, 40));
        BtnsPanel.add(btnSep4);

        backBtn.setText("Back");
        backBtn.setAlignmentX(0.5F);
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });
        BtnsPanel.add(backBtn);

        getContentPane().add(BtnsPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(RightPanel, java.awt.BorderLayout.LINE_END);
        getContentPane().add(LeftPanel, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>                    

    public void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }              
                                                 
}