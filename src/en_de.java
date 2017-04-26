
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tharushi
 */
public class en_de extends SwingWorker<Boolean, Boolean> {
    
    File[] listOfFilesAndFolders;
    String encryptOrDecrypt;
    String key;
    sha512 fileEncryptorAndDecryptor;
    int totalNumberOfFiles;
    long totalSizeOfAllFiles;
    boolean completedTask;
    JProgressBar progressBar;
    JTextArea progressOfFilesTextField;
    JLabel progressPercentLabel;
    JButton oKButton;
    Progress_view progressFrame;

    public en_de(File[] listOfFilesAndFolders, String encryptOrDecrypt, String key) {
        this.listOfFilesAndFolders = listOfFilesAndFolders;
        this.encryptOrDecrypt = encryptOrDecrypt;
        this.key = key;
        progressFrame = new Progress_view(encryptOrDecrypt);
        progressFrame.setVisible(true);
        fileEncryptorAndDecryptor = new sha512();
        progressBar = progressFrame.getProgressBar();
        progressOfFilesTextField = progressFrame.getProgressOfFilesTextField();
        progressPercentLabel = progressFrame.getProgressPercentLabel();
        oKButton = progressFrame.getoKButton();
        setTotalSizeAndNumberOfAllFiles();
    }

    @Override
    protected Boolean doInBackground() {
        try {
            if (encryptOrDecrypt.equalsIgnoreCase("encrypt")) {
                encrypt();
            } else if (encryptOrDecrypt.equalsIgnoreCase("decrypt")) {
                decrypt();
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {
            return true;
        }
    }

    //checking the progress
    protected void done() {
        try {

            progressFrame.setCompletedTask(true);
            Toolkit.getDefaultToolkit().beep();
            oKButton.setVisible(true);
            oKButton.setEnabled(true);
            oKButton.setText("OK");

        } catch (Exception e) {
            System.out.println("");
        }
    }

    private void encrypt() {
        for (File file : listOfFilesAndFolders) {
            encrypt(file);
        }
        progressBar.setValue(progressBar.getMaximum());
        progressPercentLabel.setText("100%");
    }

    private void encrypt(File file) {
        
        //getting files that need to be encrypted
        
        if (!file.isDirectory() && file.exists()) {
            progressOfFilesTextField.append("Encrypting " + file.getAbsolutePath() + "\n");
            fileEncryptorAndDecryptor.encrypt(file, key, progressBar, progressPercentLabel, totalSizeOfAllFiles, progressOfFilesTextField);
            progressOfFilesTextField.append("Done!\n\n");
        } else if (file.isDirectory() && file.exists()) {
            File[] filesInTheDirectory = file.listFiles();
            progressOfFilesTextField.append("\n-------------------  Inside " + file.getAbsolutePath() + "   -------------------\n");
            for (File eachFileInTheDirectory : filesInTheDirectory) {
                encrypt(eachFileInTheDirectory);
            }
            progressOfFilesTextField.append("-------------------   End of " + file.getAbsolutePath() + "   -------------------\n\n");
        }
    }

    private void decrypt() {
        for (File file : listOfFilesAndFolders) {
            decrypt(file);
        }
        progressBar.setValue(progressBar.getMaximum());
        progressPercentLabel.setText("100%");
    }

    //getting files or folders that need to be decrypted
    
    private void decrypt(File file) {
        if (!file.isDirectory() && file.exists() && file.getName().substring(file.getName().length() - 4, file.getName().length()).equalsIgnoreCase(".enc")) {
            progressOfFilesTextField.append("Decrypting " + file.getAbsolutePath() + "\n");
            fileEncryptorAndDecryptor.decrypt(file, key, progressBar, progressPercentLabel, totalSizeOfAllFiles, progressOfFilesTextField);
            progressOfFilesTextField.append("Done!\n\n");
        } else if (file.isDirectory() && file.exists()) {
            File[] filesInTheDirectory = file.listFiles();
            progressOfFilesTextField.append("\n-------------------   Inside " + file.getAbsolutePath() + "   -------------------\n");
            for (File eachFileInTheDirectory : filesInTheDirectory) {

                decrypt(eachFileInTheDirectory);
            }
            progressOfFilesTextField.append("-------------------   End of " + file.getAbsolutePath() + "   -------------------\n\n");
        }
    }

    private void setTotalSizeAndNumberOfAllFiles() {
        for (File file : listOfFilesAndFolders) {
            setTotalSizeAndNumberOfAllFiles(file);
        }
    }

    private void setTotalSizeAndNumberOfAllFiles(File file) {
        if (!file.isDirectory() && file.exists()) {
            totalNumberOfFiles++;
            totalSizeOfAllFiles += file.length();
        } else if (file.isDirectory() && file.exists()) {
            File[] filesInTheDirectory = file.listFiles();

            for (File eachFileInTheDirectory : filesInTheDirectory) {
                setTotalSizeAndNumberOfAllFiles(eachFileInTheDirectory);
            }
        }
    }
    
}
