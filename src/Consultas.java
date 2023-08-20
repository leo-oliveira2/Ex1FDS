import java.util.List;
public class Consultas {
    private ConsultasRepository repo;
    private String nArq;

    public Consultas(ConsultasRepository repo){
        this.nArq = repo.getNArq();
        this.repo = repo;
    }

    public void carregaDados(){
        repo.carregaDados();
    }    

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return repo.datasEmQueChouveuMaisDe(milimetros);
    }

    public String diaQueMaisChoveuNoAno(int ano){
        return repo.diaQueMaisChoveuNoAno(ano);
    }

    public List<Datas> diasEmQue(){
        return repo.diasEmQue();
    }
}
