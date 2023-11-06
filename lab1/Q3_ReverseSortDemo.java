//Question 3.4
public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
        
        
        for(int i=0;i<values.length-1;i++){ //the beginning and end of this for loop is important
            for(int j=i+1;j<values.length;j++){ //the beginning and end of this for loop is important
                if (values[i]<values[j]){
                    char temp=values[j];
                    values[j]=values[i];
                    values[i]=temp;
            }
            
        }    
                      
    }
	}

}