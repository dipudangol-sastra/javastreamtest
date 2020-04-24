package com.sastra.javastreamtest;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
        logger.error("How many sales?");
        String salesCount = String.valueOf(salesStream().count());
        logger.info(salesCount);
        /* 2. Is total sale more than 100 ? */
        logger.error("Is total sale more than 100?");
        String result = salesStream().mapToDouble(Sale::total).sum()>100 ? "yes": "no";
        logger.info(result);
        /* 3. Total sale amount */
        logger.error("Total sale amount::");
        String salesAmount = String.valueOf(salesStream().mapToDouble(Sale::total).sum());
        logger.info(salesAmount);
        /* 4. Total items sold ? */
        logger.error("Total items sold::");
        String itemSoldCount = String.valueOf(salesStream().mapToInt(sales1 -> sales1.getItems().size()).sum());
        logger.info(itemSoldCount);
        /* 5. Count Unique items sold ? */
        logger.error("Count Unique items sold ?");
        String uniqueItemSoldCount = String.valueOf(salesStream().flatMap(sale2 -> sale2.getItems().stream()).map(item -> item.items).collect(Collectors.toSet()).size());
        logger.info(uniqueItemSoldCount);
        /* 6. Total Unique items sold*/
        logger.error("Total Unique items sold.");
        String totalUniqueItemsSold = salesStream().flatMap(sale2 -> sale2.getItems().stream()).map(item -> item.items).collect(Collectors.toSet()).toString();
        logger.warn(totalUniqueItemsSold);
        /* 7. How many items Bhatbhateni sold ? */
        logger.error("How many items Bhat-Bhateni sold?");
        String bhatbhateniItemCount = String.valueOf(salesStream().filter(sale -> sale.getStore().equals(Store.BHATBHATENI)).flatMap(sales3 -> sales3.getItems().stream()).count());
        logger.info(bhatbhateniItemCount);
        /* 8. List of Customers that bought waiwai */
        logger.error("List of Customers that bought Wai Wai.");
        String customerListWhoBoughtWaiwai = salesStream().filter(sale -> sale.getItems().stream().anyMatch(item -> item.items.equals("WaiWai"))).map(Sale::getCustomer).collect(Collectors.toList()).toString();
        logger.info(customerListWhoBoughtWaiwai);
        /* 9. Uppercase any one Customer */
        logger.error("Uppercase any one Customer.");
        String upperCaseCustomer = String.valueOf(salesStream().findAny().map(Sale::getCustomer).map(String::toUpperCase));
        logger.info(upperCaseCustomer);



    }
}

