
public class Reverse_text {
	
	public static String reverseText(String s)
	{
	   String s4 = "";
		
	   //Deleting multiple Space
	   String s2 = s.replaceAll("\\s+", " ");
		
	   String[] reci = s2.split(" ");
		
	   for(int i = 0; i < reci.length - 2;){
	      char c = reci[i].charAt(reci[i].length() - 1);
			
	      if(c == '.' || c == '!' || c == '?'){
		 reci[i] = reci[i].replace( reci[i].charAt(0) , Character.toUpperCase(reci[i].charAt(0)));
		 reci[i + 1] = reci[i + 1].replace(reci[i + 1].charAt(0), Character.toLowerCase(reci[i + 1].charAt(0)));
				
		 //Deleting punctuation sign behind the word
		 reci[i] = reci[i].replace( reci[i].substring(reci[i].length() - 1) , "" );
								
		 //Deleting punctuation sign behind the word using StringBuilder
		 /*
		   StringBuilder sb = new StringBuilder(reci[i]);
		   sb.deleteCharAt(sb.length() - 1);
		   reci[i] = sb.toString();
		 */
		      
		 // Adding punctuation sign behind next word
		 reci[i + 1] += c;
		 i += 2;
	      }
              // moving the comma behind the next word.
	      else if( c == ',' ){
		 //Deleting punctuation sign behind word
		 reci[i] = reci[i].replace(  reci[i].substring( reci[i].length() - 1) , "" ) ;
				
		 //Adding a punctuation sign behind the next word
		 reci[i + 1] += ',';
		 i += 2;
	      }
	      else
		 i++;
		}
		
		
		// Let's make a big letter at the beginning of the sentence to be a little letter
		reci[0] = reci[0].replace(reci[0].charAt(0), Character.toLowerCase(reci[0].charAt(0)));
		
		// A little letter at the beginning of the last word of the sentence Let's make it a big letter 
		reci[reci.length - 1] = reci[reci.length - 1].replace(reci[reci.length - 1].charAt(0), Character.toUpperCase(reci[reci.length - 1].charAt(0)));
		
		// Deleting the last point using StringBuilder
		StringBuilder sb = new StringBuilder(reci[reci.length - 1]);
		sb.deleteCharAt(sb.length() - 1);
		reci[reci.length - 1] = sb.toString();
		
		// Deleting the last point
		//reci[reci.length - 1] = reci[reci.length - 1].replace( reci[reci.length - 1].substring(reci[reci.length - 1].length() - 1), "");
		
		// reverse a string of words
		for(int i = reci.length - 1; i >= 0; i--)
			s4 += (  i != 0 ?  reci[i] + " " : reci[i] + ".");
					
		return s4;
	}
	
	public static void main(String args[])
	{
		String input = "Hey Jennifer hallo! The Ferrari in the store, did you buy? You're look interesting.";
		
		System.out.println(input); 
		String output = reverseText(input);
		System.out.println(output);
	}

}
