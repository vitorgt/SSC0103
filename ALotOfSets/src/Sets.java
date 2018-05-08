import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given such input with 500 and 500 sets, parse them, counts their occurrences and prints duplicates
 */
public class Sets {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		HashMap<HashSet<Integer>,Integer> m[] = new HashMap[2];
		HashSet<HashSet<Integer>> unique = new HashSet<HashSet<Integer>>();
		
		for(int j = 0; j < 2; j++){
			m[j] = new HashMap<HashSet<Integer>,Integer>();
				try {
					FileInputStream fstream = new FileInputStream("src/ALotOfSets.txt");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String Line;
					while((Line = br.readLine().trim().replaceAll(" +", " ")) != null){
						String[] split = Line.split(" ");
						HashSet<Integer> aux = new HashSet<Integer>();
						for(int k = 0; k < split.length; k++){
							aux.add(Integer.parseInt(split[k]));
							unique.add(aux);
						}
						if(!m[j].containsKey(aux)){
							m[j].put(aux, 1);
						}
						else{
							m[j].put(aux, m[j].get(aux)+1);
						}
					}
					in.close();
				} catch (Exception e) {
					;
				}
		}
		for(HashSet<Integer> v : unique){
			if(m[0].get(v) > 1 | m[1].get(v) > 1/* | m[0].get(v)+m[1].get(v) > 1*/){//nao sei se devo fazer essa ultima verificacao
				System.out.println("Set "+v+" shows up "+m[0].get(v)+" times in the first 500 sets and "+m[1].get(v)+" times in the last 500 sets");
			}
		}
	}
}
