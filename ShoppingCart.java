import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Item, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    // Add an item to a cart with the given quantity.
    public void addToCart(Item item, Integer quantity) {

        if (item == null || quantity == null || quantity <= 0) {
            System.out.println("Invalid item or quantity");
            return;

        } else if (cart.containsKey(item)) {
            System.out.println(item.getName() + " already present in the cart. Updating the quantity");
            updateQty(item, cart.get(item) + quantity);  // check

        } else {
            cart.put(item, quantity);
            System.out.println("Added item: " + item.getName() + "  with the quantity: " + quantity + " to the cart");
        }
    }

    // Show quantity for added item .
    public Integer displayQty(Item item) {
        return cart.get(item);
    }

    // Update quantity of added item.
    public void updateQty(Item item, Integer quantity) {
        if (item == null || quantity == null || quantity <= 0) {
            System.out.println("Invalid item or quantity");
            return;

        }
        if (!cart.containsKey(item)) {
            System.out.println(item.getName() + " not present in the cart! Can't update");
            return;
        }
        cart.put(item, cart.get(item) + quantity);//check
        System.out.println(
                "updated  item quantity of : " + item.getName() + " with the quantity: " + quantity + " to the cart");

    }

    // Delete Item from cart.
    public void deleteItem(Item item) {
        if (item == null || !cart.containsKey(item)) {
            System.out.println("Item doesnt exist in the cart");
            return;
        }
        System.out.println(item.getName() + " deleted from the cart!");
        cart.remove(item);
        
    }

    // Display cart total value (Total bill Amount)
    public Double displayBill() {
        double totalAmt = 0;
        for (Item i : cart.keySet()) {
            totalAmt += i.getPrice() * cart.get(i);
        }
        return totalAmt;

    }

}
