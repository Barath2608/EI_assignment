package com.example.designpatterns.behavioral;

import com.example.designpatterns.core.IDemo;
import com.example.designpatterns.behavioral.strategy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class StrategyDemo implements IDemo {
    private static final Logger logger = LoggerFactory.getLogger(StrategyDemo.class);

    @Override
    public void run() {
        logger.info("--- Strategy Demo Start ---");
        int[] data = {5,3,8,1,2,9,4};
        ISortStrategy qs = new QuickSort();
        ISortStrategy bs = new BubbleSort();
        logger.info("QuickSort result: {}", Arrays.toString(qs.sort(data)));
        logger.info("BubbleSort result: {}", Arrays.toString(bs.sort(data)));
        logger.info("--- Strategy Demo End ---");
    }

    @Override
    public String getName() { return "Strategy (Behavioral)"; }
}
