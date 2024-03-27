import java.util.Scanner;

public class MyTree {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("java MyTree sozluk.txt");
            System.exit(1);
        }
        SozlukTree sozlukTree = new SozlukTree();
        System.out.println("Sozluk Yukleniyor.Lutfen Bekleyin...");
        sozlukTree.sozluguYukle(args[0]);
        System.out.println("Sozluk yuklendi");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nBir Kelime Yazıp Enter Tusuna Basınız (Çıkmak için 'exit' yazabilirsiniz)");
            String input = scanner.nextLine().trim();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
                sozlukTree.gelenHarfeGoreKelimeTamamla(input);
        }
            scanner.close();
    }
}