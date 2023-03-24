package ru.netology.javaqa;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Хургада", 10_000, 1800, 2200);
    Ticket ticket2 = new Ticket("Москва", "Хургада", 12_000, 1600, 2100);
    Ticket ticket3 = new Ticket("Москва", "Хургада", 10_000, 1020, 1120);
    Ticket ticket4 = new Ticket("Москва", "Хургада", 13_000, 930, 1430);
    Ticket ticket5 = new Ticket("Москва", "Хургада", 8_000, 100, 700);

    TicketTimeComparator timeComparator = new TicketTimeComparator();


    @Test
    void priceComparison1() {

        int expended = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    void priceComparison2() {

        int expended = 1;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    void priceComparison3() {

        int expended = 0;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    void searchWithSorting() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expended = {ticket5, ticket1, ticket3, ticket2, ticket4};
        Ticket[] actual = manager.search("Москва", "Хургада");

        Assertions.assertArrayEquals(expended, actual);
    }


    @Test
    void TicketTimeComparator1() {

        int expended = -1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    void TicketTimeComparator2() {

        int expended = 1;
        int actual = timeComparator.compare(ticket1, ticket3);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    void TicketTimeComparator3() {

        int expended = 0;
        int actual = timeComparator.compare(ticket2, ticket4);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    void searchWithSortingBy() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expended = {ticket3, ticket1, ticket2, ticket4, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Хургада", timeComparator);

        Assertions.assertArrayEquals(expended, actual);
    }
}