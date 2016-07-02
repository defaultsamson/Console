package samson.stream;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

public class ConsoleOutputStream extends OutputStream {
	private final StringBuilder sb = new StringBuilder();

	private Color colour;

	public ConsoleOutputStream(Color colour) {
		this.colour = colour;
	}

	@Override
	public void write(int b) throws IOException {

		if (b == '\r')
			return;

		if (b == '\n') {
			final String text = sb.toString() + "\n";
			Console.instance().appendToPane(text, colour);
			sb.setLength(0);
			return;
		}

		sb.append((char) b);
	}
}
