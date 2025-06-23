

import com.deitel.ch17.AccountRecord;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    private Formatter output;
    
    public void openFile()
    {
        try
        {
            output = new Formatter("clients.txt");

        }
            catch(SecurityException securityException){
                System.err.println("Voce não tem o que escrever acessando esse arquivo");
                System.exit(1);
            }
            catch (FileNotFoundException fileNotFoundException){
                System.err.println("Erro ao abrir ou criar o arquivo");
                System.exit(1);
            }
    }
    public void addRecords(){
        AccountRecord record = new AccountRecord();
        Scanner input = new Scanner(System.in);
        System.out.printf("%s\n%s\n%s\n%s\n\n", "Para terminar o input, digite o indicador do fim do arquivo", "Quando voce está promptiado para pressionar input", "No UNIX/Linux/Mac OS X digite <ctrl> d antes de pressionar enter", "No seu Windows digite <ctrl> z antes de pressionar Enter");
        System.out.printf("%s\n%s", "Digite o numero da conta (> 0), nome, sobrenome e saldo", "?");
            while(input.hasNext()){
                try{
                    record.setAccount(input.nextInt());
                    record.setFirstName(input.next());
                    record.setLastName(input.next());
                    record.setBalance(input.nextDouble());
                    if(record.getAccount()> 0){
                        output.format("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
                    }
                    else
                    {
                        System.out.println("Numero do conta precisa melhor que 0");

                    }
                }
                catch(FormatterClosedException formatterClosedException){
                    System.err.println("Erro ao escrever nesse arquivo");
                    return;

                }
                catch(NoSuchElementException elementException){
                    System.err.println("Input invalido. Por favor tente novamente");
                    input.nextLine();
                }
                System.out.printf("%s %s\n%s", "Digite o numero da conta (>0),", "First name, last name and balance.", "?");

            }
    }
    public void closeFile(){
        if(output != null)
        output.close();
    }
}

