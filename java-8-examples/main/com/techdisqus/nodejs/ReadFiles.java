package com.techdisqus.nodejs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFiles {
	
	static final Runnable r1 = () -> {
		List<String>  list = readFile("/Users/amidala/Desktop/personal/file1");
		list.parallelStream().forEach(System.out::println);
	};
	

	static final Runnable r2 = () -> {
	List<String>  list = readFile("/Users/amidala/Desktop/personal/file2");
	list.parallelStream().forEach(System.out::println);
	};
	
	public static void main(String[] args) {
	
		new Thread(r1).start();
		new Thread(r2).start();
		System.out.println("main thread ended");
	}
	
	static List<String> readFile(String path)  {
		try {
			return Files.lines(Paths.get(path)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

}
