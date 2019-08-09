package com.sastra.javastreamtest;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author prabesh on 09/08/19
 * @project javastreamtest
 */

@Component
public class SaleCalculation implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(SaleCalculation.class);



    static final List<Sale> sales = Arrays.asList(

            new Sale(Store.BHATBHATENI, new Date(), "Ram",
                    Arrays.asList(
                            new Item("WaiWai", 20.00)
                    )
            ),
            new Sale(Store.BIGMART, new Date(), "Laxman",
                    Arrays.asList(
                            new Item("WaiWai", 20.00),
                            new Item("Coke", 90.00),
                            new Item("Chocolate", 1.99)
                    )
            ),
            new Sale(Store.BIGMART, new Date(), "Sita",
                    Arrays.asList(
                            new Item("Cheeseball", 3.49),
                            new Item("Chocolate", 2.99)
                    )));

    private static Stream<Sale> salesStream() {
        return sales.stream();
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(" --- Started Application ---");

        /* 1. how many sales? */
        /* 2. Is total sale more than 100 ? */
        /* 3. Total sale amount */
        /* 4. Total items sold ? */
        /* 5. Count Unique items sold ? */
        /* 6. Total Unique items sold*/
        /* 7. How many items Bhatbhateni sold ? */
        /* 8. List of Customers that bought waiwai */
        /* 9. Uppercase any one Customer */



    }
}

