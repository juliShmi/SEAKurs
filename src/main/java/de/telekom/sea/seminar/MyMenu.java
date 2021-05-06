package de.telekom.sea.seminar;

public interface MyMenu extends EventListener, java.io.Closeable {

	public void keepAsking();

	public void close();

}
