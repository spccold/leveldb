package org.leveldb.example;

import java.nio.charset.StandardCharsets;

import org.iq80.leveldb.table.BytewiseComparator;
import org.iq80.leveldb.util.Slices;

public class Other {
	public static void main(String[] args) {
		System.out.println((byte) 0xff);
		System.out.println((byte) 0x80);
		System.out.println(-1 & 0xff);

		BytewiseComparator bytewiseComparator = new BytewiseComparator();

		System.out.println(bytewiseComparator.findShortestSeparator(Slices.wrappedBuffer("abc".getBytes()),
				Slices.wrappedBuffer("abe".getBytes())).toString(StandardCharsets.UTF_8));

		System.out.println(bytewiseComparator.findShortestSeparator(Slices.wrappedBuffer("ab".getBytes()),
				Slices.wrappedBuffer("abe".getBytes())).toString(StandardCharsets.UTF_8));
	}
}
