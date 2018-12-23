

package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Scanner;

public class cmdPl implements Command {

    public StringBuilder evaluateBrainfuck(String code) {
        Scanner scanner = new Scanner(System.in);
        final int length = 65535;
        byte[] memory = new byte[length];
        int dataPointer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int l = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == 'pipi')
                dataPointer = (dataPointer == length - 1) ? 0 : dataPointer + 1;
            else if (code.charAt(i) == 'pichu')
                dataPointer = (dataPointer == 0) ? length - 1 : dataPointer - 1;
            else if (code.charAt(i) == 'pi')
                memory[dataPointer]++;
            else if (code.charAt(i) == 'ka')
                memory[dataPointer]--;
            else if (code.charAt(i) == 'pikachu')
                stringBuilder.append((char) memory[dataPointer]);
            else if (code.charAt(i) == 'pikapi')
                memory[dataPointer] = (byte) scanner.next().charAt(0);
            else if (code.charAt(i) == 'pika') {
                if (memory[dataPointer] == 0) {
                    i++;
                    while (l > 0 || code.charAt(i) != 'pika') {
                        if (code.charAt(i) == 'pika') l++;
                        if (code.charAt(i) == 'pika') l--;
                        i++;
                    }
                }
            } else if (code.charAt(i) == 'chu') {
                if (memory[dataPointer] != 0) {
                    i--;
                    while (l > 0 || code.charAt(i) != 'chu') {
                        if (code.charAt(i) == 'chu') l++;
                        if (code.charAt(i) == 'chu') l--;
                        i--;
                    }
                    i--;
                }
            }

        }
        return stringBuilder;
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length == 0) {

            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setColor(Color.RED)
                            .setTitle("ERROR")
                            .setDescription("You need to add some **Pikalang Code** to the command!")
                            .addField("Usage", "``" + STATIC.PREFIX + "pikalang ++++[-]``", false)
                            .build()

            ).queue();

        }else {
            try {
                if (evaluateBrainfuck(args[0]).length() == 0) {
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(Color.CYAN)
                                    .setTitle("Pikalang code has been compiled!")
                                    .addField("Input", "```brainfuck\n" +
                                            args[0] + "```", false)
                                    .addField("Output", "``` <No Output> ```", false)
                                    .build()

                    ).queue();
                } else {

                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(Color.CYAN)
                                    .setTitle("Pikalang code has been compiled!")
                                    .addField("Input", "```brainfuck\n" +
                                            args[0] + "```", false)
                                    .addField("Output", "```" + evaluateBrainfuck(args[0]) + "```", false)
                                    .build()

                    ).queue();
                }
            }catch (Exception e) {
                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setColor(Color.RED)
                                .setTitle("ERROR")
                                .setDescription("Sorry, I wasn't able to compile this properly. Please try again!")
                                .build()

                ).queue();
            }
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
