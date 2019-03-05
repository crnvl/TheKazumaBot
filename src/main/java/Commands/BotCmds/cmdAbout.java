package Commands.BotCmds;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdAbout implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        int mb = 1024 * 1024;
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setColor(STATIC.MAIN)
                        .setTitle("Info Card")
                        .setDescription("This Bot has been created by " + event.getJDA().getUserById("265849018662387712").getName() + "#" + event.getJDA().getUserById("265849018662387712").getDiscriminator() + " using Java/JDA.\n")
                        .addField("Developer", "[GitHub](https://www.github.com/shinixsensei-dev/)\n" +
                                "[Twitter](https://www.twitter.com/shinixsensei/)", true)
                        .addField("System", "Available RAM ``" + Runtime.getRuntime().freeMemory() / mb + "/" + Runtime.getRuntime().maxMemory() / mb + "MB``\n" +
                                                        "Threats ``" + Runtime.getRuntime().availableProcessors() + "``", true)
                        .addField("Version", "``" + STATIC.VERSION + "``", true)
                        .addField("API-Latency", event.getJDA().getPing() + "ms", false)
                        .addField(event.getJDA().getGuilds().size() + " Servers","", false)
                        .addField(event.getJDA().getUsers().size() +" Users", "", false)
                        .addField("Commandlist", STATIC.PREFIX + "help", false)
                        .addField("Important Links", "[Add me to your server](https://bit.ly/kazumabot)\n |" +
                                                                    "[Join my support server](https://discord.gg/fyJ6PFj) |\n" +
                                                                    "[Vote for me!](https://discordbots.org/bot/406097711603908621/vote)", true)
                        .addField("Support Server", "[Click to Join](https://discord.gg/fyJ6PFj)", true)
                        .addField("Vote for me!", "[Vote on discordbots.org](https://discordbots.org/bot/406097711603908621)", false)
                        .addField("GitHub", "https://github.com/shinixsensei-dev/TheKazumaBot", true)
                        .setFooter("Kazuma is a project by MIYAKI Development. Copyright Owner is "  + event.getJDA().getUserById("265849018662387712").getName() + "#" + event.getJDA().getUserById("265849018662387712").getDiscriminator(), null)
                        .build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }
}
