import java.util.Map;
import java.util.HashMap;
public class CodeLwz{
	private static int DICT_SIZE = 256;
	public CodeLwz(){
	
	}
	public String compresser(String chaine){
		int index = DICT_SIZE;
		String w = "";
		Map <String,Integer> dictionnaire = new HashMap <String,Integer>();
		for (int i = 0; i <= DICT_SIZE; i++) {
			dictionnaire.put("" +(char) i, i);
		}
		StringBuilder chaineRetourne = new StringBuilder(); 
		for(char c  : chaine.toCharArray()){
			String wc = w + c;
			if(dictionnaire.containsKey(wc)){
				w = wc;
				System.out.println(wc+" is known "+dictionnaire.get(wc));

			}
			else{
				int i = dictionnaire.get(w);
				chaineRetourne.append((char) i); 
				dictionnaire.put(wc,++index);
				System.out.println(wc+" is encoded "+dictionnaire.get(wc));
				w = ""+c;
			}
		}
			if(!w.equals("")){
				int i = dictionnaire.get(w);
				chaineRetourne.append((char) i);
			}

			return chaineRetourne.toString();
	}
	

	public String decompresser(String chaine){
		int index = DICT_SIZE;
		Map<Integer,String> dictionnaire = new HashMap<Integer,String>();
		for (int i = 0; i <= DICT_SIZE; i++) {
			dictionnaire.put(i, "" +(char) i);
		}
	        char[] chars = chaine.toCharArray();
	        String old = "" + chars[0];
	        StringBuffer resultat = new StringBuffer(old);
	        for (int j = 1; j < chars.length; j++) {
	            int k = (int) chars[j];
	            String current;
	            if (dictionnaire.containsKey(k)) {
	                current = dictionnaire.get(k);
	            }
	            else if (k == index) {
	                System.out.println("oufff");
	                current = old + old.charAt(0);
	            }
	            else
	                throw new IllegalArgumentException("Mauvais deompression de k: " + k);

	            resultat.append(current);

	            dictionnaire.put(++index, old + current.charAt(0));

	            old = current;
	        }
	        
	        return resultat.toString();
		}
}