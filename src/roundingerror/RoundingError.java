/*
 * Author: Ahmed Al-Hayali
 * Date of Completion: 19/02/2020
 * This program 
 */
package roundingerror;

import java.awt.HeadlessException;
import javax.swing.*;

public class RoundingError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declares and initializes the boolean "userDone" to indicate whether the user is done using the program.
        boolean userDone = false;

        //Initiates a while loop to prompt user for input when the boolean userDone is false.
        while (userDone == false) {
            //Try statement to ensure any exceptions caused by taking input from the user are caught.
            try {
                //Declaration and initialization of the double "x" as the value inputted by user, if applicable.
                double x = Double.parseDouble(JOptionPane.showInputDialog("Please enter a number, preferably an integer :)"));
                /*
                Prints the square of the square root of x then the roundoff error by first using the Math.sqrt() method to 
                find the square root, then multiplying by itself to determine the square of the square root, which is
                subtracted from the original number to find the roundoff error.
                */
                System.out.println("The square of the square root of " + (int) x + " is: " + (Math.sqrt(x)) * (Math.sqrt(x)));
                System.out.println("The roundoff error is: " + (x - (Math.sqrt(x)) * (Math.sqrt(x))));
                //Setting the boolean userDone to true to end the while loop since user has successfully run program with valid inputs.
                userDone = true;
                
              //Catch statement catches a number format exception in case the user inputs a non-numeric value, preventing crashing.
            } catch (NumberFormatException e) {
                //In red text, the user is told that his or her input cannot be processed, which allows the program to run again.
                System.err.println("Please don't do that :(, your input cannot be processed.");
              
              //Second catch statement catches a null pointer exception to cleanly exit program without error text.
            } catch (NullPointerException e) {
                //Outputs text to inform the user the program is being exited from.
                System.out.println("Exiting Program");
                //Converts userDone boolean to true to stop the while loop from running again, thus terminating program. Can also be done using System.exit(0).
                userDone = true;
                
            }
        }
    }
}
