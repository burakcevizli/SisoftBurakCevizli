import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SozlukTree {

    SozlukTreeNode root;

    public SozlukTree(SozlukTreeNode root) {
        this.root = new SozlukTreeNode("");
    }

    public void sozluguYukle(String dosyaAdi){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
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
            kelimeleriTopla(node,kelimeler);
            for(String kelime : kelimeler){
                System.out.println(kelime);
            }
        }else {
            System.out.println("Bu harfi içeren kelime bulunamadı.");
        }
    }









}
