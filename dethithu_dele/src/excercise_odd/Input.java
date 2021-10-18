package excercise_odd;

import java.util.Scanner;

public interface Input {

   default  int inputScanInt(Scanner input, String request) {
        System.out.println(request);
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

     default String inputString(Scanner input, String request) {
        System.out.println(request);

        String inputStr = null;
        while (inputStr == null) {
            String inputString = input.nextLine();
                inputStr=inputString;
                if(inputStr.equals("")){
                    System.err.println("Null, enter please");
                    inputStr=null;
                }else {
                    inputStr=inputString;
                }

        }
        return inputStr;
    }

     default Double inputScanDub(Scanner input, String request) {
        System.out.println(request);
        Double inputDou = null;
        while (inputDou == null) {
            String inputStr = input.nextLine();

            try {
                inputDou = Double.parseDouble(inputStr);

                if (inputDou != Integer.parseInt(inputStr)) {
                    inputDou=null;
                } else {
                    inputDou = Double.parseDouble(inputStr);

                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, try again ");
            }
        }
        return inputDou;
    }
}
