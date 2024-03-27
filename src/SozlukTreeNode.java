import java.util.*;

public class SozlukTreeNode {

    String kelime;
    List<SozlukTreeNode> dallar;

    boolean isTamamlayici;

    public SozlukTreeNode(String kelime) {
        this.kelime = kelime;
        this.dallar = new ArrayList<>();
        this.isTamamlayici = false;
    }
}
