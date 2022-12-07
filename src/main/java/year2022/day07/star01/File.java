package year2022.day07.star01;

import lombok.Data;

@Data
public class File {

    int size;
    String name;

    public File(int size, String name) {
        this.size = size;
        this.name = name;
    }
}
