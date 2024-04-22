import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatePasswordTest {
    @Test
    public void isPasswordLongEnough_WhenPassword2Char_ThenReturnFalse() {
        // GIVEN
        String password = "ab";

        // WHEN
        boolean actual = ValidatePassword.isPasswordLongEnough(password);

        // THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void isPasswordLongEnough_WhenPassword7Char_ThenReturnFalse() {
        // GIVEN
        String password = "52wg32#";

        // WHEN
        boolean actual = ValidatePassword.isPasswordLongEnough(password);

        // THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void isPasswordLongEnough_WhenPassword8Char_ThenReturnTrue() {
        // GIVEN
        String password = "52w%g32#";

        // WHEN
        boolean actual = ValidatePassword.isPasswordLongEnough(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void isPasswordLongEnough_WhenPassword9Char_ThenReturnTrue() {
        // GIVEN
        String password = "52w%g3@2#";

        // WHEN
        boolean actual = ValidatePassword.isPasswordLongEnough(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void isPasswordLongEnough_WhenPassword128Char_ThenReturnTrue() {
        // GIVEN
        String password = "t&8hTjfQXndtBffJZC@xvS!gSeQYF54*JK^7i5QCTjTtvJFFcrq#oYgf4TVp8m!PT*^g8NW!4qYLBXnm#ud%gBy2r^^Ws%reYKRUkraR98gF4K8HBR#dvmgzsS$wVjvy";

        // WHEN
        boolean actual = ValidatePassword.isPasswordLongEnough(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void hasPasswordDigits_WhenPasswordHasNoDigit_ThenReturnFalse() {
        // GIVEN
        String password = "wegouzwgekuwzgekwrhweh";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordDigits(password);

        // THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void hasPasswordDigits_WhenPasswordHas0_ThenReturnTrue() {
        // GIVEN
        String password = "wegouzwgekuwzgekwr0hweh";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordDigits(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void hasPasswordDigits_WhenPasswordHasSeveralDigits_ThenReturnTrue() {
        // GIVEN
        String password = "wegouz7wgeku2wzge34kwr0hweh";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordDigits(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void hasPasswordMixedCase_WhenPasswordHasNoUppercaseChar_ThenReturnFalse() {
        // GIVEN
        String password = "wegouz7wgeku2wzge34kwr0hweh";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordMixedCase(password);

        // THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void hasPasswordMixedCase_WhenPasswordHasNoLowercaseChar_ThenReturnFalse() {
        // GIVEN
        String password = "EZGKWUG8125125WGQIGQUWGI";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordMixedCase(password);

        // THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void hasPasswordMixedCase_WhenPasswordHasOnlyDigits_ThenReturnFalse() {
        // GIVEN
        String password = "72039213620836702682";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordMixedCase(password);

        // THEN
        Assertions.assertFalse(actual);
    }

    @Test
    public void hasPasswordMixedCase_WhenPasswordHasUpperAndLowerCaseChar_ThenReturnTrue() {
        // GIVEN
        String password = "7203W9213620w836702682";

        // WHEN
        boolean actual = ValidatePassword.hasPasswordMixedCase(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void isPasswordCommonlyUsed_WhenPasswordIs123456_ThenReturnTrue() {
        // GIVEN
        String password = "123456";

        // WHEN
        boolean actual = ValidatePassword.isPasswordCommonlyUsed(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void isPasswordCommonlyUsed_WhenPasswordIsminecRAft_ThenReturnTrue() {
        // GIVEN
        String password = "minecRAft";

        // WHEN
        boolean actual = ValidatePassword.isPasswordCommonlyUsed(password);

        // THEN
        Assertions.assertTrue(actual);
    }

    @Test
    public void isPasswordCommonlyUsed_WhenPasswordIsVeryRandom_ThenReturnFalse() {
        // GIVEN
        String password = "a4ZzRB%BBoDb8@EJyR2#";

        // WHEN
        boolean actual = ValidatePassword.isPasswordCommonlyUsed(password);

        // THEN
        Assertions.assertFalse(actual);
    }
}
