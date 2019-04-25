package dateTime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeExample {
    public static void main(String[] args) {
        Date date = new Date();
        // Date Time API
        LocalDate date1 = LocalDate.now();
        date1.plus(2, ChronoUnit.YEARS);
        System.out.println(LocalDate.now().getDayOfWeek());
//        while(true){
//            System.out.print(LocalTime.now().);
//
//        }


        System.out.println(LocalDate.now().plus(Period.ofMonths(9)));
        System.out.println(LocalDate.now().minus(Period.ofMonths(9)));
        System.out.println(ChronoUnit.SECONDS.between(LocalDateTime.now(),LocalDateTime.now().plus(Period.ofMonths(9))));

    }

}
