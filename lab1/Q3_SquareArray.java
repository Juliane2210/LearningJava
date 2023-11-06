//Question 3.1:

public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int [] array = new int[size]; //the [size] part is confusing me

        
        for(int i=0; i< size;i++){
                array[i]= i*i;
        }
        return array;
	}

	public static void main(String[] args){
        int[] example = createArray(13);
		
        for(int i=0; i< example.length; i++){
        System.out.print("The Square of "+i +" is: "+ example[i]);
        System.out.println();
        }
	}
}
