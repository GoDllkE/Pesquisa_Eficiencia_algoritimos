package Sort;

public class Benchmark extends AbstractClass{
    
    // Listing functions, acording to the AbstractClass
    public void results() {
        // Header
        System.out.println("Showing all saved results...");
        System.out.println("");

        try {
            this.listing_results(booble_results, "BoobleSort");
            this.wait_input();
            
            this.listing_results(insert_results, "InsertSort");
            this.wait_input();

            this.listing_results(merge_results, "MergeSort");
            this.wait_input();

            this.listing_results(quick_results, "QuickSort");
            this.wait_input();

            this.listing_results(heap_results, "HeapSort");
            this.wait_input();
        }
        catch(Exception ex) {
            // Error message
            System.out.println("Error: " + ex.getMessage());
            this.wait_input();
        }
        finally {
            // Open instance and return
            InterfaceLayer.Menu main = new InterfaceLayer.Menu();
            main.start();
        }
    }
    
    // Miscellaneous functions
    private void wait_input() {
        // Wait input
        System.out.println("Prescione <enter> para prosseguir...");
        input.nextLine();
        System.out.printf("\n\n\n");
    }
    
    // Beauty output function
    private void listing_results(String[][] vetor, String name) {
        System.out.printf("Listing results for: %s. \n\n", name);
        
        System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t|\n", vetor[0][0], vetor[0][1], vetor[0][2], vetor[0][3]);
        for(int i=1; i < 7; i++) {
            if (i < 5)
                System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t\t|\n", vetor[i][0], vetor[i][1], vetor[i][2], vetor[i][3]);
            else
                System.out.printf("|\t %s \t|\t %s \t|\t %s \t|\t %s \t\t|\n", vetor[i][0], vetor[i][1], vetor[i][2], vetor[i][3]);
        }
    }
    
}
