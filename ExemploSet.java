import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione as notas:");
        Set<Double> notas = new HashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println(notas.toString()); //HashSet cria em ordem aleatória e não permite elementos repetidos

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5.0));

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma = soma + next;
        }
        System.out.println("Soma: " + soma);

        System.out.println("Média das notas: " + (soma / notas.size()));

        System.out.println("Remova a nota 0.0: ");
        notas.remove(0.0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba as notas na ordem em que foram informadas: ");
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7.0, 8.5, 9.3, 5.0, 0.0, 3.6)); //Para isso, deve usar o LinkedHashSet
        System.out.println(notas2);

        System.out.println("Exiba as notas em ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2); //Para comparar, use o TreeSet
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto:");
        notas.clear();
        System.out.println(notas.isEmpty());
        System.out.println(notas2.isEmpty()); //Verifica se está vazio
        System.out.println(notas3.isEmpty());

    }
}
