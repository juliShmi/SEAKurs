package de.telekom.sea.seminar.interfaces;

import java.io.IOException;

import de.telekom.sea.seminar.events.EventListener;

public interface MyMenu extends EventListener, java.io.Closeable {

	public void keepAsking() throws IOException;

	public void close();

}
