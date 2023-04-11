package com.example.dcs;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dcs.model.Appointment;
import com.example.dcs.model.AppointmentRepository;
import com.example.dcs.model.Doctor;
import com.example.dcs.model.Gender;
import com.example.dcs.model.DoctorRepository;
import com.example.dcs.model.Invoice;
import com.example.dcs.model.Invoice.Status;
import com.example.dcs.model.InvoiceRepository;
import com.example.dcs.model.Patient;
import com.example.dcs.model.PatientRepository;

@SpringBootApplication
public class DessClinicSystemApplication {

	boolean debug=false;
	
	public static void main(String[] args) {
		SpringApplication.run(DessClinicSystemApplication.class, args);
	}

	private void loadData(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository, InvoiceRepository invoiceRepository) {
		ArrayList<Doctor> doctors = new ArrayList<>();
		doctorRepository.save(
				new Doctor(LocalDate.of(1989, 8, 29), "Kalie", "Kim", 
						Gender.Female, "physician", 8));
		doctorRepository.save(
				new Doctor(LocalDate.of(1982, 2, 07), "Becky", "Smith", 
						Gender.Female, "gynecologist", 10));
		doctorRepository.save(
				new Doctor(LocalDate.of(1978, 5, 19), "Paul", "Hart", 
						Gender.Male, "ophthalmologist", 15));
		
		doctorRepository.findAll().forEach(System.out::println);	
		

		ArrayList<Patient> patients = new ArrayList<>();
		patientRepository.save(
				new Patient("Mary", "Davis", Gender.Female, LocalDate.of(1989, 6, 4),
						"604-546-7798", "marydavis8964@gmail.com", "1222 34th Ave, Vancouver, BC, Canada",
						"V5K 0A1", "", "", "", "1234"));

		patientRepository.save(
				new Patient("John", "Smith", Gender.Male, LocalDate.of(1919, 7, 21),
						"778-846-7003", "", "503-6011 Cooney Rd, Richmond, BC, Canada",
						"V6Y 4C5", "Aortic valve replacement", "Peanuts", "Diabetes", "5234"));
		
		patientRepository.save(
				new Patient("Xu", "Mary", Gender.Male, LocalDate.of(1958, 8, 31),
						"604-225-8721", "xuxumarymary556@gmail.com", "221 102nd st, Surrey, BC, Canada",
						"V3S 5B2", "Colostomy", "Fish", "Asthma", "6234"));
		
		patientRepository.save(new Patient("Causey","Mary",Gender.Male,LocalDate.of(1953,11,19),"284-749-9988","douglascoleman183@maildrop.cc","1439 Elmwood Avenue, Vancouver, BC, Canada","G7V 6K2","Appendectomy","","","1346"));
		patientRepository.save(new Patient("Hayden","Logan",Gender.Male,LocalDate.of(1950,1,22),"483-399-1105","lucasrivera994@inboxalias.com","720 Pine Street, Vancouver, BC, Canada","V5K 3M6","Cholecystectomy","","","1364"));
		patientRepository.save(new Patient("Durant","Bronwyn",Gender.Female,LocalDate.of(1986,3,13),"348-211-5789","kylejohnson746@tempinbox.com","2084 Oak Lane, Vancouver, BC, Canada","V5K 3V1","Hysterectomy","","","1389"));
		patientRepository.save(new Patient("Davison","Chalice",Gender.Female,LocalDate.of(1959,8,23),"932-165-1578","rebeccaallen271@tempmailgen.com","3613 Maple Street, Vancouver, BC, Canada","V6V 3R3","","Exercise-induced allergies","","1405"));
		patientRepository.save(new Patient("Danell","Les",Gender.Female,LocalDate.of(1982,3,27),"998-583-8812","joshuamurphy463@spammify.com","905 Cedar Street, Vancouver, BC, Canada","V6V 4W4","","","Cystic fibrosis","1420"));
		patientRepository.save(new Patient("Logan","Jessy",Gender.Female,LocalDate.of(2002,9,3),"391-658-3492","jacobwhite984@mailinator2.com","1234 Main St, Vancouver, BC, Canada","H9R 4R6","","Hay fever","Down syndrome","1433"));
		patientRepository.save(new Patient("Ellison","Randell",Gender.Female,LocalDate.of(1970,8,11),"855-333-4123","kristinahill734@trashmailer.com","5678 Kingsway, Burnaby, BC, Canada","V3S 6K3","Mastectomy","Asthma","Hemophilia","1445"));
		patientRepository.save(new Patient("Paterson","Lynn",Gender.Male,LocalDate.of(1990,1,6),"988-422-6761","matthewjackson337@guerrillamail.net","901 Pandora Ave, Victoria, BC, Canada","R3L 1T8","Rhinoplasty","Eczema","","1466"));
		patientRepository.save(new Patient("Holland","Cailin",Gender.Male,LocalDate.of(1934,2,4),"193-972-9490","jennifermiller497@jetable.net","3456 30th Ave, Vernon, BC, Canada","V1L 6T9","Cataract surgery","","","1479"));
		patientRepository.save(new Patient("Rush","Ronan",Gender.Male,LocalDate.of(1945,11,28),"784-449-6636","carolineparker808@tempmails.net","7890 Granville St, Richmond, BC, Canada","M5G 2M6","Hernia repair surgery","","","1499"));
		patientRepository.save(new Patient("Clifton","Reba",Gender.Male,LocalDate.of(1941,8,24),"289-293-6543","davidmartinez946@getmails.net","4321 Marine Dr, West Vancouver, BC, Canada","H1L 6E7","Coronary artery bypass surgery","","Huntington's disease","1512"));
		patientRepository.save(new Patient("Everett","Tibby",Gender.Male,LocalDate.of(1972,3,28),"982-836-9222","amandasanchez570@mail-temp.com","6543 152 St, Surrey, BC, Canada","B2T 1B9","Total joint replacement surgery","Food allergies","Marfan syndrome","1533"));
		patientRepository.save(new Patient("Forester","Oscar",Gender.Male,LocalDate.of(2008,11,24),"218-947-2448","brianharris643@inboxhub.net","2101 8th Ave, Prince George, BC, Canada","V9P 8L8","","Insect sting allergies","Muscular dystrophy","1559"));
		patientRepository.save(new Patient("Dudley","Kayla",Gender.Female,LocalDate.of(1975,3,1),"719-755-8915","sarahthomas924@mailcat.biz","9999 Main St, Coquitlam, BC, Canada","E1C 1B4","","Latex allergy","Neurofibromatosis","1573"));
		patientRepository.save(new Patient("Pearson","Jeremiah",Gender.Female,LocalDate.of(2017,2,8),"606-878-5029","ericgarcia764@boximail.com","1111 Douglas St, Victoria, BC, Canada","T4C 1H4","","Drug allergies","Phenylketonuria (PKU)","1587"));
		patientRepository.save(new Patient("Whinery","Hugh",Gender.Female,LocalDate.of(2003,6,18),"226-862-9349","kellylee734@mailsac.com","2222 West 4th Ave, Vancouver, BC, Canada","P6A 4S8","","Pet allergies","Sickle cell disease","1602"));
		patientRepository.save(new Patient("Woodhams","Riley",Gender.Female,LocalDate.of(2016,8,20),"832-255-3868","","3333 West Broadway, Vancouver, BC, Canada","R2K 3N2","Spinal fusion surgery","Mold allergy","Polycystic kidney disease","1624"));
		patientRepository.save(new Patient("Danell","Ness",Gender.Female,LocalDate.of(2014,4,7),"210-187-3970","bobbydixon630@discard.email","4444 Oak St, Vancouver, BC, Canada","V8W 3Z5","Cesarean section","","","1647"));
		patientRepository.save(new Patient("Dane","Shelly",Gender.Male,LocalDate.of(1963,9,15),"699-495-3134","alexandermorgan818@spamobox.com","5555 Hastings St, Burnaby, BC, Canada","J9J 3K1","Appendicular skeleton surgery","","","1671"));
		patientRepository.save(new Patient("Watts","Stormi",Gender.Male,LocalDate.of(1989,3,11),"126-962-4814","juliawalker759@tempmailaddress.com","6666 Royal Oak Ave, Burnaby, BC, Canada","L6A 3R5","Abdominoplasty","","","1696"));
		patientRepository.save(new Patient("Jarvis","Haven",Gender.Male,LocalDate.of(1948,7,6),"636-251-2961","alicewilson602@fakeinbox.com","7777 Main St, Vancouver, BC, Canada","J0R 1P0","","","Tay-Sachs disease","1708"));
		patientRepository.save(new Patient("Horne","Jaquelyn",Gender.Male,LocalDate.of(1943,1,26),"493-933-6073","samuelramirez793@discardmail.com","8888 University Dr, Burnaby, BC, Canada","T6E 5X9","","Dust mite allergy","Thalassemia","1735"));
		patientRepository.save(new Patient("Lynwood","Joshua",Gender.Male,LocalDate.of(1995,1,24),"966-369-5895","laurahall460@inboxmails.com","9999 King George Blvd, Surrey, BC, Canada","H2C 2A7","","Pollen allergy","Turner syndrome","1760"));
		patientRepository.save(new Patient("Morce","Rylee",Gender.Male,LocalDate.of(2000,3,12),"530-151-9348","kevinscott985@tempmails.info","12345 Marine Dr, White Rock, BC, Canada","N2C 2H1","","Sun allergy","Fragile X syndrome","1778"));
		patientRepository.save(new Patient("Burns","Rhianna",Gender.Female,LocalDate.of(1930,2,6),"722-429-6881","lisamartinez162@spammik.com","54321 152 St, Surrey, BC, Canada","L2T 2V7","Rhinoplasty","Cold allergy","","1795"));
		patientRepository.save(new Patient("Moss","Vinnie",Gender.Female,LocalDate.of(1934,9,10),"943-205-4055","rachelturner385@guerrillamail.biz","13579 88 Ave, Surrey, BC, Canada","G6H 7P8","Blepharoplasty","","","1818"));
		patientRepository.save(new Patient("Eady","Josiah",Gender.Female,LocalDate.of(2008,2,11),"576-252-4888","ethanross342@maildropz.com","24680 56 Ave, Langley, BC, Canada","R2M 1Z1","","","","1847"));
		patientRepository.save(new Patient("Gray","Kai",Gender.Female,LocalDate.of(1946,10,8),"176-121-7875","johngonzalez278@trash-me.com","98765 72 Ave, Delta, BC, Canada","V4T 4R4","","","","1863"));
		patientRepository.save(new Patient("Tipton","Trenton",Gender.Female,LocalDate.of(2006,7,9),"496-232-2597","michelleclark802@trashmails.com","45678 Wellington Ave, Chilliwack, BC, Canada","M9R 3S7","","","Gaucher disease","1885"));
		patientRepository.save(new Patient("Carter","Emily",Gender.Male,LocalDate.of(2008,9,10),"178-851-7435","jonesjennifer734@zoho.com","35791 Garibaldi Dr, Abbotsford, BC, Canada","B3S 1J2","","Contact dermatitis","Klinefelter syndrome","1914"));
		patientRepository.save(new Patient("Lee","Nathanial",Gender.Male,LocalDate.of(1979,10,23),"420-982-5654","edwardsjason120@protonmail.com","65432 No 3 Rd, Richmond, BC, Canada","V7K 3L5","","Nickel allergy","","1941"));
		patientRepository.save(new Patient("Davis","Sophia",Gender.Male,LocalDate.of(1939,1,3),"790-131-1576","parkerolivia689@yahoo.com","11223 Cambie Rd, Richmond, BC, Canada","P3N 3Z5","Breast augmentation surgery","","","1967"));
		patientRepository.save(new Patient("Wilson","Aaron",Gender.Male,LocalDate.of(1954,5,13),"993-272-9814","harrisdavid785@outlook.com","88776 120 St, Delta, BC, Canada","J0K 3E0","Lumpectomy","","","1987"));
		patientRepository.save(new Patient("Brooks","Samantha",Gender.Male,LocalDate.of(1964,5,28),"930-806-6960","moorebrian201@gmail.com","78965 108 Ave, Surrey, BC, Canada","H7A 1H8","Tonsillectomy","","","2008"));
		patientRepository.save(new Patient("Murphy","Joshua",Gender.Male,LocalDate.of(2019,7,14),"970-560-3821","","11111 152 St, Surrey, BC, Canada","G7V 6K2","","","","2037"));
		patientRepository.save(new Patient("Peterson","Olivia",Gender.Female,LocalDate.of(1988,1,16),"942-929-7727","rogerssamuel803@outlook.com","22222 16th Ave, Langley, BC, Canada","K8P 3M6","","","Angelman syndrome","2066"));
		patientRepository.save(new Patient("Richardson","William",Gender.Female,LocalDate.of(1962,8,14),"176-484-8283","cooperamanda250@protonmail.com","33333 Clayburn Rd, Abbotsford, BC, Canada","V2L 3V1","","Cosmetic allergy","Prader-Willi syndrome","2094"));
		patientRepository.save(new Patient("Mitchell","Ava",Gender.Female,LocalDate.of(1932,12,15),"994-612-7292","stewartmatthew899@gmail.com","44444 Old Yale Rd, Chilliwack, BC, Canada","B3H 3R3","","Fragrance allergy","Rett syndrome","2104"));
		patientRepository.save(new Patient("Fortin","Audrey",Gender.Female,LocalDate.of(1956,3,27),"818-714-5980","uelramirez793@discardmail.com","55555 Hope River Rd, Chilliwack, BC, Canada","J5R 4W4","Prostatectomy","Chemical sensitivity","","2124"));

		Patient patient1 = new Patient("Singh","Addison",Gender.Male,LocalDate.of(2015,9,11),"183-247-7023","inscott985@tempmails.info","77777 Kirschner Rd, Kelowna, BC, Canada","V3S 6K3","","","","2165"); 
		Patient patient2 = new Patient("Pelletier","Thomas",Gender.Male,LocalDate.of(2006,3,6),"444-410-8052","amartinez162@spammik.com","88888 Lawrence Ave, Kelowna, BC, Canada","R3L 1T8","","","","2189");
		Patient patient3 = new Patient("Gagnon","Mia",Gender.Male,LocalDate.of(1962,6,13),"148-737-1450","helturner385@guerrillamail.biz","3333 West Broadway, Vancouver, BC, Canada","V1L 6T9","","","Ehlers-Danlos syndrome","2213");
		Patient patient4 = new Patient("Bouchard","Lucy",Gender.Male,LocalDate.of(1970,1,11),"401-513-9460","anross342@maildropz.com","3187 Oakwood Avenue, Vancouver, BC, Canada","R2M 1Z1","","Anaphylaxis","","2226");
		Patient patient5 = new Patient("Gagne","Logan",Gender.Male,LocalDate.of(1944,6,23),"789-704-5999","ngonzalez278@trash-me.com","4821 Maple Lane, Vancouver, BC, Canada","V4T 4R4","Laminectomy","","","2249");
		Patient patient6 = new Patient("Gagne","Gabriel",Gender.Female,LocalDate.of(1993,4,6),"843-442-5120","rahall460@inboxmails.com","66666 Airport Rd, Kelowna, BC, Canada","H9R 4R6","","","","2144");
		
		patientRepository.save(patient1);
		patientRepository.save(patient2);
		patientRepository.save(patient3);
		patientRepository.save(patient4);
		patientRepository.save(patient5);
		
		patientRepository.findAll().forEach(System.out::println);	
		
		
		ArrayList<Invoice> invoices = new ArrayList<>();
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "VISA", 120, Status.Paid, "GCG Canada"));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "AMEX", 40, Status.Pending, "GCG USA"));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "MASTERCARD", 1000, Status.Unknown, "GCG COL"));
		invoiceRepository.save(
				new Invoice(LocalDate.now(), "TD", 1900, Status.Unknown, "HAPPY HEALTH"));
		
		invoiceRepository.findAll().forEach(System.out::println);
		
		
		// custom - sri: start testing appointment - created only with patient creation
		// need to enter visit date, visit time and quick note only while creating appointment, 
		// rest all will be coming from patient details
		

		
