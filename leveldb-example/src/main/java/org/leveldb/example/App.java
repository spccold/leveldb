package org.leveldb.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;

public class App {
	public static void main(String[] args) throws IOException {
		Iq80DBFactory factory = Iq80DBFactory.factory;
		Options options = new Options();

		byte[] nameKey = "name".getBytes(StandardCharsets.UTF_8);
		byte[] nameValue = "wuwo".getBytes(StandardCharsets.UTF_8);
		try (DB db = factory.open(new File("/Users/wuwo/leveldb"), options);) {
			//db.put(nameKey, nameValue);
			//System.out.println(new String(db.get(nameKey), StandardCharsets.UTF_8));
		}
	}
}
