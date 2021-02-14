package solutions;

public class CanPlaceFlower {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0 || n < 0) {
            return false;
        }

        if(n == 0) {
            return true;
        }


        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                int left = i - 1 >= 0 ? flowerbed[i-1] : 0;
                int right = i + 1 < flowerbed.length ? flowerbed[i+1] : 0;

                if(left == 0 && right == 0 && n > 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }
}
