
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author soujanya
 */
public class Sound {
    String sound;
    Sound(String sound){
        this.sound=sound;
        playSound(sound);
    }
    public void playSound(String sound){
        try
        { 
          InputStream inputStream=this.getClassMethod(sound);
          AudioStream audioStream = new AudioStream(inputStream);
          AudioPlayer.player.start(audioStream);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }
    
    public void stopSound() throws IOException{
                
        AudioPlayer.player.stop();
    }
    
    public InputStream getClassMethod(String sound){
        InputStream inputStream;
        return inputStream = getClass().getResourceAsStream(sound);
    } 
    
}
