package streamApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class WarStream {
    public static void main(String[] args) throws IOException {
        File file  = new File("C:\\Users\\Игорь\\IdeaProjects\\lessons-itmo\\resources\\file.txt");
        Map<String,Long> map = Files.lines(file.toPath()).parallel()
                .map(line->line.toLowerCase().replaceAll("\\pP"," "))
                .flatMap(line-> Arrays.stream(line.split(" ")))
                .map(String::trim)
                .filter(word->!"".equals(word))
                .collect(groupingBy(Function.identity(),counting()))
                .entrySet()
                .parallelStream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println(map);
    }
}
