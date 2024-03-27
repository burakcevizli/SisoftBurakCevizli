import java.io.*;
import java.util.*;

public class SozlukTree {

    SozlukTreeNode root;

    public SozlukTree() {
        this.root = new SozlukTreeNode("");
    }

    public void sozluguYukle(String dosyaAdi) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dosyaAdi))); //Dosya yüklemek için.
            String satir;
            while ((satir = reader.readLine()) != null) {
                sozlukAgacinaKelimeEkle(satir.trim());
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Sözlük işlenirken hata oluştu : " + e.getMessage());
        }
    }

    //Her bir satırda sözlükte kelime varsa
    private void sozlukAgacinaKelimeEkle(String satir) {
        SozlukTreeNode guncelHali = root;
        for (int i = 0; i < satir.length(); i++) {
            char c = satir.charAt(i);
            SozlukTreeNode dal = charIleDalBul(guncelHali, c);
            if (dal == null) {
                dal = new SozlukTreeNode(guncelHali.kelime + c);
                guncelHali.dallar.add(dal); // Eğerki dal yoksa o kelimeyle dall ekle.
            }
            guncelHali = dal;
        }
        // Son harf düğümü için booleanı  tamamlayıcı olarak işaretledim.
        guncelHali.isTamamlayici = true;
    }

    private SozlukTreeNode charIleDalBul(SozlukTreeNode guncelHali, char c) {
        for (SozlukTreeNode dal : guncelHali.dallar) {
            if (!dal.kelime.isEmpty() && dal.kelime.charAt(dal.kelime.length() - 1) == c) { // Alt düğümün kelimesinin son karakteri
                return dal;                                                                  //verilen c değerine eşit mi diye bakıyoruz.
                // Yani dal var mı yok mu diye bakıyoruz.
            }
        }
        return null;
    }

    public void gelenKokKelimeyeGoreKelimeTamamla(String gelenKokKelime) {
        SozlukTreeNode node = gelenHarfeGoreNodeBul(root, gelenKokKelime);
        if (node != null) {
            List<String> kelimeler = new ArrayList<>();
            olasiKelimeleriTopla(node, kelimeler, new StringBuilder(gelenKokKelime));
            for (String kelime : kelimeler) {
                System.out.println(kelime);
            }
        } else {
            System.out.println("Bu harfi içeren kelime bulunamadı.");
        }
    }

    private SozlukTreeNode gelenHarfeGoreNodeBul(SozlukTreeNode root, String gelenKokKelime) {
        SozlukTreeNode node = root;
        for (int i = 0; i < gelenKokKelime.length(); i++) {
            char c = gelenKokKelime.charAt(i);
            node = charIleDalBul(node, c);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private void olasiKelimeleriTopla(SozlukTreeNode node, List<String> kelimeler, StringBuilder gelenKokKelime) {
        if (node.isTamamlayici) {
            kelimeler.add(gelenKokKelime.toString());
        }
        for (SozlukTreeNode dal : node.dallar) {
            StringBuilder yeniKelime = new StringBuilder(gelenKokKelime);
            yeniKelime.append(dal.kelime.substring(gelenKokKelime.length()));
            olasiKelimeleriTopla(dal, kelimeler, yeniKelime);
        }
    }

}
