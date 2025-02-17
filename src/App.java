import com.jogodedamas.controller.TabuleiroSwingController;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.view.TabuleiroSwingView;

public class App {
    public static void main(String[] args) {
        TabuleiroSwingController tabuleiroSwingController = new TabuleiroSwingController(new Tabuleiro(), new TabuleiroSwingView());
        tabuleiroSwingController.iniciarJogo();
    }
}
