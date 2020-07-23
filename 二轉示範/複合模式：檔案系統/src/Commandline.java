import java.util.List;
import java.util.stream.Collectors;

public class Commandline {
    private Directory root = new Root();
    private Directory currentDir;

    public void start() {
        root.add(new LocalDirectory("users"));
        root.add(new LocalFile("hello.txt", "Hello".getBytes()));
        currentDir = (Directory) root.getChild("users");
        printCurrentPath();
    }

    private void printCurrentPath() {
        System.out.print(currentDir.getPath() + "> ");
    }

    public void executeCommand(String command) {
        String[] segments = command.split("\\s");

        try {
            String commandName = segments[0];
            parseAndPerformCommand(commandName, segments);
        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println("The command is incorrect!");
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }

        printCurrentPath();
    }

    private void parseAndPerformCommand(String commandName, String[] segments) {
        switch (commandName) {
            case "cd":
                changeDirectory(segments[1]);
                break;
            case "mkdir":
                makeDirectory(segments[1]);
                break;
            case "touch":
                touch(segments[1], segments[2]);
                break;
            case "rm":
                remove(segments[1]);
                break;
            case "cat":
                concatenate(segments[1]);
                break;
            case "ls":
                list();
                break;
            case "link":
                link(segments[1], segments[2]);
                break;
            case "search":
                search(segments[1]);
                break;
        }
    }

    private void changeDirectory(String path) {
        LocateItemVisitor locateItemVisitor = performPathVisit(path);
        Item target = locateItemVisitor.getItem();
        if (target instanceof Directory) {
            currentDir = (Directory) target;
        } else {
            System.err.printf("%s is not a directory.\n", path);
        }
    }

    private void makeDirectory(String path) {
        LocateItemVisitor visitor = performPathVisit(path);
        visitor.getParent()
                .add(new LocalDirectory(visitor.getItemName()));
    }

    private void touch(String path, String content) {
        LocateItemVisitor visitor = performPathVisit(path);
        visitor.getParent()
                .add(new LocalFile(visitor.getItemName(), content.getBytes()));

    }

    private void remove(String path) {
        LocateItemVisitor visitor = performPathVisit(path);
        visitor.getParent()
                .remove(visitor.getItem());
    }

    private void concatenate(String path) {
        LocateItemVisitor visitor = performPathVisit(path);
        Item item = visitor.getItem();
        if (item instanceof File) {
            System.out.println(new String(((File) item).getContent()));
        } else {
            System.err.printf("%s is not a file.\n", path);
        }
    }

    private void list() {
        printItems(currentDir.getChildren()
                .stream().filter(item -> !item.isHidden())
                .collect(Collectors.toList()));
    }

    private void link(String linkPath, String targetPath) {
        LocateItemVisitor linkPathVisitor = performPathVisit(linkPath);
        LocateItemVisitor targetPathVisitor = performPathVisit(targetPath);
        linkPathVisitor.getParent()
                .add(new Link(root, linkPathVisitor.getItemName(), targetPathVisitor.getAbsoluteItemPath()));
    }

    private void search(String keyword) {
        printItems(currentDir.search(keyword));
    }

    private void printItems(List<Item> items) {
        System.out.println(items.stream()
                .map(Item::getName)
                .collect(Collectors.joining("\n")));
    }


    private LocateItemVisitor performPathVisit(String path) {
        LocateItemVisitor locateItemVisitor = new LocateItemVisitor(root, currentDir);
        locateItemVisitor.locateItemFromPath(path);
        return locateItemVisitor;
    }

}
