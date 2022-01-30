/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustunerturizm2;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.JOptionPane;

/**
 *
 * @author iserh
 */
public class mySQLBackupRestore {

    public static void Backupdbtosql() throws IOException {
        try {
            /*NOTE: Getting path to the Jar file being executed*/
 /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = mySQLBackupRestore.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            /*NOTE: Creating Database Constraints*/
            String dbName = "musteri";
            String dbUser = "selcuk";
            String dbPass = "Selcuk123";

            /*NOTE: Creating Path Constraints for folder saving*/
 /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = "C:\\Users\\Er\\Documents\\Database Yedekleri";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

            /*NOTE: Creating Path Constraints for backup saving*/
 /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "\"" + "C:\\Users\\Er\\Documents\\Database Yedekleri" + "\\Database Yedekleri\\" + "yedek.sql\"";
            //jarFile.getParentFile().getParentFile().getAbsolutePath()
            /*NOTE: Used to create a cmd command*/
            String executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + dbName + " -r " + savePath;

            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Dosya konumu: " + savePath, "Yedekleme başarılı!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Yedekleme başarısız");
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Yedekleme başarısız" + ex.getMessage());
        }
    }

    public static void Restoredbfromsql(String s) {
        try {
            /*NOTE: String s is the mysql file name including the .sql in its name*/
 /*NOTE: Getting path to the Jar file being executed*/
 /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = mySQLBackupRestore.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());

            String jarDir = jarFile.getParentFile().getPath();

            /*NOTE: Creating Database Constraints*/
            String dbName = "musteri";
            String dbUser = "selcuk";
            String dbPass = "Selcuk123";

            /*NOTE: Creating Path Constraints for restoring*/
            String restorePath = "C:\\Users\\Er\\Documents" + "\\Database Yedekleri" + "\\" + s;

            /*NOTE: Used to create a cmd command*/
 /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
            String[] executeCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Yedeklenmiş olan: " + s + " dosyasından veri kurtarma başarılı", "Kurtarma Başarılı", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Veri kurtarmada hata");
            }

        } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Veri aktarımında hata" + ex.getMessage());
        }

    }
}
