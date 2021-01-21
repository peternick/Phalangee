package phalangee.view;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import javax.swing.text.Highlighter.HighlightPainter;

import phalangee.controller.TextController;
import phalangee.model.PhalangeeMongoDB;


public class GUICreateAccount extends javax.swing.JFrame{

	
	private static GUICreateAccount createAccountInstance;
	private TextController controller;  
	private javax.swing.JButton MPBPConfBtn;//TODO change this variable to confBtn instead of MPBPconfbtn
    private javax.swing.JPanel MPBPConfBtnPanel;
    private javax.swing.JPanel MPLPLbls;
    private javax.swing.JLabel MPLPPsswdLbl;
    private javax.swing.JSeparator MPLPSep1;
    private javax.swing.JLabel MPLPUserLbl;
    private javax.swing.JSeparator MPMPSep1;
    private javax.swing.JSeparator MPMPSep2;
    private javax.swing.JTextField MPMPTxtField1;
    private javax.swing.JPanel MPMPtxtFields;
    private javax.swing.JPanel MPRP;
    private javax.swing.JPanel MPTP;
    private javax.swing.JLabel TPuserInputLbl;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JPasswordField psswdTxtField;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel topPanel;
	
	/**
     * Creates new form GUIUserLogin
     */
	public GUICreateAccount(TextController controller) {
		this.controller = controller;
        initComponents();
    }

//	public static GUICreateAccount getInstance() {
//		if(createAccountInstance == null) {
//			createAccountInstance = new GUICreateAccount();
//		}
//		return createAccountInstance;
//	}
	
	public JButton getConfBtn() {
		return this.MPBPConfBtn;
	}
	
	public JTextField getUsernameField() {
		return this.MPMPTxtField1;
	}
	
