package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebCrawlerMultithread {
    interface HtmlParser {
      List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        int index = startUrl.indexOf('/',7);

        String hostname = (index != -1) ? startUrl.substring(0,  index) : startUrl;

        Crawler crawler = new Crawler(startUrl, hostname, htmlParser);

        Crawler.result = new HashSet<>();

        Thread thread = new Thread(crawler);
        thread.start();

        Crawler.joinThread(thread);

        return new ArrayList<>(Crawler.result);
    }

}

class Crawler implements Runnable {
    String startUrl;
    String hostname;
    WebCrawlerMultithread.HtmlParser htmlParser;

    public static volatile Set<String> result = new HashSet<>();

    public Crawler(String startUrl, String hostname, WebCrawlerMultithread.HtmlParser htmlParser) {
        this.startUrl = startUrl;
        this.hostname = hostname;
        this.htmlParser = htmlParser;
    }

    public void run(){
        if(this.startUrl.startsWith(hostname) && !result.contains(this.startUrl)) {
            addUrl(result, this.startUrl);
            List<Thread> threads = new ArrayList<>();
            for(String s: htmlParser.getUrls(startUrl)) {
                if(result.contains(s)) {
                    continue;
                }
                Crawler crawler = new Crawler(s, hostname, htmlParser);
                Thread thread = new Thread(crawler);
                thread.start();
                threads.add(thread);
            }

            for(Thread t : threads) {
                joinThread(t);
            }
        }
    }

    public static synchronized void addUrl(Set<String> result, String url) {
        result.add(url);
    }

    public static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
