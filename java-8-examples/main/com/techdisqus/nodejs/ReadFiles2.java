package com.techdisqus.nodejs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFiles2 {
	
	
	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("file1Path1")).forEach(System.out::println);
		Files.lines(Paths.get("file1Path2")).forEach(System.out::println);
	}
	


}
