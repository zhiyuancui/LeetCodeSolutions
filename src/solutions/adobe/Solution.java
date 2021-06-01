package solutions.adobe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Solution {

//    class Article {
//        private String title;
//        @SerializedName("story_title")
//        private String storyTitle;
//
//        public Article(String title, String storyTitle) {
//            this.title = title;
//            this.storyTitle = title;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public String getStoryTitle() {
//            return storyTitle;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public void setStoryTitle(String storyTitle) {
//            this.storyTitle = storyTitle;
//        }
//    }
//
//    class ArticleResponse {
//        private int page;
//        @SerializedName("total_page")
//        private int totalPage; // total_page
//        private int total;
//        private List<Article> data;
//
//        public ArticleResponse(int page, int totalPage, int total, List<Article> data) {
//            this.page = page;
//            this.totalPage = totalPage;
//            this.total = total;
//            this.data = data;
//        }
//
//        public int getPage() {
//            return this.page;
//        }
//
//        public void setPage(int page) {
//            this.page = page;
//        }
//
//        public int getTotalPage() {
//            return this.totalPage;
//        }
//
//        public int getTotal() {
//            return this.total;
//        }
//
//        public List<Article> getData() {
//            return this.data;
//        }
//
//        public void setTotalPage(int totalPage) {
//            this.totalPage = totalPage;
//        }
//
//        public void setTotal(int total) {
//            this.total = total;
//        }
//
//        public void setData(List<Article> data) {
//            this.data = data;
//        }
//    }
//
//    public List<String> getArticles(String author) {
//        List<String> result = new ArrayList<>();
//
//        try {
//            int pageId = 0;
//            int count = 0;
//            int total = 0;
//            String baseUrl = "";
//            String requestURL = baseUrl + "?author="+ author + "&page=" + pageId;
//            do {
//                URL url = new URL(null, requestURL);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setRequestProperty("Content-Type", "application/json");
//
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuffer content = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    content.append(inputLine);
//                }
//                in.close();
//
//                ArticleResponse response = gson.fromJson(content, ArticleResponse.class);
//
//                count += response.data.size();
//                for(Article a : response.getData()) {
//                    if(a.title != null) {
//                        result.add(a.title);
//                    } else if(a.storyTitle != null) {
//                        result.add(a.storyTitle);
//                    }
//                }
//
//            } while(count < total);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
}
