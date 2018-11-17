package Listeners.Loader;

import Listeners.Announcements.MemberChangeListener;
import Listeners.Cmd.CommandListener;
import Listeners.Logs.AuditLogListener;
import Listeners.Private.PrivateResponder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RegisterListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        event.getJDA().addEventListener(new CommandListener());
        event.getJDA().addEventListener(new AuditLogListener());
        event.getJDA().addEventListener(new MemberChangeListener());
        event.getJDA().addEventListener(new PrivateResponder());
        event.getJDA().setAutoReconnect(true);
        System.out.println("Finished Loading!\n" +
                            "Added " + event.getJDA().getRegisteredListeners().size() + " Listener(s)");
    }
}

