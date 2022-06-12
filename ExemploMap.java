import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {

        System.out.println("Crie um dicionária que relacione os modelos de carros e seus valores:");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
           put("gol", 14.4);
           put("uno", 15.6);
           put("mobi", 16.1);
           put("hb20", 14.5);
           put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15.2:");
        carrosPopulares.put("gol",15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo Tucson está no dicionário: "+carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: "+carrosPopulares.get("uno"));

        System.out.println("Exiba os modelos: "+carrosPopulares.keySet());

        System.out.println("Exiba os consumos: "+carrosPopulares.values());

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if(entry.getValue().equals(consumoEficiente)) modeloMaisEficiente = entry.getKey();
        }
        System.out.println("Modelo mais eficiente: "+modeloMaisEficiente+"-"+consumoEficiente);

        System.out.println("Exiba o modelo menos eficiente e o seu consumo:");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry :
                carrosPopulares.entrySet()) {
            if(entry.getValue().equals(consumoMenosEficiente)) modeloMenosEficiente = entry.getKey();
        }
        System.out.println("Modelo menos eficiente: "+modeloMenosEficiente+"-"+consumoMenosEficiente);

        System.out.println("Exiba a soma dos consumos:");
        Iterator<Double>iterator=carrosPopulares.values().iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){{
            soma = soma+ iterator.next();
        }}
        System.out.println(soma);

        System.out.println("Exiba a média dos consumos: "+(soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com o consumo igual a 15.6:");
        Iterator<Double>iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos na ordem em que foram informados:");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);

        System.out.println("Exiba o dicionário ordenado pelo modelo:");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague o primeiro dicionário:");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionário está vazio: "+carrosPopulares.isEmpty());
    }
}
