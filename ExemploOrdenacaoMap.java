import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O poder do hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
            System.out.println(livro.getKey()+"-"+livro.getValue().getNome());
        }

        System.out.println("Ordem de inserção: ");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O poder do hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21",432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
            System.out.println(livro.getKey()+"-"+livro.getValue().getNome());
        }

        System.out.println("Ordem alfabética dos autores:");
        Map<String,Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
            System.out.println(livro.getKey()+"-"+livro.getValue().getNome());
        }

        System.out.println("Ordem alfabética (nome dos livros):"); //Nome do livro é um valor, terá que trabalhar com TreeSet e passar um Comparator.
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros3) {
            System.out.println(livro.getKey()+"-"+livro.getValue().getNome());
        }

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return getNome().equals(livro.getNome()) && getPaginas().equals(livro.getPaginas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getPaginas());
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}
