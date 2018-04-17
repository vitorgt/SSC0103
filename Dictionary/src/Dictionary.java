
public class Dictionary<K,V>{

	private K k[];
	private V v[];
	private int n = 0;
	
	@SuppressWarnings("unchecked")
	public Dictionary(){
		k = (K[]) new Object[100];
		v = (V[]) new Object[100];
	}
	
	public void add(K newk, V newv){
		k[n] = newk;
		v[n] = newv;
		n++;
	}

	public V search(K s){
		for(int i = 0; i < n; i++)
			if(k[i].equals(s))
				return v[i];
		return null;
	}
	
	public boolean containsKey(K s){
		for(int i = 0; i < n; i++)
			if(k[i].equals(s))
				return true;
		return false;
	}
	
	public boolean containsValue(V s){
		for(int i = 0; i < n; i++)
			if(v[i].equals(s))
				return true;
		return false;
	}

}
