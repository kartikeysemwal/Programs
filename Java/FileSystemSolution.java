import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Folder {
    String name;
    HashSet<String> files;
    HashMap<String, Folder> childFolders;

    Folder(String name) {
        this.name = name;
        this.files = new HashSet<>();
        this.childFolders = new HashMap<>();
    }

    synchronized void addFile(String fileName) {
        files.add(fileName);
    }

    synchronized Folder addFolderIfAbsent(String folderName) {
        if (childFolders.containsKey(folderName)) {
            return childFolders.get(folderName);
        }

        Folder folder = new Folder(folderName);
        childFolders.put(folderName, folder);

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {

        }

        System.out.println("Add folder " + folderName + " parent " + name);

        return folder;
    }

    List<String> getAllChild() {

        System.out.println("Child of " + name + " " + childFolders.size());

        List<String> ret = new ArrayList<>();
        ret.add(name);

        for (String file : files) {
            ret.add(name + "/" + file);
        }

        for (Map.Entry<String, Folder> entry : childFolders.entrySet()) {
            System.out.println("Child of " + name + " " + entry.getKey());
            List<String> paths = entry.getValue().getAllChild();

            for (String path : paths) {
                ret.add(name + "/" + path);
            }
        }

        return ret;
    }
}

class FileSystem {
    Folder root;

    FileSystem() {
        root = new Folder("");
    }

    // type 0 for file
    // type 1 for folder

    void add(String path, int type) {
        if (type == 0) {
            addFile(path);
        } else if (type == 1) {
            addFolder(path);
        }

        System.out.println("Done " + path + " " + type);
    }

    private void addFile(String path) {
        int lastIndex = path.lastIndexOf("/");
        String folderPath = path.substring(0, lastIndex);
        String fileName = path.substring(lastIndex + 1);

        Folder folder = addFolder(folderPath);
        folder.addFile(fileName);
    }

    private Folder addFolder(String path) {
        String splitted[] = path.split("/");

        Folder parent = root;

        for (String folderStr : splitted) {
            Folder folder = parent.addFolderIfAbsent(folderStr);
            parent = folder;
        }

        return parent;
    }

    public void getAllChild(String path) {
        String splitted[] = path.split("/");

        Folder parent = root;

        for (String folderStr : splitted) {
            Folder folder = parent.addFolderIfAbsent(folderStr);
            parent = folder;
        }

        List<String> children = parent.getAllChild();

        System.out.println("\nChild folders for path " + path);

        for (String val : children) {
            System.out.println(val);
        }

        System.out.println("END\n");
    }
}

public class FileSystemSolution {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        Runnable task1 = () -> {
            String paths[] = new String[] { "C/F1" };
            for (String path : paths) {
                fileSystem.add(path, 1);
                try {
                    Thread.sleep(2000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            }
        };

        Runnable task2 = () -> {
            String paths[] = new String[] { "C/F2" };
            for (String path : paths) {
                fileSystem.add(path, 1);
                try {
                    Thread.sleep(2000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            }
        };

        Runnable task3 = () -> {
            String paths[] = new String[] { "C/F1/F2" };
            for (String path : paths) {
                fileSystem.add(path, 1);
                try {
                    Thread.sleep(2000);
                } catch (Exception ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
        }

        // fileSystem.add("C/F1/F2/F3", 1);
        // fileSystem.add("C/F1/F3/F4", 1);

        // fileSystem.add("C/F1/F3/text.txt", 0);
        // fileSystem.add("C/F1/F5/text.txt", 0);

        fileSystem.getAllChild("C");
    }
}
