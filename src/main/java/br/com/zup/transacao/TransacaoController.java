package br.com.zup.transacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @GetMapping
    public List<TransacaoDto> visualizarTransacoes() {
        return new ArrayList<>();
    }

}
