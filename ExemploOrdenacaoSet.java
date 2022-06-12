import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("Ordem aleatória:");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got","fantasia",60));
            add(new Serie("dark", "drama",60));
            add(new Serie("that'70s show","comédia",60));
        }};
        for (Serie serie : minhasSeries) {
            System.out.println(serie.getNome()+"-"+serie.getGenero()+"-"+serie.getTempoEpisodio());
        }

        System.out.println("Ordem de inserção:");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got","fantasia",60));
            add(new Serie("dark", "drama",60));
            add(new Serie("that'70s show","comédia",60));
        }};

        System.out.println("Ordem natural (tempo do episódio):"); //Para utilizar TreeSet, precisa implementar Comparable na classe Serie
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries); //Tempo igual não irá aparecer, pois é Set
        System.out.println(minhasSeries2);
        for (Serie serie : minhasSeries2) {
            System.out.println(serie.getNome()+"-"+serie.getGenero()+"-"+serie.getTempoEpisodio());
        }

        System.out.println("Ordem por Nome/Gênero/TempoEpisódio: ");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());//Tempo igual não irá aparecer, pois é Set
        System.out.println(minhasSeries3);
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie : minhasSeries3) {
            System.out.println(serie.getNome()+"-"+serie.getGenero()+"-"+serie.getTempoEpisodio());
        }
    }
}

class Serie implements Comparable <Serie>{ //método deve ser implementado e o return deve ser especificado
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serie)) return false;
        Serie serie = (Serie) o;
        return getNome().equals(serie.getNome()) && getGenero().equals(serie.getGenero()) && getTempoEpisodio().equals(serie.getTempoEpisodio());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNome(), getGenero(), getTempoEpisodio());
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio()); //Primeiro critério
        if(tempoEpisodio != 0) return tempoEpisodio;
        else return this.getGenero().compareTo(serie.getGenero()); //Critério de desempate
    }
}
class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome!=0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero!=0) return genero;

        return Integer.compare(s1.getTempoEpisodio(),s2.getTempoEpisodio());
    }
}