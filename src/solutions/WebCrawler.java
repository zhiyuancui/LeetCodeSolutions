package solutions;

import java.util.*;

public class WebCrawler {
    class HtmlParser {

        public List<String> getUrls(String urls) {
            return new ArrayList<>();
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        if(startUrl == null || htmlParser == null) {
            return new ArrayList<>();
        }

        String hostname = getHostName(startUrl);
        Queue<String> queue = new LinkedList<>();

        queue.add(startUrl);

        Set<String> result = new HashSet<>();
        result.add(startUrl);

        while(!queue.isEmpty()) {
            String url = queue.poll();

            for(String next : htmlParser.getUrls(url)) {
                if(next.startsWith(hostname) && result.add(next)) {
                    queue.offer(next);
                }
            }
        }


        return new ArrayList<>(result);
    }


    private String getHostName(String url) {
        int index = url.indexOf("/",7);
        return index == -1 ? url : url.substring(0, index);
    }


}
