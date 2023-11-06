public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int [] array = new int[beforeArray.length + 1];

        for(int i=0; i<array.length; i++){
            if (i < indexToInsert){
                array[i]= beforeArray[i];
            }else if (i== indexToInsert) {
                array[i]= valueToInsert;
            }else {
                array[i]=beforeArray[i-1];
            }
        }
        return array;
	}

	public static void main(String[] args){
		int[] example ={1,5,4,7,9,6};
        int[] exampleMod = insertIntoArray(example, 3, 15);
        System.out.println("Array before insertion:");

        for(int i=0; i<example.length; i++){
            System.out.println(example[i]);
        }
        System.out.println("Array after insertion of "+15+" at position "+3+":");

        for(int i=0; i<exampleMod.length; i++){
            System.out.println(exampleMod[i]);
        }
        
	}
}
