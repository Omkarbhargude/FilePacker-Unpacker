////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  Package Name  : FilePackerUnpacker
//  Class Name    : FileUnpacker
//  Author Name   : Omkar Mahadev Bhargude
//  Date          : 12/06/2025
//  
//  Description   : This class is used to unpack the given file and make
//                  indiviusal file for each packed file with data in it
//  
////////////////////////////////////////////////////////////////////////////////////////////////////

package FilePackerUnpacker;

import java.util.*;
import java.io.*;

public class FileUnpacker
{
    private String PackName;                            // Name of packed file
    private char key;                                   // Key for decryption

    public FileUnpacker(String A, char B)
    {
        this.PackName = A;
        this.key = B;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    //
    //  Function name   : UnpackingActivity()
    //  Author name     : Omkar Mahadev Bhargude
    //  Date            : 12/06/2025
    //
    //  Description     : Used to unpack the packed file
    //
    //  Input           : NONE
    //  Output          : NONE
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public void UnpackingActivity()
    {
        try
        {
            String Header = null;
            File fobjnew = null;
            int FileSize = 0, iRet = 0;
            int iCountFile = 0;
            int iDn = 0;

            File fobj = new File(PackName);

            // Checks if packed file present or not
            if(!fobj.exists())
            {
                System.out.println("Unable to access packed file");
                return;
            }

            System.out.println("Packed file gets successfully opened");

            FileInputStream fin = new FileInputStream(fobj);

            // Buffer to read the Header
            byte HeaderBuffer[] = new byte[100];

            // Scan the packed file to extract the files from it
            while((iRet = fin.read(HeaderBuffer,0,100)) != -1)
            {
                // Converts byte array into string
                Header = new String(HeaderBuffer);

                Header = Header.trim();                             // Cuts the white space from front and back

                // Tokenize the header into 2 parts
                String Tokens[] = Header.split(" ");

                fobjnew = new File(Tokens[0]);

                // Create new file to extract
                fobjnew.createNewFile();

                FileSize = Integer.parseInt(Tokens[1]);                 // file size

                FileOutputStream fout = new FileOutputStream(Tokens[0]);

                // create new buffer to store the files data
                byte Buffer[] = new byte[FileSize];
                fin.read(Buffer,0,FileSize);

                // Decrypting the data
                for(iDn = 0; iDn < FileSize; iDn++)
                {
                    Buffer[iDn] = (byte)(Buffer[iDn] ^ key);
                }

                // Writing the data in unpacked file
                fout.write(Buffer,0,FileSize);

                System.out.println("File Unpack with name : "+Tokens[0]+" having size "+FileSize);

                iCountFile++;
            }
        }
        catch(Exception eobj)
        {}
    }
       
}
