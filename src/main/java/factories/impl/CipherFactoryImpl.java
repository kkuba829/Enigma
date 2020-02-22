package factories.impl;

import Cipher.Cipher;
import Cipher.Imp.CezarCipher;
import Cipher.Imp.Root13Cipher;
import Expections.CipherNotFoundException;

public class CipherFactoryImpl implements factories.CipherFactory {
    public static final String CESAR = "cesar";
    public static final String ROOT13 = "root13";

    @Override
    public Cipher create(String type) {
        if ( type.equals(CESAR) ) {
            return new CezarCipher();
        }
        if ( type.equals(ROOT13) ) {
            return new Root13Cipher();
        }
        throw new CipherNotFoundException(type);
    }
}
