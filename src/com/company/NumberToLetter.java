package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarOutputStream;

public class NumberToLetter {

    private Map<Integer,String> equivalents;
//    Map<Integer,String> map = Map.of(1,"A",2,"C",3,"E",4,"F",5,"G",6,"H",7,"J",8,"K",9,"L",10,"M",11,"N",12,"P",13,"R",14,"S",15,"T",16,"U",17,"V",18,"W",19,"X",20,"Y");

    private int l1;
    private int l2;
    private int max;


    public NumberToLetter() {
        equivalents = new HashMap<>();

        equivalents.put(0,"A");
        equivalents.put(1,"C");
        equivalents.put(2,"E");
        equivalents.put(3,"F");
        equivalents.put(4,"G");
        equivalents.put(5,"H");
        equivalents.put(6,"J");
        equivalents.put(7,"K");
        equivalents.put(8,"L");
        equivalents.put(9,"M");
        equivalents.put(10,"N");
        equivalents.put(11,"P");
        equivalents.put(12,"R");
        equivalents.put(13,"S");
        equivalents.put(14,"T");
        equivalents.put(15,"U");
        equivalents.put(16,"V");
        equivalents.put(17,"W");
        equivalents.put(18,"X");
        equivalents.put(19,"Y");

        max = equivalents.size();
    }

    public String toRegistration(int textFields, int number) throws Exception {


        if (textFields == 1){

            if (number > max){ throw new Exception("Ran out of letters"); }

//            System.out.println("Number:" + number);

            return equivalents.get(number);

        } else if (textFields == 2){

            if (number > max*max){ throw new Exception("Ran out of letters"); }


//            System.out.println("Number:" + number);

            l1 = number / max;
            l2 = number % max;


            if (equivalents.get(l1) == null || equivalents.get(l2) == null){
                return null;
            }

            return equivalents.get(l1) + equivalents.get(l2);

        } else {
            throw new Exception("Too many text fields for Number Converter");
        }

    }

    public int getMax() {
        return max;
    }
}
