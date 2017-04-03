package br.com.cpqd.platiot.user.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;

import javax.ejb.Singleton;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import br.com.cpqd.platiot.user.service.api.KeyGeneratorService;

@Singleton
public class KeyGeneratorServiceImpl implements KeyGeneratorService {
    private static final String PROVIDER_BC = "BC";
    private static final String ALGORITHM_SHA512 = "SHA-512";
    private static final String ALGORITHM_SHA1PRNG = "SHA1PRNG";

    @Override
    public String generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, NoSuchProviderException {
        byte[] passwordBytes = password.getBytes();
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance(ALGORITHM_SHA512, PROVIDER_BC);
        byte[] keyAndSaltBytes = new byte[passwordBytes.length + salt.length];
        System.arraycopy(passwordBytes, 0, keyAndSaltBytes, 0, passwordBytes.length);
        System.arraycopy(salt, 0, keyAndSaltBytes, passwordBytes.length, salt.length);
        byte[] hash = md.digest(keyAndSaltBytes);
        return new String(Base64.encode(hash));
    }

    @Override
    public byte[] generateSalt() throws NoSuchAlgorithmException {
        byte[] salt = new byte[16];
        SecureRandom secureRandom = SecureRandom.getInstance(ALGORITHM_SHA1PRNG);
        secureRandom.nextBytes(salt);
        return salt;
    }
}