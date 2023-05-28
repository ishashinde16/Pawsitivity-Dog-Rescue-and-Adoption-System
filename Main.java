package main;

import java.util.*;

//----------------------------ARRAY CLASS------------------------------------------------
class Array {

	// Dog attributes
	public int age;
	public String breed;
	public String name;
	public int dogId;
	public int rescueCentreID;
	public String intakeReason;
	public int intakePincode;
	public String gender;
	public String colour;

	// Adopter's details
	public String aName;
	public String aPhonenumber;
	public int apin;

	// variables for adopted dog's linked list
	static Array adopthead;
	static Array next;
	static Array p;

	// Scanner object
	static Scanner sc = new Scanner(System.in);

	// constructor-1
	public Array(int dogId, int age, String name, String breed, String gender, String colour, String aName,
			String aPhonenumber, int apin) {
		this.dogId = dogId;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.gender = gender;
		this.colour = colour;
		this.aName = aName;
		this.aPhonenumber = aPhonenumber;
		this.apin = apin;

	}

	// constructor-2
	public Array(int dogId, String name, int age, String breed, int rescueCentreID, String intakeReason,
			int intakePincode, String gender, String colour)

	{

		this.dogId = dogId;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.rescueCentreID = rescueCentreID;
		this.intakeReason = intakeReason;
		this.intakePincode = intakePincode;
		this.gender = gender;
		this.colour = colour;
	}

	public Array() {

	}

}

//---------------------------------DATABASE
//CLASS------------------------------------------------
class dataBase extends Array {

	// Scanner objects
	static Scanner intsc1 = new Scanner(System.in);
	static Scanner stringsc2 = new Scanner(System.in);
	static Scanner stringsc3 = new Scanner(System.in);
	static Scanner stringsc1 = new Scanner(System.in);

	// variables required for addToDataBase method
	public int newage;
	public String newbreed;
	public String newname;
	public int newdogId;
	public int rescuecenteridofdog;
	public String newIntakeReason;
	public int newIntakePincode;
	public String newDogGender;
	public String newDogColour;

	// variables required for linear linearSearchDataBase
	public String dogBreedToBeSearched;
	public int dogIdToBeSearched;

	// variables required for deletion method
	public int dogIdToBeDeleted;
	public int index;

	// admin variables
	
	private int password = 123;
	// counter
	public int counter = 9;

	// array of dogs main data base
	Array[] dataBase = new Array[50];

	// array of dogs of same breed
	Array[] breedDataBase;

	// ........................................CREATE..........................................
	// dog database creation
	public void create() {

		Array dog0 = new Array(101, "Dexter", 11, "Golden Retriever", 1, "Stray", 1, "Male", "Golden");
		Array dog1 = new Array(102, "Akira", 6, "Golden Retriever", 3, "Incompatible with owner lifestyle", 5, "Female",
				"White and Tan");
		Array dog2 = new Array(103, "Rani", 4, "Indie", 2, "Stray", 3, "Female", "Brown");
		Array dog3 = new Array(104, "Walker", 3, "Labrador", 2, "Abandoned", 3, "Male", "Black");
		Array dog4 = new Array(105, "Gus", 2, "Golden Retriever", 2, "Stray", 3, "Male", "Golden");
		Array dog5 = new Array(106, "Rooney", 9, "Labrador", 3, "Abandoned", 9, "Male", "White");
		Array dog6 = new Array(107, "Luna", 1, "Indie", 3, "Stray", 6, "Female", "Black");
		Array dog7 = new Array(108, "Jupiter", 7, "German Shepherd", 2, "Police Assist", 7, "Male", "Black and Brown");
		Array dog8 = new Array(109, "Rose", 8, "Indie", 1, "Incompatible with owner lifestyle", 1, "Female", "Brown");
		Array dog9 = new Array(110, "Sirius", 13, "Indie", 3, "Stray", 6, "Male", "Black");

		dataBase[0] = dog0;
		dataBase[1] = dog1;
		dataBase[2] = dog2;
		dataBase[3] = dog3;
		dataBase[4] = dog4;
		dataBase[5] = dog5;
		dataBase[6] = dog6;
		dataBase[7] = dog7;
		dataBase[8] = dog8;
		dataBase[9] = dog9;
	}

