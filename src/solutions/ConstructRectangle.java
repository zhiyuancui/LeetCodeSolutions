package solutions;

public class ConstructRectangle {

	public int[] constructRectangle(int area) {
        int[] result = new int[2];
        if( area == 0 ){
            return result;
        }
        int width = (int)Math.sqrt(area);
        while( area % width != 0 ){
            width--;
        }
        
        int height = area / width;
        result[0] = height;
        result[1] = width;
        
        return result;
        
    }
}
