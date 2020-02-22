package file.Utils;

import Cipher.Imp.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRoot13 {
    private final String No_Alphabetic_Signs = "!@#$%^&*()";
    private final String Alphabetic_Signs = "Abcd";
    private final String Expected_Encode_Alphabetic_Sings = "Nopq";

    Root13Cipher root13Cipher = new Root13Cipher();

    @Test
    public void testDecode() {
        String decode = root13Cipher.decode(No_Alphabetic_Signs);
        Assertions.assertEquals(No_Alphabetic_Signs , decode);
    }

    @Test
    public void testEncode() {
        String encode = root13Cipher.encode(Expected_Encode_Alphabetic_Sings);
        Assertions.assertEquals(Alphabetic_Signs, encode);

    }


    }

