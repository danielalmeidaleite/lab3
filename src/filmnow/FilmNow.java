package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 *
 */
public class FilmNow {

    private static final int TAMANHO = 100;

    private Filme[] filmes; //uma representacao da lista de filmes
    private Filme[] hotList;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHO];
        this.hotList = new Filme[10];
    }

    /**
     * Acessa a lista de filmes mantida.
     * @return O array de filmes.
     */
    public Filme[] getFilmes() {
        return this.filmes.clone();
    }

    /**
     * Acessa os dados de um filme específico.
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public Filme getFilme(int posicao) {
        return filmes[posicao];
    }

    public Filme[] getHotList() {
        return this.hotList.clone();
    }

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assitido.
     */
    public String cadastraFilme(int posicao, String nome, String ano, String local) {
        if (posicao > 100 || posicao < 1) { return "POSIÇÃO INVÁLIDA"; }
        if (nome == null) { return "FILME INVALIDO"; }
        if (local == null) { return "FILME INVALIDO"; }

        Filme filme = new Filme(nome, ano, local);
        for (Filme filmeCadastrado : filmes) {
            if (filmeCadastrado != null && filmeCadastrado.equals(filme)) {
                return "FILME JA ADICIONADO";
            }
        }

        this.filmes[posicao] = filme;
        return "FILME ADICIONADO";
    }

    public boolean adicionarHot(int idFilme, int posicao) {
        if (idFilme > 100 || idFilme < 1) { return false; }
        if (posicao > 10 || posicao < 1) { return false; }
        for (Filme filme : hotList) {
            if (filme != null && filme.equals(filmes[idFilme])) {
                return false;
            }
        }

        if (hotList[posicao] != null) {
            hotList[posicao].setHot(false);
        }
        hotList[posicao] = filmes[idFilme];
        filmes[idFilme].setHot(true);
        return true;
    }

    public boolean removerHot(int posicao) {
        if (posicao > 10 || posicao < 1) { return false; }

        hotList[posicao].setHot(false);
        hotList[posicao] = null;
        return true;
    }
}