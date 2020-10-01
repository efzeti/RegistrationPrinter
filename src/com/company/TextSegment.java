package com.company;

public class TextSegment {

    private int textFields;
    private boolean isLetter;
    private boolean isLast;
    private NumberToLetter numberToLetter;

    public TextSegment(int textFields, boolean isLetter) throws Exception {
        this.textFields = textFields;
        this.isLetter = isLetter;
        this.numberToLetter = new NumberToLetter();

        if (textFields < 1 || textFields > 5 || (isLetter == true && textFields > 2)){
            throw new Exception("Incorrect number of fields: " + textFields + ", isLetter: " + isLetter + ".");
        }

    }

    public String toRegistration(int number){

        if (isLetter){
            try {
                return numberToLetter.toRegistration(textFields,number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return String.format("%0"+ textFields +"d", number);

    }


}
