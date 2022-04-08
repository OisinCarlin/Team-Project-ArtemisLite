/**
 * 
 */
package g11ArtemisLite;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author crclarke
 *
 */
public class DataSaver {
	
	String fName;
    StateOfPlay sop;

    /**
     * Sets the state of play
     * @param sopToSet
     */
    public void setSOP(StateOfPlay sopToSet){
        sop = sopToSet;
    }

    /**
     * sets the file name to save to
     * @param fileNameToSet
     */
   public void setFileName(String fileNameToSet){
        fName = fileNameToSet;
   }


   /**
    * Writes the SOP to file
    * @throws IOException
    */
    public void saveData() throws IOException{
        FileOutputStream f_out = new FileOutputStream(fName);
        ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
        obj_out.writeObject(sop);
        obj_out.close();
        f_out.close();
    }

}
