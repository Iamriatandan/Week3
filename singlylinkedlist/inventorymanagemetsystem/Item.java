package linkedlist.singlylinkedlist.inventorymanagemetsystem;
//class item for declaring attributes and inititalizing them
public class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next;//pointer to traverse
    //constructor to initialize
    public Item(int itemId,String itemName,int quantity,double price){
        this.itemId=itemId;
        this.itemName=itemName;
        this.quantity=quantity;
        this.price=price;
        this.next = null;//initially it doesn't belong to anywhere
    }
}
