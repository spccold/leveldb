package org.leveldb.example;

import java.nio.charset.StandardCharsets;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;

import org.iq80.leveldb.impl.InternalKey;
import org.iq80.leveldb.impl.InternalKeyComparator;
import org.iq80.leveldb.impl.ValueType;
import org.iq80.leveldb.table.BytewiseComparator;
import org.iq80.leveldb.util.Slice;
import org.iq80.leveldb.util.Slices;

public class InternalKeyComparatorApp {

	public static void main(String[] args) {

		ConcurrentSkipListMap<InternalKey, Slice> table = new ConcurrentSkipListMap<>(
				new InternalKeyComparator(new BytewiseComparator()));
		// key-sequenceNumber
		// put senqunce: a-1, b-2, b-3, c-4, c-5, c-6
		int sequence = 1;

		table.put(new InternalKey(Slices.wrappedBuffer("a".getBytes()), sequence++, ValueType.VALUE),
				Slices.wrappedBuffer(new byte[] { 1 }));
		table.put(new InternalKey(Slices.wrappedBuffer("b".getBytes()), sequence++, ValueType.VALUE),
				Slices.wrappedBuffer(new byte[] { 1 }));
		table.put(new InternalKey(Slices.wrappedBuffer("b".getBytes()), sequence++, ValueType.VALUE),
				Slices.wrappedBuffer(new byte[] { 1 }));
		table.put(new InternalKey(Slices.wrappedBuffer("c".getBytes()), sequence++, ValueType.VALUE),
				Slices.wrappedBuffer(new byte[] { 1 }));
		table.put(new InternalKey(Slices.wrappedBuffer("c".getBytes()), sequence++, ValueType.VALUE),
				Slices.wrappedBuffer(new byte[] { 1 }));
		table.put(new InternalKey(Slices.wrappedBuffer("c".getBytes()), sequence++, ValueType.VALUE),
				Slices.wrappedBuffer(new byte[] { 1 }));

		// result: a-1, b-3, b-2, c-6, c-5, c-4
		for (Entry<InternalKey, Slice> entry : table.entrySet()) {
			System.out.println(String.format("%s-%d", entry.getKey().getUserKey().toString(StandardCharsets.UTF_8),
					entry.getKey().getSequenceNumber()));
		}
	}
}
