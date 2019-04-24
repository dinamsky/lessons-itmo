package lucene;

import lucene.index.MessageIndexer;
import lucene.index.MessageToDocument;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LuceneTest {


    public static void main(String[] args) throws IOException, ParseException {
        RSSFeedParser parser = new RSSFeedParser(
                "https://habr.com/ru/rss/");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        ArrayList<Document> doc = new ArrayList<>();
        for (FeedMessage message : feed.getMessages()) {

            doc.add(MessageToDocument.createWith(message.getTitle(), message.getDescription()));
            System.out.println("Doc added: "+MessageToDocument.createWith(message.getTitle(), message.getDescription()).toString());
        }
             MessageIndexer indexer = new MessageIndexer("/tmp/teaser_index");
        for (Document d: doc) {
            indexer.index(true, d);
            System.out.println("Doc indexed: "+d.toString());
        }
            BasicSearchExamples search = new BasicSearchExamples(indexer.readIndex());
        System.out.println(indexer.readIndex().getSumTotalTermFreq("habr"));

        Scanner reader = new Scanner(System.in);  // Reading from System.in
       while (true){System.out.print("Введите запрос:\t");
         String toSearch = reader.nextLine(); // Scans the next token

        search.fuzzySearch(toSearch);}
    }
}