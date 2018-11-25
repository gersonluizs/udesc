package br.udesc.ceavi.estude.view;

import br.udesc.ceavi.estude.view.principal.FrameSistema;
import br.udesc.ceavi.estude.view.window.SplashScreen;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tela que executa a aplicação principal.
 * @author Gerson Luiz Saldanha dos Santos
 * @version 1.0
 * @since 24/11/2018
 */
public class TelaPrincipal implements Runnable {

    public static void main(String[] args) {
        //Instancia a classe principal da aplicação
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        
        //Instancia uma thread para executar a aplicação
        Thread thread = new Thread(telaPrincipal);

        //Executa a thread da aplicação.
        thread.start();
    }

    /**
     * Método responsável pela execução da Thread principal da aplicação.
     */
    @Override
    public void run() {
        
        // Instancia o splashscreen do sistema
        SplashScreen splash = new SplashScreen(3000);
        
        //Exibe o splashscreen do sistema
        try {
            splash.showSplashAndExit();
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Instancia a tela principal da aplicação
        FrameSistema frame = new FrameSistema();
        
        //Exibe a tela principal para o usuário
        frame.setVisible(true);   
    }   
}