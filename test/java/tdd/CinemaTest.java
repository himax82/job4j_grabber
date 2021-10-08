package tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        assertThat(cinema.find(session -> true), is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test(expected = RuntimeException.class)
    public void buyTicketBusyPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date1 = Calendar.getInstance();
        date1.set(2020, 10, 10, 23, 00);
        Ticket ticket1 = cinema.buy(account, 1, 1, date1);
        Ticket ticket2 = cinema.buy(account, 1, 1, date1);
    }

    @Ignore
    @Test(expected = RuntimeException.class)
    public void buyTicketIncorrectPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date1 = Calendar.getInstance();
        date1.set(2021, 10, 10, 23, 00);
        Ticket ticket1 = cinema.buy(account, 500, 300, date1);
    }

    @Ignore
    @Test(expected = RuntimeException.class)
    public void buyTicketIncorrectDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date1 = Calendar.getInstance();
        date1.set(2017, 1, 5, 22, 00);
        Ticket ticket1 = cinema.buy(account, 5, 3, date1);
    }
}