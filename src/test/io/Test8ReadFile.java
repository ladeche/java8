package test.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Test8ReadFile {
	public static void main(String[] args) throws InterruptedException {
		
		// Lecture d'un fichier plus simple en java8
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/tmp/copy.log"));
			reader.lines().forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("##########################################################################");
		Thread.sleep(1000);

		// Encore plus simple en utilisant un Stream de strings (1 string par ligne)
		try (Stream<String> lines = Files.lines(Paths.get("C:/tmp/copy.log"))) {
			lines.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("##########################################################################");
		Thread.sleep(1000);

		// Utilisation d'un Array; en plus on filtre à la volée
		List<String> fileArr;
		Path file = Paths.get("C:/tmp/copy.log");
		try{
			// read file into array
			fileArr = Files.readAllLines(file);
			
			fileArr.stream().filter(line -> line.contains("dao"))
			.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
