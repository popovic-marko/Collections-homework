import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bigram {

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

	}
}
