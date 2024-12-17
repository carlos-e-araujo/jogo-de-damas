import com.jogodedamas.JogoDeDamas;
import com.jogodedamas.JogoDeDamasController;

public class App {
    public static void main(String[] args) {
        JogoDeDamasController jogoDeDamasController = new JogoDeDamasController(new JogoDeDamas());
        jogoDeDamasController.iniciarJogo();
    }
}
