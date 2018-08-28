import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Work {

	/*ArrayList created to hold Person Objects named person */
			
	ArrayList<Person> person = new ArrayList<Person>();

	/*addPerson method adds a new Person object */
	
	public void addPerson(String name, String position, int year){
		person.add(new Person(name, position, year));
	}
	
	/*displayData method uses a for loop to traverse the person ArrayList and 
		prints each person's info by the format of the toString() method given
		in the Person class*/

	public void displayData(){
		for(int i = 0; i <person.size(); i++){
			System.out.println(person.get(i).toString());
		}
	}

	/*booleanSearch method first checks to see if the age given to search is valid
		then if it is, it will it will calculate the age of each person until it 
		finds a matching value, else it prints that "There is no one of that age" */
	
	public boolean booleanSearch (int first, int last, int value){
		if(first>last){
			System.out.println("There is no one of that age");
			return false;
		}
		if ((2014-person.get(first).getYear()) == value){
			System.out.println(person.get(first));
			return true;
		}
		else return booleanSearch(first+1,last,value);
	}
	
	/*Search method prints the age to be found and then uses the booleanSearch method
		to see if there is someone of that age in the Arraylist */

	public void search(int n){
		System.out.println("Age " + n);
		booleanSearch(0, person.size()-1, n);
	}

	/*quickSort method is used to sort the list by age from oldest to youngest */
	
	public void quickSort(int min, int max){
		int pivot;
		if (min<max){
			pivot = partition(min, max);
			quickSort(min, pivot-1);
			quickSort(pivot+1, max);
		}
	}

	/*partition method uses the swap method to perform the individual swapping to
		sort the list for the quickSort method */
	
	public int partition(int min, int max){
		int pivot = person.get(min).getYear();
		int left = min;
		int right = max;
		while (left<right){
			while ((person.get(left).getYear()) <= pivot && left < right){
				left++;
			}
			while (person.get(right).getYear() > pivot){
				right--;
			}
			if (left < right){
				swap(left, right);
			}
		}
		swap(min, right);
		
		return right;
	}

	/*swap method provides the partition method ease of moving the Person objects 
		in the person ArrayList right or left used in the partition method */

	public void swap(int left, int right){
		Person temp = person.get(left);
		person.set(left, person.get(right));
		person.set(right, temp);
		
	}
	
	/*Sort method is a quick call to the quickSort method */

	public void Sort(){
		quickSort(0, person.size()-1);
	}
	
	/*Save method creates a new .txt file wherever the program resides and records
		each Object Person a in Arraylist person in the format of the Reset method
		given in the Person class */

	public void Save(String fileName) throws FileNotFoundException {
	    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
	    for (Person a : person)
	         pw.println(a.Reset());
	    pw.close();
	}
}

