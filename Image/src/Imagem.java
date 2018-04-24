import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagem {

	private int iniX, iniY, maiorLargura, maiorAltura, altura, largura;
	private double peri;
	private int[][] img;

	public Imagem(String nome){

		BufferedImage image = null;
		File inFile = new File(nome);
		try {
			image = ImageIO.read(inFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		altura = image.getHeight();
		largura = image.getWidth();
		img = new int[largura][altura];


		Raster raster = image.getData();
		boolean flag = true;
		for (int i = 0; i <altura; i++) {
			int lAt = 0;
			for (int j = 0; j < largura; j++) {
				img[j][i] = raster.getSample(j, i, 0);

				if(img[j][i] == 255) lAt = 0;
				else {
					lAt += 1;
					if(lAt > maiorLargura){
						maiorLargura = lAt;
					}
				}

				if(flag && img[j][i] < 255){
					iniX = j;
					iniY = i;
					flag = false;
				}
				//System.out.printf("%3d",raster.getSample(j, i, 0));
			}
			// System.out.println("");
		}
		for (int i = 0; i <largura; i++) {
			int aAt = 0;
			for (int j = 0; j < altura; j++) {
				if(img[i][j] == 255) aAt = 0;
				else {
					aAt += 1;
					if(aAt > maiorAltura){
						maiorAltura = aAt;
					}
				}
			}
		}
	}

	public int getIniX() {
		return iniX;
	}
	public int getIniY() {
		return iniY;
	}
	public int getMaiorLargura() {
		return maiorLargura;
	}
	public int getMaiorAltura() {
		return maiorAltura;
	}

	public int getPoints(){
		int numPontos = 0;
		for(int i = 0; i < altura ; i++){
			for(int j = 0; j < largura; j++){
				if(img[j][i] < 255 && ((img[j+1][i]) == 255 || (img[j-1][i]) == 255 || (img[j][i+1]) == 255 || (img[j][i-1]) == 255)){
					numPontos++;
				}
			}
		}
		return numPontos;
	}

	public double getPeri(){
		peri = 0;
		for(int i = 1; i < altura - 1; i++){
			for(int j = 1; j < largura - 1; j++){
				if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] == 255 && img[j+1][i-1] == 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] == 255 && img[j+1][i-1] == 255){
					peri += 2;
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] == 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] == 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] == 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 2;
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] == 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] == 255){
					peri += 2;
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] == 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 2;
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] == 255 && img[j+1][i-1] < 255){
					peri += 2*Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] == 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 2*Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] == 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 2*Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] == 255 && img[j+1][i-1] == 255){
					peri += 2*Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] == 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] == 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] == 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] == 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] == 255 && img[j+1][i-1] == 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] == 255 && img[j+1][i+1] == 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] == 255 && img[j][i+1] == 255 && img[j+1][i+1] == 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] < 255 && img[j][i-1] < 255 && img[j+1][i-1] < 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] == 255 && img[j][i] < 255 && img[j+1][i] < 255 && img[j-1][i-1] == 255 && img[j][i-1] == 255 && img[j+1][i-1] == 255){
					peri += 1+Math.sqrt(2);
				}
				else if(img[j-1][i+1] < 255 && img[j][i+1] < 255 && img[j+1][i+1] < 255 && img[j-1][i] < 255 && img[j][i] < 255 && img[j+1][i] == 255 && img[j-1][i-1] == 255 && img[j][i-1] == 255 && img[j+1][i-1] == 255){
					peri += 1+Math.sqrt(2);
				}
			}
		}
		return peri/2;
	}


}
