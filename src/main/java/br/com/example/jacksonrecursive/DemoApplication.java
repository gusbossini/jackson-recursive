package br.com.example.jacksonrecursive;

import br.com.example.jacksonrecursive.model.EfetividadeGrupo;
import br.com.example.jacksonrecursive.model.Versao;
import br.com.example.jacksonrecursive.repository.VersaoRepository;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private VersaoRepository versaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Module hibernate5Module() {
        return new Hibernate5Module();
    }

    @Override
    public void run(String... args) throws Exception {
        Versao versao = new Versao();
        versao.setNomeVersao("VERSAO 1");

        EfetividadeGrupo efetividadeGrupo1 = new EfetividadeGrupo();
        efetividadeGrupo1.setVersao(versao);
        efetividadeGrupo1.setNomeGrupo("GRUPO 1");

        EfetividadeGrupo efetividadeGrupo2 = new EfetividadeGrupo();
        efetividadeGrupo2.setVersao(versao);
        efetividadeGrupo2.setNomeGrupo("GRUPO 2");

        List<EfetividadeGrupo> efetividadeGrupos = new ArrayList<>();
        efetividadeGrupos.add(efetividadeGrupo1);
        efetividadeGrupos.add(efetividadeGrupo2);

        versao.setEfetividadeGrupo(efetividadeGrupos);

        versaoRepository.save(versao);
    }
}
