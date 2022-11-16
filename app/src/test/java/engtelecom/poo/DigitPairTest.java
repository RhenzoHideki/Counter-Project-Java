package engtelecom.poo;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

public class DigitPairTest {

    @Test
    void ShowDigitPairTest() {
        Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)
        int dimensao = 800;
        desenho.setXscale(0, 800);
        desenho.setYscale(0, 800);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto
        // depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos
        double fator = 50;
        double xInicial = 200;
        double yInicial = 200;

        // Deve mostrar 52 24 12 como 3 pares de 7 segments
        DigitPair digitsDigit = new DigitPair(fator, Draw.BLACK, Draw.RED, xInicial, yInicial);
        digitsDigit.showOnes(2, desenho);
        digitsDigit.showTens(5, desenho);

        DigitPair a = new DigitPair(fator, Draw.BLACK, Draw.RED, xInicial + 3 * fator, yInicial);
        a.showOnes(4, desenho);
        a.showTens(2, desenho);

        DigitPair b = new DigitPair(fator, Draw.BLACK, Draw.RED, xInicial + 6 * fator, yInicial);
        b.showOnes(2, desenho);
        b.showTens(1, desenho);

        desenho.show();
    }

}
