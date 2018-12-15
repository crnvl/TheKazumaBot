package Listeners.Loader;

import Listeners.Announcements.CountingChannelListener;
import Listeners.Announcements.MemberChangeListener;
import Listeners.Cmd.CommandListener;
import Listeners.GlobalChat.GCListener;
import Listeners.Logs.AuditLogListener;
import Listeners.MentionResponder;
import Listeners.Private.PrivateResponder;
import Listeners.XPCreditsHandler;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RegisterListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        event.getJDA().addEventListener(new CommandListener());
        event.getJDA().addEventListener(new AuditLogListener());
        event.getJDA().addEventListener(new MemberChangeListener());
        event.getJDA().addEventListener(new PrivateResponder());
        event.getJDA().addEventListener(new XPCreditsHandler());
       event.getJDA().addEventListener(new MentionResponder());
        event.getJDA().addEventListener(new CountingChannelListener());
        event.getJDA().addEventListener(new GCListener());


        event.getJDA().setAutoReconnect(true);
        System.out.println("Finished Loading!\n" +
                            "Added " + event.getJDA().getRegisteredListeners().size() + " Listener(s)");
    }
}
