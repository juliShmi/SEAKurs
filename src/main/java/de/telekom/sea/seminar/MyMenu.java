package de.telekom.sea.seminar;

public interface MyMenu extends EventListener, java.io.Closeable {
	
				// gibt das Verwaltungs -"DB" de Menu bekannt
	public void keepAsking(); 
	
	public void close();//haelt die Schleife bis zum Abbruch am Leben
	
	
}
