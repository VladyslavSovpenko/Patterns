package services;

public class Validator {

    private static final Validator validator = new Validator();

    public static Validator getInstance() {
        return validator;
    }


//    public boolean validateKey(String text) {
//        return patternForKeyToDB.matcher(text).matches();
//    }
}