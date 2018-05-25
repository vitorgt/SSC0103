import java.util.Calendar;

/**
 * Random numbers generator.
 * @author 10284667	Fabio F. Destro
 * @author 10284952	Vitor G. Torres
 */
public class Random {

	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	private long x = 1023;

	/**
	 * Class constructor that sets a random seed.
	 */
	public Random(){
		this.x = -Calendar.getInstance().getTimeInMillis();
		this.x = (a + m * x) % p;
	}

	/**
	 * Class constructor setting seed.
	 * @param seed Desired seed.
	 */
	public Random(int seed){
		this.x = seed;
	}

	/**
	 * Returns a random number in range [0;1[.
	 * @return Generated number.
	 */
	public double getRandom(){
		this.x = (a + m * x) % p;
		return ((double)x)/p;
	}

	/**
	 * Returns a random number in range [0;max[.
	 * @param max The limit value for generating the integer number.
	 * @return Generated number.
	 */
	public int getIntRandom(int max){
		return (int)(getRandom() * max);
	}

	/**
	 * Allows to change the seed.
	 * @param seed New seed.
	 */
	public void setSeed(int seed){
		this.x = seed;
	}

}
