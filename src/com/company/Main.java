package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static Boolean checkWord(String word, List<Character> vowels)
	{
		Double word_half = Math.floor(word.length()/2.0);
		Integer count_vowels = 0;
		for(int i = 0; i < word.length(); i++) {
			if (vowels.contains(word.charAt(i)))
				count_vowels++;

			if (count_vowels > word_half) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		try {
			FileReader file = new FileReader("java.txt");

			BufferedReader varRead = new BufferedReader(file);
			String all_vowels = "AEUIYOaeuioy";

			List<Character> vowels = new ArrayList<Character>(){};
			for(char ch : all_vowels.toCharArray())
			{
				vowels.add(ch);
			}

			ArrayList<String> words = new ArrayList<String>(); // result
			String line;

			while ((line = varRead.readLine()) != null) {
				var line_split = line.split("[^a-zA-Z]+");
				for (int i = 0; i < line_split.length; i++) {
					String word = line_split[i];
					if(word.length()>30)
						word = word.substring(0,29);

					if(checkWord(word, vowels))
					{
						if(!(words.contains(line_split[i])))
							words.add(line_split[i]);
					}
				}
			}
			System.out.println("Result");
			for(String word: words)
			{
				System.out.println(word);
			}
		}
		catch(java.io.FileNotFoundException e)
		{
			System.out.println("No such file");
		}
	}
}
