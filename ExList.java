import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
 */
public class ExList {
    public static void main(String[] args) {

        int count = 0;
        double temp,media,somaTemp = 0;

        Scanner scan = new Scanner(System.in);
        List<Double>temperaturas = new ArrayList<Double>();

        do{
            System.out.println("Digite a temperatura:");
            temp = scan.nextDouble();
            count=count+1;
            temperaturas.add(temp);
            somaTemp = somaTemp+temp;
        }while(count<6);

        System.out.println(temperaturas);

        media = somaTemp/6;

        System.out.println("Média das temperaturas: "+media);

        System.out.println("Temperaturas acima da média: ");
        Iterator<Double>iterator = temperaturas.iterator();

        int op = 0;
        while (iterator.hasNext()){
            temp = iterator.next();
            if(temp>media){
                switch (op){
                    case(0):
                        System.out.println("1 - janeiro: \n"+temp);
                        break;
                    case(1):
                        System.out.println("2 - fevereiro: \n"+temp);
                        break;
                    case(2):
                        System.out.println("3 - março: \n"+temp);
                        break;
                    case(3):
                        System.out.println("4 - abril: \n"+temp);
                        break;
                    case(4):
                        System.out.println("5 - maio: \n"+temp);
                        break;
                    case(5):
                        System.out.println("6 - junho: \n"+temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média.");
                }
            }
        op=op+1;
        }
    }
}
