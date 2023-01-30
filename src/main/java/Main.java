import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import java.util.ArrayList;

@ScriptManifest(author = "Script Author", category = Category.THIEVING, description = "An Example Script That Thieves From Men & Women.", name = "Example-Script", servers = {"2006Scape"}, version = 0.1)
public class Main extends Script {
    public ArrayList<Strategy> strategies = new ArrayList<>();

    @Override
    public boolean onExecute() {
        strategies.add(new Thieve());
        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {
    }
}