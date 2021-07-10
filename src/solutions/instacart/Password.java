package solutions.instacart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Password {
//    public static void main(String[] args) throw Exception{
//        Map<Integer, String> map = new HashMap<>();
//        int max = 0;
//        StringBuilder sb = new StringBuilder();
//        int idx = 0;
//        String indexLine = "";
//        List<String> list = new ArrayList<>();
//        try
//        {
//            int count = 0;
//            File file = new File("pd2.txt");
//            FileReader fileReader = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fileReader);
//            String line;
//            while ((line = reader.readLine()) != null)
//            {
//                // System.out.println(line);
//                if (count == 0)
//                {
//                    idx = Integer.parseInt(line);
//                    count++;
//                    continue;
//                }
//                else if (count == 1)
//                {
//                    indexLine = line;
//                    count++;
//                    continue;
//                }
//                else
//                {
//                    // System.out.println(line);
//                    if (line.length() != 0)
//                    {
//                        list.add(line);
//                        count++;
//                        continue;
//                    }
//                    else
//                    {
//                        String result = findCharacter(indexLine, list);
//                        System.out.println(result);
//                        map.put(idx, result);
//                        max = Math.max(max, idx);
//
//                        count = 0;
//                        indexLine = "";
//                        list = new ArrayList<>();
//                        idx = 0;
//                    }
//                }
//            }
//            reader.close();
//            if (list.size() > 0)
//            {
//                String result = findCharacter(indexLine, list);
//                System.out.println(result);
//                map.put(idx, result);
//                max = Math.max(max, idx);
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        for (int i=0; i<=max; i++)
//        {
//            if (!map.containsKey(i))
//            {
//                throw new Exception("missing index");
//            }
//            sb.append(map.get(i));
//        }
//        System.out.println(sb.toString());
//    }
//    public static String findCharacter(String indexLine, List<String> list) throws Exception
//    {
//        if (indexLine.length() == 0 && list.size() == 0)
//        {
//            return "";
//        }
//        if (indexLine.length() != 0 && list.size() == 0)
//        {
//            throw new Exception("no valid matrix");
//        }
//        // System.out.println(indexLine);
//        String index = indexLine.substring(1, indexLine.length()-1);
//        String[] indexes = index.split(",");
//        int x = Integer.parseInt(indexes[0].trim());
//        int y = Integer.parseInt(indexes[1].trim());
//        System.out.println(x + "," + y);
//        int row = list.size();
//
//        return String.valueOf(list.get(row-1-y).charAt(x));
//    }
}
