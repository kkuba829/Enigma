package factories;

import Cipher.Cipher;
import Cipher.Imp.CezarCipher;
import Cipher.Imp.Root13Cipher;
import Expections.CipherNotFoundException;
import factories.impl.CipherFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {
    private CipherFactory factory = new CipherFactoryImpl();
    private static final String MESSAGE = "Type of cipher is not recognized : ";

    @Test
    protected void ifCesarInstanceReturndeWitchCesarTypeTest() {
        Cipher cipher = factory.create(CipherFactoryImpl.CESAR);
        Assertions.assertTrue(cipher instanceof CezarCipher);


    }

    @Test
    protected void testRoot13() {
        Cipher cipher = factory.create(CipherFactoryImpl.ROOT13);
        Assertions.assertTrue(cipher instanceof Root13Cipher);
    }

    @Test
    protected void shouldThroweExpectionWithGivenKnownType() {
        String unknown = "unknown";

        Assertions.assertThrows(CipherNotFoundException.class, () -> factory.create(unknown), MESSAGE + unknown);
    }
}
