import java.util.Scanner;

public class MyTree {
    public static void main(String[] args) {

        SozlukTree sozlukTree = new SozlukTree();
        System.out.println("Sozluk Yukleniyor.Lutfen Bekleyin...");
        sozlukTree.sozluguYukle(args[0]);
        System.out.println("Sozluk yuklendi");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBir Kelime Yazip Enter Tusuna Basiniz (Cikmak icin 'exit' yazabilirsiniz)");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Yazdiginiz Kelime : " + input);
            System.out.println("Olasi Kelimeler : ");
            sozlukTree.gelenKokKelimeyeGoreKelimeTamamla(input);

        }
        scanner.close();
    }
}