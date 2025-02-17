import com.jogodedamas.controller.JogoDeDamasSwingController;
import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.view.JogoDeDamasView;

public class App {
    public static void main(String[] args) {
        JogoDeDamasSwingController jogoDeDamasSwingController = new JogoDeDamasSwingController(new JogoDeDamas());
        jogoDeDamasSwingController.iniciarJogo();
    }
}
