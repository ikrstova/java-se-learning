package flowcontrol.exceptions.assertions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadData {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("randomFileName1.txt", "r");
            byte[] bytes = new byte[1000];
            randomAccessFile.readFully(bytes, 0, 1000);
            System.out.println("Try has been successful!");

        } catch (FileNotFoundException e) {
            System.err.println("FileNorFoundException caught!");
            e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
/*        catch (IOException e) {
            System.err.println("IOException caught!");
            e.printStackTrace();
        }*/
    }
}
