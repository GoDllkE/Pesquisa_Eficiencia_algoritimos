package Sort;

// Libraries imported //
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
        
public class InsertSort extends AbstractClass {
    // ====================================================================== //
    //                           Atributes                                    //
    // ====================================================================== //
    //
    private int[] vetor;
    private int size;
    
    // Define max value for auto-test
    private final int MAX_TEST_SIZE = 1000000;

    // ====================================================================== //
    //                              Main                                      //
    // ====================================================================== //
    // Main //
    public void menu() {
        // Call sub-Menu
        this.select_action_course(submenu("InsertSort"));
        
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
                    this.Benchmark_InsertSort(i, false);
                
                // Stop to save results
                input_wait();
                
                System.out.printf("\n\n");
                System.out.println("==> Iniciando teste em ordem decrescente...");
                for(int i=10; i <= MAX_TEST_SIZE; i*=10)
                    this.Benchmark_InsertSort(i, true);
                
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
                this.Insert_Order();
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
    
    // Do the "InsertSort" Thing (normal mode)//
    public void Insert_Order() {
        // Save results //
        Date dt = new Date();
        System.err.println("Inicio: " + dt.toString());
        
        // Aligment/Order function //
        for(int i = 0; i < this.getVetor().length; i++) {
            int aux = vetor[i];
            for(int j = i; j >= 0 && vetor[j] > aux; j--) {
                vetor[j+1] = vetor[j];
                vetor[j] = aux;
            }
        }
        
        // Print end time.
        Date dtf = new Date();
        System.err.println("Fim: " + dtf.toString());
    }

    // ====================================================================== //
    //                            Test Session                                //
    // ====================================================================== //
    // InsertSort function manager (Benchmark mode)
    public void Benchmark_InsertSort(int size, boolean inverse) {
        // Fill Table results header //
        insert_results[0][0] = "Size";
        insert_results[0][1] = "Start at";
        insert_results[0][2] = "End at";
        insert_results[0][3] = "Time(ms)";
        
        // Select 
        switch (size) {
            case 10:
                System.out.println("Testing with 10...");
                vetor = new int[10];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Insert_Order(1, inverse);
                break;
            case 100:
                System.out.println("Testing with 100...");
                vetor = new int[100];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Insert_Order(2, inverse);
                break;
            case 1000:
                System.out.println("Testing with 1000...");
                vetor = new int[1000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Insert_Order(3, inverse);
                break;
            case 10000:
                System.out.println("Testing with 10000...");
                vetor = new int[10000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Insert_Order(4, inverse);
                break;
            case 100000:
                System.out.println("Testing with 100000...");
                vetor = new int[100000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Insert_Order(5, inverse);
                break;
            case 1000000:
                System.out.println("Testing with 1000000...");
                vetor = new int[1000000];
                Load_Vetor(vetor, 0, 3);
                Benchmark_Insert_Order(6, inverse);
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
        System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t|\n", insert_results[0][0], insert_results[0][1], insert_results[0][2], insert_results[0][3]);
        for(int i=1; i < 7; i++) {
            if (i < 5)
                System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t\t|\n", insert_results[i][0], insert_results[i][1], insert_results[i][2], insert_results[i][3]);
            else
                System.out.printf("|\t %s \t|\t %s \t|\t %s \t|\t %s \t\t|\n", insert_results[i][0], insert_results[i][1], insert_results[i][2], insert_results[i][3]);
        }
        // End
    }
    
    // InsertSort function (Benchmark mode)
    public void Benchmark_Insert_Order(int size, boolean inverse) {
        // Start crono
        long start_cron = System.currentTimeMillis();
        
        // Sabe the results of the init time.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms"); 
	Date dt_init = new Date(); 

        insert_results[size][0] = String.valueOf(getVetor().length);
        insert_results[size][1] = String.valueOf(dateFormat.format(dt_init));
        
        // Aligment/Order function //
        // Decrescent order
        if (inverse) {
            for(int i = (this.getVetor().length -1 ); i > 0; i--) {
                int aux = vetor[i];
                for(int j = i; j >= 0 && vetor[j] > aux; j--) {
                    vetor[j+1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        else {
            // Crescent order
            for(int i = 0; i < this.getVetor().length; i++) {
                int aux = vetor[i];
                for(int j = i; j >= 0 && vetor[j] > aux; j--) {
                    vetor[j+1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        
        // Save the results of the end time
	Date dt_end = new Date(); 
        insert_results[size][2] = String.valueOf(dateFormat.format(dt_end));
        
        // End crono
        long end_cron = System.currentTimeMillis() - start_cron;
        
        // Calculate the time cost
        insert_results[size][3] = String.valueOf(end_cron);
        
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