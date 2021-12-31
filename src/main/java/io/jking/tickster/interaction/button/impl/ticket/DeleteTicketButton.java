package io.jking.tickster.interaction.button.impl.ticket;

import io.jking.tickster.interaction.button.AbstractButton;
import io.jking.tickster.interaction.core.impl.ButtonSender;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.concurrent.TimeUnit;

public class DeleteTicketButton extends AbstractButton {
    public DeleteTicketButton() {
        super("button:delete_ticket:id:%s");
    }

    @Override
    public void onButtonPress(ButtonSender context) {
        context.replyEphemeral("Are you sure you want to delete this ticket?")
                .addActionRow(
                        Button.danger("button:yes_delete", "Delete Ticket")
                ).queue();
    }

    public static class YesDeleteTicketButton extends AbstractButton {

        public YesDeleteTicketButton() {
            super("button:yes_delete");
        }

        @Override
        public void onButtonPress(ButtonSender context) {
            final long channelId = context.getTextChannel().getIdLong();

            context.replyEphemeral("Deleting your ticket now...")
                    .delay(5, TimeUnit.SECONDS)
                    .flatMap(ignored -> context.getTextChannel().delete())
                    .queue();
            context.getTicketCache().delete(channelId);
        }
    }
}
