public class ValidatePassword {

    public static boolean isPasswordLongEnough(String password) {
        int length = password.length();
        return length >= 8;
    }

    public static boolean hasPasswordDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}
