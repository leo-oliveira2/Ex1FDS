import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
}
