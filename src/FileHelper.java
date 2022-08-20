import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;;

public class FileHelper {

    public ArrayList<File> getFileDirectory(String fileDir) {
        File folderToRead = new File(fileDir);

        ArrayList<File> fileList = new ArrayList<File>();
        Collections.addAll(fileList, folderToRead.listFiles());

        return fileList;
    }

    public Scanner getFileScanner(File fileToRead) {
        try {
            Scanner fileScanner = new Scanner(fileToRead);
            return fileScanner;
        } catch (FileNotFoundException error) {
            System.out.println("The file was unable to be located.");
            error.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}