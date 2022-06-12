import java.util.*;

//Criar classe Gato
//Criar lista
public class ExemploOrdenacao {
    public static void main(String[] args) {

        List<Gato>meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};
        System.out.println(meusGatos);

        System.out.println("Lista em ordem de inserção: "+meusGatos);

        Collections.shuffle(meusGatos);
        System.out.println("Lista em ordem aleatória: "+meusGatos);

        Collections.sort(meusGatos);
        System.out.println("Ordem natural (nome): "+meusGatos);

        Collections.sort(meusGatos, new ComparatorIdade());
        System.out.println("Ordem por idade: "+meusGatos);//Precisa usar o Comparator, pois o Comparable já foi sobrescrito.

        Collections.sort(meusGatos, new ComparatorCor());
        System.out.println("Ordem por cor: "+meusGatos);

        Collections.sort(meusGatos, new ComparatorCorIdadeENome());
        System.out.println("Ordem por cor, idade e nome: "+meusGatos);
    }
}

class Gato implements Comparable<Gato>{ //Utiliza Comparable<> para poder implementar o método compareTo();
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1,Gato g2){
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{
    @Override
    public int compare(Gato g1,Gato g2){
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorCorIdadeENome implements Comparator<Gato>{
    @Override
    public int compare(Gato g1,Gato g2){
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome!=0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (nome!=0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}