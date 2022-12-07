package year2022.day07.star01;

import utils.SharedUtils;

import java.util.*;
import java.util.stream.Collectors;

public class NoSpaceLeftOnDevice {

    public static void main(String[] args) {
        String data = SharedUtils.loadDataFromInput("year2022/day07/input.txt");

        HashMap<String, List<File>> directories = new HashMap();

        String[] output = data.split("\n");

        String currentDir = "";
        for (String line : output) {
            if (line.contains("$ cd")) {
                String targetDirectory = line.replace("$ cd ", "");

                switch (targetDirectory) {
                    case "/":
                        currentDir = "/";
                        break;
                    case "..":
                        // TODO improve this with Regex
                        currentDir = currentDir.substring(0, currentDir.lastIndexOf("/", currentDir.length() - 2)) + "/";
                        break;
                    default:
                        currentDir += targetDirectory + "/";
                        break;
                }
            } else if (line.contains("$ ls")) {
                // do nothing and skip
            } else if (line.contains("dir")) {
                String[] dir = line.split(" ");

                directories.put(currentDir + dir[1] + "/", new ArrayList<>());
            } else {
                String[] file = line.split(" ");

                List<File> filesInDirectory = directories.get(currentDir);
                filesInDirectory = filesInDirectory == null ? new ArrayList() : filesInDirectory;
                filesInDirectory.add(new File(Integer.parseInt(file[0]), file[1]));
                directories.put(currentDir, filesInDirectory);
            }
        }
        // Calculate total dir sizes
        int dirSize = 0;
        int result = 0;
        for (String key : directories.keySet()) {
            Set<String> includedDirKeys = directories.keySet().stream().filter(dirKey -> dirKey.contains(key)).collect(Collectors.toSet());

            for (String includedDirKey : includedDirKeys) {
                List<File> files = directories.get(includedDirKey);
                int sum = files.stream().map(file -> file.getSize()).reduce(0, Integer::sum);
                dirSize += sum;
            }
            if (dirSize < 100000) {
                result += dirSize;
            }
            System.out.println("dir: " + key + " size: " + dirSize);
            dirSize = 0;
        }
        System.out.println("result: " + result);
    }
}
