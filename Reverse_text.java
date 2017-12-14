
public class Reverse_text {
	
	public static String reverseText(String s)
	{
		String s4 = "";
		
		//Deleting multiple Space
		String s2 = s.replaceAll("\\s+", " ");
		
		String[] reci = s2.split(" ");
		
		for(int i = 0; i < reci.length - 2;)
		{
			char c = reci[i].charAt(reci[i].length() - 1);
			
			if(c == '.' || c == '!' || c == '?')
			{
				reci[i] = reci[i].replace( reci[i].charAt(0) , Character.toUpperCase(reci[i].charAt(0)));
				reci[i + 1] = reci[i + 1].replace(reci[i + 1].charAt(0), Character.toLowerCase(reci[i + 1].charAt(0)));
				
				//Brisanje punctuation sign iza reci iza koje se nalazi
				reci[i] = reci[i].replace( reci[i].substring(reci[i].length() - 1) , "" );
								
				//Deleting punctuation sign iza reci iza koje se nalazi koristeci StringBuilder
				//StringBuilder sb = new StringBuilder(reci[i]);
				//sb.deleteCharAt(sb.length() - 1);
				//reci[i] = sb.toString();
				
				// Adding punctuation sign behind next word
				reci[i + 1] += c;
				i += 2;
			}
			
			// pomerim zarez iza sledece reci. 
			else if( c == ',' )
			{
				//Brisanje punctuation sign iza reci iza koje se nalazi
				reci[i] = reci[i].replace(  reci[i].substring( reci[i].length() - 1) , "" ) ;
				
				// Dodavanje punctuation sign iza sledece reci
				reci[i + 1] += ',';
				i += 2;
			}
			else
				i++;
		}
		
		
		// Veliko slovo na pocetku recenice prepravimo da bude malo slovo
		reci[0] = reci[0].replace(reci[0].charAt(0), Character.toLowerCase(reci[0].charAt(0)));
		
		// Malo slovo na pocetku poslednje reci recenice Prepravimo da bude veliko slovo 
		reci[reci.length - 1] = reci[reci.length - 1].replace(reci[reci.length - 1].charAt(0), Character.toUpperCase(reci[reci.length - 1].charAt(0)));
		
		// Brisanje poslednje tacke koristeci StringBuilder
		StringBuilder sb = new StringBuilder(reci[reci.length - 1]);
		sb.deleteCharAt(sb.length() - 1);
		reci[reci.length - 1] = sb.toString();
		
		// Brisanje poslednje tacke
		//reci[reci.length - 1] = reci[reci.length - 1].replace( reci[reci.length - 1].substring(reci[reci.length - 1].length() - 1), "");
		
		// okretanje niza reci
		for(int i = reci.length - 1; i >= 0; i--)
			s4 += (  i != 0 ?  reci[i] + " " : reci[i] + ".");
					
		return s4;
		
	}
	
	public static void main(String args[])
	{
		String input = "Agree with you, the council does. Your apprentice, Skywalker will be.";
		String input2 = "Hey Jennifer hallo! The Ferrari in the store, did you buy? You're look interesting.";
		
		System.out.println(input); 
		String output = reverseText(input);
		System.out.println(output);
		
		System.out.println();
			
		System.out.println(input2);
		String output2 = reverseText(input2);
		System.out.println(output2);
	}

}
