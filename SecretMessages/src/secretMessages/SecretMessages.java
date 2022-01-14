package secretMessages;

import java.util.Scanner;
import javax.swing.JFrame;

public class SecretMessages extends JFrame {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String message = "";
		boolean goodKey = true;
		do {	
			System.out.println("Enter a message to code or decode, or press enter to quit:");
			message = scan.nextLine();					//Prompt user for message
			do {
				try {
					if (message.length() != 0) {		//Run codec if message was entered
						String output = "";
						System.out.println("Enter a secret key (-25 to 25):");
						int keyVal = Integer.parseInt(scan.nextLine());		//Prompt user for key
						char key = (char)keyVal;
						for(int x = message.length() - 1; x >= 0; x--) {	//For each character in the message...
							char input = message.charAt(x);
							if (input >= 'A' && input <= 'Z') {				//Capital letters are shifted to capital letters
								input += key;
								if (input > 'Z')
									input -= 26;
								if (input < 'A')
									input += 26;
							}
							else if (input >= 'a' && input <= 'z') {		//Lowercase to lowercase
								input += key;
								if (input > 'z')
									input -= 26;
								if (input < 'a')
									input += 26;
							}
							else if (input >= '0' && input <= '9') {		//Numbers to numbers
								input += keyVal % 10;
								if (input > '9')
									input -= 10;
								if (input < '0')
									input += 10;
							}
							output += input;
						}
						System.out.println(output);
						goodKey = true;
					}
					else 
						System.out.println("Goodbye!");
				} catch (Exception e){
					System.out.println("Sorry, the key value must be an integer between -25 and 25.");
					goodKey = false;
				}
			} while (goodKey == false);						//Re-prompt for key if an invalid value was input
		} while (message.length() != 0);					//Run as long as messages are entered
		scan.close();
	}
}


