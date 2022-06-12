import java.util.*;

public class ExemploList {
    public static void main(String[] args) {

        System.out.println("Crie uma lista e adicione as sete notas:");

        List<Double>notas = new ArrayList<Double>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.5);
        notas.add(0.0);
        notas.add(3.6);

        System.out.println(notas.toString());

        System.out.println("Exiba a posição da nota 5.0: "+notas.indexOf(5.0));

        System.out.println("Adiciona a nota 8.0 na posição 4: ");
        notas.add(4,8.0);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5.0),6.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 está na lista: "+notas.contains(5.0));

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota : notas)
        {
            System.out.println(nota);
        }

        System.out.println("Exiba a terceita nota adicionada: "+notas.get(2));

        System.out.println("Exiba a maior nota: "+ Collections.min(notas));

        System.out.println("Exiba a maior nota: "+ Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma = soma + next;
        }
        System.out.println(soma);

        System.out.println("Exiba a média: "+(soma/notas.size()));

        System.out.println("Remota a nota 0.0:");
        notas.remove(0.0);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0: ");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7.0");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next<7){
                iterator1.remove();
            }
        }
        System.out.println(notas);

        System.out.println("Apague a lista: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista está vazia: "+notas.isEmpty());

    }
}
