/*124m*/

import java.util.*;

public class Random {

	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	//private long xi = 1023;
	private long xi = -Calendar.getInstance().getTimeInMillis();
	private boolean retry = true;

	public Random(long seed){
		xi = seed;
	}

	public Random(){
	}

	public void setSeed(){
		while(retry){
			try{
				System.out.println("Type an integer for seed: ");
				xi = EntradaTeclado.leInt();
				retry = false;
			}
			catch(Exception e){
				System.out.println("\nNot an integer\n");
				retry = true;
			}
			if(xi < 0){
				xi = -xi;
			}
		}
	}

	public double getRand(){
		xi = (a+m*xi)%p;
		double s = ((double)(xi))/p;
		return s;
	}

	public int getIntRand(){
		return (int)(getRand()*Integer.MAX_VALUE);
	}

	public int getIntRand(int max){
		return (int)(getRand()*max);
	}

	public int getIntRand(int min, int max) throws IllegalArgumentException{
		if(max <= min)
			throw new IllegalArgumentException("Invalid parameters");
		return (int)(min+(getRand()*(max-min)));
	}

	public long whatsMySeed(){
		return xi;
	}
}
