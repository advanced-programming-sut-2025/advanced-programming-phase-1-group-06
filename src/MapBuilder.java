import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MapBuilder {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder map = new StringBuilder();
        map.append("""
                {
                    "length": 44,
                    "width": 44,
                    "tiles": [""");
        int x = 45;
        while (x-- > 0) {
            String line = scanner.nextLine();
            map.append('\n').append("\t[\n");
            for (char c: line.toCharArray()) {
                switch (c) {
                    case '.' : //dirt
                        map.append("""
                                    {
                                        "tileType": "Dirt",
                                        "isBlocked": false,
                                        "isHoed": false,
                                        "isWatered": false,
                                        "isFertilized": false
                                      },
                                      """);
                        break;
                    case '=':
                        map.append("""
                                {
                                    "tileType": "Flooring",
                                    "flooringInfo": "GRASS"
                                      },
                                      """);
                        break;
                    case '#':
                        map.append("""
                               {
                                    "tileType": "Flooring",
                                    "flooringInfo": "STONE"
                                    },
                                    """);
                        break;
                    case '~':
                        map.append("""
                                {
                                    "tileType": "Water"
                                    },""");
                        break;
                }
            }
            map.deleteCharAt(map.length()-2);
            map.append("\n],\n");
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\user\\Desktop\\Proj\\src\\models\\Game\\GameMap\\Maps\\map2.json");
        fileWriter.write(map.toString());
        fileWriter.close();
    }
}
