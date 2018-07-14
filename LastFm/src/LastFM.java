import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class Yo {

	private enum mon {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec};

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		HashMap<String, Artist> lib = new HashMap<>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(new File("src/yo.tsv")));
		} catch (Exception e) {}

		String line;
		try {
			while ((line = br.readLine()) != null) {
				String reg[] = line.split("\t");
				//if(!reg[1].isEmpty() && !reg[2].isEmpty() && !reg[3].isEmpty() && !reg[4].isEmpty() && !reg[5].isEmpty() && !reg[6].isEmpty() && !reg[7].isEmpty() && !reg[8].isEmpty()) {
				Builder time = new Calendar.Builder();
				time.set(Calendar.YEAR, Integer.parseInt(reg[1]));
				time.set(Calendar.MONTH, Integer.parseInt(reg[2])-1);
				time.set(Calendar.DAY_OF_MONTH, Integer.parseInt(reg[3]));
				time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(reg[4]));
				time.set(Calendar.MINUTE, Integer.parseInt(reg[5]));
				//System.out.println(time.build().getTime());
				if(!lib.containsKey(reg[6])) {
					lib.put(reg[6], new Artist());
				}
				if(!lib.get(reg[6]).getAlbuns().containsKey(reg[7])) {
					lib.get(reg[6]).getAlbuns().put(reg[7], new Album());
				}
				if(!lib.get(reg[6]).getAlbuns().get(reg[7]).getSong().containsKey(reg[8])) {
					lib.get(reg[6]).getAlbuns().get(reg[7]).getSong().put(reg[8], new Song());
				}
				lib.get(reg[6]).getAlbuns().get(reg[7]).getSong().get(reg[8]).getListened().add(time.build().getTime());
				//}
				/*
				   Set<HashMap<String, HashMap<String, Vector<String>>>> artista = lib.keySet();
				   if(!lib.keySet()) {
				   HashMap<String, HashMap<String, Vector<String>>> artista = new HashMap<String, HashMap<String, Vector<String>>>();
				   lib.put(artista, new Vector<Date>());
				   }
				   lib.putIfAbsent(
				   new HashMap<String, HashMap<String, Vector<String>>>().putIfAbsent(
				   reg[6],
				   new HashMap<String, Vector<String>>().putIfAbsent(
				   reg[7],
				   new Vector<String>().add(
				   reg[8]
				   )
				   )
				   ),
				   new Vector<Date>().add(
				   time.build().getTime()
				   )
				   )
				   ;
				   */
			}
		} catch (Exception e) {}
		HashMap<Integer, int[]> hours = new HashMap<Integer, int[]>();
		hours.put(0, new int[24]);
		HashMap<Integer, int[]> monthdays = new HashMap<Integer, int[]>();
		monthdays.put(0, new int[31]);
		HashMap<Integer, int[]> months = new HashMap<Integer, int[]>();
		months.put(0, new int[12]);
		HashMap<Integer, HashMap<Integer, int[]>> detail = new HashMap<Integer, HashMap<Integer, int[]>>();
		//int hours[][] = 	new int[7][24];
		//int monthdays[][] = new int[7][31];
		//int months[][] = 	new int[7][12];
		//int detail[][][] = 	new int[6][12][31];
		for(String artist : lib.keySet()) {
			//System.out.println(artist);
			for(String album : lib.get(artist).getAlbuns().keySet()) {
				//System.out.println("\t"+album);
				for(String song : lib.get(artist).getAlbuns().get(album).getSong().keySet()) {
					//System.out.println("\t\t("+lib.get(artist).getAlbuns().get(song).getSong().size()+") "+song);
					//int dat = 0;
					for(Date date : lib.get(artist).getAlbuns().get(album).getSong().get(song).getListened()) {
						if(!hours.containsKey(date.getYear()+1900)) {
							hours.put(date.getYear()+1900, new int[24]);
							monthdays.put(date.getYear()+1900, new int[31]);
							months.put(date.getYear()+1900, new int[12]);
							detail.put(date.getYear()+1900, new HashMap<Integer, int[]>());
						}
						if(!detail.get(date.getYear()+1900).containsKey(date.getMonth()))
							detail.get(date.getYear()+1900).put(date.getMonth(), new int[YearMonth.of(date.getYear()+1900, date.getMonth()+1).lengthOfMonth()]);
						hours.get(date.getYear()+1900)[date.getHours()]++;
						hours.get(0)[date.getHours()]++;
						monthdays.get(date.getYear()+1900)[date.getDate()-1]++;
						monthdays.get(0)[date.getDate()-1]++;
						months.get(date.getYear()+1900)[date.getMonth()]++;
						months.get(0)[date.getMonth()]++;
						detail.get(date.getYear()+1900).get(date.getMonth())[date.getDate()-1]++;
						//hours[6][date.getHours()]++;
						//monthdays[date.getYear()-113][date.getDate()-1]++;
						//monthdays[6][date.getDate()-1]++;
						//months[date.getYear()-113][date.getMonth()]++;
						//months[6][date.getMonth()]++;
						//detail[date.getYear()-113][date.getMonth()][date.getDate()-1]++;
					}
					//System.out.println("\t\t("+dat+") "+song);
				}
			}
		}
		Vector<Integer> years = new Vector<>();
		for(Integer year : hours.keySet())
			years.add(year);
		years.remove(0);
		Collections.sort(years);
		System.out.println("hours");
		for(Integer year : years)
			System.out.println(year+Arrays.toString(hours.get(year)));
		System.out.println("TOTL"+Arrays.toString(hours.get(0)));
		System.out.println("days of the month");
		for(Integer year : years)
			System.out.println(year+Arrays.toString(monthdays.get(year)));
		System.out.println("TOTL"+Arrays.toString(monthdays.get(0)));
		System.out.println("months");
		for(Integer year : years)
			System.out.println(year+Arrays.toString(months.get(year)));
		System.out.println("TOTL"+Arrays.toString(months.get(0)));
		int seqInt = 0;
		String seqStr = "";
		for(Integer year : years) {
			System.out.println(year);
			Vector<Integer> months1 = new Vector<>();
			for(Integer month : detail.get(year).keySet())
				months1.add(month);
			Collections.sort(months1);
			for(Integer month : months1) {
				System.out.printf(mon.values()[month]+"\t");
				for(int k = 0; k < YearMonth.of(year, month+1).lengthOfMonth(); k++) {
					if(detail.get(year).get(month)[k] == 0) {
						if(seqInt != 0) {
							seqStr += seqInt+"|";
							seqInt = 0;
						}
					}
					else
						seqInt++;
					System.out.printf("%3d"+((k+1 == YearMonth.of(year, month+1).lengthOfMonth()) ? "" : ","), detail.get(year).get(month)[k]);
				}
				if(!seqStr.isEmpty()) {
					String tabs = "";
					for(int i = 0; i < 32-YearMonth.of(year, month+1).lengthOfMonth(); i++) {
						if(YearMonth.of(year, month+1).lengthOfMonth() < 30 && i == 0) i++;
						tabs += "\t";
					}
					System.out.printf(tabs+seqStr);
					seqStr = "";
				}
				System.out.println();
			}
		}
		for(Integer year : years) {
			System.out.println(year);
			Vector<Integer> months1 = new Vector<>();
			for(Integer month : detail.get(year).keySet())
				months1.add(month);
			Collections.sort(months1);
			for(Integer month : months1) {
				System.out.println(month);
				for(int k = 0; k < YearMonth.of(year, month+1).lengthOfMonth(); k++) {
					System.out.printf("%d"+((k+1 == YearMonth.of(year, month+1).lengthOfMonth()) ? "" : ","), detail.get(year).get(month)[k]);
				}
				System.out.println();
			}
		}
		//for(int i = 0; i < 6; i++)
		//System.out.println((2013+i)+Arrays.toString(hours[i]));
		//System.out.println("hours TOTAL\n"+Arrays.toString(hours[6]));
		//		System.out.println("days of the month");
		//		for(int i = 0; i < 6; i++)
		//			System.out.println((2013+i)+Arrays.toString(monthdays[i]));
		//		System.out.println("days of the month TOTAL\n"+Arrays.toString(monthdays[6]));
		//		System.out.println("months");
		//		for(int i = 0; i < 6; i++)
		//			System.out.println((2013+i)+Arrays.toString(months[i]));
		//		System.out.println("months TOTAL\n"+Arrays.toString(months[6]));
		//		System.out.println("details");
		//		int seq = 0;
		//		String se = "";
		//		for(int i = 0; i < 6; i++) {
		//			System.out.println(2013+i);
		//			for(int j = 0; j < 12; j++) {
		//				System.out.println(" "+(j+1));
		//				for(int k = 0; k < YearMonth.of(2013+i, j+1).lengthOfMonth(); k++) {
		//					if(detail[i][j][k] == 0) {
		//						if(seq != 0) {
		//							se += seq+"|";
		//							seq = 0;
		//						}
		//					}
		//					else {
		//						seq++;
		//					}
		//					System.out.printf("%3d, ",detail[i][j][k]);
		//				}
		//				System.out.println();
		//				if(!se.isEmpty()) {
		//					System.out.printf(se.trim());
		//					se = "";
		//				}
		//				//System.out.println(Arrays.toString(detail[i][j]));
		//			}
		//		}
	}

}

/*
   class TypeVector<V>{
   public String t;
   public Vector<V> v;
   public TypeVector(String t) {
   this.t = t;
   v = new Vector<V>();
   }
   }
   */

class Artist {
	private HashMap<String, Album> albuns;
	public Artist() {
		this.setAlbuns(new HashMap<String, Album>());
	}
	public HashMap<String, Album> getAlbuns() {
		return albuns;
	}
	public void setAlbuns(HashMap<String, Album> albuns) {
		this.albuns = albuns;
	}
}

class Album {
	private HashMap<String, Song> song;
	public Album() {
		this.setSong(new HashMap<String, Song>());
	}
	public HashMap<String, Song> getSong() {
		return song;
	}
	public void setSong(HashMap<String, Song> song) {
		this.song = song;
	}
}

class Song {
	private Vector<Date> listened;
	public Song() {
		this.setListened(new Vector<Date>());
	}
	public Vector<Date> getListened() {
		return listened;
	}
	public void setListened(Vector<Date> listened) {
		this.listened = listened;
	}
}
