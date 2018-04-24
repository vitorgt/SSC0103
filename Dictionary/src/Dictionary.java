
public class Dictionary<K,V>{

	private K k[];
	private V v[];
	private int n = 0;

	@SuppressWarnings("unchecked")
		public Dictionary(){
			k = (K[]) new Object[10];
			v = (V[]) new Object[10];
		}

	@SuppressWarnings("unchecked")
		public Dictionary(int n){
			k = (K[]) new Object[n];
			v = (V[]) new Object[n];
		}

	public void add(K newk, V newv){
		if(n == v.length)
			throw new IndexOutOfBoundsException("Array full");
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
		return search(s) != null;
		/*
		   for(int i = 0; i < n; i++)
			   if(k[i].equals(s))
				   return true;
		   return false;
		 */
	}

	public boolean containsValue(V s){
		for(V l : v){
			if(l == null) return false;
			if(l.equals(s)) return true;
		}
		return false;
		/*
		   for(int i = 0; i < n; i++)
			   if(v[i].equals(s))
				   return true;
		   return false;
		 */
	}

}
