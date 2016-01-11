package br.com.curiosity.utils;

public class Normalize {
	
	public static String normalize(String instruction) {
		return instruction.replaceAll("[^\\dRLM]", "");
	} 
}
