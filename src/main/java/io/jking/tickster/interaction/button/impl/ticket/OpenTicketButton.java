package io.jking.tickster.interaction.button.impl.ticket;

import io.jking.tickster.interaction.button.AbstractButton;
import io.jking.tickster.interaction.core.impl.ButtonSender;
import io.jking.tickster.interaction.core.responses.Error;
import io.jking.tickster.utility.EmbedUtil;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import net.dv8tion.jda.api.requests.restaction.PermissionOverrideAction;

public class OpenTicketButton extends AbstractButton {

    public OpenTicketButton() {
        super("button:open_ticket:id:%s");
    }

    @Override
    public void onButtonPress(ButtonSender sender) {
        final Member member = sender.getMember();
        final TextChannel channel = sender.getTextChannel();
        final String buttonId = String.format("button:close_ticket:id:%s", member.getIdLong());
        final ActionRow actionRow = ActionRow.of(
                Button.danger(buttonId, "Close Ticket").withEmoji(EmbedUtil.LOCK_EMOJI)
        );

        sender.deferEdit().flatMap(hook -> setPermissions(channel, member))
                .flatMap(ignored -> sender.getHook().retrieveOriginal())
                .flatMap(message -> editComponents(message, actionRow))
                .queue(null, error -> sender.replyErrorEphemeral(Error.CUSTOM, "Could not lock ticket!"));
    }

    private PermissionOverrideAction setPermissions(TextChannel channel, Member member) {
        return channel.upsertPermissionOverride(member).resetDeny()
                .setAllow(Permission.VIEW_CHANNEL, Permission.MESSAGE_SEND);
    }

    private MessageAction editComponents(Message message, ActionRow actionRow) {
        return message.editMessageComponents(actionRow);
    }
}
