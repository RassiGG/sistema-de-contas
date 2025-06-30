import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import ricardo.AccountRecord;

public class ReadTextFile {
    private Scanner input;
    
    public void openFile(){
        try{
            input = new Scanner(new File("clients.txt"));
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }
    }
    public void readRecords(){
        AccountRecord record = new AccountRecord();
        System.out.printf("%-10s%-12s%-12s%10s\n", "Account","First Name", "Last Name", "Balance");
        try{
            while(input.hasNext()){
                
            
                record.setAccount(input.nextInt());
            record.setFirstName(input.next());
            record.setLastName(input.next());
            record.setBalance(input.nextDouble());
            System.out.printf("%-10d% -12s%-12s%10.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
            
        }
    }
    catch( NoSuchElementException elementException){
    System.err.println("Arquivo improvavelmente formado");
    input.close();
    System.exit(1);
        }
    catch(IllegalStateException stateException){
    System.err.println("Erro ao ler o arquivo");
    System.exit(1);
     }
}
    public void closeFile(){
        if(input!= null)
    input.close();
    
    }
            
        
    }