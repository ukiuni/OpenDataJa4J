package org.ukiuni.opendataja4j.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	public static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		for (int readed; (readed = in.read(buffer)) > 0;) {
			out.write(buffer, 0, readed);
		}
	}

	public static String streamToString(InputStream in) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		IOUtils.copy(in, bout);
		return new String(bout.toByteArray());
	}
}
