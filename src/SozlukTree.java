import java.io.*;
import java.util.*;

public class SozlukTree {

    SozlukTreeNode root;

    public SozlukTree() {
        this.root = new SozlukTreeNode("");
    }

    public void sozluguYukle(String dosyaAdi){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dosyaAdi), "UTF-8"));
            String satir;
            while ((satir = reader.readLine()) != null){
                kelimeEkle(satir.trim());
            }
            reader.close();
        }catch (IOException e){
            System.err.println("Sözlük işlenirken hata oluştu : " + e.getMessage());
        }
    }

    private void kelimeEkle(String kelime) {
        SozlukTreeNode guncelHali = root;
        for(int i = 0; i<kelime.length(); i++){
            char c = kelime.charAt(i);
            SozlukTreeNode dal = charIleDalBul(guncelHali , c);
            if(dal == null){
                dal = new SozlukTreeNode(guncelHali.kelime + c);
                        guncelHali.dallar.add(dal);
            }
            guncelHali = dal;
        }
    }

    private SozlukTreeNode charIleDalBul(SozlukTreeNode guncelHali, char c) {
        for(SozlukTreeNode dal : guncelHali.dallar){
            if(dal.kelime.length() > 0 && dal.kelime.charAt(dal.kelime.length() -1) == c){
                return dal;
            }
        }
        return null;
    }

    public void gelenHarfeGoreKelimeTamamla(String gelenHarf){
        SozlukTreeNode node = gelenHarfeGoreNodeBul(root , gelenHarf);
        if(node != null){
            List<String> kelimeler = new ArrayList<>();
            kelimeleriTopla(node,kelimeler , new StringBuilder(gelenHarf));
            for(String kelime : kelimeler){
                System.out.println(kelime);
            }
        }else {
            System.out.println("Bu harfi içeren kelime bulunamadı.");
        }
    }

    private SozlukTreeNode gelenHarfeGoreNodeBul(SozlukTreeNode root, String gelenHarf) {
        for(SozlukTreeNode dal : root.dallar){
            if(dal.kelime.startsWith(gelenHarf)){
                return dal;
            }
        }
        return null;
    }

    private void kelimeleriTopla(SozlukTreeNode node, List<String> kelimeler , StringBuilder kelime) {
        if(node.dallar.isEmpty()){
            kelimeler.add(kelime.toString());
        }else{
            for(SozlukTreeNode dal : node.dallar){
                kelimeleriTopla(dal,kelimeler , new StringBuilder(kelime).append(dal.kelime.charAt(dal.kelime.length() - 1)));
            }
        }
    }
}
