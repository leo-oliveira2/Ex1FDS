import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ConsultasRepository{

    private List<RegistroDoTempo> registros;
    private String nArq;
    private Predicate<RegistroDoTempo> consultaPadrao; // MUDANCA
    // CONDICAO DEFAULT

    public ConsultasRepository(String nArq){
        registros = new LinkedList<>();
        this.nArq = nArq;
        consultaPadrao = registro -> registro.getPrecipitacao() > 0.0; // MUDANCA
    }

    public Predicate<RegistroDoTempo> getConsulta(){
        return this.consultaPadrao;
    }

    public String getNArq(){
        return nArq;
    }

    public void carregaDados(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        // Monta o nome do arquivo
        String nomeCompleto = currDir+"/" + "src" +  "/" +nArq; // ALTERAÇÃO DO LOCAL DO ARQUIVO
        System.out.println(nomeCompleto);
        // Cria acesso ao "diretorio" da mídia (disco)
        Path path = Paths.get(nomeCompleto);

        String linha = "";
         // Usa a classe scanner para fazer a leitura do arquivo
         try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            // Pula o cabecalho
            sc.nextLine();
            // Le os dados
            while(sc.hasNext()){
                linha = sc.nextLine();
                String dados[] = linha.split(" ");
                // Trata a data
                String data[] = dados[0].split("/");
                int dia = Integer.parseInt(data[0]);
                int mes = Integer.parseInt(data[1]);
                int ano = Integer.parseInt(data[2]);
                Datas datas = new Datas(dia, mes, ano);
                // Trata demais dados
                double precipitacao = Double.parseDouble(dados[1]);
                double tempMaxima = Double.parseDouble(dados[2]);
                double tempMinima = Double.parseDouble(dados[3]);
                double horasInsolacao = Double.parseDouble(dados[4]);
                double temperaturaMedia = Double.parseDouble(dados[5]);
                double umidadeRelativaDoAr = Double.parseDouble(dados[6]);
                double velocidadeDoVento = Double.parseDouble(dados[7]);
                // Cria um registro e insere na lista
                RegistroDoTempo reg = new RegistroDoTempo(datas, precipitacao, tempMaxima, tempMinima, horasInsolacao, temperaturaMedia, umidadeRelativaDoAr, velocidadeDoVento);
                registros.add(reg);
            }
         }catch (IOException x){
            x.printStackTrace();
            System.err.format("Erro de E/S: %s%n", x);
         }
    }    

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return registros
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }

    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }

    //MUDANCAS
    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        consultaPadrao = consulta;
        //Alteracao do predicate da consulta do metodo diasEmQue
    }

    public List<Datas> diasEmQue() {
        //Realiza um filtro das ocorrencias de acordo com o predicate e as retorna em forma de lista
        return registros.stream()
            .filter(consultaPadrao)
            .map(r -> r.getData())
            .collect(Collectors.toList());
    }
}