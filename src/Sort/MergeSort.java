package Sort;

// Libraries imported //
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
        
public class MergeSort extends AbstractClass {
    // ====================================================================== //
    //                           Atributes                                    //
    // ====================================================================== //
    //
    private int size;
    Comparable[] vetor;
    
    // MergeSort temporary vetor
    Comparable[] tmpArray;
    
    // Define max value for auto-test
    private final int MAX_TEST_SIZE = 1000000;

    // ====================================================================== //
    //                              Main                                      //
    // ====================================================================== //
    // Main //
    public void menu() {
        // Call sub-Menu
        this.select_action_course(submenu("MergeSort"));
        
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
                    this.Benchmark_MergeSort(i, false);
   
                // Wait input function to save results and proceed to the next test
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
                this.Merge_Order();
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
        
        // Initialize vector with custom size
        vetor = new Comparable[getSize()];
        
        // Initialize the temporary vector too
        tmpArray = new Comparable[this.vetor.length];
        
        // Load vector
        Load_Vetor(vetor, 0, tipo);
    }
    
    // Do the "InsertSort" Thing (normal mode) //
    public void Merge_Order() {
        // Save results //
        Date dt = new Date();
        System.err.println("Inicio: " + dt.toString());
        
        // Aligment/Order function //
        this.MergeSort_manager(this.vetor, this.tmpArray, 0, (this.vetor.length));
        
        // Print end time.
        Date dtf = new Date();
        System.err.println("Fim: " + dtf.toString());
    }

    // ====================================================================== //
    //                            Test Session                                //
    // ====================================================================== //
    // MergeSort function mangaer (Benchmark mode)
    public void Benchmark_MergeSort(int size, boolean decrescent) {
        // Fill Table results header //
        merge_results[0][0] = "Size";
        merge_results[0][1] = "Start at";
        merge_results[0][2] = "End at";
        merge_results[0][3] = "Time(ms)";
        
        // Select 
        switch (size) {
            case 10:
                System.out.println("Testing with 10...");
                vetor = new Comparable[10];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Merge_Order(6);
                else
                    Benchmark_Merge_Order(1);
                break;
            case 100:
                System.out.println("Testing with 100...");
                vetor = new Comparable[100];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Merge_Order(5);
                else
                    Benchmark_Merge_Order(2);
                break;
            case 1000:
                System.out.println("Testing with 1000...");
                vetor = new Comparable[1000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Merge_Order(4);
                else
                    Benchmark_Merge_Order(3);
                break;
            case 10000:
                System.out.println("Testing with 10000...");
                vetor = new Comparable[10000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Merge_Order(3);
                else
                    Benchmark_Merge_Order(4);
                break;
            case 100000:
                System.out.println("Testing with 100000...");
                vetor = new Comparable[100000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Merge_Order(2);
                else
                    Benchmark_Merge_Order(5);
                break;
            case 1000000:
                System.out.println("Testing with 1000000...");
                vetor = new Comparable[1000000];
                Load_Vetor(vetor, 0, 3);
                if (decrescent == true)
                    Benchmark_Merge_Order(1);
                else
                    Benchmark_Merge_Order(6);
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
        System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t|\n", merge_results[0][0], merge_results[0][1], merge_results[0][2], merge_results[0][3]);
        for(int i=1; i < 7; i++) {
            if (i < 5)
                System.out.printf("|\t %s \t\t|\t %s \t|\t %s \t|\t %s \t\t|\n", merge_results[i][0], merge_results[i][1], merge_results[i][2], merge_results[i][3]);
            else
                System.out.printf("|\t %s \t|\t %s \t|\t %s \t|\t %s \t\t|\n", merge_results[i][0], merge_results[i][1], merge_results[i][2], merge_results[i][3]);
        }
        // End
    }
    
    // MergeSort funtion (Benchmark mode)
    public void Benchmark_Merge_Order(int size) {
        // Start crono
        long start_cron = System.currentTimeMillis();
        
        // Sabe the results of the init time.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:ms"); 
	Date dt_init = new Date(); 

        merge_results[size][0] = String.valueOf(getVetor().length);
        merge_results[size][1] = String.valueOf(dateFormat.format(dt_init));
        
        // Aligment/Order function //
        this.MergeSort_manager(this.vetor, this.tmpArray, 0, (this.vetor.length - 1));
        
        // Save the results of the end time
	Date dt_end = new Date(); 
        merge_results[size][2] = String.valueOf(dateFormat.format(dt_end));
        
        // End crono
        long end_cron = System.currentTimeMillis() - start_cron;
        
        // Calculate the time cost
        merge_results[size][3] = String.valueOf(end_cron);
        
        // End
    }
   
    // ====================================================================== //
    /* Order Algorithm */
    private void MergeSort_manager(Comparable[] vector, Comparable[] tmpArray, int left, int right ) {
        if(left < right) {
            int center = ((left + right)/2);
            MergeSort_manager(vector, tmpArray, left, center);
            MergeSort_manager(vector, tmpArray, center + 1, right);
            MergeSort_Order(vector, tmpArray, left, center + 1, right);
        }
    }
    
    private void MergeSort_Order(Comparable[] vector, Comparable[] tmpArray, int leftPos, int rightPos, int rightEnd ) {
        // Variable
        int leftEnd = (rightPos - 1);
        int tmpPos = leftPos;
        int numElements = (rightEnd - leftPos + 1);
        
        // loop principal
        while((leftPos <= leftEnd) && (rightPos <= rightEnd))
            if(vector[leftPos].compareTo(vector[rightPos])<= 0)
                tmpArray[(tmpPos+=1)] = vector[(tmpPos+=1)];
            else
                tmpArray[tmpPos++] = vector[rightPos++];
        
        while(leftPos <= leftEnd)     
            tmpArray[tmpPos++] = vetor[leftPos++];
        
        while(rightPos <= rightEnd)   
            tmpArray[tmpPos++] = vector[rightPos++];
        
        // Copiando o array temporário de volta
        for( int i = 0; i < numElements; i++, rightEnd-- )
            vector[rightEnd] = tmpArray[rightEnd];
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
    
    // ====================================================================== //
    // Sources:
    /* 1) http://www.devmedia.com.br/algoritmos-de-ordenacao/2622 */
    
}