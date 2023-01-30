import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

public class Thieve implements Strategy {

    boolean PICKPOCKET;

    @Override
    public boolean activate() {
        if (Players.getMyPlayer().getAnimation() != Constants.PICKPOCKET_ANIM_ID) {
            if (Players.getMyPlayer().getAnimation() == 404 || Players.getMyPlayer().getAnimation() == Constants.PICKPOCKET_ANIM_ID) {
                Time.sleep(2000);
            } else {
                if (Players.getMyPlayer().getAnimation() == -1) {
                    PICKPOCKET = attemptPickPocket();
                }
            }
        }
        return attemptPickPocket();
    }


    private boolean attemptPickPocket() {
        for (Npc npc : Npcs.getNearest(Constants.NPC_IDS)) {
            if (npc != null && Players.getMyPlayer().getAnimation() == -1) {
                npc.interact(Npcs.Option.PICKPOCKET);
                Time.sleep(2000);
            }
        }
        return true;
    }

    @Override
    public void execute() {

    }
}
