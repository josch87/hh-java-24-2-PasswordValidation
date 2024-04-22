import java.security.SecureRandom;

public class GeneratePassword {
    public static String getNewPassword(int PasswordLength) {
        if (PasswordLength < 8 ) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }

        StringBuilder password = new StringBuilder((PasswordLength));
        SecureRandom random = new SecureRandom();

        String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
        String DIGITS = "0123456789";
        String SPECIAL_CHARACTERS = "!@#$%^&*()-+";
        String ALL_CHARS = UPPERCASE_CHARS + LOWERCASE_CHARS + DIGITS + SPECIAL_CHARACTERS;

        password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));
        password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < PasswordLength; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        if (ValidatePassword.isPasswordCommonlyUsed(password.toString())) {
            return getNewPassword(PasswordLength);
        }

        if (!ValidatePassword.isPasswordLongEnough(password.toString())) {
            return getNewPassword(PasswordLength);
        }
        if (!ValidatePassword.hasPasswordDigits(password.toString())) {
            return getNewPassword(PasswordLength);
        }
        if (!ValidatePassword.hasPasswordMixedCase(password.toString())) {
            return getNewPassword(PasswordLength);
        }
        if (!ValidatePassword.hasPasswordSpecialCharacter(password.toString())) {
            return getNewPassword(PasswordLength);
        }

        return password.toString();
    }


}
