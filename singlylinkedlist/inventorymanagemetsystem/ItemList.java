package linkedlist.singlylinkedlist.inventorymanagemetsystem;
//class item list for creating list of items and performing necessary methods on it
public class ItemList {
    private Item head;//head node for initial element of list

    //adding items in list
    //adding items at start of list
    public void addItemAtBegin(int itemId, String itemName, int quantity, double price) {
        //creating a new node
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;//assigning is pointer to next value
        head = newItem;//updating head
    }

    //adding item at last of list
    public void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);//new node for insertion
        if (head == null) {
            head = newItem;
            return;
        }
        //creating temporary pointer for traversal
        Item temp = head;//assigning it with head
        while (temp.next != null) { // until adress reaches to 0
            temp = temp.next;
        }
        temp.next = newItem; // pointer points to new added item at last
    }

    //adding item at a specific position
    public void addAtPosition(int itemId, String itemName, int quantity, double price, int position) {
        if (position == 1) {
            addItemAtBegin(itemId, itemName, quantity, price);
            return;
        }
        Item newItem = new Item(itemId, itemName, quantity, price);//new node for insertion
        Item temp = head;//temprorary pointer
        for (int i = 1; temp != null && i < position - 1; i++) {//i<position -1 because the value should pont 1 index before addition of position desired
            temp = temp.next;//assign with address
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;//pointing pointer to adrress of new added item
    }

    //Removing item based on item id
    public void removeItem(int id) {
        if (head == null) return;
        if (head.itemId == id) { // if item on head needs to be deleted
            head = head.next;
            System.out.println("Item removed successfully");
            return;
        }
        Item temp = head;//temproray pointer assigned to head
        while(temp.next != null && temp.next.itemId != id){//finding id of item 1 before the one to be deleted
            temp = temp.next;//assigning pointer for that address
        }
        if(temp.next == null){
            System.out.println("Item not found");
            return;
        }
        temp.next = temp.next.next;// by passing the node to be deleted and assigning pointer to after node present
    }

    //updating quantity of item using item id
    public void updateQuantity(int id, int newQuantity) {
        //temp pointer to traverse the list
        Item temp = head;
        while (temp != null) {
            if(temp.itemId == id){
                temp.quantity =newQuantity;
                System.out.println("Quantity updated ");
                return;
            }
            temp = temp.next;//move to next item if id doesn't match
        }
        System.out.println("Item does not found");
    }

    //method to search item based on item name or item id
    public void searchItem(String name, int id ){
        //creating a temporary pointer for traversal
        Item temp = head;
        boolean found = false;
        while(temp!=null){
            if(temp.itemName.equals(name) || temp.itemId == id){
                System.out.println("Item id : " + temp.itemId + " | Item Name : " + temp.itemName + " | Quantity : " + temp.quantity + " | Price : " + temp.price);
                found =true;
            }
            temp = temp.next; //moved to new item
        }
        if(!found){
            System.out.println("Item not found");
        }

    }
    //calculating total sum of each item based on quantity
    //method for calculating sum by traversing list
    public double totalCost(){
        Item temp = head;//creating temporary pointer and assigning it to head
        double sum=0;
        while(temp!= null){

                 sum += temp.quantity*temp.price;
                 temp = temp.next;
            }
        return sum;
        }



    //method to sort list in ascending or descending order
    public void sortItems(boolean descending){
        if(head == null || head.next == null){//if list is empty or has only one element
         return;
        }
        head =mergeSortByName(head , descending);//calling function to start sorting
    }
    //recursive method to sort linkedlist using mergesort
    private Item mergeSortByName(Item head,boolean descending){
        if(head == null || head.next == null){//if list is empty or has only one element
            return head;
        }
        //finding middle of list and splitting it into two halves
        Item middle =getMiddle(head);//method calling to find middle node of list
        Item left = head;//left part of list before middle
        Item right = middle.next;//right prt of list after middle
        middle.next=null; // breaks list into two halves

        //recursively sort left and right part of list
        left = mergeSortByName(left,descending);
        right = mergeSortByName(right,descending);

        //merge two sorted halves back togather
        return mergeByName(left,right,descending);
    }
    //helper method to find middle node of list
    private Item getMiddle(Item head){
        if(head == null) return null;//list empty
        //using slow and fast pointers to find middle
        Item slow = head , fast =  head;
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;//slow moves 1 step
            fast = fast.next.next;//movs two steps
        }
        return slow;
    }

    //merge two sorted list by item name in either ascending or descending order
    private Item mergeByName(Item left ,Item right , boolean descending){
        if(left == null) return right;//left list is empty
        if(right == null) return left;//right list is empty

        //compare the item names in either ascending or descending order
        if((left.itemName.compareTo(right.itemName)< 0 && ! descending) || (left.itemName.compareTo(right.itemName)>0 && descending)){
            left.next = mergeByName(left.next,right,descending);//recursively merge remaining items
            return left;// Return the left node as the current head of the sorted list
        }
        else{
            right.next = mergeByName(left, right.next, descending); // Recursively merge remaining items
            return right;// Return the right node as the current head of the sorted list
        }
    }

    //printing iventory items with list
    public void displayDetails(){
        Item temp = head;
        while(temp!= null){
            System.out.println("ID : " + temp.itemId + " | Item Name : " + temp.itemName + " | Quantity : " + temp.quantity + " | Price : " + temp.price);
            temp = temp.next;
        }
    }
}