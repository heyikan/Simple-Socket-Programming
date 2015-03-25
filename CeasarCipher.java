public class CeasarCipher {

	public String encrypt(String value) {

		char [] buffer = value.toCharArray();
		
		for (int i = 0; i < buffer.length; i++) {
			
			char letter = buffer[i];
			
			if (letter >= 'a' && letter <= 'z') // if lowercase
			{
				letter -= 'a';
				letter += 3;
				letter %= 26;
				letter += 'a';
			}
			else if (letter >= 'A' && letter <= 'Z') // if uppercase
			{
				letter -= 'A';
				letter += 3;
				letter %= 26;
				letter += 'A';
			}
			
			buffer[i] = letter;

		}
		
		return new String(buffer);
	}
	public String decrypt(String value) {

		char [] buffer = value.toCharArray();
		
		for (int i = 0; i < buffer.length; i++) {
			
			char letter = buffer[i];
			
			if (letter >= 'a' && letter <= 'z') // if lowercase
			{
				letter -= 'a';
				letter -= 3;
				letter += 26;
				letter %= 26;
				letter += 'a';
			}
			else if (letter >= 'A' && letter <= 'Z') // if uppercase
			{
				letter -= 'A';
				letter -= 3;
				letter += 26;
				letter %= 26;
				letter += 'A';
			}
			
			buffer[i] = letter;

		}
		
		return new String(buffer);
	}

}
