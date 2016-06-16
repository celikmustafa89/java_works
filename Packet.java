import java.io.Serializable;

/**
 * Created by joker on 6/16/16.
 */
public class Packet implements Serializable{

    public String content;

    public Packet(String content){
        this.content = content;
    }
}
