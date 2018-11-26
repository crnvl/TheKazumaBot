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
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setTitle("Info Card")
                        .setDescription("This Bot has been created by " + event.getJDA().getUserById("265849018662387712").getName() + "#" + event.getJDA().getUserById("265849018662387712").getDiscriminator() + " using Java/JDA.\n")
                        .addField("Developer", "[GitHub](https://www.github.com/shinixsensei-dev/)\n" +
                                "[Twitter](https://www.twitter.com/shinixsensei/)", false)
                        .addField("Version", "``" + STATIC.VERSION + "``", true)
                        .addField("API-Latency", event.getJDA().getPing() + "ms", false)
                        .addField("Servers","``" + event.getJDA().getGuilds().size() + "``", false)
                        .addField("Users", "``" + event.getJDA().getUsers().size() + "``", false)
                        .addField("Commandlist", STATIC.PREFIX + "help", true)
                        .addField("Invite me!", "[Add To Your Server](https://discordapp.com/api/oauth2/authorize?client_id=406097711603908621&permissions=21469585838&scope=bot)", true)
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
