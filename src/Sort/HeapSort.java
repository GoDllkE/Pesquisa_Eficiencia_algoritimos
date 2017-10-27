package Sort;

// Libraries imported //
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
        
public class HeapSort extends AbstractClass {
    // ====================================================================== //
    //                           Atributes                                    //
    // ====================================================================== //
    //
    private Comparable[] vetor;
    private int size;
    
    // Define max value for auto-test (a thousand)
    private final int MAX_TEST_SIZE = 1000000;

    // ====================================================================== //
    //                              Main                                      //
    // ====================================================================== //
    // Main //
    public void menu() {
        // Call sub-Menu
        this.select_action_course(submenu("HeapSort"));
        
        // end of
        this.menu();
    }
    
    // Own name already explain //
    private void select_action_course(int option) {
        // Clear terminal
        clear_terminal();
        
        switch (option) {
            case 1:
                System.out.println("=> Iniciando teste automatizado...");
                System.out.printf("\n\n");
                
                System.out.println("==> Iniciando teste em ordem crescente...");
                for(int i=10; i <= MAX_TEST_SIZE; i*=10)
                    this.Benchmark_HeapSort(i, false);
                
                // Stop to save results
                input_wait();
                
                System.out.printf("\n\n");
                System.out.println("==> Iniciando teste em ordem decrescente...");
                System.out.println("==> Error: Function not ready yet.");
                System.out.println("==> Returning home...");
                select_action_course(7);
                break;
            case 2: 
                System.out.println("Crescente...");
                inicializar(1);
                break;
            case 3: 
                System.out.println("Decrescente...");
                inicializar(2);
                break;
            case 4: 
                System.out.println("Aleatório...");
                inicializar(3);
                break;
            case 5: 
                System.out.println("Ordenar...");
                this.Heap_Order();
                break;
            case 6: 
                System.out.println("Listar...");
                List_Vetor(getVetor());
                break;
            case 7:
                InterfaceLayer.Menu main = new InterfaceLayer.Menu();
                main.start();
            case 8:
                System.exit(0);
            default: 
                System.out.println("Erro: Opção invalida, tente novamente! <enter>"); 
                input.nextLine();
                break;
        }
        // Wait a key 
        System.out.println("Press <enter> to continue...");
        input.nextLine();
    }
    
    // ====================================================================== //
    //                           Functions                                    //
    // ====================================================================== //
    // Initialize the vetor //
    public void inicializar(int tipo) {
        System.out.println("Entre com o tamanho do vetor.");
        System.out.print("Tamanho: ");
        this.setSize(Integer.parseInt(input.nextLine()));
        vetor = new Comparable[this.getSize()];
        Load_Vetor(vetor, 0, tipo);
    }
    
    // Do the "boobleSort" Thing (normal mode) //
    public void Heap_Order() {
        // Save results //
        Date dt = new Date();
        System.err.println("Inicio: " + dt.toString());
        
        // Aligment/Order function //
        this.Manager_HeapSort(this.vetor);
        
        // Print end time.
        Date dtf = new Date();
        System.err.println("Fim: " + dtf.toString());
        
    }

    // ====================================================================== //
    //                            Test Session                                //
    // ====================================================================== //
    // BoobleSort function manager (benchmark mode)
    public void Benchmark_HeapSort(int size, boolean inverse) {
        // Fill Table results header //
        heap_results[0][0] = "Size";
        heap_results[0][1] = "Start at";
        heap_results[0][2] = "End at";
        heap_results[0][3] = "Time(ms)";
        
        // Select 
        switch (size) {
            case 10:
                System.out.println("Testing with 10...");
                vetor = new Comparable[10];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Heap_Order(1, inverse);
                break;
            case 100:
                System.out.println("Testing with 100...");
                vetor = new Comparable[100];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Heap_Order(2, inverse);
                break;
            case 1000:
                System.out.println("Testing with 1000...");
                vetor = new Comparable[1000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Heap_Order(3, inverse);
                break;
            case 10000:
                System.out.println("Testing with 10000...");
                vetor = new Comparable[10000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Heap_Order(4, inverse);
                break;
            case 100000:
                System.out.println("Testing with 100000...");
                vetor = new Comparable[100000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Heap_Order(5, inverse);
                break;
            case 1000000:
                System.out.println("Testing with 1000000...");
                vetor = new Comparable[1000000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Heap_Order(6, inverse);
                break;
            default:
                System.out.println("Erro: Tamano invalido! <enter>");
                input.nextLine();
                break;
        }
        
        // Clear terminal
        clear_terminal();
        
        // List results
        System.out.printf("Listing results...\n\n");
        System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t|\n", booble_results[0][0], booble_results[0][1], booble_results[0][2], booble_results[0][3]);
        for(int i=1; i < 7; i++) {
            if (i < 5)
                System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t\t|\n", booble_results[i][0], booble_results[i][1], booble_results[i][2], booble_results[i][3]);
            else
                System.out.printf("|\t %s \t|\t %s \t|\t %s \t|\t %s \t\t|\n", booble_results[i][0], booble_results[i][1], booble_results[i][2], booble_results[i][3]);
        }
        // End
    }
    
    // BoobleSort function (benchmark mode)
    public void Benchmark_Heap_Order(int size, boolean inverse) {
        // Start crono
        long start_cron = System.currentTimeMillis();
        
        // Sabe the results of the init time.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms"); 
	Date dt_init = new Date(); 

        booble_results[size][0] = String.valueOf(getVetor().length);
        booble_results[size][1] = String.valueOf(dateFormat.format(dt_init));
        
        // Aligment/Order function //
        this.Manager_HeapSort(vetor);
        
        // Save the results of the end time
	Date dt_end = new Date(); 
        booble_results[size][2] = String.valueOf(dateFormat.format(dt_end));
        
        // End crono
        long end_cron = System.currentTimeMillis() - start_cron;
        
        // Calculate the time cost
        booble_results[size][3] = String.valueOf(end_cron);
        
        // End
    }
    
    // ====================================================================== //
    /* Order Algorithm */
    public void Manager_HeapSort(Comparable[] vetor) {
        for(int i = (vetor.length / 2); i >= 0; i--)
            percDown(vetor, i, vetor.length);
        for(int i = (vetor.length - 1); i > 0; i--) {
            this.TrocaValores(vetor, 0, i);
            percDown(vetor, 0, i);
        }
    }
    
    // Method to search down the vetor
    public void percDown(Comparable[] vetor, int i, int n) {
        // Variables
        int child;
        Comparable temporary;

        for(temporary = vetor[i]; leftChild(i) < n; i = child)
        {
            child = leftChild(i);
            if((child != n - 1) && (vetor[child].compareTo(vetor[child + 1]) < 0 ))
                child++;
            if(temporary.compareTo(vetor[child]) < 0)
                vetor[i] = vetor[child];
            else
                break;
        }
        vetor[i] = temporary;
    }
    
    // Method to swap elements values from a comparable
    public void TrocaValores(Object[] a, int index1, int index2) {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
    
    // ====================================================================== //
    //                        Encapsulamento                                  //
    // ====================================================================== //
    // Vetor[]
    public Comparable[] getVetor() {
        return vetor;
    }
    public void setVetor(Comparable[] vetor) {
        this.vetor = vetor;
    }

    // Size
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    // Left Child
    public int leftChild(int i) {
        return (2*i+1);
    }
    
    // Right Child
    public int rightChild(int i) {
        return (2*i+2);
    }
    
    // ====================================================================== //
    // Sources:
    /* 1) http://www.devmedia.com.br/algoritmos-de-ordenacao/2622 */
    
}