//		appointmentRepository.save(new Appointment("2023-04-10", "09:00", "Cold", new Patient("Pelletier","Thomas",Gender.Male,LocalDate.of(2006,3,6),"444-410-8052","amartinez162@spammik.com","88888 Lawrence Ave, Kelowna, BC, Canada","R3L 1T8","","","","2189")));
		
		Appointment app1 = new Appointment("2023-04-10", "09:00", "Cold");
		Appointment app2 = new Appointment("2023-04-10", "10:00", "Fever");
		Appointment app3 = new Appointment("2023-04-10", "11:00", "Flu Shot");
		Appointment app4 = new Appointment("2023-04-10", "12:00", "Covid-19");
		Appointment app5 = new Appointment("2023-04-11", "13:00", "Vomit");
		
		
		if(debug) System.out.println("OK1");
		app1.setPatient(patient1);
		app2.setPatient(patient2);
		app3.setPatient(patient3);
		app4.setPatient(patient4);
		app5.setPatient(patient5);
		if(debug) System.out.println("OK2");
//		patient1.addAppointment(app1);
		if(debug) System.out.println("OK3");
		Appointment newApp = appointmentRepository.save(app1);
		appointmentRepository.save(app2);
		appointmentRepository.save(app3);
		appointmentRepository.save(app4);
		appointmentRepository.save(app5);
		if(debug) System.out.println("OK4");
		
		System.out.println(newApp.getAppointmentId());
		if(debug) System.out.println("OK5");
		
		
		
		ArrayList<Appointment> appointments = new ArrayList<>();
