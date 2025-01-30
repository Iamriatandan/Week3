package linkedlist.singlylinkedlist.inventorymanagemetsystem;
//class to execute created functions
public class Main {
    public static void main(String[] args) {
        //creating object for item class
        ItemList items = new ItemList();

        //adding items to our list
        items.addItemAtBegin(371,"Apple",12,340.56);
        items.addItemAtEnd(1331,"Zip",3,16.3);
        items.addAtPosition(72686,"Basket",5,80.22,2);
        items.addAtPosition(6276,"Cotton",1,45,3);
        items.addAtPosition(82936,"Diaper",10,100,4);
        items.addAtPosition(282,"Eggs",6,54.95,5);
        items.addAtPosition(8901,"Fire Extinguisher",2,400,6);
        items.addAtPosition(938,"Graham Crackers",20,50,7);
        items.addAtPosition(18,"Idli Batter",2,160.75,8);
        items.addAtPosition(329,"Jugs",3,30,9);
        items.addAtPosition(8928,"Kitchen item",12,250,10);

        //displayong list
        items.displayDetails();

        //removing items
        items.removeItem(18);

        //updating quantity of items
        items.updateQuantity(8928,50);
        items.updateQuantity(171,22);

        //searching items
        items.searchItem("Eggs" , 282);
        items.searchItem("bird",724);

        //total value of iventory items
        items.totalCost();

        //sorting list in ascending order
        System.out.println("Items of list in ascending order");
        items.sortItems(false);
        items.displayDetails();


    }
}
