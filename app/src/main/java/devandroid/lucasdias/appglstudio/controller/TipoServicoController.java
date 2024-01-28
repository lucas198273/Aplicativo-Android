package devandroid.lucasdias.appglstudio.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.lucasdias.appglstudio.model.TipoServico;

public class TipoServicoController {

    private List listaServicos;

    public List getListaServicos(){
        listaServicos = new ArrayList<TipoServico>();
        listaServicos.add(new TipoServico("Tatuagem"));
        listaServicos.add(new TipoServico("Piercing"));
        listaServicos.add(new TipoServico("Orcamento"));

        return  listaServicos;
    }
    public ArrayList<String>  dadosParaOSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaServicos().size(); i++) {
            TipoServico obj = (TipoServico) getListaServicos().get(i);
            dados.add(obj.getNomeServico());
        }
        return  dados;
    }




}
