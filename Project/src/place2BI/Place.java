package place2BI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Place extends Place2BI {
    double latitude, longitude, minLatitude = 46.3721, maxLatitude = 49.0207, minLongitude = 9.5308, maxLongitude = 17.1607;
    String place;
    int placeX, placeY;

    public Place(String file) throws IOException {
        Path path = Path.of(file);
        int line = new Random().nextInt(0, Files.readAllLines(path).size());
        place = String.valueOf(Files.readAllLines(path).get(line).split(",")[0]);
        latitude = Double.parseDouble(Files.readAllLines(path).get(line).split(",")[1]);
        longitude = Double.parseDouble(Files.readAllLines(path).get(line).split(",")[2]);
        placeX = (int) Math.round(((longitude - minLongitude) / (maxLongitude - minLongitude)) * super.width * 0.904 + super.width * 0.048);
        placeY = (int) Math.round((1 - (latitude - minLatitude) / (maxLatitude - minLatitude)) * super.height * 0.8 * 0.828 + super.height * 0.2 + super.height * 0.8 * 0.08);
    }
}