/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.control;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Está classe define o metodo para criptografar informação.
 * Para que informações sigilosas, não sejam salvas em formato texto simples.
 * @author Gerson Luiz
 * @since 23/09/2018
 * @see http://blog.caelum.com.br/guardando-senhas-criptografadas-em-java/
 * @version 1.0
 */
public class Criptografia {
    
    /**
    * Este método define a criptografia utilizando o algoritmo SHA-256
    * @author Gerson Luiz
    * @see http://blog.caelum.com.br/guardando-senhas-criptografadas-em-java/
    * @param original Texto original, do tipo String a ser criptografado.
    * @return Texto criptografado, em formato String.
    * @since 23/09/2018
    * @version 1.0
    */
    public String sha256(String original){
        MessageDigest algorithm = null;
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte messageDigest[] = null;
        try {
            messageDigest = algorithm.digest(original.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        String criptografada = hexString.toString();
        return criptografada;
    }   
}