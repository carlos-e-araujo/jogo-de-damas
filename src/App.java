import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.controller.JogoDeDamasController;

public class App {
    public static void main(String[] args) {
        JogoDeDamasController jogoDeDamasController = new JogoDeDamasController(new JogoDeDamas());
        jogoDeDamasController.iniciarJogo();
    }
}
