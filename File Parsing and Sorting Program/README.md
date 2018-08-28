This project is one of my earlier Java assignments that reads the given "data.txt" file that contains data separated by commas, 
tokenizes this data into a Person object ArrayList, sorts the list of people by age from oldest to youngest using the quicksort method, 
and records this sorted list to a new text file called "workerlist.txt".

The "data.txt" file is simply a comma separated list of names of people, their occupation, and the year they were born. The program 
tokenizes this data with commas as the delimiter by name, position, and year into an ArrayList constructed of Person objects. 

Once the data is in the ArrayList, it is printed to display a version of it unsorted. The quicksort method is then used to sort the 
Person data by age from oldest to youngest, and once this is done, the sorted data is then printed for comparison. Finally, this new, 
sorted list is then written to a text file called "workerlist.txt" with more organized formatting.

A search method is also used in this program to be able to find if there is anyone of certain ages which is what is demonstrated 
at the end of the program after running it.
