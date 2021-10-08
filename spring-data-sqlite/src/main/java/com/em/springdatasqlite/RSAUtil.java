////package com.daselearn.manage.util;
//package com.em.springdatasqlite;
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import java.io.ByteArrayOutputStream;
//import java.security.*;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
//public class RSAUtil {
//
//    public static String content = "{\"dateTime\":\"20210907\",\"state\":\"0\",\"content\":\"数据确认无误\"}";
//
//    public static void main(String[] args) throws Exception {
//        try {
////            generatorKey();
////            String content = "SyUSdU0hQP/iDae+6T6gj7EJzGsW4UPpG34bgRD8kEXpTpvBsGlGN7kxzgHL7l06WrXRRBdEpRB49/P1Vyl2Hi7C2OwgZpNWlrla2WnSLyBho71M07n4uG1GXby4RQvPRDLzVhXHG1oXpOPmj3d0oaYkc44YBDNfWGGsJ7mU8Jw=";
//            String content = "SyUSdU0hQP/iDae+6T6gj7EJzGsW4UPpG34bgRD8kEXpTpvBsGlGN7kxzgHL7l06WrXRRBdEpRB49/P1Vyl2Hi7C2OwgZpNWlrla2WnSLyBho71M07n4uG1GXby4RQvPRDLzVhXHG1oXpOPmj3d0oaYkc44YBDNfWGGsJ7mU8Jw=";
//            String base64publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAN4r62Tb/EZ7qCB6z9sXUGLKprMOY0ct\n" +
//                    "I1HNmZ9PvqVbCfn4FfiMp4bnGEKFsJ9WEOOyQIsUlPFY1lyYt/7yUNcCAwEAAQ==";
//            publicKeyDecrypt(content, base64publicKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 初始化密钥
//     */
//    public static void generatorKey() throws Exception {
//        //1.初始化密钥
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        keyPairGenerator.initialize(512);
//        KeyPair keyPair = keyPairGenerator.generateKeyPair();
//        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
//        System.out.println("Public Key : " + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
//        System.out.println("Private Key : " + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
//
//    }
//
//
//    /**
//     * 私钥加密、公钥解密——加密
//     *
//     * @param content          待加密数据
//     * @param base64privateKey 私钥
//     */
//    public static String privateKeyEncrypt(String content, String base64privateKey) throws Exception {
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(base64privateKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
//        byte[] bytes = content.getBytes();
//        int inputLen = bytes.length;
//        int offLen = 0;//偏移量
//        int i = 0;
//        ByteArrayOutputStream bops = new ByteArrayOutputStream();
//        while(inputLen - offLen > 0){
//            byte [] cache;
//            if(inputLen - offLen > 53){
//                cache = cipher.doFinal(bytes, offLen,53);
//            }else{
//                cache = cipher.doFinal(bytes, offLen,inputLen - offLen);
//            }
//            bops.write(cache);
//            i++;
//            offLen = 53 * i;
//        }
//        bops.close();
//        byte[] encryptedData = bops.toByteArray();
//        String data = Base64.encodeBase64String(encryptedData);
//        System.out.println("私钥加密、公钥解密——加密 : " + Base64.encodeBase64String(encryptedData));
//        return data;
//    }
//
//
//    /**
//     * 私钥加密、公钥解密——解密
//     *
//     * @param content         待解密数据
//     * @param base64publicKey 公钥
//     */
//    public static String publicKeyDecrypt(String content, String base64publicKey) throws Exception {
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64publicKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.DECRYPT_MODE, publicKey);
//        //byte[] result = cipher.doFinal(Base64.decodeBase64(content));
//        byte[] bytes = Base64.decodeBase64(content);
//        int inputLen = bytes.length;
//        int offLen = 0;
//        int i = 0;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        while(inputLen - offLen > 0){
//            byte[] cache;
//            if(inputLen - offLen > 64){
//                cache = cipher.doFinal(bytes,offLen,64);
//            }else{
//                cache = cipher.doFinal(bytes,offLen,inputLen - offLen);
//            }
//            byteArrayOutputStream.write(cache);
//            i++;
//            offLen = 64 * i;
//
//        }
//        byteArrayOutputStream.close();
//        byte[] byteArray = byteArrayOutputStream.toByteArray();
//        String data = new String(byteArray);
//        System.out.println("私钥加密、公钥解密——解密：" + new String(byteArray));
//        return data;
//    }
//
//
//    /**
//     * 公钥加密、私钥解密——加密
//     *
//     * @param content         待加密数据
//     * @param base64publicKey 公钥
//     */
//    public static String publicKeyEncrypt(String content, String base64publicKey) throws Exception {
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64publicKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        byte[] bytes = content.getBytes();
//        int inputLen = bytes.length;
//        int offLen = 0;//偏移量
//        int i = 0;
//        ByteArrayOutputStream bops = new ByteArrayOutputStream();
//        while(inputLen - offLen > 0){
//            byte [] cache;
//            if(inputLen - offLen > 53){
//                cache = cipher.doFinal(bytes, offLen,53);
//            }else{
//                cache = cipher.doFinal(bytes, offLen,inputLen - offLen);
//            }
//            bops.write(cache);
//            i++;
//            offLen = 53 * i;
//        }
//        bops.close();
//        byte[] encryptedData = bops.toByteArray();
//        String data = Base64.encodeBase64String(encryptedData);
//        System.out.println("公钥加密、私钥解密——加密 : " + Base64.encodeBase64String(encryptedData));
//        return data;
//    }
//
//    /**
//     * 公钥加密、私钥解密——解密
//     *
//     * @param content          待解密数据
//     * @param base64privateKey 秘钥
//     */
//    public static String privateKeyDecrypt(String content, String base64privateKey) throws Exception {
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(base64privateKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);
//        byte[] bytes = Base64.decodeBase64(content);
//        int inputLen = bytes.length;
//        int offLen = 0;
//        int i = 0;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        while(inputLen - offLen > 0){
//            byte[] cache;
//            if(inputLen - offLen > 64){
//                cache = cipher.doFinal(bytes,offLen,64);
//            }else{
//                cache = cipher.doFinal(bytes,offLen,inputLen - offLen);
//            }
//            byteArrayOutputStream.write(cache);
//            i++;
//            offLen = 64 * i;
//
//        }
//        byteArrayOutputStream.close();
//        byte[] byteArray = byteArrayOutputStream.toByteArray();
//        String data = new String(byteArray);
//        System.out.println("公钥加密、私钥解密——解密：" + new String(byteArray));
//        return data;
//
//    }
//
//    /**
//     * 私钥签名
//     *
//     * @param content          签名数据
//     * @param base64privateKey 私钥
//     */
//    public static String sign(String content, String base64privateKey) throws Exception {
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(base64privateKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//        Signature signature = Signature.getInstance("MD5withRSA");
//        signature.initSign(privateKey);
//        signature.update(content.getBytes());
//        byte[] result = signature.sign();
//        String data = Base64.encodeBase64String(result);
//        System.out.println("签名后的数据:" + Base64.encodeBase64String(result));
//        return data;
//    }
//
//    /**
//     * 公钥验签
//     *
//     * @param content         待签名数据
//     * @param sign            签名后的数据
//     * @param base64publicKey 公钥
//     */
//    public static boolean signVerify(String content, String sign, String base64publicKey) throws Exception {
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64publicKey));
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//        Signature signature = Signature.getInstance("MD5withRSA");
//        signature.initVerify(publicKey);
//        signature.update(content.getBytes());
//        boolean flag = signature.verify(Base64.decodeBase64(sign));
//        System.out.println("签名结果: " + flag);
//        return flag;
//    }
//
//}
