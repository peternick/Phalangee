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

    /**
     * Creates new form GUIInGame
     */
    public GUIInGame() {
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

        TopPanel = new javax.swing.JPanel();
        TopSep1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        TopSep2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        TopSep3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        BottomPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ParagraphPane = new javax.swing.JTextArea();
        ParagraphLeftSep = new javax.swing.JSeparator();
        ParagraphRightSep = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 10, 10));
        setLocation(new java.awt.Point(200, 200));
        setMinimumSize(new java.awt.Dimension(700, 500));

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

        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("Time:");
        TopPanel.add(jLabel3);

        TopSep2.setBackground(new java.awt.Color(203, 203, 203));
        TopSep2.setForeground(new java.awt.Color(203, 203, 203));
        TopSep2.setMinimumSize(new java.awt.Dimension(150, 10));
        TopSep2.setOpaque(true);
        TopSep2.setPreferredSize(new java.awt.Dimension(150, 0));
        TopPanel.add(TopSep2);

        jLabel2.setForeground(new java.awt.Color(60, 60, 60));
        jLabel2.setText("Mistyped Words:");
        jLabel2.setPreferredSize(new java.awt.Dimension(114, 30));
        TopPanel.add(jLabel2);

        TopSep3.setBackground(new java.awt.Color(203, 203, 203));
        TopSep3.setForeground(new java.awt.Color(203, 203, 203));
        TopSep3.setMinimumSize(new java.awt.Dimension(80, 10));
        TopSep3.setOpaque(true);
        TopSep3.setPreferredSize(new java.awt.Dimension(100, 0));
        TopPanel.add(TopSep3);

        jLabel1.setForeground(new java.awt.Color(60, 60, 60));
        jLabel1.setText("% accuracy:");
        TopPanel.add(jLabel1);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);

        BottomPanel.setBackground(new java.awt.Color(203, 203, 203));
        BottomPanel.setMinimumSize(new java.awt.Dimension(10, 50));
        BottomPanel.setPreferredSize(new java.awt.Dimension(600, 100));
        BottomPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 20));
        BottomPanel.add(jPanel2, java.awt.BorderLayout.PAGE_END);
        BottomPanel.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel4.setMinimumSize(new java.awt.Dimension(70, 10));
        jPanel4.setPreferredSize(new java.awt.Dimension(120, 100));
        jPanel4.setLayout(new java.awt.BorderLayout(30, 20));
        jPanel4.add(jSeparator2, java.awt.BorderLayout.LINE_END);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator3, java.awt.BorderLayout.PAGE_END);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator4, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("Restart");
        jButton1.setAlignmentX(0.1F);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel4.add(jButton1, java.awt.BorderLayout.CENTER);

        BottomPanel.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel5.setMinimumSize(new java.awt.Dimension(26, 20));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setText("Type the paragraph by each bolded word. Pressing space");
        jLabel4.setAlignmentX(0.5F);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel4);

        jLabel5.setText("will end the word. To start the timer, type a letter.");
        jLabel5.setAlignmentX(0.5F);
        jPanel5.add(jLabel5);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMaximumSize(new java.awt.Dimension(0, 20));
        jSeparator1.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 20));
        jPanel5.add(jSeparator1);

        jTextField2.setMaximumSize(new java.awt.Dimension(150, 20));
        jTextField2.setMinimumSize(new java.awt.Dimension(100, 24));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 24));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField2);

        BottomPanel.add(jPanel5, java.awt.BorderLayout.CENTER);
        BottomPanel.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setBackground(new java.awt.Color(163, 86, 168));

        ParagraphPane.setBackground(new java.awt.Color(212, 241, 246));
        ParagraphPane.setColumns(20);
        ParagraphPane.setRows(5);
        ParagraphPane.setMaximumSize(new java.awt.Dimension(500, 500));
        ParagraphPane.setPreferredSize(new java.awt.Dimension(272, 70));
        jScrollPane1.setViewportView(ParagraphPane);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ParagraphLeftSep.setBackground(new java.awt.Color(255, 255, 255));
        ParagraphLeftSep.setForeground(new java.awt.Color(255, 255, 255));
        ParagraphLeftSep.setPreferredSize(new java.awt.Dimension(30, 10));
        getContentPane().add(ParagraphLeftSep, java.awt.BorderLayout.LINE_START);

        ParagraphRightSep.setPreferredSize(new java.awt.Dimension(30, 10));
        getContentPane().add(ParagraphRightSep, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>                        

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIInGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIInGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIInGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIInGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIInGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JSeparator ParagraphLeftSep;
    private javax.swing.JTextArea ParagraphPane;
    private javax.swing.JSeparator ParagraphRightSep;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JSeparator TopSep1;
    private javax.swing.JSeparator TopSep2;
    private javax.swing.JSeparator TopSep3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}