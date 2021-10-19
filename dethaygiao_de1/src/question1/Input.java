package question1;

import java.util.Scanner;

public class Input {

    public int inputScannerInt() {
        Scanner input=new Scanner(System.in);
        Integer inputInt;
        while (true) {
            String inputString = input.nextLine();

            try {
                inputInt = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, try again");
                continue;
            }
            break;
        }
        System.out.println(inputInt);
        return inputInt;
    }

    public static String inputString() {
        Scanner input =new Scanner(System.in);
        String outputString;
        while (true){
            String inputString=input.nextLine();
            outputString=inputString;
            if(outputString.isEmpty()){
                System.err.println("Enter string please");
                continue;
            }
            break;
        }
        return outputString;
    }

}