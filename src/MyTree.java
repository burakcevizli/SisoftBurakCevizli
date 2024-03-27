import java.util.Scanner;

public class MyTree {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("java MyTree sozluk.txt");
            System.exit(1);
        }
        SozlukTree sozlukTree = new SozlukTree();
        sozlukTree.sozluguYukle(args[0]);
        System.out.println("Sözlük yüklendi");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nBir Kelime Yazıp Enter Tuşuna Basınız (Çıkmak için 'exit' yazabilirsiniz)");
            String input = scanner.nextLine().trim();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
                sozlukTree.gelenHarfeGoreKelimeTamamla(input);
        }
            scanner.close();
    }
}