package br.com.example.jacksonrecursive.controller;

import br.com.example.jacksonrecursive.repository.VersaoRepository;
import br.com.example.jacksonrecursive.model.Versao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("versao")
public class VersaoController {

    @Autowired
    private VersaoRepository versaoRepository;

    @GetMapping
    public ResponseEntity<List<Versao>> versaoLazyProxy() {
        return new ResponseEntity<>(versaoRepository.findAll(), OK);
    }

    @GetMapping("lazy")
    public ResponseEntity<List<Versao>> versaoLazyResolved() {
        return new ResponseEntity<>(versaoRepository.findAllFetched(), OK);
    }

}
