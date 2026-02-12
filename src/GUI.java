/////////////////////////////////////////////////////////////////////////////////////////////
//
//  Class Name  : GUI
//  Author Name : Omkar Mahadev Bhargude
//  Date        : 20/09/2025
//
////////////////////////////////////////////////////////////////////////////////////////////
import FilePackerUnpacker.FilePacker;
import FilePackerUnpacker.FileUnpacker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI {

    // Helper method to safely get a char from JTextField
    private static char getCharFromField(JTextField field, JFrame frame) 
    {
        String text = field.getText();

        if (text.isEmpty()) 
        {
            JOptionPane.showMessageDialog(frame, "Please enter a character!");
            return 0;
        }
        if (text.length() > 1) 
        {
            JOptionPane.showMessageDialog(frame, "Please enter only a single character!");
            return 0;
        }

        return text.charAt(0);
    }

    public static void main(String A[]) 
    {
        // Window frame
        JFrame fobj = new JFrame("File Packer-Unpacker");
        fobj.setSize(500, 400);
        fobj.setLayout(null);
        fobj.getContentPane().setBackground(Color.LIGHT_GRAY); // Sky Blue); // Frame background
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TabbedPane
        JTabbedPane tbobj = new JTabbedPane();
        tbobj.setBounds(20, 20, 450, 300);

        //
        //           Panel 1 :- Packer
        //

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(230, 230, 250)); // Light grey background

        
        // ---------------------------------------------------------------
        JLabel DirLabel = new JLabel("Enter Directory Name:");
        DirLabel.setBounds(30, 20, 150, 25);

        JLabel PackLabel = new JLabel("Enter Pack file Name:");
        PackLabel.setBounds(30, 60, 150, 25);

        JLabel keyLabel = new JLabel("Enter key:");
        keyLabel.setBounds(30, 100, 150, 25);

        // ---------------------------------------------------------------
        JTextField DirField = new JTextField();
        DirField.setBounds(180, 20, 150, 25);

        JTextField PackField = new JTextField();
        PackField.setBounds(180, 60, 150, 25);

        JTextField keyField = new JTextField();
        keyField.setBounds(180, 100, 50, 25);
        // ---------------------------------------------------------------

        JButton bobj1 = new JButton("Pack");
        bobj1.setBounds(180, 140, 100, 30);

        panel1.add(DirLabel);
        panel1.add(PackLabel);
        panel1.add(keyLabel);
        panel1.add(DirField);
        panel1.add(PackField);
        panel1.add(keyField);
        panel1.add(bobj1);


        //
        //                  Panel 2 :- Unpacker           //
        //

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(230, 230, 250)); // Light grey background

        // --------------------------------------------------------------------
        JLabel packLabel = new JLabel("Enter Pack file Name:");
        packLabel.setBounds(30, 20, 150, 25);

        JLabel keyLabel1 = new JLabel("Enter key:");
        keyLabel1.setBounds(30, 60, 150, 25);

        // --------------------------------------------------------------------

        JTextField packField = new JTextField();
        packField.setBounds(180, 20, 150, 25);

        JTextField keyField2 = new JTextField();
        keyField2.setBounds(180, 60, 50, 25);

        // --------------------------------------------------------------------

        JButton bobj2 = new JButton("Unpack");
        bobj2.setBounds(180, 100, 100, 30);

        panel2.add(packLabel);
        panel2.add(keyLabel1);
        panel2.add(packField);
        panel2.add(keyField2);
        panel2.add(bobj2);

        // Add panels to tabbed pane
        tbobj.addTab("Packer", panel1);
        tbobj.addTab("Unpacker", panel2);

        fobj.add(tbobj);
        fobj.setVisible(true);

        //////////////////////////////////////////////////////////////////////////////////////////
        //
        //  Action Listner
        //
        /////////////////////////////////////////////////////////////////////////////////////////
        // Pack button
        bobj1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent aobj) 
            {
                String DirName = DirField.getText();
                String PackName = PackField.getText();
                String Confirmation = fobj.getTitle();

                char key1 = getCharFromField(keyField, fobj);
                if (key1 == 0) 
                {
                    return; // validation failed
                }
                
                JOptionPane.showMessageDialog(fobj,"Packing Directory : "+DirName+" \nPack file Name : "+PackName);
                FilePacker FPobj = new FilePacker(DirName, PackName, key1);
                FPobj.PackingActivity();

            }
        });

        // Unpack button
        bobj2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent aeobj)
            {
                String PackName = packField.getText();

                char key1 = getCharFromField(keyField2, fobj);
                if (key1 == 0) return; // validation failed

                JOptionPane.showMessageDialog(fobj,"Unpacking file : "+PackName);
                FileUnpacker FUobj = new FileUnpacker(PackName, key1);
                FUobj.UnpackingActivity();

            }
        });
    }
}
