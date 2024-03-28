package tw.dh46.example.videostore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideoStoreTest {


    @Test
    public void testSingleNewReleaseStatement() {
        String expected = "Rental Record for Daniel\n" +
                "\tTop Gun\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";

        Customer daniel = new Customer("Daniel");
        Movie movie = new Movie("Top Gun", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);
        daniel.addRental(rental);

        String actual = daniel.statement();
        System.out.println(actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTwoNewReleaseStatement() {
        String expected = "Rental Record for Daniel\n" +
                "\tTop Gun\t9.0\n" +
                "\tTop Gun Maverick\t9.0\n" +
                "Amount owed is 18.0\n" +
                "You earned 4 frequent renter points";

        Customer daniel = new Customer("Daniel");
        daniel.addRental(new Rental(new Movie("Top Gun", Movie.NEW_RELEASE), 3));
        daniel.addRental(new Rental(new Movie("Top Gun Maverick", Movie.NEW_RELEASE), 3));

        String actual = daniel.statement();
        System.out.println(actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSingleChildrenStatement() {
        String expected = "Rental Record for Daniel\n" +
                "\tTop Gun\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        Customer daniel = new Customer("Daniel");
        daniel.addRental(new Rental(new Movie("Top Gun", Movie.CHILDRENS), 3));

        String actual = daniel.statement();
        System.out.println(actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMultipleRegularStatement() {
        String expected = "Rental Record for Daniel\n" +
                "\tTop Gun\t2.0\n" +
                "\tTop Gun Maverick\t2.0\n" +
                "\tMission Impossible\t3.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 3 frequent renter points";

        Customer daniel = new Customer("Daniel");
        daniel.addRental(new Rental(new Movie("Top Gun", Movie.REGULAR), 1));
        daniel.addRental(new Rental(new Movie("Top Gun Maverick", Movie.REGULAR), 2));
        daniel.addRental(new Rental(new Movie("Mission Impossible", Movie.REGULAR), 3));

        String actual = daniel.statement();
        System.out.println(actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSingleNewReleaseHtmlStatement() {
        String expected = "<H1>Rentals for <EM>Daniel</EM></H1><P>\n" +
                "Top Gun: 9.0<BR>\n" +
                "<P>You owe <EM>9.0</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>";

        Customer daniel = new Customer("Daniel");
        Movie movie = new Movie("Top Gun", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);
        daniel.addRental(rental);

        String actual = daniel.htmlStatement();
        System.out.println(actual);

        Assertions.assertEquals(expected, actual);
    }

}
