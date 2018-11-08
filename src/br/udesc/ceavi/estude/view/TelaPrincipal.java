/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view;

import br.udesc.ceavi.estude.view.frame.FrameCRUDAcao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDAcaoManutencao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDTela;
import br.udesc.ceavi.estude.view.frame.FrameCRUDTelaManutencao;
import br.udesc.ceavi.estude.view.frame.FrameCRUDUsuario;
import br.udesc.ceavi.estude.view.frame.FrameCRUDUsuarioManutencao;
import br.udesc.ceavi.estude.view.principal.FramePrincipal;
import br.udesc.ceavi.estude.view.window.SplashScreen;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Gerson Luiz
 */
public class TelaPrincipal implements Runnable{
    
    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        Thread thread = new Thread(telaPrincipal);

        thread.start();
    }
    @Override
    public void run() {

        SplashScreen splash = new SplashScreen(3000);
        try {
            splash.showSplashAndExit();
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame fPrincipal = new FramePrincipal();
        fPrincipal.setVisible(true);

    }
}