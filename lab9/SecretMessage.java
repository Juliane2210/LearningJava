import java.io.*;

public class SecretMessage {

    public static void encrypt( String inputFilem, String outputFile, int key ) throws IOException, FileNotFoundException {

        InputStreamReader input = null;
        OutputStreamWriter out = null;
        
        try{
            input= new InputStreamReader (new FileInputStream(inputFilem));
            out = new OutputStreamWriter(new FileOutputStream(outputFile));

            int character;
            while((character= input.read()) != -1){
                //character gets encrypted by adding the key
                character +=key;
                out.write(character);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (out != null) {
                out.close();
            }
            
        }
        //throw new UnsupportedOperationException("SecretMessage encrypt not implemented");
        // YOUR CODE HERE (remove the exception)

    }
	
    public static void decrypt(String inputFilem, String outputFile, int key)
            throws IOException, FileNotFoundException {
        
        encrypt(inputFilem, outputFile, -key);
        //throw new UnsupportedOperationException("SecretMessage decrypt not implemented");
        // YOUR CODE HERE (remove the exception)

    }

    public static void main( String[] args ) {

        if ( args.length != 4 ) {
            System.out.println( "Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key" );
            System.exit( 0 );
        }

		if(args[0].equals("encrypt")){

		
            try {
                encrypt( args[1],args[2], Integer.parseInt(args[3]));
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found: "+e.getMessage() );
            } catch (IOException e) {
                System.err.println( "Cannot read/write file: "+e.getMessage() );
            }
		}
		else if(args[0].equals("decrypt")){

		
            try {
                decrypt( args[1],args[2], Integer.parseInt(args[3]));
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found: "+e.getMessage() );
            } catch (IOException e) {
                System.err.println( "Cannot read/write file: "+e.getMessage() );
            }
        }
		else{
			System.out.println( "Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key" );
            System.exit( 0 );
		}
        
    }
}