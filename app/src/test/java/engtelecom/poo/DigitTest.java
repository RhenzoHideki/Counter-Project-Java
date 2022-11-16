package engtelecom.poo;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

public class DigitTest {

    @Test
    void showDigitTest() {
        Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)
        int dimensao = 800;
        desenho.setXscale(0, dimensao);
        desenho.setYscale(0, dimensao);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto
        // depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos
        double fator = 50;
        double xInicial = 200;
        double yInicial = 200;

        // Deve Mostrar O numero 2 utilizando 7 segmentos
        Digit digit = new Digit(fator, Draw.BLACK, Draw.GRAY, xInicial, yInicial);
        digit.showNumber(2, desenho);
        desenho.show();
    }

}
