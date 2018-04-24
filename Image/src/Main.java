import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {

		Imagem circulo = new Imagem("src/circulo.png");
		Imagem oval = new Imagem("src/oval.png");

		System.out.println("Circulo");
		System.out.println("Inicio: " + circulo.getIniX() + " " + circulo.getIniY());
		System.out.println("Largura " + circulo.getMaiorLargura());
		System.out.println("Altura " +circulo.getMaiorAltura());
		System.out.println("Numero de pontos na borda " + circulo.getPoints());
		System.out.println("Perimetro " + circulo.getPeri());


		System.out.println("\n");
		System.out.println("Oval");
		System.out.println("Inicio: " + oval.getIniX() + " " + oval.getIniY());
		System.out.println("Largura " + oval.getMaiorLargura());
		System.out.println("Altura " +oval.getMaiorAltura());
		System.out.println("Numero de pontos na borda " + oval.getPoints());
		System.out.println("Perimetro " + oval.getPeri());
	}



}
