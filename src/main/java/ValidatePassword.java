public class ValidatePassword {

    public static boolean isPasswordLongEnough(String password) {
        int length = password.length();
        return length >= 8;
    }
}
