package br.com.zup.transacao;

import br.com.zup.cartao.Cartao;
import br.com.zup.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/transacoes-do-cartao/{idCartao}")
    public ResponseEntity<?> visualizarTransacoes(@PathVariable("idCartao") String idCartao) {

        Cartao cartao = cartaoRepository.findById(idCartao).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse cartão não existe."));

        List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoOrderByIdDesc(cartao);
        List<TransacaoDto> dtos = transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);

    }

}
