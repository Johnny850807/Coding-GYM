import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileSystem {
    private List<Item> fileList = new ArrayList<>();
    private List<String> printAllPath = new ArrayList<>();
    private List<Item> searches = new ArrayList<>();
    private CutPath cutPath = new CutPath();
    private List<Item> useFileList;
    private List<Item> link;
    private String fileName;
    private StringTokenizer tokenizer;

    public FileSystem() {
    }

    public String transferDirectory(String inputPath) {
        List<Item> useFileList = cutPath.judgePath(fileList, inputPath);
        tokenizer = new StringTokenizer(inputPath, "\\");
        String fileName = "";
        searches.clear();

        while (tokenizer.hasMoreTokens()) {
            fileName = tokenizer.nextToken().toString();
        }
        if (fileName.equals("..") || fileName.equals(".")) {
            cutPath.setCurrentPath(cutPath.getCurrentFilePath());
            return cutPath.getCurrentFilePath();
        }

        for (Item item : useFileList) {
            if (item.getName().equals(fileName)) {
                if (item instanceof Folder) {
                    cutPath.setCurrentPath(item.getPath());
                    return item.getPath();
                }
                return "notDirectory";
            }
            searchSameFile(item.getChildren(),fileName);

            for (Item search1 : searches) {
                if(search1.getName().equals(fileName)){
                    if (search1 instanceof Folder) {
                        cutPath.setCurrentPath(search1.getPath());
                        return search1.getPath();
                    }
                    return "notDirectory";
                }
            }
        }
        return "isDirectory";
    }

    public boolean createFolder(String inputPath) {

        if (createFileOrFolderSearch(inputPath)) {
            return true;
        }
        cutPath.setCurrentFilePath(cutPath.getCurrentFilePath() + "\\" + fileName);
        useFileList.add(new Folder(fileName, cutPath.getCurrentFilePath()));
        return false;
    }

    public boolean createFileAndContent(String inputPath, String inputContent) {
        if (createFileOrFolderSearch(inputPath)) {
            return true;
        }
        cutPath.setCurrentFilePath(cutPath.getCurrentFilePath() + "\\" + fileName);
        useFileList.add(new File(fileName, inputContent, cutPath.getCurrentFilePath()));
        return false;
    }

    public boolean deleteFolderOrFile(String inputPath) {
        List<Item> useFileList = cutPath.judgePath(fileList, inputPath);
        tokenizer = new StringTokenizer(inputPath, "\\");
        String fileName = "";
        searches = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            fileName = tokenizer.nextToken();
        }

        for (Item item : useFileList) {
            if (item.getName().equals(fileName)) {
               useFileList.remove(item);
                return true;
        }
 }
        searchSameFile(useFileList, fileName);
        for (Item item : searches) {
            if (item.getName().equals(fileName)) {
                useFileList.remove(item);
                return true;
            }
        }
        return false;
    }

    public String printFileContent(String inputPath) {
        List<Item> useFileList = cutPath.judgePath(fileList, inputPath);
        tokenizer = new StringTokenizer(inputPath, "\\");
        String fileName = "";
        Item spare = null;
        searches = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            fileName = tokenizer.nextToken();
        }

        searchSameFile(useFileList, fileName);
        for (Item item : searches) {
            if (item.getName().equals(fileName)) {
                if (item instanceof Link) {
                    for (Item item1 : item.getChildren()) {
                        if (item1.getName().equals(item.getRootName())) {
                            spare = item1;
                        }
                    }
                    if (spare == null) {
                        return "Cannot find " + item.getPath();
                    }
                    break;
                }
                spare = item;
            }
        }
        if (spare == null) {
            return null;
        }
        return spare.getContent();
    }

    public List<Item> printDirectoryFolderAndFile() {
        return cutPath.judgePath(fileList, " ");
    }

    public void createLink(String linkInput, String targetInput) {
        String rootLinkName = null;
        String linkPath = null;

        createFileOrFolderSearch(targetInput);
        for (Item item : useFileList) {
            if (item.getName().equals(fileName)) {
                rootLinkName = item.getName();
                linkPath = item.getPath();
                link = useFileList;
            }
            createFileOrFolderSearch(linkInput);
            useFileList.add(new Link(fileName, linkPath, null, rootLinkName));
        }
    }

    public List<String> searchAllOrFile(String input) {
        List<Item> useFileList = cutPath.judgePath(fileList, input);
        printAllPath.clear();

        searchSameWordFile(useFileList, input);
        return printAllPath;
    }

    public void searchSameFile(List<Item> items, String fileName) {
        for (Item item : items) {
            if (item.getName().equals(fileName)) {
                searches = items;
            }
            if (item instanceof Folder) {
                searchSameFile(item.getChildren(), fileName);
            }
        }
    }

    public void searchSameWordFile(List<Item> file, String fileName) {
        for (Item item : file) {
            if (item instanceof Link) {
                break;
            }
            if (item.getName().contains(fileName)) {
                printAllPath.add(item.getPath());
            }
            if (item instanceof Folder) {
                searchSameWordFile(item.getChildren(), fileName);

            }
        }
    }

    public boolean createFileOrFolderSearch(String inputPath) {
        useFileList = cutPath.judgePath(fileList, inputPath);
        tokenizer = new StringTokenizer(inputPath, "\\");
        fileName = "";

        while (tokenizer.hasMoreTokens()) {
            fileName = tokenizer.nextToken();
        }
        for (Item item : useFileList) {
            if (item.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
