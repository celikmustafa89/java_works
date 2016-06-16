import java.io.Serializable;

/**
 * Created by joker on 6/16/16.
 */
public class Packet implements Serializable{

    public String content;
    public int portNumber;

    public Packet(String content, int portNumber){
        this.content = content;
        this.portNumber = portNumber;
    }
}
