package Listeners.Loader;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class ResetService extends ListenerAdapter{


    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("starting ResetService");
        Timer resetTimer = new Timer();
        TimerTask task = new TimerTask() {
            int secondsPassed = 0;
            @Override
            public void run() {
                switch(secondsPassed){
                    case 0:
                        try {
                            for (int i = 0; i < event.getJDA().getGuildById("548636655456747521").getTextChannels().size(); i++) {
                                event.getJDA().getGuildById("548636655456747521").getTextChannels().get(i).delete().complete();
                            }
                            secondsPassed++;
                            break;
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    case 1:
                        try {
                            for (int i = 0; i < event.getJDA().getGuildById("548636655456747521").getTextChannels().size(); i++) {
                                event.getJDA().getGuildById("548636655456747521").getTextChannels().get(i).delete().complete();
                            }
                            secondsPassed = 0;
                            break;
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }
        };
        resetTimer.schedule(task, 1000, 86400000);
    }
}
