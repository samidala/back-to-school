package com.techdisqus.streams.test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	
	@Test
	public void testIntStreamV1() {
		
		IntStream inStream = Stream.generate(new Supplier<Integer>() {
			int x= 0;
			@Override
			public Integer get() {
				return x+=2 ;
			}
		}).limit(10).mapToInt(t -> t.intValue());
		inStream.forEach(System.out::println);
		//System.out.println(inStream.average().getAsDouble());
	}
	
	@Test
	public void testIntStreamV2() {
		
	
		AtomicInteger atomicInteger = new AtomicInteger(0);
		IntStream inStream = Stream.generate(() -> atomicInteger.getAndAdd(2)).limit(10).mapToInt(t -> t.intValue());
		inStream.forEach(System.out::println);
		//System.out.println(inStream.average().getAsDouble());
	}
	
	@Test
	public void testIntStreamV3() {
		
		StreamTest generateNo = new StreamTest();
		IntStream inStream = Stream.generate(() -> generateNo.getNo()).limit(10).mapToInt(t -> t.intValue());
		
		inStream.forEach(System.out::println);
	}
	
	@Test
	public void testIntStreamV4() {
		
		StreamTest generateNo = new StreamTest();
		Stream<Integer> inStream = IntStream.generate(new AtomicInteger(1)::getAndIncrement) .limit(10) .boxed();
		
		inStream.forEach(System.out::println);
	}
	
	
	int x= 0;
	int y = 1;

	private int getNo() {
		
		int temp = x + y;
		int ret = x;
		x = y;
		y = temp;
		return ret;
	}
	

}
