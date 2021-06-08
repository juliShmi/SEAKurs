package de.telekom.sea.seminar.generics;

import java.util.ArrayList;

public class Together<T, U> {

	private T firstObject;
	private U secondObject;

	@SuppressWarnings("rawtypes")

	public T getFirst() {
		return firstObject;

	}

	public U getSecond() {
		return secondObject;

	}

	public Together() {

	}

	public Together(T firstObject, U secondObject) {

	}

	public boolean join(T firstObject, U secondObject) {
		if (firstObject != null || secondObject != null) {
			this.firstObject = firstObject;
			this.secondObject = secondObject;
			return true;
		}
		return false;

	}

	public void split() {
		getFirst();
		getSecond();

	}

	public String togetherToString() {
		String fpstring = this.firstObject.toString();
		String spstring = this.secondObject.toString();
		return fpstring + " " + spstring;

	}

	public boolean equalsTogether(Together<T, U> together) {

		if (this.firstObject.equals(together.firstObject) && this.secondObject.equals(together.secondObject)) {
			return true;
		}
		return false;

	}

	public boolean hashCode(Together<T, U> together) {
		if (this.hashCode() == together.hashCode()) {
			System.out.println("Same hashcodes");
			return true;

		}
		return false;
	}
}
