



import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author S!N3TH
 */

public class Progress_view extends javax.swing.JFrame
{
    private String encryptOrDecrypt;
    private boolean completedTask;

    public void setCompletedTask(boolean completedTask)
    {
        this.completedTask = completedTask;
    }
    
    public Progress_view(String encryptOrDecrypt)
    {
        this.encryptOrDecrypt=encryptOrDecrypt;
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Progress_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Progress_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Progress_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Progress_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        
        initComponents();
        setResizable(false);
        progressOfFilesTextField.setEditable(false);
        oKButton.setVisible(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                JFrame frame = (JFrame)e.getSource();
                int result;
                if(completedTask)
                {
                    Toolkit.getDefaultToolkit().beep();
                    result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                    {
                        
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                    
                }
                else if(encryptOrDecrypt.equals("encrypt"))
                {
                    Toolkit.getDefaultToolkit().beep();
                    result = JOptionPane.showConfirmDialog(frame, "Encryption is in progress. "+"Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                
                else if (encryptOrDecrypt.equals("decrypt"))
                {
                    Toolkit.getDefaultToolkit().beep();
                     result = JOptionPane.showConfirmDialog(frame, "Decryption is in progress. "+"Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);
                     if (result == JOptionPane.YES_OPTION)
                     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                
            }
        });
        if(encryptOrDecrypt.equalsIgnoreCase("encrypt"))
        {
            heading.setText("Encrypting:");
        }
        else if(encryptOrDecrypt.equalsIgnoreCase("decrypt"))
        {
            heading.setText("Decrypting:");
        }
        getRootPane().setDefaultButton(oKButton);
        this.setVisible(true);
        
        
    }

    public JButton getoKButton()
    {
        return oKButton;
    }

    public JProgressBar getProgressBar()
    {
        return progressBar;
    }

    public JTextArea getProgressOfFilesTextField()
    {
        return progressOfFilesTextField;
    }

    public JLabel getProgressPercentLabel()
    {
        return progressPercentLabel;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        progressOfFilesTextField = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();
        progressPercentLabel = new javax.swing.JLabel();
        oKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        heading.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        progressOfFilesTextField.setColumns(20);
        progressOfFilesTextField.setRows(5);
        progressOfFilesTextField.setToolTipText("OK");
        jScrollPane1.setViewportView(progressOfFilesTextField);

        progressBar.setForeground(new java.awt.Color(0, 51, 204));

        progressPercentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        progressPercentLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        progressPercentLabel.setText("0%");

        oKButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        oKButton.setToolTipText("OK");
        oKButton.setEnabled(false);
        oKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heading)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(250, 250, 250)
                                        .addComponent(oKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(progressPercentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressPercentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oKButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_oKButtonActionPerformed
    {//GEN-HEADEREND:event_oKButtonActionPerformed
       
        setVisible(false);
        dispose();
        new MainDashBord().setVisible(true);
    }//GEN-LAST:event_oKButtonActionPerformed
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton oKButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextArea progressOfFilesTextField;
    private javax.swing.JLabel progressPercentLabel;
    // End of variables declaration//GEN-END:variables

}