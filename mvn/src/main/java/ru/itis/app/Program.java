package ru.itis.app;

import com.beust.jcommander.JCommander;
import ru.itis.javalab.utils.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Program {
	public static void main(String[] args) {

		Args argv = new Args();
		JCommander.newBuilder()
		.addObject(argv)
		.build()
		.parse(args);

		String [] urls = argv.files.split(",");
		String folder = argv.folder;
		int count = argv.count;
		ExecutorService service = Executors.newFixedThreadPool(count);		
		
		for (String url : urls) {
			Task task = new Task(url, folder);
			service.execute(task);			
		}
	}
}