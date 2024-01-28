package devandroid.lucasdias.appglstudio.model;

public class AgendamentoConfirmado {

    public String nomeCompleto;
    public String telefoneContato;
    public String tipoServico;

    public AgendamentoConfirmado(String nomeCompleto,String telefoneContato, String tipoServico){

        this.nomeCompleto = nomeCompleto;
        this.telefoneContato = telefoneContato;
        this.tipoServico = tipoServico;
    }

    public AgendamentoConfirmado() {
    }

    public String getNomeDoUsuario() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public String toString() {
        return " AgendamentoConfirmado " +
                " \n Nome Completo = " + nomeCompleto +
                "\n Telefone Contato = " + telefoneContato +
                " TipoServico = " + tipoServico  ;
    }
}
