import java.util.*;

public class SozlukTreeNode {

    String kelime;
    List<SozlukTreeNode> dallar;

    public SozlukTreeNode(String kelime) {
        this.kelime = kelime;
        this.dallar = new ArrayList<>();
    }
}
