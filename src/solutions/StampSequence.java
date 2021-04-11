package solutions;

import java.util.ArrayList;
import java.util.List;

public class StampSequence {

    List<Integer> result = new ArrayList<>();
    int slen = 0;
    int tlen = 0;

    public int[] movesToStamp(String stamp, String target) {
        if(stamp == null || target == null) {
            return new int[]{};
        }

        slen = stamp.length();
        tlen = target.length();

        int[] pmt = buildPMT(stamp);

        boolean success = divideConquer(0, tlen, stamp, target, pmt);
        if(!success) return new int[0];

        int[] res = new int[result.size()];

        for(int i =result.size()-1; i >= 0; i--) {
            res[result.size()-1 - i] = result.get(i);
        }

        return res;
    }

    private boolean divideConquer(int start, int end, String stamp, String target, int[] pmt) {
        if(start >= end) {
            return true;
        }

        int idx = kmpFind(start, end, stamp, target, pmt);

        if(idx >= 0) {
            result.add(idx);
            return divideConquer(start, idx, stamp, target, pmt) && divideConquer(idx+slen, end, stamp, target, pmt);
        }

        while(start < end) {
            idx = bfFind(start, end, stamp, target);
            if(idx < 0) {
                return false;
            }

            result.add(idx);

            if(idx < start) {
                start = idx + slen;
            } else {
                end = idx;
            }
        }

        return true;
    }

    private int kmpFind(int start, int end, String stamp, String target, int[] pmt) {
        for(int i = start, j = 0; i < end; i++) {
            while(j > 0 && target.charAt(i) != stamp.charAt(j)) {
                j = pmt[j-1];
            }
            if(target.charAt(i) == stamp.charAt(j) && ++j == slen) {
                return i + 1 - slen;
            }
        }
        return -1;
    }

    private int bfFind(int start, int end, String stamp, String target) {
        int firstwin, lastwin;
        int i, j;

        firstwin = Math.max(start+1-slen, 0);
        lastwin = Math.min(start-1, tlen - slen);

        for(int winstart = lastwin; winstart >= firstwin; winstart--) {
            for(j=start-winstart, i=start; j < slen &&(i >= end||target.charAt(i) == stamp.charAt(j)); i++,j++) {
                if(j == slen) {
                    return winstart;
                }
            }
        }

        firstwin = Math.max(end-slen, 0);
        lastwin = Math.min(end-1, tlen - slen);

        for(int winstart = firstwin; winstart <= lastwin; winstart++) {
            for(j=0,i=winstart; i<end && (i<start || target.charAt(i) == stamp.charAt(j)); i++,j++) {
                if(i == end) {
                    return winstart;
                }
            }
        }

        return -1;
    }

    private int[] buildPMT(String s) {
        int n = s.length();
        int j = 0;

        int[] pmt = new int[n];
        for(int i = 1; i < n; i++) {
            while( j > 0 && s.charAt(i) != s.charAt(j) ) {
                j = pmt[j-1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                j++;
                pmt[i] = j;
            }
        }

        return pmt;
    }

}
