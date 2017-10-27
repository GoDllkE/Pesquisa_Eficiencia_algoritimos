package InterfaceLayer;

// Imported Packages (Abstract only)
import Sort.AbstractClass;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends AbstractClass {    
    
    // Define Instances //
    Sort.BoobleSort booble = new Sort.BoobleSort();
    Sort.InsertSort insert = new Sort.InsertSort();
    Sort.MergeSort merge = new Sort.MergeSort();
    Sort.QuickSort quick = new Sort.QuickSort();
    Sort.HeapSort heap = new Sort.HeapSort();
    Sort.Benchmark benchmark = new Sort.Benchmark();
    
    // Init function //
    public void start() {
        this.main();
    }
    
    // Header //
    private void main() {
        // Clear terminal
        clear_terminal();
        
        // Show hostname
        String nome_pc;
        try {
            nome_pc = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException ex) {
            nome_pc = ex.getMessage();
        }
        
        System.out.println("Executando em: " + nome_pc);
        
        // Main
        System.out.println("Selecione uma opção:");
        System.out.println("");
        System.out.println("|1| BoobleSort");
        System.out.println("|2| InserSort");
        System.out.println("|3| MergeSort");
        System.out.println("|4| QuickSort");
        System.out.println("|5| HeapSort");
        System.out.println("|6| List Results");
        System.out.println("|7| Sair");
        System.out.println("");
        
        // Get data from user
        System.out.print("Opção: ");
        String selected_option = input.nextLine();
        this.select_action_course(Integer.parseInt(selected_option));
    }
    
    // Own name explain //
    private void select_action_course(int option) {
        switch(option) {
            case 1:
                booble.menu();
                break;
            case 2:
                insert.menu();
                break;
            case 3:
                merge.menu();
                break;
            case 4:
                quick.menu();
                input.nextLine();
                break;
            case 5:
                heap.menu();
                break;
            case 6:
                benchmark.results();
                break;
            case 7:
                System.exit(0);
                break;    
            default:
                System.out.println("Erro: Opção invalida, tente novamente! <enter>");
                input.nextLine();
                break;
        }
    }
    
}