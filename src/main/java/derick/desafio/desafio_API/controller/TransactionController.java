package derick.desafio.desafio_API.controller;


import derick.desafio.desafio_API.dto.StatisticsResponse;
import derick.desafio.desafio_API.dto.TransactionRequest;
import derick.desafio.desafio_API.models.Transaction;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import derick.desafio.desafio_API.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> addTransaction(@Valid @RequestBody TransactionRequest request) {
        Transaction transaction = new Transaction(request.getValor());

        transactionService.addTransaction(transaction);

        return ResponseEntity.ok().build();
    }

    @GetMapping("estatistica")
    public ResponseEntity<StatisticsResponse> checkStatistics() {
        StatisticsResponse stats = transactionService.getStatistics();

        return ResponseEntity.ok().body(stats);
    }

}
