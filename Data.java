package adoption;
import java.util.*;
//Java program to demonstrate initializing
//an array of objects using constructor

class Data {

static Scanner sc=new Scanner(System.in);
public static void main(String args[])
{

Adoption[] arr;
arr = new Adoption[6];
arr[1] = new Adoption("tommy",10, "indie");
arr[0] = new Adoption("jerry",50, "gs");
arr[2] = new Adoption("pari",15, "gr");
arr[3] = new Adoption("dexter",2,"gr");
arr[4] = new Adoption("akira",22,"gs");
arr[5] = new Adoption("rooney",17,"gr");

Adoption obj=new Adoption(null,0, null);

do {                                                            
System.out.println("Options - \n1.Display \n2.Filter");
System.out.println("your choice: ");
obj.setCh(sc.nextInt());
switch(obj.getCh()) {
case 1:
obj.display(arr);
break;

case 2:    
Adoption[] newarr=obj.breed(arr);
obj.sort(newarr, 0, obj.counter-1,1);
obj.display(newarr);
do {
System.out.println("OPTIONS - \n1.Apply age filter \n2.Change breed \n3.Finalize choice");
System.out.println("Option : ");
int opt=sc.nextInt();
switch(opt) {
case 1:
if(obj.counter>1) {
obj.age(newarr);
}
else {
System.out.println("There is just one dog of your liking..");
}
break;

case 2:
newarr=obj.breed(arr);
obj.sort(newarr, 0, obj.counter-1,1);
obj.display(newarr);
break;

case 3:

break;

default:
System.out.println("Invalid input!");
}
System.out.println("Continue filtering?");
}
while(sc.next().equalsIgnoreCase("yes"));
System.out.println("END OF FILTERS");
break;

case 3:
Adoption[] narr=obj.breed(arr);
obj.sort(narr, 0, narr.length-1);
obj.display(narr);
break;

default:
System.out.println("invalid input!");
}
System.out.println("Continue?");
}while(sc.next().equalsIgnoreCase("yes"));

}
}

