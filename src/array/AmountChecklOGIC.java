package array;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AmountChecklOGIC {
    public static void main(String[] args) {


        Double weeksDiff = BigDecimal.valueOf((LocalDate.of(2024,06,01)
                        .until(LocalDate.of(2025,01,31),
                                ChronoUnit.DAYS
                        ) + 1) / 7)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        BigDecimal annualizedEarings = BigDecimal.valueOf(26.91 * ((Double.valueOf(2080) / 52) * weeksDiff));
        System.out.println(annualizedEarings);
    }
}