	// ........................................ADD TO DATA BASE..........................................
	// method to assign the details to adopted dog and adding it to database
	public void addToDataBase() {
		

		int flag = 0;
		System.out.println("Enter the dog id :");
		do {
			flag = 0;

			newdogId = intsc1.nextInt();
			for (int a = 0; a <= counter; a++) {
				if (newdogId == dataBase[a].dogId) {
					flag = 1;
					System.out.println("Enter a unique dogID please: ");
					break;
				}
			}

		} while (flag == 1);

		System.out.println("Enter Dog name :");
		newname = stringsc1.next();

		System.out.println("Enter the dog age :");
		newage = intsc1.nextInt();

		System.out.println("Enter the dog breed : ");
		newbreed = stringsc1.next();

		int flag2=0;
		while(flag2 == 0) {
			System.out.println("Enter the number of the rescue centre in which dog is being admitted : ");
			rescuecenteridofdog = intsc1.nextInt();
			if(rescuecenteridofdog>0 && rescuecenteridofdog<4) {
				flag2 = 1;
				break;
			}
			System.out.println("Invalid center..");
		}

		System.out.println("Enter the intake reason of dog : ");
		newIntakeReason = stringsc1.next();

		System.out.println("Enter the intake pincode of dog : ");
		newIntakePincode = intsc1.nextInt();

		System.out.println("Enter the dog gender : ");
		newDogGender = stringsc1.next();

		System.out.println("Enter the dog colour : ");
		newDogColour = stringsc1.next();

		Array nextDog = new Array(newdogId, newname, newage, newbreed, rescuecenteridofdog, newIntakeReason,
				newIntakePincode, newDogGender, newDogColour);

		counter = counter + 1;

		dataBase[counter] = nextDog;
		
		System.out.println("Dog is Medically Tested and is registered successfully ! ");
	}

	void display_admin()
	{
		Formatter f9 = new Formatter();
		Formatter f10 = new Formatter();
		System.out.println(
				"____________________________________________________________________________________________________________________________________");
		f9.format("%5s %8s %5s %20s %8s %17s %5s %40s %5s\n", "ID", "Name", "Age", "Breed", "Gender", "Colour","Centre No","Intake Reason","Intake Pincode");
		System.out.println(f9);
		System.out.println(
				"____________________________________________________________________________________________________________________________________");

		for (int i = 0; i <= counter; i++) {
			f10.format("%5s %8s %5s %20s %8s %17s %5s %40s %5s\n", dataBase[i].dogId, dataBase[i].name, dataBase[i].age,
					dataBase[i].breed, dataBase[i].gender, dataBase[i].colour,dataBase[i].rescueCentreID,dataBase[i].intakeReason,dataBase[i].intakePincode);
		}
		System.out.println(f10);
	}

	// ........................................ADMIN..........................................
	// login method for admin
	public void admin() {
		
		System.out.println("Thank-you for reaching out! ");
		
		System.out.println("----------------------------------ADMIN CONTROL----------------------------------");
		int enteredWord = 0;

		int flag;
		System.out.println("Enter admin password: ");
		do {
			
			flag = 0;

			enteredWord = intsc1.nextInt();
			for (int a = 0; a <= counter; a++) {
				if (enteredWord != password) {
					flag = 1;
					System.out.println("OOPs! You entered the wrong password!\nplease enter the correct password: ");
					break;
				}
			}

		} while (flag == 1);
		addToDataBase();
	}

	// ........................................DISPLAY DATA
	// BASE..........................................
	// method to display database
	public void displayDataBase() {
		Formatter f1 = new Formatter();
		Formatter f2 = new Formatter();
		System.out.println(
				"____________________________________________________________________________________________________________________________________");
		f1.format("%20s %20s %20s %20s %20s %20s\n", "ID", "Name", "Age", "Breed", "Gender", "Colour");
		System.out.println(f1);
		System.out.println(
				"____________________________________________________________________________________________________________________________________");

		for (int i = 0; i <= counter; i++) {
			f2.format("%20s %20s %20s %20s %20s %20s\n", dataBase[i].dogId, dataBase[i].name, dataBase[i].age,
					dataBase[i].breed, dataBase[i].gender, dataBase[i].colour);
		}
		System.out.println(f2);
	}

