import java.util.Scanner;

public class MineSweeperRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        MineSweeperPlayer player = new MineSweeperPlayer(name);
        player.savePlayer(player);
        MineSweeperFrame frame = new MineSweeperFrame();
    }
}

