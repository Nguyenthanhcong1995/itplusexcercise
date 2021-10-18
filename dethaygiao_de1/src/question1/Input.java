package question1;

import java.util.Scanner;

public class Input {

    public int inputScannerInt() {
        Scanner input=new Scanner(System.in);
        Integer inputInt = null;
        while (inputInt == null) {
            String inputStr = input.nextLine();

            try {
                inputInt = Integer.parseInt(inputStr);

                if (inputInt != Integer.parseInt(inputStr)) {
                    inputInt=null;
                } else {
                    inputInt = Integer.parseInt(inputStr);
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, try again ");
            }
        }

        return inputInt;
    }

    public static String inputString() {
        Scanner input =new Scanner(System.in);
        String inputStr = null;
        while (inputStr == null) {
            String inputString = input.nextLine();
            inputStr=inputString;
            if((inputStr.isEmpty())){
                System.err.println("Null, enter please");
                inputStr=null;
            }else {
                inputStr=inputString;
            }

        }
        return inputStr;
    }

}