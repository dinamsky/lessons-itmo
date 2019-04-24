package lucene;

import lucene.index.MessageIndexer;
import lucene.index.MessageToDocument;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexOptions;
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
            Document document = new Document();
            FieldType textIndexedType = new FieldType();
            textIndexedType.setStored(true);
            textIndexedType.setIndexOptions(IndexOptions.DOCS);
            textIndexedType.setTokenized(true);


            Field title = new Field("title", message.getTitle(), textIndexedType);

            Field description = new Field("description", message.getDescription(), textIndexedType);

            document.add(title);
            document.add(description);
            doc.add(document);
            System.out.println("Doc added... ");
        }
             MessageIndexer indexer = new MessageIndexer("C:\\Users\\Игорь\\IdeaProjects\\lessons-itmo\\src\\main\\resources\\index");

            indexer.index(true, doc);

            BasicSearchExamples search = new BasicSearchExamples(indexer.readIndex());
        System.out.println("Index --   "+indexer.readIndex());

        Scanner reader = new Scanner(System.in);  // Reading from System.in
       while (true){System.out.print("Введите запрос:\t");
         String toSearch = reader.nextLine(); // Scans the next token

        search.fuzzySearch(toSearch);}
    }
}