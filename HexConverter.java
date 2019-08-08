package CrpytoChallenges;

import com.sun.org.apache.xml.internal.security.utils.Base64.*;
import java.util.Base64;

/**
 * A class designed for converting Hex numbers to Base64 Numbers and more.
 */
public class HexConverter {
    /**
     * A method to convert any hex encoding into a byte array.
     *
     * @param hexCode
     * @return the byte array
     */
    public static byte[] hexToByteConverter(String hexCode) {
       int length = hexCode.length();
       byte[] data = new byte[length / 2];
       for(int i = 0; i < length; i+=2)
           data[i / 2] = (byte) ((Character.digit(hexCode.charAt(i), 16) << 4)
                   + Character.digit(hexCode.charAt(i+1), 16));
       return data;
    }

    /**
     * A simple method to turn a byte array into a 64Base Encoding.
     * @param data
     * @return the encoding of the byte array into 64 Base.
     */
    public static String byteToBaseSixtyFourConverter(byte[] data) { return new String(Base64.getEncoder().encode(data));}

    /**
     * A class to convetr a byte array into its Hex representation.
     * @param data
     * @return
     */
    public static String byteArrayToHexConverter(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    /**
     * A class to xor together any two equal length hex numbers.
     * @param hexOne
     * @param hexTwo
     * @return
     */
    public static String xorProducer(String hexOne, String hexTwo) {
        if(hexOne.length() != hexTwo.length())
            throw new NumberFormatException();
        byte[] byteOne = hexToByteConverter(hexOne);
        byte[] byteTwo = hexToByteConverter(hexTwo);
        byte[] xorArray = new byte[byteOne.length];
        int i = 0;
        for(byte num : byteOne) {
            xorArray[i] = (byte)(num ^ byteTwo[i++]);
        }
        return byteArrayToHexConverter(xorArray);
    }
}
