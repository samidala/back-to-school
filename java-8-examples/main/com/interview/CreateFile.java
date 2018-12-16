package com.interview;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateFile {
	
	public static void main(String[] args) throws Exception {
		
		
		System.setOut(new PrintStream(new FileOutputStream(new File("/Users/amidala/Desktop/personal/100mbfile"))));
		Stream.generate(() -> "test\n").limit(10000000).forEach(System.out::println);
		System.out.println("done");
	}

}
