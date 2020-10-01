package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationMaker {

    public final String MAX_FIRST_SEQUENCE = "99999";

    public RegistrationMaker() throws Exception {
    }


    TextSegment fiveDigit = new TextSegment(5, false);
    TextSegment fourDigit = new TextSegment(4, false);
    TextSegment threeDigit = new TextSegment(3, false);
    TextSegment twoDigit = new TextSegment(2, false);
    TextSegment oneDigit = new TextSegment(1, false);

    TextSegment twoLetter = new TextSegment(2, true);
    TextSegment oneLetter = new TextSegment(1, true);


    private Map<Integer, String> makeRegistration(String prefix, int number, boolean print) throws Exception {

        prefix = prefix.toUpperCase();
        prefix = prefix.substring(0,2);

        int sequence = 1;
        int i = 1;
        int letterPicker = 0;
        int smallI = 1;
        int totalCount = 1;
        String registration = "";
        Map<Integer,String> registrationRegister = new HashMap<>();



        do {

            if (sequence == 5) {

                registration = prefix + " " + oneDigit.toRegistration(smallI) + twoLetter.toRegistration(letterPicker) + twoDigit.toRegistration(i);


                if(twoDigit.toRegistration(i).equals("99")){
                    i=0;
                    smallI++;
                    if (smallI == 10){
                        letterPicker++;
                        smallI=1;
                    }
                }

                if(twoLetter.toRegistration(letterPicker) == null){
                    sequence++;
                    letterPicker = 0;
                    i = 0;
                }

            }

            if (sequence == 4) {

                registration = prefix + " " + oneDigit.toRegistration(smallI) + oneLetter.toRegistration(letterPicker) + threeDigit.toRegistration(i);


                if(threeDigit.toRegistration(i).equals("999")){
                    i=0;
                    smallI++;
                    if (smallI == 10){
                        letterPicker++;
                        smallI=1;
                    }
                }

                if(oneLetter.toRegistration(letterPicker) == null){
                    sequence++;
                    letterPicker = 0;
                    i = 0;
                }

            }

            if (sequence == 3) {

                registration = prefix + " " + threeDigit.toRegistration(i) + twoLetter.toRegistration(letterPicker);


                if(threeDigit.toRegistration(i).equals("999")){
                    i=0;
                    letterPicker++;
                }

                if(twoLetter.toRegistration(letterPicker) == null){
                    sequence++;
                    letterPicker = 0;
                    i = 0;
                }
            }

            if (sequence == 2) {

                registration = prefix + " " + fourDigit.toRegistration(i) + oneLetter.toRegistration(letterPicker);


                if(fourDigit.toRegistration(i).equals("9999")){
                    i=0;
                   letterPicker++;
                }

                if(oneLetter.toRegistration(letterPicker) == null){
                    sequence++;
                    letterPicker = 0;
                    i = 0;
                }
            }

            if (sequence == 1) {

                registration = prefix + " " + fiveDigit.toRegistration(i);


                if(fiveDigit.toRegistration(i).equals(MAX_FIRST_SEQUENCE)){
                    sequence++;
                    i = 0;
                }
            }

            if (print){
                System.out.println(registration);
            }

            registrationRegister.put(totalCount, registration);
            i++;
            totalCount++;

        } while (sequence<6 && totalCount<=number);

//        totalCount = 1;
        return registrationRegister;
    }

    public Map<Integer, String> RegistrationMap(String prefixA) throws Exception {
        return makeRegistration(prefixA, 99999 + 199980 + 399600 + 179820 + 356400, false);
    }

    public void PrintRegistrations(String prefixB, int numberB) throws Exception {
        makeRegistration(prefixB, numberB, true);
    }

    public void PrintRegistration(String prefixC, int numberB) throws Exception {
        Map<Integer, String> regs = makeRegistration(prefixC, numberB, false);
        System.out.println(regs.get(regs.size()));
    }

    public boolean toFile(Map<Integer, String> regsMap, String filename) throws Exception{

        try {
            File regsFile = new File(filename + ".txt");
            if (regsFile.createNewFile()) {
                System.out.println("File created: " + regsFile.getName());
            } else {
                System.out.println("File already exists. Write to file? Y/N");
                Scanner s = new Scanner(System.in);
                String decision = s.nextLine();
                if (decision.toUpperCase().equals("N")){
                    System.out.println("Failed to write file.");
                    return false;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }


        try {
            FileWriter myWriter = new FileWriter(filename + ".txt");
            for (int i = 1; i <= regsMap.size(); i++){
                myWriter.write(String.format("%07d",i) + " " +regsMap.get(i) + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }



        return true;
    }


}
