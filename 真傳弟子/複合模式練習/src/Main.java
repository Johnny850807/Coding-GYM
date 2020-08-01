import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static FileSystem fileSystem = new FileSystem();
    private static String target = "\\";

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        while (true) {
            if (target.equals("")) {
                target = "\\";
            }
            System.out.print(target + ">");
            inputJudgement();
        }
    }

    public static void inputJudgement() {
        String inputTitle = input.next();
        String inputContent;
        String inputPath;

        switch (inputTitle) {
            case "cd":
                inputPath = input.next();

                String pathExist = fileSystem.transferDirectory(inputPath);
                if (pathExist.equals("notDirectory")) {
                    System.out.println(inputPath + " is not a directory");
                } else if (pathExist.equals("cantFind")) {
                    System.out.println("Cannot find " + inputPath);
                } else {
                    target = pathExist;
                }
                break;
            case "mkdir":
                inputPath = input.next();

                boolean haveSameFolder = fileSystem.createFolder(inputPath);
                if (haveSameFolder) {
                    System.out.println("Cannot create " + inputPath + "," + inputPath + " has existed");
                }

                break;
            case "touch":
                inputPath = input.next();
                inputContent = input.next();

                boolean haveSameFile = fileSystem.createFileAndContent(inputPath, inputContent);
                if (haveSameFile) {
                    System.out.println("Cannot create " + inputPath + "," + inputPath + " has existed");
                }

                break;
            case "rm":
                inputPath = input.next();

                boolean haveFile = fileSystem.deleteFolderOrFile(inputPath);
                if (!haveFile) {
                    System.out.println("Cannot find " + inputPath);
                }
                break;
            case "cat":
                inputPath = input.next();

                String file = fileSystem.printFileContent(inputPath);
                if (file == null) {
                    System.out.println("Cannot find " + inputPath);
                } else {
                    System.out.println(file);
                }
                break;
            case "ls":
                List<Item> print = fileSystem.printDirectoryFolderAndFile();

                if (print != null) {
                    for (Item item : print) {
                        System.out.println(item.getName());
                    }
                }
                break;
            case "link":
                String linkPath = input.next();
                String targetPath = input.next();

                fileSystem.createLink(linkPath,targetPath);
                break;
            case "search":
                inputPath = input.next();

                List<String> sameFile = fileSystem.searchAllOrFile(inputPath);
                for (String s : sameFile) {
                    System.out.println(s);
                }
                break;
            default:
                System.out.println("'The command is incorrect!'");
        }

    }
}
