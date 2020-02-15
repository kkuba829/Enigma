import Cipher.Cipher;
import Cipher.Imp.CezarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class Test {


    protected final String textWithAlphabeticLetters = "112312[]][";
        protected final String TextWithAlphabeticsLetters = "abcćd";
        protected final String expectedTextForAlphabeticLetters = "defgg";
        protected final String mixedText = "123ac///";
        protected final String expectedTextForMixedText = "123df//";
        protected Cipher cesarCipher = new CezarCipher();

        @DisplayName( "Testing correction of encoding text with no alphabetic letters")


    @org.junit.jupiter.api.Test
    public void testIfOnlyAlphabeticLettersAreEncode () {
            String decode = cesarCipher.encode(textWithAlphabeticLetters);
            Assertions.assertEquals(expectedTextForAlphabeticLetters, decode);
    }

    @org.junit.jupiter.api.Test
    public void Testencode() {
        String encode = cesarCipher.encode("sass");
        Assertions.assertEquals(textWithAlphabeticLetters, encode);

    }
        @DisplayName("Testing correction of encoding text with no alphabetic letters")
                @org.junit.jupiter.api.Test
        public void testEncodingModifyTextWithAlphabeticChars() {
            String encoded = cesarCipher.encode(textWithAlphabeticLetters);
            Assertions.assertEquals(expectedTextForAlphabeticLetters, encoded);
        }
        @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @org.junit.jupiter.api.Test
    public void  tetEncodingModifyTextWithAlphabeticChars() {
            String decoded = cesarCipher.decode(mixedText);
            Assertions.assertEquals(expectedTextForMixedText, decoded);
        }

}


