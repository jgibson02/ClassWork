package fronds;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author John Gibson
 */
public class FrondsInstaller {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            String fPath = new File("").getAbsolutePath();
            fPath.concat("\\dist\\Fronds.jar");
            File frondsJar = new File(fPath );
            File frondsCopy = new File("C:\\Users\\John\\Fronds\\");
            
            inStream = new FileInputStream(frondsJar);
            outStream = new FileOutputStream(frondsCopy);
            
            byte[] buffer = new byte[4096];
            
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            
            if (inStream != null)inStream.close();
            if (outStream != null)outStream.close();
            
            System.out.println("File Copied.");
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}