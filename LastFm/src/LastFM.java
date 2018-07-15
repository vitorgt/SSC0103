import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class LastFM {

	private enum mon {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec};

	public static void main(String[] args) {

		HashMap<String, Artist> lib = new HashMap<>();
		HashMap<Integer, int[]> hours = new HashMap<Integer, int[]>();
		HashMap<Integer, int[]> weekdays = new HashMap<Integer, int[]>();
		HashMap<Integer, int[]> monthdays = new HashMap<Integer, int[]>();
		HashMap<Integer, int[]> months = new HashMap<Integer, int[]>();
		HashMap<Integer, HashMap<Integer, int[]>> detail = new HashMap<Integer, HashMap<Integer, int[]>>();
		BufferedReader br = null;
		hours.put(-1, new int[24]);
		weekdays.put(-1, new int[7]);
		monthdays.put(-1, new int[31]);
		months.put(-1, new int[12]);

		try {
			br = new BufferedReader(new FileReader(new File("yo.tsv")));
		} catch (Exception e) {}

		String line;
		try {
			while ((line = br.readLine()) != null) {
				String reg[] = line.split("\t");
				Builder time = new Calendar.Builder();
				time.set(Calendar.YEAR, Integer.parseInt(reg[1]));
				time.set(Calendar.MONTH, Integer.parseInt(reg[2])-1);
				time.set(Calendar.DAY_OF_MONTH, Integer.parseInt(reg[3]));
				time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(reg[4]));
				time.set(Calendar.MINUTE, Integer.parseInt(reg[5]));
				Calendar cal = time.build();
				if(!lib.containsKey(reg[6])) {
					lib.put(reg[6], new Artist());
				}
				if(!lib.get(reg[6]).getAlbuns().containsKey(reg[7])) {
					lib.get(reg[6]).getAlbuns().put(reg[7], new Album());
				}
				if(!lib.get(reg[6]).getAlbuns().get(reg[7]).getSong().containsKey(reg[8])) {
					lib.get(reg[6]).getAlbuns().get(reg[7]).getSong().put(reg[8], new Song());
				}
				lib.get(reg[6]).getAlbuns().get(reg[7]).getSong().get(reg[8]).getListened().add(cal);
				if(!hours.containsKey(cal.get(Calendar.YEAR))) {
					hours.put(cal.get(Calendar.YEAR), new int[24]);
					weekdays.put(cal.get(Calendar.YEAR), new int[7]);
					monthdays.put(cal.get(Calendar.YEAR), new int[31]);
					months.put(cal.get(Calendar.YEAR), new int[12]);
					detail.put(cal.get(Calendar.YEAR), new HashMap<Integer, int[]>());
				}
				if(!detail.get(cal.get(Calendar.YEAR)).containsKey(cal.get(Calendar.MONTH)))
					detail.get(cal.get(Calendar.YEAR)).put(cal.get(Calendar.MONTH), new int[YearMonth.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1).lengthOfMonth()]);
				hours.		get(cal.get(Calendar.YEAR))[cal.get(Calendar.HOUR_OF_DAY)]++;//0-24
				weekdays.	get(cal.get(Calendar.YEAR))[time.build().get(Calendar.DAY_OF_WEEK)-1]++;//1-7
				monthdays.	get(cal.get(Calendar.YEAR))[cal.get(Calendar.DAY_OF_MONTH)-1]++;//1-31
				months.		get(cal.get(Calendar.YEAR))[cal.get(Calendar.MONTH)]++;//0-11
				detail.		get(cal.get(Calendar.YEAR)).get(cal.get(Calendar.MONTH))[cal.get(Calendar.DAY_OF_MONTH)-1]++;
				hours.		get(-1)[cal.get(Calendar.HOUR_OF_DAY)]++;
				weekdays.	get(-1)[cal.get(Calendar.DAY_OF_WEEK)-1]++;
				monthdays.	get(-1)[cal.get(Calendar.DAY_OF_MONTH)-1]++;
				months.		get(-1)[cal.get(Calendar.MONTH)]++;
			}
		} catch (Exception e) {}
		//		for(String artist : lib.keySet()) {
		//			System.out.println(artist);
		//			for(String album : lib.get(artist).getAlbuns().keySet()) {
		//				System.out.println("\t"+album);
		//				for(String song : lib.get(artist).getAlbuns().get(album).getSong().keySet()) {
		//					System.out.println("\t\t("+lib.get(artist).getAlbuns().get(song).getSong().size()+") "+song);
		//					int dat = 0;
		//					for(Calendar cal : lib.get(artist).getAlbuns().get(album).getSong().get(song).getListened()) {
		//					}
		//					System.out.println("\t\t("+dat+") "+song);
		//				}
		//			}
		//		}
		Vector<Integer> years = new Vector<Integer>();
		for(Integer year : hours.keySet())
			if(year != -1) years.add(year);
		Collections.sort(years);
		System.out.println("hours");
		for(Integer year : years)
			System.out.println(year+"\n"+Arrays.toString(hours.get(year)).replace("[", "").replace("]", ""));
		System.out.println("TOTL\n"+Arrays.toString(hours.get(-1)).replace("[", "").replace("]", ""));
		System.out.println("weekdays");
		for(Integer year : years)
			System.out.println(year+"\n"+Arrays.toString(weekdays.get(year)).replace("[", "").replace("]", ""));
		System.out.println("TOTL\n"+Arrays.toString(weekdays.get(-1)).replace("[", "").replace("]", ""));
		System.out.println("days of the month");
		for(Integer year : years)
			System.out.println(year+"\n"+Arrays.toString(monthdays.get(year)).replace("[", "").replace("]", ""));
		System.out.println("TOTL\n"+Arrays.toString(monthdays.get(-1)).replace("[", "").replace("]", ""));
		System.out.println("months");
		for(Integer year : years)
			System.out.println(year+"\n"+Arrays.toString(months.get(year)).replace("[", "").replace("]", ""));
		System.out.println("TOTL\n"+Arrays.toString(months.get(-1)).replace("[", "").replace("]", ""));
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
				System.out.println(mon.values()[month]);
				for(int k = 0; k < YearMonth.of(year, month+1).lengthOfMonth(); k++) {
					System.out.printf("%d"+((k+1 == YearMonth.of(year, month+1).lengthOfMonth()) ? "" : ","), detail.get(year).get(month)[k]);
				}
				System.out.println();
			}
		}
	}

}

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
	private Vector<Calendar> listened;
	public Song() {
		this.setListened(new Vector<Calendar>());
	}
	public Vector<Calendar> getListened() {
		return listened;
	}
	public void setListened(Vector<Calendar> vector) {
		this.listened = vector;
	}
}
