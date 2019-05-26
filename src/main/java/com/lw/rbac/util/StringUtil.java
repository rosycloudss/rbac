package com.lw.rbac.util;

import org.springframework.util.DigestUtils;
import org.springframework.web.util.pattern.PatternParseException;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName StringUtil
 * @Descriptio TODO
 * @Author liwei
 * @Date 2019/5/24 23:54
 * @Version 1.0
 */
public class StringUtil {

    private static String DEFAULT_ENCODING = "UTF-8";
    private static String SHA_256 = "SHA-256";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_PHONE = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * @return
     * @Author liwei
     * @Description TODO
     * @Date 2019/5/25 0:03
     * @Param
     */
    public static String getSalt() {
        return UUID.randomUUID().toString();
    }

    /**
     * @Author liwei
     * @Description TODO 获取字符串的hash值
     * @Date 2019/5/25 9:07
     * @Param [str]
     * @Return java.lang.String
     */
    public static String sha256Digest(String password, String salt) {
        String result = null;
        try {
            // SHA 加密开始
            // 创建加密对象 并傳入加密類型
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
            // 传入要加密的字符串
            messageDigest.update((password + salt).getBytes());
            // 得到 byte 类型结果
            byte[] byteBuffer = messageDigest.digest();
            //将byte转换为String类型
            StringBuffer strHexString = new StringBuffer();
            for (int i = 0; i < byteBuffer.length; i++) {
                String hex = Integer.toHexString(0xff & byteBuffer[i]);
                if (hex.length() == 1) {
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }
            result = strHexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Author liwei
     * @Description TODO 判断字符串是否为空
     * @Date 2019/5/25 9:43
     * @Param [str]
     * @Return boolean
     */
    public static boolean isBlank(String str) {
        if (str == null || Objects.equals(str, "")) {
            return true;
        }
        return false;
    }

    /**
     * @Author liwei
     * @Description TODO 判断字符串是否为电话号码
     * @Date 2019/5/25 9:49
     * @Param [phone]
     * @Return boolean
     */
    public static boolean isPhone(String phone) {
        if (!StringUtil.isBlank(phone)) {
            return Pattern.matches(REGEX_PHONE, phone);
        }
        return false;
    }

    /**
     * @Author liwei
     * @Description TODO 验证邮箱
     * @Date 2019/5/25 9:53
     * @Param [email]
     * @Return boolean
     */
    public static boolean isEmail(String email) {
        if (!StringUtil.isBlank(email)) {
            return Pattern.matches(REGEX_EMAIL, email);
        }
        return false;
    }

    /**
     * @Author liwei
     * @Description TODO 验证身份证号
     * @Date 2019/5/25 9:57
     * @Param [idCard]
     * @Return boolean
     */
    public static boolean isIDCard(String idCard) {
        if (!StringUtil.isBlank(idCard)) {
            return Pattern.matches(REGEX_ID_CARD, idCard);
        }
        return false;
    }

    /**
     * @Author liwei
     * @Description TODO 验证ip
     * @Date 2019/5/25 9:56
     * @Param [ip]
     * @Return boolean
     */
    public static boolean isIp(String ip) {
        if (!StringUtil.isBlank(ip)) {
            return Pattern.matches(REGEX_IP_ADDR, ip);
        }
        return false;
    }

}
