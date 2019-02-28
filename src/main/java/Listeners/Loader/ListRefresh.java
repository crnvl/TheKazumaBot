package Listeners.Loader;

import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.discordbots.api.client.DiscordBotListAPI;

public class ListRefresh extends ListenerAdapter {

    DiscordBotListAPI api = new DiscordBotListAPI.Builder()
            .token(System.getenv("DB_TOKEN"))
            .botId("406097711603908621")
            .build();

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
            int serverCount = event.getJDA().getGuilds().size();
            api.setStats(serverCount);
        }
    }
