package de.telekom.sea.seminar;

import java.io.IOException;

public interface MyMenu extends EventListener, java.io.Closeable {

	public void keepAsking() throws IOException;

	public void close();

}
