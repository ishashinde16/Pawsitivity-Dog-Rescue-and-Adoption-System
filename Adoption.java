package  adoption;
import java.util.*;
class Adoption {

static Scanner sc=new Scanner(System.in);
public int age;
public String breed;
public String name;

private int ch;

public int getCh() {
return ch;
}

public void setCh(int ch) {
this.ch = ch;
}

//Student class constructor
public  Adoption(String name, int age, String breed)
{
this.name=name;
this.age = age;
this.breed = breed;
}

//sort by breed method -

void swap(Adoption[] arr, int i, int j)
{
Adoption temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}

@SuppressWarnings("unused")
int partition(Adoption[] arr, int low, int high)
{
System.out.println("In partition...");
//pivot

Adoption pivot = arr[high+low/2];


//Index of smaller element and
//indicates the right position
//of pivot found so far
int i = (low -1);


for (int j = low; j <= high-1 ;j++) {

//If current element is smaller
//than the pivot

System.out.println("***");
if (arr[j].age < pivot.age) {
//Increment index of
//smaller element
i++;
swap(arr, i, j);
}


if(ch == 2) {
System.out.println("---");
if (arr[j].breed.compareToIgnoreCase(pivot.breed)<=0) {

//Increment index of
//smaller element
i++;
swap(arr, i, j);
}
}



swap(arr, i + 1, high);
return (i + 1);
}
return (1);
}

/* The main function that implements QuickSort
           arr[] --> Array to be sorted,
           low --> Starting index,
           high --> Ending index
*/
void sort(Adoption [] arr, int low, int high) //10 5
{
System.out.println("in sorting...");

if (low < high) {

//pi is partitioning index, arr[p]
//is now at right place
int pi = partition(arr, low, high);
if(pi>0 || pi<arr.length) {
//Separately sort elements before
//partition and after partition
sort(arr, low, pi - 1);
sort(arr, pi + 1, high);
}
}
}

//shortlisting through age
public void age(Adoption[] arr) {
System.out.println("Enter age range: (low,high)");
int low=sc.nextInt();
int high=sc.nextInt();
System.out.println("Sr.No\tAge\tBreed");
System.out.println("---------------------------------------");
for(int i=0;i<3;i++) {
if(arr[i]==null) {
continue;
}
else if(arr[i].age >= low && arr[i].age<=high) {
System.out.println(i+1+"\t"+arr[i].age+"\t"+arr[i].breed);
}
}
System.out.println("---------------------------------------");
}
int counter;
////shortlisting through breed
public Adoption[] breed(Adoption[] arr) {
counter=0;
System.out.println("Enter breed: ");
String br=sc.next();

Adoption[] newarr = new Adoption[arr.length];
for(int i=0;i<arr.length;i++) {
if(arr[i].breed.contentEquals(br) ) {
newarr[counter]=arr[i];
counter++;
}
}
System.out.println("No of dogs that interest user - "+counter);
return newarr;
}

//display method -
public void display(Adoption arr[])
{
int sr=0;
System.out.println("Sr.No\tDog.No\tAge\tBreed");
System.out.println("----------------------------");
for(int i=0;i<arr.length;i++) {
if(arr[i]==null) {
continue;
}
else {
sr++;
System.out.println(sr+"\t"+(i+1)+"\t"+arr[i].age + "\t"
+  arr[i].breed);
}
}
System.out.println("----------------------------");
}
}


