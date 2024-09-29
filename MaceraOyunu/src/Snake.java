import java.util.Random;

public class Snake extends Obstacle {

    public Snake() {
        super("Yılan", 4, 0, 12, 0); // Başlangıçta hasar 0 olarak ayarlandı
        this.setDamage(randomHealth());
    }

    // Bu metod artık statik değil
    public int randomHealth() {
        Random random = new Random();
        
        int min = 3;
        int max = 6;

        return random.nextInt((max - min) + 1) + min;
    }
}
