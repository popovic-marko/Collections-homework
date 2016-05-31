import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bigram {

	public static String pronadjiSledeci(Map<String, Integer> mapa, String s){
		String max = new String();
		int n = 0;
		for(Map.Entry<String, Integer> e : mapa.entrySet()){
			if(e.getKey().startsWith(s) && e.getValue() > n){
				max = e.getKey().substring(1, 2);
				n = e.getValue();
			}
		}
		return max;
	}

	public static boolean proveri(Map<String, Integer> mapa, String s){

		for(Map.Entry<String, Integer> e : mapa.entrySet()){
			if(e.getKey().endsWith(s)){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Map<String, Integer> mapa = new HashMap<>();
		Scanner in = new Scanner(System.in);

		System.out.print("Unesite string: ");
		String string = in.nextLine();
		String key = new String();

		for (int i = 0; i < string.length() - 1; i++) {
			key = string.substring(i, i + 2);
			if(!mapa.containsKey(key)){
				mapa.put(key, 1);
			} else {
				mapa.put(key, mapa.get(key) + 1);
			}
		}

		System.out.println("\n" + "Frekvencije za odgovarajuce bigrame: ");

		for(Map.Entry<String, Integer> e : mapa.entrySet()){

			System.out.println(e.getKey() + " " + e.getValue());
		}    

		System.out.print("\n" + "Unesite string za predvidjanje karaktera(mora postojati u prethodnom stringu): ");
		boolean kraj = false;
		String novi = new String();
		while(!kraj){
			novi = in.nextLine();
			if(proveri(mapa, novi.substring(novi.length() - 1))){
				kraj = true;
			} else {
				System.out.println("\n" + "Uneti string ne postoji u prethodnom!");
				System.out.print("Unesite string za predvidjanje karaktera: ");
			}
		}

		for (int i = 0; i < 3; i++) {
			String s = novi.substring(i + 1, i + 2);
			novi = novi + pronadjiSledeci(mapa, s);
		}

		System.out.println("\n" + "Rezultat predvidjanaja: " + novi);

	}
}
