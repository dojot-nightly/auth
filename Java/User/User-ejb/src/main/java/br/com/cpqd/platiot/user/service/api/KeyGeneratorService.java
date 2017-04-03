package br.com.cpqd.platiot.user.service.api;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface KeyGeneratorService {
    String generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, NoSuchProviderException;

    byte[] generateSalt() throws NoSuchAlgorithmException;
}