	// ........................................SWAP............................................
	// swapping method(used in partition method for quick sort)
	static void swap(Array[] arr, int i, int j) {
		Array temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// method to make partitions according to criterion passed in arguments(used for
	// quick sort)
	// criterion: formal parameter for criterion on ehich array is to be sorted e.g.
	// age, ID etc

	// .......................................PARTITION..........................................
	static int partition(Array[] arr, int low, int high, String criterion) {
		// pivot element
		Array pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			// if criterion is age
			if (criterion.equalsIgnoreCase("age")) {

				if (arr[j].age < pivot.age) {
					i++;
					swap(arr, i, j);
				}

			}
			// if criterion is breed
			if (criterion.equalsIgnoreCase("breed")) {
				if (arr[j].breed.compareTo(pivot.breed) < 0) {
					i++;
					swap(arr, i, j);
				}

			}
			// if criterion is dog id
			if (criterion.equalsIgnoreCase("dogID")) {
				if (arr[j].breed.compareTo(pivot.breed) < 0) {
					i++;
					swap(arr, i, j);
				}

			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	// ........................................QUICK SORT..........................................
	// method for sorting
	static void quickSort(Array[] arr, int low, int high, String criterion) {
		if (low < high) {
			int pi = partition(arr, low, high, criterion);
			quickSort(arr, low, pi - 1, criterion);
			quickSort(arr, pi + 1, high, criterion);
		}
	}

	// counter for breed array
	public int counter1 = 0;

	// ........................................LINEAR SEARCH DATABASE ..........................................
	// searching in database on basis of criterion passed
	Array[] linearSearchDataBase(int dogIdToBeSearched, String dogBreedToBeSearched, String choice) {

		// if criterion is dogid then that dog id is searched and it's index is stored
		if (choice.equalsIgnoreCase("dogId")) {

			for (int i = 0; i <= counter; i++) {

				if (dataBase[i].dogId == dogIdToBeSearched) {
					index = i;
					break;
				}

			}

		}
		// if criterion is dog breed then dogs of that breed are selected and stored in
		// breedDataBase array and returned
		else if (choice.equalsIgnoreCase("dogBreed")) {
			counter1 = 0;
			for (int i = 0; i <= counter; i++) {
				if (dataBase[i].breed.equalsIgnoreCase(dogBreedToBeSearched)) {
					counter1 = counter1 + 1;
				}
			}
			breedDataBase = new Array[10];
			int y = 0;
			while (y < counter1) {
				for (int z = 0; z <= counter; z++) {
					if (dataBase[z].breed.equalsIgnoreCase(dogBreedToBeSearched)) {
						breedDataBase[y++] = dataBase[z];
					}
				}
			}
		}
		return breedDataBase;
	}

	// ...........................................PRINT DISTINCT BREEDS..........................................
	// method to print all available breeds in database
	public void printDistinctBreeds(Array arr[], int n) {
		n = arr.length;
		// Pick all elements one by one
		for (int i = 0; i < n; i++) {
			if (arr[i] != null) {
				// Check if the picked element
				// is already printed
				int j;
				for (j = 0; j < i; j++)
					if (arr[i].breed.equalsIgnoreCase(arr[j].breed))
						break;

				// If not printed earlier,
				// then print it
				if (i == j)
					System.out.println(arr[i].breed);
			} else {
				break;
			}
		}
	}

	// ...........................................AGE..........................................
	// method to apply age filter
	public void age(Array[] arr) {
		// taking age range
		System.out.println("-Enter your preferred age range-");
		// lower bound
		System.out.println("Lower limit: ");
		int low = sc.nextInt();
		// higher bound
		System.out.println("Upper limit: ");
		int high = sc.nextInt();

		// printing
		Formatter f5 = new Formatter();
		Formatter f6 = new Formatter();
		System.out.println(
				"____________________________________________________________________________________________________________________________________");
		f5.format("%20s %20s %20s %20s %20s %20s \n", "ID", "Name", "Age", "Breed", "Gender", "Colour");
		System.out.println(f5);
		System.out.println(
				"____________________________________________________________________________________________________________________________________");

		int cnt=0;
		for (int i = 0; i < counter1; i++) {
			if (arr[i] == null) {
				continue;
			} else if (arr[i].age >= low && arr[i].age <= high) {
				cnt++;
				f6.format("%20s %20s %20s %20s %20s %20s\n", arr[i].dogId, arr[i].name, arr[i].age, arr[i].breed, arr[i].gender,
						arr[i].colour);				
			}
		}
		if(cnt == 0) {
			System.out.println("No dog found of the given specification..");
		}
		
		System.out.println(f6);
		System.out.println(
				"____________________________________________________________________________________________________________________________________");
	}

	// ..............................................DELETION..........................................
	// method to delete the adopted dog from the database
	void deletion() {
		// adopted dog's id
		System.out.println("Entre the dog Id of dog you wish to select : ");
		dogIdToBeDeleted = sc.nextInt();
		dogIdToBeSearched = dogIdToBeDeleted;
		// searched and index updated
		linearSearchDataBase(dogIdToBeSearched, null, "dogId");
		// accepting adopter's details
		System.out.println("Enter your name");
		aName = stringsc2.nextLine();
		System.out.println("Enter your phonenumber");
		aPhonenumber = stringsc3.nextLine();
		System.out.println("Enter your pincode");
		apin = sc.nextInt();
		// creating new node for adopted dog
		Array temp = new Array(dataBase[index].dogId, dataBase[index].age, dataBase[index].name, dataBase[index].breed,
				dataBase[index].gender, dataBase[index].colour, aPhonenumber, aName, apin);

		// passing that node to the create_adoptionlist list method
		create_adoptionlist(temp);
		for (int i = index; i <= counter; i++) {
			dataBase[i] = dataBase[i + 1];
		}
		counter = counter - 1;
	}

	// ........................................CREATE ADOPTION LIST..........................................
	// create_adoptionlist method
	void create_adoptionlist(Array temp) {
		// if list is empty
		if (adopthead == null) {
			adopthead = temp;
		} else {
			// traversing p to the end and then attaching temp
			p = adopthead;
			while (p.next != null) {
				p = p.next;
			}
			p.next = temp;
		}
	}

	// ........................................DISPLAY ADOPTION LIST..........................................
	// method to dispaly adoption list to admin
	void display_adoptionlist() {
		Formatter f3 = new Formatter();
		Formatter f4 = new Formatter();
		// if adoption list is empty
		if (adopthead == null) {
			System.out.println("No adopted dogs");
		} else {
			// printing list
			p = adopthead;
			System.out.println(
					"_________________________________________________________________________________________________________________________");
			f3.format("%10s %10s %10s %10s %10s %10s %10s %10s %10s ", "Dog Id", "Dog Name", "Dog age", "Dog Breed",
					"Dog colour", "Dog gender", "Adopter's name", "Adopter's phonenumber", "Adopter's pincode");
			System.out.println(f3);
			System.out.println(
					"_________________________________________________________________________________________________________________________");

			while (p != null) {
				f4.format("%10s %10s %10s %10s %10s %10s %10s %10s %10s ", p.dogId, p.name, p.age, p.breed, p.colour, p.gender,
						p.aName, p.aPhonenumber, p.apin);
				p = p.next;
			}
			System.out.println(f4);
			System.out.println(
					"_________________________________________________________________________________________________________________________");

		}
	}

}

//---------------------------------------RESCUE CENTER CLASS------------------------------------------------
//class to store rescue center id and distance from entered pin code
class RescueCenter {
	int rcID;// rescuecenter id
	int dist;// distance of rescue center from entered pincode

	RescueCenter(int rcID, int dist) {
		this.rcID = rcID;
		this.dist = dist;
	}
}

//--------------------------------------GRAPH CLASS------------------------------------------------
//class to suggest closest rescue center to the user for rescuing the dog
class graph extends dataBase {

	// ........................................DIJKSTRA..........................................
	void dijkstra(int graph[][], int pin) {
		// array to store shortest path distance of entered pincode from all pincodes
		int sp[] = new int[10];// size initialised to 10 as total 10 places

		// visied array to store the visited status
		// false=not visited
		// true=visited
		Boolean visited[] = new Boolean[10];

		// initially assigning max distance in the shortest path array and making
		// visited status false
		for (int i = 0; i < 10; i++) {
			sp[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		// making distance of source from itself as 0
		sp[pin] = 0;

		for (int j = 0; j < 10; j++) {
			int u = minDistance(sp, visited);
			visited[u] = true;
			for (int v = 0; v < 10; v++) {
				if (!visited[v] && graph[u][v] != 0 && sp[u] != Integer.MAX_VALUE && sp[u] + graph[u][v] < sp[v]) {
					sp[v] = sp[u] + graph[u][v];
				}
			}
		}
		rescuecenteridofdog = printinggraph(sp);
	}

	// ........................................MIN
	// DISTANCE..........................................
	// method to calculate minimum distance
	int minDistance(int sp[], Boolean visited[]) {
		int min = Integer.MAX_VALUE;
		int minindex = -1;
		for (int k = 0; k < 10; k++) {
			if (visited[k] == false && sp[k] <= min) {
				min = sp[k];
				minindex = k;
			}
		}
		return minindex;
	}

	// .........................................PRINTING
	// GRAPH..........................................
	// method to print nearest rescue center from source pincode
	int printinggraph(int sp[])

	{
		// adding rescue center details to list
		RescueCenter r1 = new RescueCenter(1, sp[0]);
		RescueCenter r2 = new RescueCenter(2, sp[4]);
		RescueCenter r3 = new RescueCenter(3, sp[8]);
		System.out.println(
				"_____________________________________________________________________________________________________________\n");
		System.out.println("The distance from rescue center 1 is " + sp[0] + " km\n");
		System.out.println("The distance from rescue center 2 is " + sp[4] + " km\n");
		System.out.println("The distance from rescue center 3 is " + sp[8] + " km\n");
		System.out.println(
				"_____________________________________________________________________________________________________________\n");
		ArrayList<RescueCenter> rc = new ArrayList<>();
		rc.add(r1);
		rc.add(r2);
		rc.add(r3);
		int min = rc.get(0).dist;
		int minindex = 0;
		// getting mindistance rescue center
		for (int i = 0; i < 3; i++) {
			if (rc.get(i).dist < min) {
				min = rc.get(i).dist;
				minindex = i;
			}
		}

		System.out.println(
				"The closest rescue center is : " + rc.get(minindex).rcID + " and it is " + rc.get(minindex).dist + " km away");
		return rc.get(minindex).rcID;
	}

}

//------------------------------------------DONATE NODE CLASS------------------------------------------------
//class to store donor's details
class DonateNode {

	// variables
	String name;
	int amt;
	int phnNo;
	DonateNode next;

	// constructor
	DonateNode(String name, int phnNo, int amt) {

		this.name = name;
		this.phnNo = phnNo;
		this.amt = amt;
	}
	DonateNode()
	{

	}
}

//--------------------------------------------DONATE CLASS-------------------------------------------
//Donation class
class Donate extends DonateNode{
	// scanner object
	Donate()
	{

	}
	Scanner sc = new Scanner(System.in);

	// variables
	int amt;
	int phnNo;
	String name;
	// initial fund present
	int fund = 210000;
	DonateNode head, newDonor1,next;
	DonateNode ptr;

	// ........................................PAY..........................................
	// method to accept donor details
	void pay() {

		// list of some donors
		newDonor1 = new DonateNode("Anushri Patil", 1234567891, 10000);
		head = newDonor1;
		DonateNode newDonor2 = new DonateNode("Isha Shinde", 1234567891, 70000);
		newDonor1.next = newDonor2;
		DonateNode newDonor3 = new DonateNode("Mrunal Vibhute", 1234567891, 50000);
		newDonor2.next = newDonor3;
		DonateNode newDonor4 = new DonateNode("Aditi Wagh", 1234567891, 80000);
		newDonor3.next = newDonor4;
		DonateNode ptr = head;

		System.out.println("Enter your name: ");
		name = sc.nextLine();
		System.out.println("Enter the phone number: ");
		phnNo = sc.nextInt();
		System.out.println("Enter the amount to be donated: ");
		amt = sc.nextInt();

		DonateNode newDonor = new DonateNode(name, phnNo, amt);

		while (ptr.next != null) {

			ptr = ptr.next;

		}
		ptr.next = newDonor;
		// updating amount
		fund = fund + amt;

	}

}


//----------------------------------------------CLASS ADMIN-----------------------------------------
class Admin extends dataBase {
	int j, i, k, n;
	int[] count;

	void occ(Array a[], String criterion) {
		// Initialize array

		// Array fr will store frequencies of element
		int[] fr = new int[counter + 1];
		int visited = -1;
		for (int i = 0; i <= counter; i++) {
			int count = 1;
			for (int j = i + 1; j <= counter; j++) {
				if (criterion.equals("no of dogs at each rescue centre")) {
					if (a[i].rescueCentreID == a[j].rescueCentreID) {
						count++;
						// To avoid counting same element again
						fr[j] = visited;
					}
				}
				if (criterion.equals("intake pincode analysis")) {
					if (a[i].intakePincode == a[j].intakePincode) {
						count++;
						// To avoid counting same element again
						fr[j] = visited;
					}
				}
			}
			if (fr[i] != visited)
				fr[i] = count;
		}

		// Displays the frequency of each element present in array
		if (criterion.equals("no of dogs at each rescue centre")) {
			System.out.println(
					"*************************ANALYSIS OF NUMBER OF DOGS AT EACH RESCUE CENTRE*************************");
			for (int i = 0; i < fr.length; i++) {
				int n = fr[i];
				if (fr[i] != visited) {

					System.out.print(a[i].rescueCentreID + " | ");
					for (int l = 0; l < n; l++) {
						System.out.print("-");
					}

					System.out.println("");
				}
			}
		}
		if (criterion.equals("intake pincode analysis")) {
			System.out.println(
					"*********************ANALYSIS OF NUMBER OF DOGS RECEIVED FROM DIFFERENT PINCODES********************");
			for (int i = 0; i < fr.length; i++) {
				int n = fr[i];
				if (fr[i] != visited) {
					System.out.print(a[i].intakePincode + " | ");
					for (int l = 0; l < n; l++) {
						System.out.print("-");
					}

					System.out.println("");
				}
			}

		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
	}
}

//---------------------------------------------MAIN CLASS------------------------------------------------

public class Main extends dataBase
//class start
{
	// scanner objects
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc3 = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	static Scanner scan6 = new Scanner(System.in);

	// declaring variables
	static int choice1, choice2, choice3;
	static String continueAdmin;
	static String continueUser;
	static String breedTobeSearched;
	static int mainChoice;
	static String homePageChoice;
	static String continueAdopt;
	// objects
	static Donate d = new Donate();
	static Admin admin = new Admin();


	// ........................................MAIN
	// METHOD..........................................

	public static void main(String[] args)
	//mainmethod start
	{
		try {


			do
			{
				System.out.println("**************************************PAWSITIVITY**********************************");
				System.out.println("                       - Dog Rescue and Adoption Centres -                        "); 
				dataBase obj = new dataBase();
				obj.create();
				System.out.println("Choose: ");
				System.out.println("\n1. USER\n2. ADMIN");
				mainChoice = sc2.nextInt();


				switch(mainChoice)
				{
				case 1:
					do{
						// USER
						System.out.println("");

						System.out.println("1. RESCUE a dog in need. \n2. ADOPT and provide a dog with a home \n3. DONATE and ensure all our dogs are taken care of");
						System.out.println("Enter option number from the above choices: ");
						choice1 = sc2.nextInt();

						switch(choice1)
						{
						case 1:

							// rescue
							System.out.println("-----------OUR MISSION IS TO RESCUE. OUR DREAM IS THAT ONE DAY WE WON'T HAVE TO.-----------");
							System.out.println("\n\n");
							graph g = new graph();
							int graph[][] = {
									{ 0, 5, 8, 0, 0, 0, 2, 0, 0, 0 },
									{ 5, 0, 0, 6, 0, 15, 0, 7, 0, 0 },
									{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
									{ 0, 6, 0, 0, 7, 0, 0, 0, 0, 10 },
									{ 0, 0, 0, 7, 0, 0, 0, 11, 0, 10 },
									{ 0, 15, 0, 0, 0, 0, 0, 0, 8, 0 },
									{ 12, 0, 0, 0, 0, 0, 0, 0, 5, 0 },
									{ 0, 7, 0, 0, 11, 0, 0, 0, 0, 0 },
									{ 0, 0, 0, 0, 0, 8, 5, 0, 0, 6 },
									{ 0, 0, 0, 10, 10, 0, 0, 0, 6, 0 }
							};
							System.out.println("Enter the pincode of the area from which the dog is to be rescued: ");
							int pincode = sc.nextInt();
							g.dijkstra(graph, pincode);

							obj.admin();
							obj.displayDataBase();

							break;


						case 2:

							//adopt 

							do
							{
								System.out.println("----------TRUE LOVE IS A HOP, SKIP AND A DOG SHELTER AWAY :)---------");

								System.out.println("\n\n");

								System.out.println("1. View all dogs available in the centres \n2. Filter dogs based on breed");
								System.out.println("Enter your choice: ");
								choice2 = sc2.nextInt();
								switch(choice2)
								{
								case 1:
									obj.displayDataBase();
									break;

								case 2:
									String option;
									do{

										// display all breeds
										System.out.println("-----All available breeds----");
										obj.printDistinctBreeds(obj.dataBase, obj.counter);

										int flag=0;
										while(flag == 0) {
											//enter breed
											System.out.println("Enter the breed of your choice: ");

											obj.dogBreedToBeSearched = sc3.nextLine();
											for(int i=0;i<obj.counter;i++) {
												if(obj.dogBreedToBeSearched.equalsIgnoreCase(obj.dataBase[i].breed)) {
													flag = 1;
												}
											}
											if(flag == 1) {
												break;
											}
											System.out.println("Oops..try again..");
										}


										Array[] mainBreedDataBase = new Array[obj.counter1];

										mainBreedDataBase = obj.linearSearchDataBase(0, obj.dogBreedToBeSearched, "dogBreed");


										Formatter f5=new Formatter();
										Formatter f6=new Formatter();
										System.out.println("____________________________________________________________________________________________________________________________________");
										f5.format("%20s %20s %20s %20s %20s %20s \n","ID","Name","Age","Breed","Gender","Colour");
										System.out.println(f5);
										System.out.println("____________________________________________________________________________________________________________________________________");


										for (int k = 0; k < obj.counter1; k++) {
											f6.format("%20s %20s %20s %20s %20s %20s\n",mainBreedDataBase[k].dogId ,mainBreedDataBase[k].name ,mainBreedDataBase[k].age, mainBreedDataBase[k].breed,mainBreedDataBase[k].gender,mainBreedDataBase[k].colour);

										}

										System.out.println(f6);   System.out.println("__________________________________________________________________________________________________________________________________");



										System.out.println("____________________________");

										// apply age filter

										System.out.println("Do you want to apply age filter ?");
										option = sc2.next();

										if (option.equalsIgnoreCase("yes")) {
											obj.age(mainBreedDataBase);
										}


										// finalise dog
										System.out.println("Do you want to finalise a dog ?");

										option = sc2.next();

										if (option.equalsIgnoreCase("yes")) {

											obj.deletion();

											obj.displayDataBase();
										} 
										else {
											System.out.println("Exiting filtering.. ");

											option = "yes";

											obj.counter1 = 0;

										}
									}while(option.equalsIgnoreCase("no"));//end of do while loop of filter
								}

								System.out.println("Do you want to continue on adoption page?");
								continueAdopt=scan6.nextLine();
							}while(continueAdopt.equalsIgnoreCase("yes"));//adopt end loop


							break;
						case 3:
							//sponsor
							d.pay();
							break;
						default:
							System.out.println("Enter valid option");
							break;


						}//end of user switch


						System.out.println("Do you want to continue on user side?");
						continueUser=sc3.nextLine();
					}while(continueUser.equalsIgnoreCase("yes"));//end of user do while




					break;
				case 2:
					do{
						System.out.println("1.Display data of all dogs present in rescue centres\n2.Display adopted dogs data\n3.Analysis of number of dogs in each rescue centre\n4. Analysis of number of dogs received from different pincodes\n5.Check the fund available");
						choice3 = sc2.nextInt();
						switch(choice3)
						{
						case 1:
							obj.display_admin();
							break;
						case 2:

							obj.display_adoptionlist();
							break;

						case 3:
							admin.occ(obj.dataBase, "no of dogs at each rescue centre");
							break;
						case 4:
							admin.occ(obj.dataBase, "intake pincode analysis");
							break;
						case 5:
							System.out.println("The fund available is "+d.fund+" rs only");
							break;
						}//end of admin switch



						System.out.println("Do you want to continue on the admin side?");
						continueAdmin = scan6.nextLine();
					} while(continueAdmin.equalsIgnoreCase("yes"));//end of admin do while

					break;


				}//end of main switch



				System.out.println("Do you want to visit Home page");
				homePageChoice = sc3.nextLine();
			}while(homePageChoice.equalsIgnoreCase("yes"));//end of main do while loop

		}catch(Exception e) 
		{
			System.out.println(e);
		}
	}//main method end

}
//class end

