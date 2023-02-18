package logic;
import java.io.File;
import java.io.FileReader;
import java.io.*;

/**
 * used to define method for reading the config file
 * @author Hypolite
 * @version 1.0
 */
public class file extends File {
    public file(String pathname) {
        super(pathname);
    }

    /**
     * Find the number of line on the selected file.
     * @param fis : reader
     * @return the number of lines
     * @throws IOException
     */
    public int findLine(FileReader fis) throws  IOException {
        int charCode;
        int count = 0;
        while((charCode = fis.read()) != -1){
            if((char)charCode == '\n'){
                count++;
            }
        }
        return count;
    }


    /**
     * Read the selected line from the selected file
     * @param selectedLine : the number of the selected line
     * @param nbLine : the total number of line in the file
     * @param fis : reader for the file
     * @return : the string containing the line
     * @throws IOException
     */
    public String readLine(int selectedLine, int nbLine, FileReader fis) throws IOException{
        String line = "";
        int charCode;
        for(int i=0;i<nbLine;i++){
            if(i== selectedLine -1){
                while((char)(charCode = fis.read()) != '\n'){
                    line = line + (char)charCode;
                }
            }
        }
        return line;
    }
}
