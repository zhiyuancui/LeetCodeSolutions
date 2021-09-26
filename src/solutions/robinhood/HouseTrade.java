package solutions.robinhood;

import java.util.*;

public class HouseTrade {
    class Record {
        String symbol;
        String quantity;
        String ID;
        String action;

        public Record(String symbol, String quantity, String ID, String action) {
            this.symbol = symbol;
            this.quantity = quantity;
            this.ID = ID;
            this.action = action;
        }

        public boolean isExactEqual(Record record) {
            return this.ID.equals(record.ID) && this.isAttributeMatch(record);
        }

        public boolean isAttributeMatch(Record record) {
            return this.symbol.equals(record.symbol) && this.quantity.equals(record.quantity) && this.action.equals(record.action);
        }

        public String toString() {
            return symbol+","+action+","+quantity+","+ID;
        }
    }
    public List<String> findUnMatchOrders(String[] houseTrades, String[] streetTrades) {
        Map<String, List<Record>> houseMap = getTradeMap(houseTrades);
        Map<String, List<Record>> streetMap = getTradeMap(streetTrades);

        removeMatches(houseMap, streetMap);

        List<String> unMatched = new ArrayList<>();

        for(List<Record> value : houseMap.values()) {
            for(Record r : value) {
                unMatched.add(r.toString());
            }
        }

        for(List<Record> value : streetMap.values()) {
            for(Record r : value) {
                unMatched.add(r.toString());
            }
        }

        Collections.sort(unMatched);
        return unMatched;
    }

    public List<String> findUnMatchOrders2(String[] houseTrades, String[] streetTrades) {
        Map<String, List<Record>> houseMap = getTradeMap(houseTrades);
        Map<String, List<Record>> streetMap = getTradeMap(streetTrades);

        removeMatches2(houseMap, streetMap);

        List<String> unMatched = new ArrayList<>();

        for(List<Record> value : houseMap.values()) {
            for(Record r : value) {
                unMatched.add(r.toString());
            }
        }

        for(List<Record> value : streetMap.values()) {
            for(Record r : value) {
                unMatched.add(r.toString());
            }
        }


        return unMatched;
    }

    private void removeMatches(Map<String, List<Record>> houseMap, Map<String, List<Record>> streetMap) {

        for(String key : houseMap.keySet()) {
            if(streetMap.containsKey(key)) {
                List<Record> houseRecordList = houseMap.get(key);
                List<Record> streetRecordList = streetMap.get(key);

                Collections.sort(houseRecordList, (a,b) -> a.toString().compareTo(b.toString()));
                Collections.sort(streetRecordList, (a,b) -> a.toString().compareTo(b.toString()));

                List<Integer> houseRemoveList = new ArrayList<>();
                List<Integer> streetRemoveList = new ArrayList<>();

                for(int i = 0; i < houseRecordList.size(); i++) {
                    for(int j = 0; j < streetRecordList.size(); j++) {
                        if(streetRemoveList.contains(j)) {
                            continue;
                        }
                        if(houseRecordList.get(i).isExactEqual(streetRecordList.get(j))) {
                            houseRemoveList.add(i);
                            streetRemoveList.add(j);
                            break;
                        }
                    }
                }

                houseMap.put(key, removeRecord(houseRecordList, houseRemoveList));
                streetMap.put(key, removeRecord(streetRecordList, streetRemoveList));
            }
        }
    }

    private void removeMatches2(Map<String, List<Record>> houseMap, Map<String, List<Record>> streetMap) {

        for(String key : houseMap.keySet()) {
            if(streetMap.containsKey(key)) {
                List<Record> houseRecordList = houseMap.get(key);
                List<Record> streetRecordList = streetMap.get(key);

                Collections.sort(houseRecordList, (a,b) -> a.toString().compareTo(b.toString()));
                Collections.sort(streetRecordList, (a,b) -> a.toString().compareTo(b.toString()));

                List<Integer> houseRemoveList = new ArrayList<>();
                List<Integer> streetRemoveList = new ArrayList<>();

                for(int i = 0; i < houseRecordList.size(); i++) {
                    for(int j = 0; j < streetRecordList.size(); j++) {
                        if(streetRemoveList.contains(j)) {
                            continue;
                        }
                        if(houseRecordList.get(i).isExactEqual(streetRecordList.get(j))) {
                            houseRemoveList.add(i);
                            streetRemoveList.add(j);
                            break;
                        } else if(houseRecordList.get(i).isAttributeMatch(streetRecordList.get(j))) {
                            houseRemoveList.add(i);
                            streetRemoveList.add(j);
                            break;
                        }
                    }
                }


                houseMap.put(key, removeRecord(houseRecordList, houseRemoveList));
                streetMap.put(key, removeRecord(streetRecordList, streetRemoveList));
            }
        }
    }

    private List<Record> removeRecord(List<Record> record, List<Integer> removeList) {
        List<Record> updatedList = new ArrayList<>();
        for(int i = 0; i < record.size(); i++) {
            if(removeList.contains(i)) {
                continue;
            }
            updatedList.add(record.get(i));
        }
        return updatedList;
    }

    private Map<String, List<Record>> getTradeMap(String[] trades) {
        Map<String, List<Record>> tradeMap = new HashMap<>();

        for(String trade : trades) {
            String[] parts = trade.split(",");
            String symbol = parts[0];
            String quantity = parts[2];
            String key = symbol +" " + quantity;
            Record record = new Record(parts[0], parts[2], parts[3], parts[1]);

            List<Record> tradeList = tradeMap.getOrDefault(key, new ArrayList<>());
            tradeList.add(record);
            tradeMap.put(key, tradeList);
        }

        return tradeMap;
    }

}
