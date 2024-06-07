package orderManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderReceiptFileManager {

    public static void writeReceiptToFile(Order order){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String timestamp = LocalDateTime.now().format(formatter);
            String filename = "src/main/resources/" + timestamp + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

                    writer.write(order.toString());
                    writer.newLine();

            } catch (IOException e) {
                System.out.println("There's nothing here!");
            }

            System.out.println("Your receipt was written to: " + filename);

    }
}
