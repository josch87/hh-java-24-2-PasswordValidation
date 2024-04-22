import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratePasswordTest {

    @Test
    public void getNewPassword_CheckIfPasswordLongEnough_WhenCalledWith7_ThenReturnException() {
        // GIVEN
        int passwordLength = 7;

        // THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> GeneratePassword.getNewPassword((passwordLength)), "getNewPassword() should throw exception because password length must be at least 8 characters");
    }
    
    @Test
    public void getNewPassword_CheckIfPasswordLongEnough_WhenCalledWith8_ThenReturnTrue() {
        // GIVEN
        int passwordLength = 8;

        // WHEN
        String newPassword = GeneratePassword.getNewPassword(passwordLength);

        // THEN
        boolean isLongEnough = ValidatePassword.isPasswordLongEnough(newPassword);
        Assertions.assertTrue(isLongEnough);
    }

    @Test
    public void getNewPassword_WhenCalledWith8_ThenReturnValidString() {
        // GIVEN
        int passwordLength = 8;

        // WHEN
        String actual = GeneratePassword.getNewPassword(passwordLength);

        // THEN
        boolean isPasswordLongEnough = ValidatePassword.isPasswordLongEnough(actual);
        boolean hasPasswordDigits = ValidatePassword.hasPasswordDigits(actual);
        boolean hasPasswordMixedCase = ValidatePassword.hasPasswordMixedCase(actual);
        boolean noCommonPassword = !ValidatePassword.isPasswordCommonlyUsed(actual);

        Assertions.assertTrue(isPasswordLongEnough && hasPasswordDigits && hasPasswordMixedCase && noCommonPassword);
    }

    @Test
    public void getNewPassword_WhenCalledWith10_ThenReturnStringLength10() {
        // GIVEN
        int passwordLength = 10;

        // WHEN
        String actual = GeneratePassword.getNewPassword(passwordLength);

        // THEN
        Assertions.assertEquals(passwordLength, actual.length());
    }
}
