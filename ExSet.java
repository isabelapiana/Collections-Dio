import java.util.*;

public class ExSet {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto contendo as cores do arco-íris:");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("vermelho");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("verde");
        System.out.println(coresArcoIris);

        System.out.println("Exiba as cores uma abaixo da outra:");
        for (String cor : coresArcoIris) {
            System.out.println(cor);
        }

        System.out.println("A quantidade de cores é de: "+coresArcoIris.size());

        System.out.println("Cores em ordem alfabética:");
        Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris2);

        System.out.println("Exiba as cores na ordem inversa: ");
        Set<String> coresdoArcoiris3 = new LinkedHashSet<>(Arrays.asList("verde","laranja","amarelo","vermelho","azul","anil","violeta"));

        System.out.println("Exiba as cores que começam com a letra V:");
        for (String cor : coresArcoIris) {
            if(cor.startsWith("v")) System.out.println(cor);
        }

        System.out.println("Remova as cores que não começam com a letra V:");
        Iterator<String> iterator = coresArcoIris.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().startsWith("v")) iterator.remove();
        }

        System.out.println(coresArcoIris);

        System.out.println("Apague o conjunto:");
        coresArcoIris.clear();

        System.out.println("Confira se o conjunto está vazio: "+coresArcoIris.isEmpty());
    }
}
