//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  Class Name      :   FilePacker
//  Author Name     :   Omkar Mahadev Bhargude
//  Date            :   27/07/2025
//
//  Description     :   This class is specifically designed for packing the file in from given directory
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////

package FilePackerUnpacker;

import java.util.*;
import java.io.*;

public class FilePacker
{
    private String DirName;                                 // Directory name    
    private String PackName;                                // Name of packed file
    private char key;                                       // Key for encryption

    public FilePacker(String A, String B, char C)           // Parametrised constructor
    {
        this.DirName = A;
        this.PackName = B;
        this.key = C;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  PackingActivity
    //  Author Name     :  Omkar Mahadev Bhargude
    //  Date            :  27/07/2025
    //
    //  Description     :  This function is used to packing files from given 
    //                     directory into a single file 
    //
    //  Input           :  NONE
    //  Returns         :  NONE
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public void PackingActivity()
    {

        try
        {
            int i = 0, j = 0, iEn = 0;
            int iRet = 0, iCountFile = 0;

            File fobj = new File(DirName);          // file class object

            // Checks if the directory is present
            if(fobj.exists() && fobj.isDirectory())
            {
                System.out.println(DirName+" directory is successfully opened");

                File PackObj = new File(PackName);      // Object of new file

                // creates new file if is not present
                boolean bRet = PackObj.createNewFile();

                if(bRet == false)
                {
                    System.out.println("Unable to create pack file");
                    return;
                }


                System.out.println("Packed file gets created successfully");
                System.out.println();

                // Create Object of each file in directory
                File Arr[] = fobj.listFiles();

                if( Arr == null)
                {
                    System.out.println("Unable to fetch objects from directory");
                    return;
                }

                // Object to write the data in packed file
                FileOutputStream fout = new FileOutputStream(PackObj);

                // Buffer for read and write activity from file
                byte Buffer[] = new byte[1024];

                String Header = null;

                // Directory Traversal
                for(i = 0; i < Arr.length; i++)
                {
                    Header = Arr[i].getName() + " " + Arr[i].length();          // "test.txt 123"


                    // Loop to form 100 byte header
                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }

                    // Write the header in packed file
                    fout.write(Header.getBytes());

                    // Open file from directory for reading the metadata from file
                    FileInputStream fin = new FileInputStream(Arr[i]);

                    // Write the content of file into packed file
                    while((iRet = fin.read(Buffer)) != -1)
                    {   

                        // Using XOR cipher encryption for data security
                        for(iEn = 0; iEn < iRet; iEn++)
                        {
                            Buffer[iEn] = (byte)(Buffer[iEn] ^ key);
                        }

                        fout.write(Buffer,0,iRet);                                                  // Writes encrypted data

                        System.out.println("Name of scanned file : "+Arr[i].getName());
                        System.out.println("Size of scanned file : "+iRet);
                    }

                    fin.close();
                    iCountFile++;
                }
                System.out.println();
                System.out.println("Encryption activity Done");
                System.out.println("Packing Activity Done");

                System.out.println("+---------------------------------------------------------------+");
                System.out.println("+---------------------- Statistical Report ---------------------+");
                System.out.println("+---------------------------------------------------------------+");

                System.out.println("Total files Packed : "+iCountFile);
                System.out.println("Size of Packed file is : "+PackObj.length());

                System.out.println("+---------------------------------------------------------------+");
                System.out.println("---------------- Thanks for using our application --------------+");
                System.out.println("+---------------------------------------------------------------+");
            }
            else
            {
                System.out.println("There is no such Directory");
                return;
            }
        }// End of try
        catch(Exception eobj)
        {
            System.out.println("Exception ouccured");
        }
    }// End of PackingActivity Method

}// End of FilePacker class
