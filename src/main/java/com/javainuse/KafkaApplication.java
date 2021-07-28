package com.javainuse;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javainuse.service.BookService;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {

	@Autowired
	private RestHighLevelClient highLevelClient;

//	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		printElasticSearchInfo();

//		Random rand = new Random();
//		bookService.save(new Book(UUID.randomUUID().toString(), "Elasticsearch Basics" + rand.nextInt(), "Rambabu Posa",
//				"23-FEB-2017"));
//		bookService.save(new Book(UUID.randomUUID().toString(), "Apache Lucene Basics" + rand.nextInt(), "Rambabu Posa",
//				"13-MAR-2017"));
//		bookService.save(new Book(UUID.randomUUID().toString(), "Apache Solr Basics" + rand.nextInt(), "Rambabu Posa",
//				"21-MAR-2017"));
//		bookService.save(new Book(UUID.randomUUID().toString(), "Elasticsearch Basics" + rand.nextInt(), "Rambabu Posa",
//				"23-FEB-2021"));
//		bookService.save(new Book(UUID.randomUUID().toString(), "Apache Lucene Basics" + rand.nextInt(), "Rambabu Posa",
//				"13-MAR-2021"));
//		bookService.save(new Book(UUID.randomUUID().toString(), "Apache Solr Basics" + rand.nextInt(), "Rambabu Posa",
//				"21-MAR-2020"));

	}

	// useful for debug, print elastic search details
	private void printElasticSearchInfo() {

//		RestClient lowLevelClient = highLevelClient.lowLevelClient();  
//		RestClient client = highLevelClient.getLowLevelClient();
//		List<Node> lst = client.getNodes();
	}
}
