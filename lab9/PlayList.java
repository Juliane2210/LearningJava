import java.util.Arrays;
import java.io.*;

public class PlayList {

    // Instance variables

    private Song[] songs;
    private int count;
    private int capacityIncrement;
  
    // Constructor
    // See below for a new usage of the reserved keyword this.

    public PlayList( int initialCapacity, int capacityIncrement ) {
    
        if ( initialCapacity < 1 )
            throw new IllegalArgumentException( "Illegal capacity: "+ initialCapacity );
    
        if ( capacityIncrement < 1 )
            throw new IllegalArgumentException( "Illegal increment: "+ capacityIncrement );
    
        songs = new Song[ initialCapacity ];
        this.capacityIncrement = capacityIncrement;
    }
  
    public PlayList( int initialCapacity ) {
        this( initialCapacity, 10 );
    }
  
    public PlayList() {
        this( 10, 10 );
    }

    // Returns the number of elements currently stored in the PlayList
  
    public int getSize() {
        return count;
    }
  
    public boolean addSong( Song song ) {

        if ( song == null )
            throw new IllegalArgumentException( "null is not a valid argument" );

        for ( int i=0; i<count; i++ )
            if ( songs[ i ].equals( song ) ) // songs[ i ] cannot be null
                return false;
        
        if ( count == songs.length ) {

            Song[] tmp = songs;
            songs = new Song[ tmp.length + capacityIncrement ];
            for ( int i=0; i< tmp.length; i++ )
                songs[ i ] = tmp[ i ];
        }

        songs[ count++ ] = song;
        return true;
    }
  
    public Song getSongAt( int index ) {

        if ( index < 0 || index >= count )
            throw new IndexOutOfBoundsException( "" + index );

        return songs[ index ];
    }
  
    // Arrays already has a sort method.

    public void sort( java.util.Comparator<Song> c ) {
        Arrays.sort( songs, c );
    }

    // Implementing our own sort method.

    public void sort2( java.util.Comparator<Song> c ) {
    
        for ( int i = 0; i < count; i++ ) {
      
            int min = i;
      
            // Find the smallest element in the unsorted region of the
            // array.
      
            for ( int j = i+1; j < count; j++ )
                if ( c.compare( songs[ j ], songs[ min ] ) < 0 )
                    min = j;
      
            // Swap the smallest unsorted element with the element
            // found a position i.
      
            Song tmp = songs[ min ];
            songs[ min ] = songs[ i ];
            songs[ i ] = tmp;
        }
    }

    public static PlayList getSongsFromFile( String fileName ) throws IOException {
       
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // transforms the reader style so it knows
        // when there is a new line

        // int initialCapacity = 10;
        // int capacityIncrement = 1;
        PlayList playlist = new PlayList();//initialCapacity, capacityIncrement);

        for (String line = ""; line != null;) {// looping one line at a time to read the file
            line = bufferedReader.readLine();// Buffered Reader has a method readLine()

            if (line != null) {
                String[] songs = line.split(":");
                Song song = new Song(songs[0], songs[1], songs[2]);

                playlist.addSong(song);
            }
        }

        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();

        return playlist;// YOUR CODE HERE (remove the exception)

    }

    public void writeSongsToFile( String fileName ) throws IOException {
        OutputStreamWriter outWriter = new OutputStreamWriter(new FileOutputStream(fileName));

        for (int i = 0; i < this.getSize(); i++) {
            Song song = this.getSongAt(i);
            String strSong = song.toString();
            outWriter.write(strSong + "\r\n");
        }
        outWriter.close();

        // YOUR CODE HERE (remove the exception)

    }

    public boolean equals(PlayList other){
        if(other == null){
            return false;
        }
        if(count != other.count || capacityIncrement != other.capacityIncrement){
            return false;
        }
        for(int i = 0; i < count; i++){
            if(! songs[i].equals(other.songs[i])){
                return false;
            }
        }
        return true;
    }


    public String toString(){
        String result = "PlayList:\n";
        for(int i = 0; i < count; i++){
            result += "\t" + songs[i].toString() + "\n";
        }
        result += "Count: " + count + "\nCapacityIncrement: "+ capacityIncrement;
        return result;
    }
}
