package fr.paquet.commun;

import java.util.ArrayList;
import java.util.List;

public class CastList {

	public CastList() {
		super();

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<?> toArrayList(List<?> list) {

		if (list instanceof ArrayList<?> == false) {
			ArrayList<Object> listMethode = new ArrayList<>();
			for (Object obj : list) {
				listMethode.add(obj);
			}
			list = listMethode;
		}

		return (ArrayList<Object>) list;
	}

}
