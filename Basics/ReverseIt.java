/*
 * Author - Vikram Gopal.
 * Description - This class is to choose a file 
 * using the JFileChooser class and reverse its content 
 * using the FileReader and PrintWriter adn File Classes. 
 */

package Viky_Programs;

import javax.swing.JFileChooser;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReverseIt
{
    public static void main(String [] args)throws FileNotFoundException, IOException
    {
        Scanner myScanner= new Scanner(System.in);

        JFileChooser myChooser;

        myChooser = new JFileChooser();
        
        if(myChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File myFile = myChooser.getSelectedFile();
            FileReader myReader = new FileReader(myFile);

            PrintWriter myWriter = new PrintWriter ("Output File Name and Path!");
            Scanner inputFile = new Scanner(myReader);
            while(inputFile.hasNext())
            {
                String inString = inputFile.nextLine();
                String outString = "";
                for (int i = 0; i < inString.length(); i++)
                    outString = inString.charAt(i) + outString;
                myWriter.println(outString);
            }
            myReader.close();
            myWriter.close();
            inputFile.close();
            myScanner.close();
            
            System.out.println("File content reversed and saved as Ouput.txt");
            System.out.println("Goodbye!");
        }
    }           
}
