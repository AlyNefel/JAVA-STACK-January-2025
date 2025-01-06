public class GroceryStore {
    // Method to process a purchase
    public void processPurchase(String[] items) {
        try {
            for (String item : items) {
                scanItem(item); // Scan each item
            }
            System.out.println("Purchase processed successfully.");
        } catch (InvalidBarcodeException e) {
            System.out.println("Error: Invalid barcode detected. Please check the item.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred. Please try again.");
        } finally {
            System.out.println("Thank you for shopping with us.");
        }
    }

    // Method to scan an item
    public void scanItem(String item) throws InvalidBarcodeException {
        if (item.equals("invalid")) {
            throw new InvalidBarcodeException("Invalid barcode: " + item);
        }
        System.out.println("Item scanned: " + item);
    }

    // Custom exception class for invalid barcodes
    public class InvalidBarcodeException extends Exception {
        public InvalidBarcodeException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        GroceryStore store = new GroceryStore();
        String[] items = {"apple", "banana", "invalid", "orange"};
        store.processPurchase(items);
    }
}
