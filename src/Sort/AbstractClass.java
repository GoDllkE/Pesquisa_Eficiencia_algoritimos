// Default Package
package Sort;

// Libraries imported //
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractClass {
    
    // Default Scanner //
    public Scanner input = new Scanner(System.in);
 
    // Random instance //
    public Random gerador = new Random();
    
    // Result Matrix //
    public String[][] booble_results = new String[7][4];
    public String[][] insert_results = new String[7][4];
    public String[][] merge_results = new String[7][4];
    public String[][] quick_results = new String[7][4];
    public String[][] heap_results = new String[7][4];
    
    // DEBUG //
    public boolean DEBUG = true;
    
    // ====================================================================== //
    //                            Functions                                   //
    // ====================================================================== //
    // List vetor //
    public void List_Vetor(int vetor[]) {
        for(int i=0; i< vetor.length; i++)
            System.out.println(vetor[i]);
    }
    
    // Load vector respectly with the type of //
    public void Load_Vetor(int[] vetor, int i, int tipo) {
        for(i=0; i<vetor.length; i++) {
            switch(tipo) {
                case 1: 
                    vetor[i] = i; 
                    break;
                case 2: 
                    vetor[i] = vetor.length -1 - i; 
                    break;
                case 3:
                    vetor[i] = gerador.nextInt();
                    break;
            }
        }
    }
    
    // ====================================================================== //
    /*        Same functions, but for Comparable type vectors                 */
    // ====================================================================== //
    // List vetor //
    public void List_Vetor(Comparable vetor[]) {
        for(int i=0; i< (vetor.length - 1); i++)
            System.out.println(vetor[i]);
    }
    
    // Load vector respectly with the type of //
    public void Load_Vetor(Comparable[] vetor, int i, int tipo) {
        for(i=0; i<vetor.length; i++) {
            switch(tipo) {
                case 1: 
                    vetor[i] = i; 
                    break;
                case 2: 
                    vetor[i] = vetor.length -1 - i; 
                    break;
                case 3:
                    vetor[i] = gerador.nextInt();
                    break;
            }
        }
    }
    
    // ====================================================================== //
    //                          Miscelaneous                                  //
    // ====================================================================== //
    // And public menu
    public int submenu(String name) {
        // Clear terminal
        clear_terminal();
        
        // Menu
        System.out.println("Ordenação " + name);
        System.out.println("");
        System.out.println("|1| Teste automatizado");
        System.out.println("|2| Inicializar (Crescente)");
        System.out.println("|3| Inicializar (Decrescente)");
        System.out.println("|4| Inicializar (Aleatório)");
        System.out.println("|5| Realizar " + name);
        System.out.println("|6| Listar Vetor");
        System.out.println("|7| Voltar");
        System.out.println("|8| Sair");
        System.out.println("");
        
        System.out.print("Opção: ");
        String option = input.nextLine();
        
        return Integer.parseInt(option);
    }
    
    
    // Clear Netbeans Terminal //
    public void clear_terminal() {
        for(int i=0; i < 35; i++)
            System.out.println("");
    }
    
    // Wait output confirmation to process //
    public void input_wait() {
        System.out.println("==> Order Completa! <enter> para prosseguir");
        input.nextLine();
    }
    
}
