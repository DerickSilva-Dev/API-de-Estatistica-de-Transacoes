package derick.desafio.desafio_API.service;

import derick.desafio.desafio_API.dto.StatisticsResponse;
import derick.desafio.desafio_API.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;


@Service
public class TransactionService {

    private final List<Transaction> transactions = Collections.synchronizedList(new ArrayList<>());

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public StatisticsResponse getStatistics() {
        DoubleSummaryStatistics stats = transactions.stream()
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();

        return new StatisticsResponse(stats);
    }

}
