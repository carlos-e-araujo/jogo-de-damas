import com.jogodedamas.JogoDeDamas;
import com.jogodedamas.JogoDeDamasController;
import com.jogodedamas.JogoDeDamasView;

public class App {
    public static void main(String[] args) {
        JogoDeDamasController jogoDeDamasController = new JogoDeDamasController(new JogoDeDamas(), new JogoDeDamasView());
        jogoDeDamasController.iniciarJogo();
    }
}
