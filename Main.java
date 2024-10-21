import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(1, "Pencil", "xyzsjdk", 5));
        items.add(new Item(2, "Pen", "xyzsjdk", 10));
        items.add(new Item(3, "Notebook", "xyzsjdk", 25));
        items.add(new Item(4, "IndiaMap", "xyzsjdk", 15));
        items.add(new Item(5, "MarkerPen", "xyzsjdk", 30));
        items.add(new Item(6, "MathsBook", "xyzsjdk", 150));
        items.add(new Item(7, "PhysicsBook", "xyzsjdk", 300));

        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu of Shopping App:  ");
            System.out.println("1: Add a new item to the cart!");
            System.out.println("2: Show the quantity for the addded item!");
            System.out.println("3: Update quantity for the added item!");
            System.out.println("4: Delete the item from the cart!");
            System.out.println("5: Display total bill value of the cart!");
            System.out.println("6: Exit!");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select an item to add to the cart: ");
                    displayItems(items);
                    System.out.println("Enter item Number:");
                    int item = scanner.nextInt() - 1;
                    System.out.println("Enter quantity to add: ");
                    int quantity = scanner.nextInt();
                    if (item >= 0 && item < items.size() && quantity > 0) {
                        cart.addToCart(items.get(item), quantity);

                    } else {
                        System.out.println("Invalid item selection");
                    }
                    break;

                case 2:
                    System.out.println("Select an item to check quantity in the cart: ");
                    displayItems(items);
                    System.out.println("Enter item Number:");
                    int itemToDisplay = scanner.nextInt() - 1;
                    if (itemToDisplay >= 0 && itemToDisplay < items.size()) {
                        System.out.println("Quantity in the cart: " + cart.displayQty(items.get(itemToDisplay)));

                    } else {
                        System.out.println("Invalid item selection");
                    }
                    break;

                case 3:
                    System.out.println("Select an item to updtate quantity in the cart: ");
                    displayItems(items);
                    System.out.println("Enter item Number:");
                    int itemToUpdate = scanner.nextInt() - 1;
                    System.out.println("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    if (itemToUpdate >= 0 && itemToUpdate < items.size()) {
                        cart.updateQty(items.get(itemToUpdate), newQuantity);

                    } else {
                        System.out.println("Invalid item selection");
                    }
                    break;

                case 4:
                    System.out.println("Select an item to Delete from the cart: ");
                    displayItems(items);
                    System.out.println("Enter item Number:");
                    int itemToDelete = scanner.nextInt() - 1;
                    if (itemToDelete >= 0 && itemToDelete < items.size()) {
                        cart.deleteItem(items.get(itemToDelete));

                    } else {
                        System.out.println("Invalid item selection");
                    }
                    break;

                case 5:
                    System.out.println("Total Bill: " + cart.displayBill());
                    break;

                default:
                    System.out.println("Enter valid menu option!");
                    break;
            }

        } while (choice != 6);

        scanner.close();

    }

    public static void displayItems(ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getItemId() + " " + items.get(i).getName()
                    + " " + items.get(i).getPrice());
        }
    }
}
