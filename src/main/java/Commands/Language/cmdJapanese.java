package Commands.Language;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdJapanese implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {
            event.getMessage().getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.GREEN)
                            .setTitle("japanese")
                            .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                            .setDescription("Please enter a valid statement!\n" +
                                    "Available Selections: ``san, sama, kun, chan, tan, Bo, senpai, kohai, sensei, hakase, Shi``")
                            .build()).queue();
        }
        switch (args[0].toLowerCase()) {
            case "san":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -san")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```San (さん) (sometimes pronounced han (はん) in Kansai dialect) is the most commonplace honorific and is a title of respect typically used between equals of any age. Although the closest analog in English are the honorifics \"Mr.\", \"Miss\", \"Ms.\", or \"Mrs.\", -san is almost universally added to a person's name; \"-san\" can be used in formal and informal contexts and for any gender```")
                                .build()).queue();
                break;
            case "sama":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -sama")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Sama (様【さま】) is a more respectful version for people of a higher rank than oneself, toward one's guests or customers (such as a sports venue announcer addressing members of the audience), and sometimes toward people one greatly admires. It is seemingly said to be the origin word for \"-san\" but there is no major evidence otherwise. Deities such as the native Shinto kami and the Christian God, are referred to as kami-sama, meaning \"Revered spirit-sama\". When used to refer to oneself, sama expresses extreme arrogance (or self-effacing irony), as in praising one's self to be of a higher rank, as with ore-sama (俺様, \"my esteemed self\").```")
                                .build()).queue();
                break;
            case "kun":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -kun")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Kun (君【くん】) is generally used by people of senior status addressing or referring to those of junior status, by anyone addressing or it can be used when referring to men in general, male children or male teenagers, or among male friends. It can be used by males or females when addressing a male whom they are emotionally attached to or have known for a long time. Although it may seem rude in workplaces, the suffix is also used by juniors when referring to seniors in both academic situations and workplaces, more typically when the two people are associated.```")
                                .build()).queue();
                break;
            case "chan":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -chan")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Chan (ちゃん) is a diminutive suffix; it expresses that the speaker finds a person endearing. It is seemingly said to have come from a \"cute\" pronouncing of -san (in japanese, replacing s sounds with ch sounds is seen as cute), although there is no evidence otherwise as this suffix has been used since the early days of ancient Japan. In general, chan is used for babies, young children, friends, grandparents and adolescents. It may also be used towards cute animals, lovers, close friends, any youthful woman, or between friends. Using chan with a superior's name is considered to be condescending and rude.```")
                                .build()).queue();
                break;
            case "tan":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -tan")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Tan (たん) is an even more cute or affectionate variant of \"chan\". It evokes a small child's mispronunciation of that form of address, or baby talk – similar to how, for example, a speaker of English might use \"widdle\" instead of \"little\" when speaking to a baby. Moe anthropomorphisms are often labeled as \"-tan\", e.g., the commercial mascot Habanero-tan, the manga figure Afghanis-tan or the OS-tans representing operating systems.```")
                                .build()).queue();
                break;
            case "Bo":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -Bo")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Bō (坊【ぼう】) is another diminutive that expresses endearment. Like \"chan\", it is used for babies or young children, but is exclusively used for boys instead of girls.```")
                                .build()).queue();
                break;
            case "senpai":
            case "kohai":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -senpai / -kohai")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Senpai (先輩【せんぱい】) is used to address or refer to one's elder colleagues in a school, dojo, or sports club. So at school, the students in higher grades than oneself are senpai. Teachers are not senpai, but rather they are \"Sensei.\" Neither are students of the same or lower grade: they are referred to as kōhai. In a business environment, those with more experience are senpai.```")
                                .build()).queue();
                break;
            case "sensei":
            case "hakase":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -sensei / -hakase")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Sensei (先生【せんせい】) (literally meaning \"former-born\") is used to refer to or address teachers, doctors, politicians, lawyers, and other authority figures. It is used to show respect to someone who has achieved a certain level of mastery in an art form or some other skill, such as accomplished novelists, musicians, artists and martial artists. In japanese martial arts, sensei typically refers to someone who is the head of a dojo. As with senpai, sensei can be used not only as a suffix, but also as a stand-alone title. The term is not generally used when addressing a person with very high academic expertise; the one used instead is hakase (博士【はかせ】) (lit. \"Doctor\" or \"PhD\").\n" +
                                        "\n" +
                                        "Sensei can be used fawningly, and it can also be employed sarcastically to ridicule such fawning. The japanese media invoke it (rendered in katakana, akin to scare quotes or italics in English) to highlight the megalomania of those who allow themselves to be sycophantically addressed with the term.```")
                                .build()).queue();
                break;
            case "Shi":
                event.getMessage().getTextChannel().sendMessage(
                        new EmbedBuilder().setColor(Color.GREEN)
                                .setTitle("japanese/ -shi")
                                .setFooter("Source: Wikipedia", "http://www.nrhz.de/flyer/media/20994/wikipedia-logo.jpg")
                                .setDescription("```Shi (氏【し】) is used in formal writing, and sometimes in very formal speech, for referring to a person who is unfamiliar to the speaker, typically a person known through publications whom the speaker has never actually met. For example, the shi title is common in the speech of newsreaders. It is preferred in legal documents, academic journals, and certain other formal written styles. Once a person's name has been used with shi, the person can be referred to with shi alone, without the name, as long as there is only one person being referred to.```")
                                .build()).queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}

