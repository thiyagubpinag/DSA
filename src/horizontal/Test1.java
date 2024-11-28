package horizontal;

import javax.sound.midi.Patch;

public class Test1 {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3;
        int res=getIndex(arr,key);
        System.out.println(res);
    }

    public static int getIndex(int[] arr,int key){
        int low=0;
        int high=arr.length-1;

        while(low<=high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[low] < arr[mid] && arr[low] <= key && key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
//
//Why is the main method static in java?
//    because you dont want to create object for main and run by using static you can directly access it via main method itself.
//
//Differences between HashMap and HashTable in Java.
//    Hashmap are not thread safe , it is not synchronized
//    hashtable are thread safe , it is synchronized
//
//
//
//What is the main difference between POST, PUT and PATCH?
//    POST - used for adding resources and we can give maximum payload
//    PUT - used for updating resources
//    PATCH - used for updating resources but here the constraint is only send the attribute whichever is updated.
//
//What are the key components of an HTTP Request?
//    Application-accept - json or anything
//    body - payload
//    header
//    authentication
//    Request Type - GET,POST,PUT,Patch
//    Url of component.(path param , query param)
//
//
//Difference between “ == “ and “ === “ operators in JavaScript.
//        == - used for checking value
//        === - used for checking value and type
//Explain Closures in JavaScript.
//        only inner paramter was accessed by inner function not on outer functionalities
//
//
//The Table name is Employee with columns - id, name, salary. Delete duplicate names keeping 1st name not deleted.
//delete from Employee where name='1st name';
//
//How to find Nth highest salary from a table
//select * from Employee order by salary limit n,1;
//
//There is a table which contains two columns Student and Marks,
//you need to find all the students, whose marks are greater than average marks i.e., list of above average students.
//
//select student from table where marks > (select AVG(MARKS) from tables);