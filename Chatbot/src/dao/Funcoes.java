/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Frase;
import entidades.Porcentagem;
import entidades.Respostas;
import entidades.Significado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author Gustavo
 */
public class Funcoes {
    Conexao conexao = new Conexao();
    
    /* SIGNIFICADO */
    SignificadoJpaController jpSignificado = new SignificadoJpaController(conexao.getConexao());
    
    public void inserirSignificado(String s) {
        jpSignificado.create(new Significado(null, s));
    }
    
    public void preencherSignificado(JComboBox cbs) {
        List<Significado> listSignificado = new ArrayList<>();
        
        listSignificado = jpSignificado.findSignificadoEntities();
        
        for (int i = 0; i < listSignificado.size(); i++) {
            cbs.addItem(listSignificado.get(i).getSignificado());
        }
    }
    
    public Significado getSignificado(String sig) {
        List<Significado> listSig = jpSignificado.findSignificadoEntities();
        
        Significado s = new Significado();
        
        for (int i = 0; i < listSig.size(); i++) {
            if (listSig.get(i).getSignificado().equals(sig)) {
                s = listSig.get(i);
            }
        }        
        return s;
    }
    
    /* FRASE */
    FraseJpaController jpFrase = new FraseJpaController(conexao.getConexao());
    
    public void inserirFrase(String frase, String significado) {
        jpFrase.create(dadosFrase(frase, significado));
    }
    
    public Frase dadosFrase(String f, String s) {
        Frase fa = new Frase();
        fa.setFrase(f);
        fa.setId(null);
        fa.setIdSignificado(getSignificado(s));
        
        return fa;
    }
    
    public void listarFrase(JComboBox cbf) {
        List<Frase> fa = jpFrase.findFraseEntities();
        
        for (int i = 0; i < fa.size(); i++) {
            cbf.addItem(fa.get(i).getFrase());
        }
    }
    
    public int getIdFrase(String fa) {
        List<Frase> f = jpFrase.findFraseEntities();
        int num = 0;
        
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).getFrase().equals(fa)) {
                num = f.get(i).getId();
            }
        }
        return num;
    }
    
    /*  RESPOSTA */
    RespostasJpaController jpResposta = new RespostasJpaController(conexao.getConexao());
    
    public void inserirResposta(String resposta) {
        jpResposta.create(getRespostas(resposta));
    }
    
    public Respostas getRespostas(String r) {
        Respostas re = new Respostas();
        re.setId(null);
        re.setIdFrase(fraseId(r));
        return re;
    }
    
    public Frase fraseId(String f) {
        Frase fa = new Frase();
        
        fa.setId(getIdFrase(f));
        return fa;
    }
    
    public String tirarEspeciais(String aux) {
        String nova = new String();
        
        for (int i = 0; i < aux.length(); i++) {
            //System.out.println(frase.length());
            if ((aux.charAt(i) == ',') || (aux.charAt(i) == '.') || (aux.charAt(i) == ';') || (aux.charAt(i) == ':')
                    || (aux.charAt(i) == '?') || (aux.charAt(i) == '!') || (aux.charAt(i) == '+') 
                    || (aux.charAt(i) == '-') || (aux.charAt(i) == '/') || (aux.charAt(i) == '#')
                    || (aux.charAt(i) == '*')) {
                
            } else {
                nova += aux.charAt(i);
            }
        }
        
        return nova;
    }
    
    public boolean ehLetra(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        
        return false;        
    }
    
    public boolean ehNumero(char c) {
        if (c >= 0 && c <= 9)
            return true;
        
        return false;        
    }
    
    public String[] fraseDividida(String frase) {
        String aux[] = frase.split(" ");
        
        return aux;
    }
    
    public void resposta(JTextArea area, String[] entrada) {
        List<Frase> listFrase = jpFrase.findFraseEntities();
        ArrayList<Porcentagem> porcent = new ArrayList<>();
        
        for (int i = 0; i < listFrase.size(); i++) {
            String[] f = fraseDividida(tirarEspeciais(listFrase.get(i).getFrase()));
            if (f.length > entrada.length) {
                //System.out.println("A frase do banco é maior"); System.out.println("A porcentagem é: " + porcentagem(f, entrada));
                porcent.add(new Porcentagem(listFrase.get(i), porcentagem(f, entrada)));
            } else if (f.length < entrada.length) {
                //System.out.println("A frase de entrada é maior"); System.out.println("A porcentagem é: " + porcentagem(entrada, f));
                porcent.add(new Porcentagem(listFrase.get(i), porcentagem(entrada, f)));
            } else {
                //System.out.println("São iguais"); System.out.println("A porcentagem é: " + porcentagem(f, entrada));
                porcent.add(new Porcentagem(listFrase.get(i), porcentagem(f, entrada)));
            }
        }
        
        //System.out.println(getfFrasePorcentagem(porcent));
        List<Respostas> respostasListas = respo(getfFrasePorcentagem(porcent));
        //Random random = new Random(respostasListas.size()); System.out.println(random.nextInt());
        Random random = new Random(); 
        area.append("\nSuper: " + respostasListas.get(random.nextInt(respostasListas.size())).getIdFrase().getFrase()+"\n\n");
    }
    
    public boolean iguais(String a, String b) {
        if (a.equals(b))
            return true;        
        return false;
    }
    
    public float porcentagem(String a[], String b[]) {
        int cont = 0;
        float porcentagem = 0;
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (iguais(a[i], b[j]) == true) {
                    cont++;
                }
            }
        }
        
        porcentagem = (100 * cont) / a.length;
        
        return porcentagem;
    }
    
    public void mostrarMapa(HashMap<Integer, Float> mapa) {
        Set set = mapa.entrySet();
        Iterator it = set.iterator();
        
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            System.out.println("Id Frase: " + ent.getKey() + " porcentagem: " + ent.getValue());
            
        }
    }
    
    public Frase getfFrasePorcentagem(ArrayList<Porcentagem> p) {
        float maior = 0;
        
        for (int i = 0; i < p.size(); i++) {
            if (maior < p.get(i).getPorcentagem()) {
                maior = p.get(i).getPorcentagem();
            }
        }
        
        for (int j = 0; j < p.size(); j++) {
            if (maior == p.get(j).getPorcentagem()) {
                return p.get(j).getFrase();
            }
        }
        return null;
    }
    
    public List respo(Frase f) {
        List<Respostas> respo = jpResposta.findRespostasEntities();
        
        for (int i = 0; i < respo.size(); i++) {
            if (respo.get(i).getIdFrase().getId() != f.getId()) {
                respo.remove(i);
            }
        }
        return respo;
    }
    
}
