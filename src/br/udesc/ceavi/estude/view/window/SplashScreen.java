/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.estude.view.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Classe que define os atributos e comportamentos do SplashScreen do sistema
 * SplashScreen é a tela de inicialização.
 * @author Gerson Luiz
 * @since 23/09/2018
 */
public class SplashScreen extends JWindow{
    private int duration;
    
    public SplashScreen(){
        super();
    }
    
    public SplashScreen(int d){
        setDuration(d);
    }
    
    public void setDuration(int d){
        this.duration = d;
    }
    
    public void showSplash() throws IOException{
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);
        
        //Posição e tamanho da tela
        int width  = 600;
        int height = 600;
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        
        // splash screen
        //pacote onde estao as imagens no seu projeto
        String diretorio = "/br/udesc/ceavi/estude/view/img/splashscreen.png";

        InputStream stream = getClass().getResourceAsStream(diretorio);
        Image image = ImageIO.read(stream);
        ImageIcon icon = new ImageIcon(image);
        JLabel imagem = new JLabel(icon);
        
        JLabel copyrt = new JLabel ("Copyriht 2018, Estude", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        
        content.add(imagem, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        
        setVisible(true);
        
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            setVisible(false);
        }
    }
    
    public void showSplashAndExit() throws IOException{
        showSplash();
        setVisible(false);
    }
}