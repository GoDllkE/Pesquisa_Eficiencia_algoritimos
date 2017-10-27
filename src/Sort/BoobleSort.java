package Sort;

// Libraries imported //
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
        
public class BoobleSort extends AbstractClass {
    // ====================================================================== //
    //                           Atributes                                    //
    // ====================================================================== //
    //
    private int[] vetor;
    private int size;
    
    // Define max value for auto-test (a thousand)
    private final int MAX_TEST_SIZE = 1000000;

    // ====================================================================== //
    //                              Main                                      //
    // ====================================================================== //
    // Main //
    public void menu() {
        // Call sub-Menu
        this.select_action_course(submenu("BoobleSort"));
        
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
                
                /*
                System.out.println("==> Iniciando teste em ordem crescente...");
                for(int i=10; i <= MAX_TEST_SIZE; i*=10)
                    this.Benchmark_BoobleSort(i, false);
                
                // Stop to save results
                input_wait();
                */
                System.out.printf("\n\n");
                System.out.println("==> Iniciando teste em ordem decrescente...");
                for(int i=10; i <= MAX_TEST_SIZE; i*=10)
                    this.Benchmark_BoobleSort(i, true);
                
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
                this.Booble_Order();
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
        setSize(Integer.parseInt(input.nextLine()));
        vetor = new int[getSize()];
        Load_Vetor(vetor, 0, tipo);
    }
    
    // Do the "boobleSort" Thing (normal mode) //
    public void Booble_Order() {
        // Save results //
        Date dt = new Date();
        System.err.println("Inicio: " + dt.toString());
        
        // Aligment/Order function //
        int aux;
        for(int i=0; i < this.getVetor().length; i++) {
            for(int j=0; j < this.getVetor().length-1; j++) {
                if(this.getVetor()[j] > this.getVetor()[j+1]) {
                    aux = this.getVetor()[j];
                    this.getVetor()[j] = this.getVetor()[j+1];
                    this.getVetor()[j+1] = aux;
                }
            }
        }
        
        // Print end time.
        Date dtf = new Date();
        System.err.println("Fim: " + dtf.toString());
        
    }

    // ====================================================================== //
    //                            Test Session                                //
    // ====================================================================== //
    // BoobleSort function manager (benchmark mode)
    public void Benchmark_BoobleSort(int size, boolean inverse) {
        // Fill Table results header //
        booble_results[0][0] = "Size";
        booble_results[0][1] = "Start at";
        booble_results[0][2] = "End at";
        booble_results[0][3] = "Time(ms)";
        
        // Select 
        switch (size) {
            case 10:
                System.out.println("Testing with 10...");
                vetor = new int[10];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Booble_Order(1, inverse);
                break;
            case 100:
                System.out.println("Testing with 100...");
                vetor = new int[100];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Booble_Order(2, inverse);
                break;
            case 1000:
                System.out.println("Testing with 1000...");
                vetor = new int[1000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Booble_Order(3, inverse);
                break;
            case 10000:
                System.out.println("Testing with 10000...");
                vetor = new int[10000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Booble_Order(4, inverse);
                break;
            case 100000:
                System.out.println("Testing with 100000...");
                vetor = new int[100000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Booble_Order(5, inverse);
                break;
            case 1000000:
                System.out.println("Testing with 1000000...");
                vetor = new int[1000000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Booble_Order(6, inverse);
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
    public void Benchmark_Booble_Order(int size, boolean inverse) {
        // Start crono
        long start_cron = System.currentTimeMillis();
        
        // Sabe the results of the init time.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms:ns"); 
	Date dt_init = new Date(); 

        booble_results[size][0] = String.valueOf(getVetor().length);
        booble_results[size][1] = String.valueOf(dateFormat.format(dt_init));
        
        // Aligment/Order function //
        // Order decrescent
        if (inverse == true) {
            int aux;
            for(int i=(this.getVetor().length - 1); i > 0; i--) {
                for(int j=(this.getVetor().length -1); j > 0 ; j--) {
                    if(this.getVetor()[j] > this.getVetor()[j-1]) {
                        aux = this.getVetor()[j];
                        this.getVetor()[j] = this.getVetor()[j-1];
                        this.getVetor()[j-1] = aux;
                    }
                }
            }    
        }
        else {
            // Order crescent
            int aux;
            for(int i=0; i < this.getVetor().length; i++) {
                for(int j=0; j < this.getVetor().length-1; j++) {
                    if(this.getVetor()[j] > this.getVetor()[j+1]) {
                        aux = this.getVetor()[j];
                        this.getVetor()[j] = this.getVetor()[j+1];
                        this.getVetor()[j+1] = aux;
                    }
                }
            }   
        }
        
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
    //                        Encapsulamento                                  //
    // ====================================================================== //
    // Vetor[]
    public int[] getVetor() {
        return vetor;
    }
    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    // Size
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    // ====================================================================== //
}