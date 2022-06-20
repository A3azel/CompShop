package SiteSeqretu;

import DAO.DAOFactory;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSecurity {
    private static final int ITERATIONS = 200000;
    private static final int KEY_LENGTH = 512;
    private static final int SALT_LENGTH = 128;

    public static String hashPassword(final String password) throws Exception {
        byte[] salt = new byte[SALT_LENGTH / 8];
        (new SecureRandom()).nextBytes(salt);
        byte[] hashedBytes = hashPassword(password.toCharArray(), salt);
        return Hex.encodeHexString(hashedBytes) + Hex.encodeHexString(salt);
    }

    private static byte[] hashPassword(final char[] password, final byte[] salt) throws Exception {
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        SecretKey key = skf.generateSecret(spec);
        return key.getEncoded();
    }

    public static boolean isPasswordCorrect(final String password, final String passwordSaltHexed) throws Exception {
        if (password == null || passwordSaltHexed == null)
            return false;
        String passwordHexed = passwordSaltHexed.substring(0, KEY_LENGTH / 8 * 2);
        byte[] salt = Hex.decodeHex(passwordSaltHexed.substring(KEY_LENGTH / 8 * 2).toCharArray());
        byte[] hashedBytes = hashPassword(password.toCharArray(), salt);
        return Hex.encodeHexString(hashedBytes).equals(passwordHexed);
    }


    public static boolean isLoginValid(final String login){
        return login != null && login.length() >= 4 && login.length() <= 16 && DAOFactory.getInstance().getUserDAORealize().getUser(login)==null;
    }

    public static boolean isPasswordValid(final String password)  {
        return password != null && password.length() >= 8 && password.length() <= 64;
    }

    public static boolean isEmailValid(final String email)  {
        Pattern pattern = Pattern.compile("^((([0-9A-Za-z]{1}[-0-9A-z\\.]{0,30}[0-9A-Za-z]?)|([0-9А-Яа-я]{1}[-0-9А-я\\.]{0,30}[0-9А-Яа-я]?))@([-A-Za-z]{1,}\\.){1,}[-A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean isPhoneValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }
}
