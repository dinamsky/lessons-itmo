package lucene;

import lucene.index.MessageIndexer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchTest {

    public static void main(String[] args) throws IOException, ParseException {


        Directory memoryIndex = new RAMDirectory();
        Analyzer analyzer = new RussianAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter writter = new IndexWriter(memoryIndex, indexWriterConfig);
        RSSFeedParser parser = new RSSFeedParser(
                "https://habr.com/ru/rss/");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        ArrayList<Document> doc = new ArrayList<>();

        for (FeedMessage message : feed.getMessages()) {
            Document document = new Document();

            document.add(new TextField("title", message.getTitle(), Field.Store.YES));
            document.add(new TextField("body", message.getDescription(), Field.Store.YES));
            System.out.println(message.getDescription());
            writter.addDocument(document);

        }
        writter.close();
        System.out.println("");
        System.out.println("");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter search string : ");
        String queryString = reader.next();
        Query query = new QueryParser("body", analyzer)
                .parse(queryString);

        IndexReader indexReader = DirectoryReader.open(memoryIndex);
        IndexSearcher searcher = new IndexSearcher(indexReader);
        TopDocs topDocs = searcher.search(query, 10);
        List<Document> documents = new ArrayList<>();
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            documents.add(searcher.doc(scoreDoc.doc));
        }
for (Document d:documents){
    System.out.println("  ");
    System.out.println("  ");
    System.out.println("  ");
    System.out.println("Document found :     "+d.toString());
}

    }
}
