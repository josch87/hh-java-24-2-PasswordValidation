import java.util.Arrays;

public class ValidatePassword {

    private static final String[] passwordListTop100 = {
            "123456", "password", "123456", "password", "12345678", "qwerty", "123456789", "12345", "1234", "111111",
            "1234567", "dragon", "123123", "baseball", "abc123", "football", "monkey", "letmein", "696969", "shadow",
            "master", "666666", "qwertyuiop", "123321", "mustang", "1234567890", "michael", "654321", "pussy",
            "superman", "1qaz2wsx", "7777777", "fuckyou", "121212", "000000", "qazwsx", "123qwe", "killer", "trustno1",
            "jordan", "jennifer", "zxcvbnm", "asdfgh", "hunter", "buster", "soccer", "harley", "batman", "andrew",
            "tigger", "sunshine", "iloveyou", "fuckme", "2000", "charlie", "robert", "thomas", "hockey", "ranger",
            "daniel", "starwars", "klaster", "112233", "george", "asshole", "computer", "michelle", "jessica", "pepper",
            "1111", "zxcvbn", "555555", "11111111", "131313", "freedom", "777777", "pass", "fuck", "maggie", "159753",
            "aaaaaa", "ginger", "princess", "joshua", "cheese", "amanda", "summer", "love", "ashley", "6969", "nicole",
            "chelsea", "biteme", "matthew", "access", "yankees", "987654321", "dallas", "austin", "thunder", "taylor",
            "matrix", "minecraft"
    };

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

    public static boolean hasPasswordMixedCase(String password){
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                hasUppercase = true;
            }
            if (Character.isLowerCase(character)) {
                hasLowercase = true;
            }
        }

        return hasUppercase && hasLowercase;
    }

    public static boolean isPasswordCommonlyUsed(String password) {
        return Arrays.asList(passwordListTop100).contains(password.toLowerCase());
    }
}
