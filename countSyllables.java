	protected static int countSyllables(String word)
	{
		
		//	1:) use a search algorithm to check on either side of a letter in chars for other vowels 
		//	2:) check if word has e at the end. 
		// 	3:) if so I check if it has vowels in the word (boolean statement). 
		
		int sylCount = 0;
		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
		char[] chars = word.toLowerCase().toCharArray();
		boolean hasVowel = false;
		
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < vowels.length; j++) {
				if (chars[i] == vowels[j]) {
					
					int k = i;
					while (k < chars.length) {
						if (chars[k]== 'a' ||
								chars[k]== 'e' ||
								chars[k]== 'i' ||
								chars[k]== 'o' ||
								chars[k]== 'u' ||
								chars[k]== 'y') {
							
							k++;
							
						} else if (chars[k] != 'a' ||
								chars[k] != 'e' ||
								chars[k] != 'i' ||
								chars[k] != 'o' ||
								chars[k] != 'u' ||
								chars[k] != 'y') {
							
							sylCount++;
							hasVowel = true;
							i = k;
							break;
							
						}  
					}
					
				} else {
					continue;
				}
			}
		}
	
		if (chars[chars.length-1] == 'e' && hasVowel == false) {
			sylCount++;
			
		} if (hasVowel == false && chars[chars.length-1] != 'e') {
			sylCount++;
			
		} if (hasVowel == true &&
				(chars[chars.length-1] == 'a' ||
				chars[chars.length-1] == 'e' ||
				chars[chars.length-1] == 'i' ||
				chars[chars.length-1] == 'o' ||
				chars[chars.length-1] == 'u' ||
				chars[chars.length-1] == 'y') &&
				(chars[chars.length-2] == 'a' ||
				chars[chars.length-2] == 'e' ||
				chars[chars.length-2] == 'i' ||
				chars[chars.length-2] == 'o' ||
				chars[chars.length-2] == 'u' ||
				chars[chars.length-2] == 'y')) {
			
			sylCount++;
			
		} if (hasVowel == true &&
				(chars[chars.length-1] == 'a' ||
				chars[chars.length-1] == 'i' ||
				chars[chars.length-1] == 'o' ||
				chars[chars.length-1] == 'u' ||
				chars[chars.length-1] == 'y') &&
				(chars[chars.length-2] != 'a' ||
				chars[chars.length-2] != 'e' ||
				chars[chars.length-2] != 'i' ||
				chars[chars.length-2] != 'o' ||
				chars[chars.length-2] != 'u' ||
				chars[chars.length-2] != 'y')) {
			sylCount++;
		}
	
		return sylCount;
	} 
