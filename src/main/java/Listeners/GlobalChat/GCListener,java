package Listeners.Announcements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class GCListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getJDA().getGuildById("523536808265383937").getTextChannelsByName(event.getGuild().getId(), true).size() != 0 && !(event.getMessage().getEmbeds().size() > 0) && event.getJDA().getGuildById("523536808265383937").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().contains(event.getTextChannel().getId())) {

            if (event.getJDA().getGuildById("559488253376462878").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {

                if (

                    //Main.REGBOTS.containsKey(event.getMessage().getAuthor().getId()) ||
                        (event.getMessage().getAuthor().isBot() && event.getJDA().getGuildById("552539681212989450").getTextChannelsByName(event.getAuthor().getId(), true).size() != 0) || !event.getAuthor().isBot()) {

                    String out = null;

                    Random Rrate = new Random();
                    Random Grate = new Random();
                    Random Brate = new Random();
                    int r = Rrate.nextInt(256);
                    int gc = Grate.nextInt(256);
                    int b = Brate.nextInt(256);

                    if (event.getMessage().mentionsEveryone()) {
                        event.getMessage().getTextChannel().sendMessage("You are not allowed to mention everyone!").queue();
                    } else {
                        for (int i = 0; i < event.getJDA().getGuildById("523536808265383937").getTextChannels().size(); i++) {

                            String IMAGE = new String();
                            if (event.getMessage().getAttachments().size() == 0) {
                                IMAGE = null;
                            } else {
                                IMAGE = event.getMessage().getAttachments().get(0).getUrl();
                            }

                            if (event.getMessage().getAuthor().getId().contains("265849018662387712") || event.getMessage().getAuthor().getId().contains("289077956976967680")) {
                                try {
                                    out = event.getJDA().getGuildById("523536808265383937").getTextChannels().get(i).getTopic();
                                    event.getJDA().getTextChannelById(out).sendMessage(
                                            new EmbedBuilder().setColor(new Color(r, gc, b))
                                                    .setAuthor(event.getMessage().getAuthor().getName() + "#" + event.getMessage().getAuthor().getDiscriminator(), null, event.getMessage().getAuthor().getAvatarUrl())
                                                    .setDescription(event.getMessage().getContentRaw().replace("discord.gg/", ""))
                                                    .setImage(IMAGE)
                                                    //.setThumbnail(event.getJDA().getUserById("464067535587901440").getAvatarUrl())
                                                    .setFooter("\uD83D\uDC51 [DEV] Server • " + event.getMessage().getGuild().getName(), event.getMessage().getGuild().getIconUrl()).build()).queue();
                                } catch (Exception e) {

                                }

                            } else {
                                try {
                                    out = event.getJDA().getGuildById("523536808265383937").getTextChannels().get(i).getTopic();


                                    event.getJDA().getTextChannelById(out).sendMessage(
                                            new EmbedBuilder().setColor(new Color(r, gc, b))
                                                    .setAuthor(event.getMessage().getAuthor().getName() + "#" + event.getMessage().getAuthor().getDiscriminator(), null, event.getMessage().getAuthor().getAvatarUrl())
                                                    .setDescription(event.getMessage().getContentRaw().replace("discord.gg/", ""))
                                                    .setImage(IMAGE)
                                                    .setFooter("Server • " + event.getMessage().getGuild().getName(), event.getMessage().getGuild().getIconUrl()).build()).queue();

                                } catch (Exception e) {

                                }


                            }
                        }

                    }
                }
                event.getMessage().delete().queue();
            } else {
                event.getTextChannel().sendMessage(
                        new EmbedBuilder()
                                .setTitle(event.getAuthor().getName() + " you are banned from Kazuma")
                                .setDescription("Due to inappropriate Actions in our Globalchat, you're temporarily banned from acting as a participant. If you want to get your access back, apply on the official discord server")
                                .addField("Support", "If this is an error please contact us. [join our support server](https://discord.gg/fyJ6PFj)", false)
                                .build()


                ).queue();
            }
            } else {

            }
       
    }

    

}
