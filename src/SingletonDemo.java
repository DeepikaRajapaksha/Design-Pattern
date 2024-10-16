public class SingletonDemo {

    // Nested static class acting as the singleton
    public static class Printer {
        // Private static variable to hold the single instance of Printer
        private static Printer instance;

        // Private constructor to prevent external instantiation
        private Printer() {
        }

        // Public static synchronized method to get the single instance of Printer
        public static synchronized Printer getInstance() {
            // Lazily initialize the Printer instance
            if (instance == null) {
                instance = new Printer();
            }
            return instance;
        }

        // Public method to simulate printing functionality
        public void print(String document) {
            // Print the document message to the console
            System.out.println("Printing: " + document);
        }
    }

    // Main method as the entry point of the Java program
    public static void main(String[] args) {
        // Obtain the singleton instance of the Printer class
        Printer printer = Printer.getInstance();

        // Simulate printing three documents
        printer.print("Document 1");
        printer.print("Document 2");
        printer.print("Document 3");
    }
}
