package excercise_odd;

import java.util.Scanner;

public interface Input {
    /**
     * <h1>Function ask user enter integer, if wrong formatting enter again</h1>
     * @param input
     * @param request
     * @return
     */
   default  int inputScanInt(Scanner input, String request) {
       System.out.println(request);
       Integer inputInt;
       while (true) {
           String inputStr = input.nextLine();

           try {
               inputInt = Integer.parseInt(inputStr);
           } catch (NumberFormatException e) {
               System.err.println("Wrong format, try again");
               continue;
           }
           break;
       }

       return inputInt;
    }

     default String inputString(Scanner input, String request) {
         System.out.println(request);

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

     default Double inputScanDub(Scanner input, String request) {
        System.out.println(request);
        Double inputDou;
        while (true) {
            String inputStr = input.nextLine();

            try {
                inputDou = Double.parseDouble(inputStr);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, try again");
                continue;
            }
            break;
        }

         return inputDou;
    }
}
