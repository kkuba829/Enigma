package factories.impl;

import Cipher.Cipher;
import Cipher.Imp.CezarCipher;
import Cipher.Imp.Root13Cipher;
import Cipher.Imp.VigenereCipher;
import Expections.CipherNotFoundException;

public class CipherFactoryImpl implements factories.CipherFactory {
    public static final String CESAR = "cesar";
    public static final String ROOT13 = "root13";
    public static final String VigenereCipher = "Vigenerecipher";

    @Override
    public Cipher create(String type) {
        if ( type.equals(CESAR) ) {
            return new CezarCipher();
        }
        if ( type.equals(ROOT13) ) {
            return new Root13Cipher();
        }
        if ( type.equals(VigenereCipher) ) {
            return new VigenereCipher("Tak");
        }
        throw new CipherNotFoundException(type);
    }
}