//		appointmentRepository.save(new Appointment("2023-04-10", "09:00", "Cold", new Patient("Pelletier","Thomas",Gender.Male,LocalDate.of(2006,3,6),"444-410-8052","amartinez162@spammik.com","88888 Lawrence Ave, Kelowna, BC, Canada","R3L 1T8","","","","2189")));
//		appointmentRepository.save(new Appointment("2023-04-10", "10:00", "Fever", new Patient("Gagnon","Mia",Gender.Male,LocalDate.of(1962,6,13),"148-737-1450","helturner385@guerrillamail.biz","3333 West Broadway, Vancouver, BC, Canada","V1L 6T9","","","Ehlers-Danlos syndrome","2213")));
//		appointmentRepository.save(new Appointment("2023-04-10", "11:00", "Flu Shot", new Patient("Bouchard","Lucy",Gender.Male,LocalDate.of(1970,1,11),"401-513-9460","anross342@maildropz.com","3187 Oakwood Avenue, Vancouver, BC, Canada","R2M 1Z1","","Anaphylaxis","","2226")));
//		appointmentRepository.save(new Appointment("2023-04-10", "12:00", "Covid-19", new Patient("Gagne","Logan",Gender.Male,LocalDate.of(1944,6,23),"789-704-5999","ngonzalez278@trash-me.com","4821 Maple Lane, Vancouver, BC, Canada","V4T 4R4","Laminectomy","","","2249")));
//		appointmentRepository.save(new Appointment("2023-04-11", "13:00", "Vomit", new Patient("Paul","Smith",Gender.Male,LocalDate.of(1954,7,23),"604-704-5991","paulsmith111@1234-me.com","21 market Lane, Vancouver, BC, Canada","V5T 4R6","","","","2255")));
		appointmentRepository.findAll().forEach(System.out::println);
		// custom - sri: end
		
	}
	
	
	@Bean

	ApplicationRunner init(DoctorRepository doctorRepository, PatientRepository patientRepository, AppointmentRepository appointmentRepository, InvoiceRepository invoiceRepository) {
		return args -> {
			loadData(doctorRepository, patientRepository, appointmentRepository, invoiceRepository);
		};
	}
	
	
}
