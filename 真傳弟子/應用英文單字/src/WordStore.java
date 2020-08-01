import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordStore {

    private String Path = "src\\應用英文單字.txt";
    private Map<String, Integer> map = new HashMap<>();
    private File file;

    public WordStore() {
        try {
            initialization();
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() throws IOException {
        file = new File(Path);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            while (reader.ready()) {
                String input = reader.readLine();
                StringTokenizer token = new StringTokenizer(input);

                while (token.hasMoreTokens()) {
                    map.put(token.nextToken(), Integer.parseInt(token.nextToken()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String input = String.format("%s %s %n", entry.getKey(), entry.getValue());
                writer.append(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }
}

