
public class Main {

	public static void main(String[] args) {

		System.out.println("Start!");

		Teilnehmer teilnehmer1 = new Teilnehmer(); // !! for the class initialization
		teilnehmer1.setVorname("Roland");
		teilnehmer1.setNachname("Niedermeier");

		Teilnehmer teilnehmer2 = new Teilnehmer();
		teilnehmer2.setVorname("Iuliia");
		teilnehmer2.setNachname("Shmitko");

		System.out.println(teilnehmer1.getVorname() + " " + teilnehmer1.getNachname());
		System.out.println(teilnehmer2.getVorname() + " " + teilnehmer2.getNachname());

		MyList gruppe1 = new VerwaltungsGruppe();
		gruppe1.add(teilnehmer1);
		gruppe1.add(teilnehmer2);

		System.out.println("Size is: "+ gruppe1.size());

		gruppe1.get(0);
		gruppe1.get(1);

		gruppe1.remove(teilnehmer1);
		System.out.println("Size is: "+ gruppe1.size());

		Teilnehmer teilnehmer3 = new Teilnehmer(); // !! for the class initialization
		teilnehmer3.setVorname("Hans");
		teilnehmer3.setNachname("Mueller");
		System.out.println(teilnehmer3.getVorname() + " " + teilnehmer3.getNachname());
		gruppe1.add(teilnehmer3);
		System.out.println("Size is: "+ gruppe1.size());
		gruppe1.get(1);
		gruppe1.remove(teilnehmer3);
		System.out.println("Size is: "+ gruppe1.size());
		gruppe1.clear();
		System.out.println("List is clean " + gruppe1.size());
		//gruppe1.get(0); //funktioniert nicht, weil drin null steht
		

//		Teilnehmer teilnehmerZweiteGruppe2 = new Teilnehmer(); // !! for the class initialization
//		teilnehmerZweiteGruppe2.setVorname("Thorsten");
//		teilnehmerZweiteGruppe2.setNachname("Lorenz");
//		
//		System.out.println(teilnehmerZweiteGruppe2.getVorname() + " " + teilnehmerZweiteGruppe2.getNachname());
//		
//		MyList gruppe2 = new VerwaltungsGruppe2(); 
//		gruppe2.add(teilnehmerZweiteGruppe2);
//		gruppe2.size();
//		System.out.println("teilnehmerGruppe ist " +gruppe2.get(0).getVorname() + " " + gruppe2.get(0).getNachname());
//		
//		
//		
//		Teilnehmer teilnehmerNullTest = new Teilnehmer(); // !! for the class initialization
//		teilnehmerNullTest.setVorname(null);
//		teilnehmerNullTest.setNachname(null);
//		System.out.println(teilnehmerNullTest.getVorname() + " " + teilnehmerNullTest.getNachname());
//		MyList gruppe3 = new VerwaltungsGruppe(); 
//		gruppe3.add(teilnehmerNullTest);
//		gruppe3.size();
//		gruppe3.get(0);
//		System.out.println("Finish!");
	}

}
