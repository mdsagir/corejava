package com.greenjava.trywithresource;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

public class Java_UUID {


    Logger logger = Logger.getLogger(Java_UUID.class.getName());

    @Test
    public void uuidGenerate() throws UnsupportedEncodingException, NoSuchAlgorithmException {

        // version 4
        MessageDigest messageDigestSalt = MessageDigest.getInstance("SHA-256");
        messageDigestSalt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
        String digest = bytesToHex(messageDigestSalt.digest());
        logger.info("Digest "+digest);


        UUID uuid = UUID.randomUUID();
        logger.info("variant "+uuid.variant());
        logger.info("version "+uuid.version());


    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
