package solutions.stripe;

import java.util.*;

public class LanguageHeader {

    public class HttpHeader {

        //Part 1
        public List<String> parseAcceptLanguage(String header, List<String> supportedLanguage) {
            Set<String> supportDict = new HashSet<>(supportedLanguage);

            header = header.replaceAll("\\s+","");
            String[] parts =  header.split(",");

            List<String> result = new ArrayList<>();
            for(String tag: parts) {
                if(supportDict.contains(tag)) {
                    result.add(tag);
                }
            }

            return result;
        }

        //Part2
        public List<String> parseAcceptLanguage2(String header, List<String> supportedLanguage) {
            Map<String, List<String>> map = new HashMap<>();
            Set<String> dict = new HashSet<>();
            for(String language: supportedLanguage) {
                dict.add(language);
                String[] parts = language.split("-");
                List<String> countries = map.getOrDefault(parts[0], new ArrayList<>());
                countries.add(language);
                map.put(parts[0], countries);
            }

            header = header.replaceAll("\\s+","");
            String[] parts =  header.split(",");

            List<String> result = new ArrayList<>();
            for(String tag: parts) {
                if(tag.indexOf("-") == -1) {
                    List<String> allLanguages = map.get(tag);
                    for(String language: allLanguages) {
                        if(!result.contains(language)) {
                            result.add(language);
                        }
                    }
                } else {
                    if(dict.contains(tag)) {
                        if(!result.contains(tag)) {
                            result.add(tag);
                        }
                    }
                }
            }

            return result;
        }

        //Part3
        public List<String> parseAcceptLanguage3(String header, List<String> supportedLanguage) {
            Map<String, List<String>> map = new HashMap<>();
            Set<String> dict = new HashSet<>();
            for(String language: supportedLanguage) {
                dict.add(language);
                String[] parts = language.split("-");
                List<String> countries = map.getOrDefault(parts[0], new ArrayList<>());
                countries.add(language);
                map.put(parts[0], countries);
            }

            header = header.replaceAll("\\s+","");
            String[] parts =  header.split(",");

            List<String> result = new ArrayList<>();
            for(String tag: parts) {
                if(tag.equals("*")) {
                    for(List<String> languages: map.values()) {
                        for(String language : languages) {
                            if (!result.contains(language)) {
                                result.add(language);
                            }
                        }
                    }
                } else if(tag.indexOf("-") == -1) {
                    List<String> allLanguages = map.get(tag);
                    for(String language: allLanguages) {
                        if(!result.contains(language)) {
                            result.add(language);
                        }
                    }
                } else {
                    if(dict.contains(tag)) {
                        if(!result.contains(tag)) {
                            result.add(tag);
                        }
                    }
                }
            }

            return result;
        }

        //Part4
        public List<String> parseAcceptLanguage4(String header, List<String> supportedLanguage) {
            Map<String, Double> map = new HashMap<>();
            header = header.replaceAll("\\s+","");

            String[] parts = header.split(",");

            for(String part : parts) {
                String[] item = part.split(";");
                String language = item[0];
                double score = Double.parseDouble(item[1].substring(item[1].indexOf('=')+1));
                if(language.equals("*")) {
                    for(String l : supportedLanguage) {
                        map.put(l, score);
                    }
                } else if(language.indexOf('-') == -1) {
                    for(String l: supportedLanguage) {
                        if(l.startsWith(language)) {
                            if(!map.containsKey(l)) {
                                map.put(l, score);
                            }
                        }
                    }
                } else {
                    map.put(language, score);
                }
            }

            List<String> result = new ArrayList<>(supportedLanguage);
            Collections.sort(result, (a,b) -> {
                if(map.get(a) > map.get(b)) {
                    return -1;
                } else if(map.get(a) == map.get(b)) {
                    return 0;
                }
                else{
                    return 1;
                }
            });

            return result;
        }
    }

}
