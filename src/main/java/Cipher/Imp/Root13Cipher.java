package Cipher.Imp;

import Cipher.Cipher;

public class Root13Cipher implements Cipher {
    private static final String Alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int ROOT_DISPLACEMENT = 13;
    @Override
    public String encode(String textToEncode) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < textToEncode.length(); i++) {
            char sign = textToEncode.charAt(i);
            if (isIncluded(sign)) {
                boolean islowerCase = Character.isLowerCase(sign);
                int indexInAlphabet = Alphabet.indexOf(Character.toLowerCase(sign));
                int indexAfterDisplacement = (indexInAlphabet + ROOT_DISPLACEMENT) % Alphabet.length();
                if ( islowerCase ) {
                    stringBuilder.append(Alphabet.charAt(indexAfterDisplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(Alphabet.charAt(indexAfterDisplacement)));
                }

            }else {
                stringBuilder.append(sign);
            }
            }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String textToDecode) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < textToDecode.length(); i++) {
            char sign = textToDecode.charAt(i);
            if (isIncluded(sign)) {
                boolean islowerCase = Character.isLowerCase(sign);
                int indexInAlphabet = Alphabet.indexOf(Character.toLowerCase(sign));
                int indexAfterDisplacement = (indexInAlphabet - ROOT_DISPLACEMENT + Alphabet.length()) % Alphabet.length();
                if ( islowerCase ) {
                    stringBuilder.append(Alphabet.charAt(indexAfterDisplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(Alphabet.charAt(indexAfterDisplacement)));
                }

            }else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }
    private boolean isIncluded(char sign) {
        return Alphabet.contains(Character.toString(sign).toLowerCase());
    }
    }

