
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
class PlayerSocket {
    
    static CLIENT client ;
    //static NameForm nform ;
    public static void main(String[] args)throws IOException 
    {
        client = new CLIENT() ;
        client.setVisible(true);
        //nform = new NameForm() ;
        
    }
    
}
