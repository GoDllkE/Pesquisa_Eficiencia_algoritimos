package Sort;

// Libraries imported //
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
        
public class QuickSort extends AbstractClass {
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
        this.select_action_course(submenu("QuickSort"));
        
        // end of
        this.menu();
    }
    
    // Own name already explain //
    private void select_action_course(int option) {
        // Clear terminal
        clear_terminal();
        
        switch (option) {
            case 1:
                System.out.println("Iniciando teste automatizado...");
                
                // Ordem crescente
                System.out.println("Ordem crescente...");
                for(int i=10; i <= MAX_TEST_SIZE; i*=10)
                    this.Benchmark_QuickSort(i, false);
   
                // Wait input to save results and proceed to the next test
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
                this.Quick_Order();
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
    public void Quick_Order() {
        // Save results //
        Date dt = new Date();
        System.err.println("Inicio: " + dt.toString());
        
        // Aligment/Order function //
        this.QuickSort_manager(this.vetor, 0,this.vetor.length-1);
        
        // Print end time.
        Date dtf = new Date();
        System.err.println("Fim: " + dtf.toString());
        
    }

    // ====================================================================== //
    //                            Test Session                                //
    // ====================================================================== //
    // BoobleSort function manager (benchmark mode)
    public void Benchmark_QuickSort(int size, boolean decrescent) {
        // Fill Table results header //
        quick_results[0][0] = "Size";
        quick_results[0][1] = "Start at";
        quick_results[0][2] = "End at";
        quick_results[0][3] = "Time(ms)";
        
        // Select 
        switch (size) {
            case 10:
                System.out.println("Testing with 10...");
                vetor = new int[10];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Quick_Order(6);
                else
                    Benchmark_Quick_Order(1);
                break;
            case 100:
                System.out.println("Testing with 100...");
                vetor = new int[100];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Quick_Order(5);
                else
                    Benchmark_Quick_Order(2);
                break;
            case 1000:
                System.out.println("Testing with 1000...");
                vetor = new int[1000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Quick_Order(4);
                else
                    Benchmark_Quick_Order(3);
                break;
            case 10000:
                System.out.println("Testing with 10000...");
                vetor = new int[10000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Quick_Order(3);
                else
                    Benchmark_Quick_Order(4);
                break;
            case 100000:
                System.out.println("Testing with 100000...");
                vetor = new int[100000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Quick_Order(2);
                else
                    Benchmark_Quick_Order(5);
                break;
            case 1000000:
                System.out.println("Testing with 1000000...");
                vetor = new int[1000000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Quick_Order(1);
                else
                    Benchmark_Quick_Order(6);
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
        System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t|\n", quick_results[0][0], quick_results[0][1], quick_results[0][2], quick_results[0][3]);
        for(int i=1; i < 7; i++) {
            if (i < 5)
                System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t\t|\n", quick_results[i][0], quick_results[i][1], quick_results[i][2], quick_results[i][3]);
            else
                System.out.printf("|\t %s \t|\t %s \t|\t %s \t|\t %s \t\t|\n", quick_results[i][0], quick_results[i][1], quick_results[i][2], quick_results[i][3]);
        }
        // End
    }
    
    // BoobleSort function (benchmark mode)
    public void Benchmark_Quick_Order(int size) {
        // Start crono
        long start_cron = System.currentTimeMillis();
        
        // Sabe the results of the init time.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms"); 
	Date dt_init = new Date(); 

        quick_results[size][0] = String.valueOf(getVetor().length);
        quick_results[size][1] = String.valueOf(dateFormat.format(dt_init));
        
        // Aligment/Order function //
        this.QuickSort_manager(this.vetor, 0,this.vetor.length-1);
        
        // Save the results of the end time
	Date dt_end = new Date(); 
        quick_results[size][2] = String.valueOf(dateFormat.format(dt_end));
        
        // End crono
        long end_cron = System.currentTimeMillis() - start_cron;
        
        // Calculate the time cost
        quick_results[size][3] = String.valueOf(end_cron);
        
        // End
    }
    
    // ====================================================================== //
    /* Order Algorithm */
    private void QuickSort_manager(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
              int posicaoPivo = QuickSort_swapper(vetor, inicio, fim);
              QuickSort_manager(vetor, inicio, posicaoPivo - 1);
              QuickSort_manager(vetor, posicaoPivo + 1, fim);
        }
    }
    //////////////
    private int QuickSort_swapper(int[] vetor, int inicio, int fim) {
        // Variables
        int pivo = vetor[inicio];
        int i = inicio + 1;
        int f = fim;
        
        // Quick thing
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
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
    // Sources:
    /* 1) http://www.devmedia.com.br/algoritmos-de-ordenacao/2622 */
    
}