import java.util.List;
import java.util.StringTokenizer;

public class CutPath {
    private String currentPath = "";
    private String inputPath;
    private String tokenizeInputPath;
    private String currentFilePath;
    private StringTokenizer inputPathTokenizer;
    private StringTokenizer currentPathTokenizer;
    private List<Item> relatively;
    private int currentPathTokenizeSize;

    public List<Item> judgePath(List<Item> list, String Path) {
        inputPath = Path;
        currentFilePath = "";
        inputPathTokenizer = new StringTokenizer(inputPath, "\\");

        if (Path.startsWith("\\")) {
            return absolutePath(list);
        } else {
            currentPathTokenizer = new StringTokenizer(currentPath, "\\");
            currentPathTokenizeSize = currentPathTokenizer.countTokens();

            return relativelyPath(list);
        }
    }

    public List<Item> absolutePath(List<Item> list) {
        String tokenizePath = inputPathTokenizer.nextToken();

        while (inputPathTokenizer.hasMoreTokens()) {
            for (Item item : list) {
                if (item.getName().equals(tokenizePath) && item instanceof Folder) {
                    currentFilePath += "\\" + item.getName();
                    return absolutePath(item.getChildren());
                }
            }
        }
        return list;
    }

    public List<Item> relativelyPath(List<Item> list) {
        tokenizeInputPath = inputPathTokenizer.nextToken();
        relatively = list;
        cutSpecialPath(list);

        if (!inputPathTokenizer.hasMoreTokens()) {
            return relatively;
        }
        searchSecondToLast(relatively, tokenizeInputPath);

        return relativelyPath(relatively);

    }

    public void searchSecondToLast(List<Item> file, String fileName) {
        for (Item item : file) {
            if (item.getName().equals(fileName)) {
                relatively = item.getChildren();
                currentFilePath = item.getPath();
                return;
            }
            if (item instanceof Folder) {
                searchSecondToLast(item.getChildren(), fileName);
            }
        }
    }

    public void cutSpecialPath(List<Item> list) {

        if (tokenizeInputPath.equals("..")) {
            if (currentPathTokenizeSize == 0) {
                return;
            }
            currentPathTokenizeSize--;
            if (inputPathTokenizer.hasMoreTokens()) {
                tokenizeInputPath = inputPathTokenizer.nextToken();
            }
            tokenizeInputPath = "";
            cutSpecialPath(list);
        } else if (tokenizeInputPath.equals(".")) {

            if (inputPathTokenizer.hasMoreTokens()) {
                tokenizeInputPath = inputPathTokenizer.nextToken();
            }
            tokenizeInputPath = "";
            cutSpecialPath(list);
        }
        if (currentPathTokenizer.hasMoreTokens()) {
            currentPath = currentPathTokenizer.nextToken();
        }

        for (int i = 0; i < currentPathTokenizeSize; i++) {
            for (Item item : list) {
                if (item.getName().equals(currentPath) && item instanceof Folder) {
                    currentFilePath += "\\" + item.getName();
                    relatively = item.getChildren();
                    currentPathTokenizeSize--;
                    cutSpecialPath(relatively);
                    break;
                }
            }
        }
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public void setCurrentFilePath(String currentFilePath) {
        this.currentFilePath = currentFilePath;
    }
}
