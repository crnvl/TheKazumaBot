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
            if (

                    //Main.REGBOTS.containsKey(event.getMessage().getAuthor().getId()) ||
                    (event.getMessage().getAuthor().isBot() && event.getJDA().getGuildById("552539681212989450").getTextChannelsByName(event.getAuthor().getId(), true).size() != 0) || !event.getAuthor().isBot()) {

                String out = null;
                int r, gc,b;
                r = 0;
                gc = 0;
                b = 0;
                if(event.getJDA().getGuildById("552907756622053376").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                    Random Rrate = new Random();
                    Random Grate = new Random();
                    Random Brate = new Random();
                    r = Rrate.nextInt(256);
                    gc = Grate.nextInt(256);
                    b = Brate.nextInt(256);
                }else {
                    switch (event.getJDA().getGuildById("552907756622053376").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic()) {
                        case "darkgreen":
                            r = 109;
                            gc = 159;
                            b = 75;
                            break;
                        case "pink":
                            r = 241;
                            gc = 16;
                            b = 157;
                            break;
                        case "clay":
                            r = 224;
                            gc = 207;
                            b = 221;
                            break;
                        case "cyan":
                            r = 20;
                            gc = 252;
                            b = 151;
                            break;
                        case "brown":
                            r = 139;
                            gc = 104;
                            b = 53;
                            break;
                        case "darkcyan":
                            r = 113;
                            gc = 206;
                            b = 165;
                            break;
                        case "lightgreen":
                            r = 124;
                            gc = 161;
                            b = 93;
                            break;
                        case "lightpurple":
                            r = 148;
                            gc = 128;
                            b = 137;
                            break;
                        case "seablue":
                            r = 25;
                            gc = 93;
                            b = 101;
                            break;
                        case "lightblue":
                            r = 35;
                            gc = 179;
                            b = 155;
                            break;
                        case "dirt":
                            r = 109;
                            gc = 105;
                            b = 64;
                            break;
                        case "neongreen":
                            r = 53;
                            gc = 251;
                            b = 128;
                            break;
                        case "orange":
                            r = 226;
                            gc = 64;
                            b = 1;
                            break;
                        case "purple":
                            r = 176;
                            gc = 35;
                            b = 155;
                            break;
                        case "darkergreen":
                            r = 76;
                            gc = 102;
                            b = 2;
                            break;
                    }
                }

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

                        if (event.getMessage().getAuthor().getId().contains("265849018662387712") || event.getMessage().getAuthor().getId().contains("289077956976967680") || event.getMessage().getAuthor().getId().contains("414755070161453076") || event.getMessage().getAuthor().getId().contains("483662695841923076")) {
                            try {
                                out = event.getJDA().getGuildById("523536808265383937").getTextChannels().get(i).getTopic();
                                event.getJDA().getTextChannelById(out).sendMessage(
                                        new EmbedBuilder().setColor(new Color(r, gc, b))
                                                .setAuthor(event.getMessage().getAuthor().getName() + "#" + event.getMessage().getAuthor().getDiscriminator(), null, event.getMessage().getAuthor().getAvatarUrl())
                                                .setDescription(event.getMessage().getContentRaw().replace("discord.gg/", ""))
                                                .setImage(IMAGE)
                                                //.setThumbnail(event.getJDA().getUserById("464067535587901440").getAvatarUrl())
                                                .setFooter("\uD83D\uDC51 [DEV] | Server • " + event.getMessage().getGuild().getName(), event.getMessage().getGuild().getIconUrl()).build()).queue();
                            } catch (Exception e) {

                            }

                            }else{
                                try {
                                 out = event.getJDA().getGuildById("523536808265383937").getTextChannels().get(i).getTopic();

                                 event.getJDA().getTextChannelById(out).sendMessage(
                                 new EmbedBuilder().setColor(new Color(r, gc, b))
                                 .setAuthor(event.getMessage().getAuthor().getName() + "#" + event.getMessage().getAuthor().getDiscriminator(), null, event.getMessage().getAuthor().getAvatarUrl())
                                 .setDescription(event.getMessage().getContentRaw().replace("discord.gg/", ""))
                                 .setImage(IMAGE)
                                 .setFooter("Server • " + event.getMessage().getGuild().getName(), event.getMessage().getGuild().getIconUrl()).build()).queue();

                                 } catch(Exception e){

                                 }


                            }
                        }

                    }
                }
                event.getMessage().delete().queue();
            } else {

            }
        }

    }