	public JTextField getPasswordField() {
		return this.psswdTxtField;
	}
	public JLabel getUserInputLbl() {
		return this.TPuserInputLbl;
	}
	public void setUserInputLbl(String label) {
		this.TPuserInputLbl.setText(label);
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        TPuserInputLbl = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        middlePanel = new javax.swing.JPanel();
        MPLPLbls = new javax.swing.JPanel();
        MPLPUserLbl = new javax.swing.JLabel();
        MPLPSep1 = new javax.swing.JSeparator();
        MPLPPsswdLbl = new javax.swing.JLabel();
        MPTP = new javax.swing.JPanel();
        MPRP = new javax.swing.JPanel();
        MPBPConfBtnPanel = new javax.swing.JPanel();
        MPBPConfBtn = new javax.swing.JButton();
        MPMPtxtFields = new javax.swing.JPanel();
        MPMPTxtField1 = new javax.swing.JTextField();
        MPMPSep1 = new javax.swing.JSeparator();
        psswdTxtField = new javax.swing.JPasswordField();
        MPMPSep2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phalangee - Login");
        setMinimumSize(new java.awt.Dimension(400, 300));

        leftPanel.setPreferredSize(new java.awt.Dimension(30, 120));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        topPanel.setPreferredSize(new java.awt.Dimension(400, 50));
        topPanel.setLayout(new javax.swing.BoxLayout(topPanel, javax.swing.BoxLayout.Y_AXIS));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setMaximumSize(new java.awt.Dimension(0, 32767));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 10));
        topPanel.add(jSeparator4);

        TPuserInputLbl.setForeground(new java.awt.Color(47, 47, 47));
        TPuserInputLbl.setText("*Password must have a capital letter and a number");
        TPuserInputLbl.setAlignmentX(0.5F);
        TPuserInputLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topPanel.add(TPuserInputLbl);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        rightPanel.setPreferredSize(new java.awt.Dimension(30, 120));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        bottomPanel.setPreferredSize(new java.awt.Dimension(400, 20));

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        middlePanel.setMaximumSize(new java.awt.Dimension(600, 500));
        middlePanel.setMinimumSize(new java.awt.Dimension(200, 50));
        middlePanel.setName(""); // NOI18N
        middlePanel.setPreferredSize(new java.awt.Dimension(340, 50));
        middlePanel.setLayout(new java.awt.BorderLayout());

        MPLPLbls.setMaximumSize(new java.awt.Dimension(120, 300));
        MPLPLbls.setPreferredSize(new java.awt.Dimension(130, 50));
        MPLPLbls.setLayout(new javax.swing.BoxLayout(MPLPLbls, javax.swing.BoxLayout.Y_AXIS));

        MPLPUserLbl.setText("Username:");
        MPLPUserLbl.setAlignmentX(0.5F);
        MPLPUserLbl.setIconTextGap(50);
        MPLPLbls.add(MPLPUserLbl);

        MPLPSep1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        MPLPSep1.setMaximumSize(new java.awt.Dimension(0, 40));
        MPLPSep1.setMinimumSize(new java.awt.Dimension(0, 5));
        MPLPSep1.setPreferredSize(new java.awt.Dimension(0, 20));
        MPLPLbls.add(MPLPSep1);

        MPLPPsswdLbl.setText("Password:");
        MPLPPsswdLbl.setAlignmentX(0.5F);
        MPLPPsswdLbl.setIconTextGap(20);
        MPLPLbls.add(MPLPPsswdLbl);

        middlePanel.add(MPLPLbls, java.awt.BorderLayout.LINE_START);

        MPTP.setMaximumSize(new java.awt.Dimension(300, 300));
        MPTP.setMinimumSize(new java.awt.Dimension(149, 100));
        MPTP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        middlePanel.add(MPTP, java.awt.BorderLayout.PAGE_START);

        MPRP.setMinimumSize(new java.awt.Dimension(10, 60));
        MPRP.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout MPRPLayout = new javax.swing.GroupLayout(MPRP);
        MPRP.setLayout(MPRPLayout);
        MPRPLayout.setHorizontalGroup(
            MPRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        MPRPLayout.setVerticalGroup(
            MPRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        middlePanel.add(MPRP, java.awt.BorderLayout.LINE_END);

        MPBPConfBtnPanel.setMaximumSize(new java.awt.Dimension(0, 70));
        MPBPConfBtnPanel.setPreferredSize(new java.awt.Dimension(340, 70));
        MPBPConfBtnPanel.setLayout(new javax.swing.BoxLayout(MPBPConfBtnPanel, javax.swing.BoxLayout.Y_AXIS));

        MPBPConfBtn.setText("Confirm");
        MPBPConfBtn.setAlignmentX(0.5F);
        MPBPConfBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MPBPConfBtn.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	controller.listenConfirmAccountBtn();
		    }
		});
        MPBPConfBtnPanel.add(MPBPConfBtn);

        middlePanel.add(MPBPConfBtnPanel, java.awt.BorderLayout.PAGE_END);

        MPMPtxtFields.setPreferredSize(new java.awt.Dimension(140, 50));
        MPMPtxtFields.setLayout(new javax.swing.BoxLayout(MPMPtxtFields, javax.swing.BoxLayout.Y_AXIS));

        MPMPTxtField1.setMargin(new java.awt.Insets(0, 6, 2, 6));
        MPMPTxtField1.setMaximumSize(new java.awt.Dimension(200, 300));
        MPMPTxtField1.setMinimumSize(new java.awt.Dimension(64, 24));
        MPMPTxtField1.setPreferredSize(new java.awt.Dimension(130, 24));
        MPMPtxtFields.add(MPMPTxtField1);

        MPMPSep1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        MPMPSep1.setMaximumSize(new java.awt.Dimension(0, 400));
        MPMPSep1.setPreferredSize(new java.awt.Dimension(0, 10));
        MPMPtxtFields.add(MPMPSep1);

        psswdTxtField.setMaximumSize(new java.awt.Dimension(150, 200));
        psswdTxtField.setPreferredSize(new java.awt.Dimension(90, 30));
        MPMPtxtFields.add(psswdTxtField);

        MPMPSep2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        MPMPSep2.setMaximumSize(new java.awt.Dimension(0, 500));
        MPMPSep2.setPreferredSize(new java.awt.Dimension(0, 10));
        MPMPtxtFields.add(MPMPSep2);

        middlePanel.add(MPMPtxtFields, java.awt.BorderLayout.CENTER);

        getContentPane().add(middlePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>    
    
}
