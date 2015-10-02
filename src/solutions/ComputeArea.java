package solutions;

public class ComputeArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	     
        int area = ( C - A )*( D - B ) + ( G - E ) *( H - F); 
        
        if( C <= E || A >= G || B >= H || D <= F)
        {
            return area;
        }
        
        int overlap = 0;
        
        int leftX = Math.max( A, E );
        int leftY = Math.max( B, F );
        int rightX = Math.min(C ,G );
        int rightY = Math.min(D, H);
        
        overlap = (rightX - leftX)*(rightY - leftY);
        
        area = area - overlap;
        
        return area;
    }
	
	public static void main(String[] args)
	{
		ComputeArea c = new ComputeArea();
		c.computeArea(-2, -2, 2, 2, 3, 3, 4, 4);
	}
}
