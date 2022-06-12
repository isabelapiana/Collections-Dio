import java.util.*;

public class ExMap {
    public static void main(String[] args) {

        System.out.println("Crie um dicionário que relacione os estados e suas populações:");
        Map<String,Integer> populacaoEstados = new HashMap<>(){{
           put("PE", 9616621);
           put("AL", 3351543);
           put("CE", 9187103);
           put("RN", 3534265);
        }};
        System.out.println(populacaoEstados);

        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populacaoEstados.put("RN",3534165);
        System.out.println(populacaoEstados);

        System.out.println("Confira se o estado da Paraíba (PB) está no dicionário e, caso não esteja, adicione:"+populacaoEstados.containsKey("PB"));
        populacaoEstados.put("PB",3534165);
        System.out.println(populacaoEstados);

        System.out.println("Exiba a população do estado PE:"+populacaoEstados.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem em que foram inseridas: ");
        Map<String,Integer>populacaoEstados2 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 3534165);
        }};
        System.out.println(populacaoEstados2);

        System.out.println("Exiba os estados em ordem alfabética:");
        Map<String,Integer>populacaoEstados3 = new TreeMap<>(populacaoEstados2);

        System.out.println("Exiba o estado com a menor população e o estado com a maior população:");
        Collection<Integer> populacao = populacaoEstados2.values();
        String estadoMaiorPop = "";
        String estadoMenorPop = "";
        for (Map.Entry<String, Integer> entry :
                populacaoEstados2.entrySet()) {
            if(entry.getValue().equals(Collections.max(populacao))) estadoMaiorPop = entry.getKey();
            if(entry.getValue().equals(Collections.min(populacao))) estadoMenorPop = entry.getKey();
        }
        System.out.println("Maior população: "+estadoMaiorPop+" - "+Collections.max(populacao));
        System.out.println("Menor população: "+estadoMenorPop+" - "+Collections.min(populacao));

        System.out.println("Exiba a soma da população dos estados: ");
        int soma = 0;
        Iterator<Integer>iterator = populacaoEstados2.values().iterator();
        while(iterator.hasNext()){
            soma = soma+ iterator.next();
        }
        System.out.println("soma: "+soma);

        System.out.println("Exiba a média da população:"+(soma/populacaoEstados2.size()));

        System.out.println("Remova os estados com a população menor que 4000000");
        Iterator<Integer>iterator1 = populacaoEstados2.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next()<4000000) iterator1.remove();
        }
        System.out.println(populacaoEstados2);

        System.out.println("Apague o dicionário 2:");
        populacaoEstados2.clear();
        System.out.println(populacaoEstados2);

        System.out.println("Confira se a lista está vazia: "+populacaoEstados2.isEmpty());
    }
}
