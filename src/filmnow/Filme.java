package filmnow;

import java.util.Objects;

public class Filme {
    private String nome;
    private String ano;
    private String local;
    private boolean hot;

    public Filme(String nome, String ano, String local){
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public boolean getHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return ano == filme.ano && Objects.equals(nome, filme.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, ano);
    }

    @Override
    public String toString() {
        return nome + ", " + ano;
    }
}