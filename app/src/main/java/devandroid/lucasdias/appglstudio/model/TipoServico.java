package devandroid.lucasdias.appglstudio.model;

public class TipoServico {

    private String nomeServico;

    public TipoServico(String novoServico) {
        this.nomeServico = novoServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
}
