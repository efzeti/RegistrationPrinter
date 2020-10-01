package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        NumberToLetter numberToLetter = new NumberToLetter();
        RegistrationMaker registrationMaker = new RegistrationMaker();




        Map<Integer, String> regRegister = registrationMaker.RegistrationMap("LU");

        registrationMaker.PrintRegistrations("KR", 20);
        registrationMaker.PrintRegistration("WE", 999999);

        


        int checker;
        for (int i = 1; i < 5; i++){
            checker = (int) Math.round(Math.random()*(99999 + 199980 + 399600 + 179820 + 356400));

            System.out.println("Number: " + checker + " | Plate: " + regRegister.get(checker));
        }

        registrationMaker.toFile(regRegister, "regs");

    }





}
