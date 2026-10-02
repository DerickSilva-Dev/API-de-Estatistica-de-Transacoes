package derick.desafio.desafio_API.dto;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class StatisticsResponse {

    private long count;
    private double sum;
    private double avg;
    private double max;
    private double min;

    public StatisticsResponse(DoubleSummaryStatistics summaryStatistics) {
        this.count = summaryStatistics.getCount();
        this.sum = summaryStatistics.getSum();
        this.avg = summaryStatistics.getAverage();
        this.max = summaryStatistics.getMax();
        this.min = summaryStatistics.getMin();
    }

}
