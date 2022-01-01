package io.jking.tickster.interaction.command;

import io.jking.tickster.interaction.command.impl.admin.SettingsCommand;
import io.jking.tickster.interaction.command.impl.bot_owner.BlacklistCommand;
import io.jking.tickster.interaction.command.impl.bot_owner.StatsCommand;
import io.jking.tickster.interaction.command.impl.bot_owner.UpdateCommand;
import io.jking.tickster.interaction.command.impl.info.AboutCommand;
import io.jking.tickster.interaction.command.impl.info.InfoCommand;
import io.jking.tickster.interaction.command.impl.ticket_manage.TManageCommand;
import io.jking.tickster.interaction.command.impl.utility.ServerCommand;
import io.jking.tickster.interaction.command.impl.utility.SnowflakeCommand;
import io.jking.tickster.interaction.command.impl.utility.TestCommand;
import io.jking.tickster.interaction.core.Registry;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.List;
import java.util.stream.Collectors;

public class CommandRegistry extends Registry<AbstractCommand> {

    public CommandRegistry() {
        put("update", new UpdateCommand(this));
        put("info", new InfoCommand());
        put("about", new AboutCommand());
        put("snowflake", new SnowflakeCommand());
        put("test", new TestCommand());
        put("tmanage", new TManageCommand());
        put("settings", new SettingsCommand());
        put("server", new ServerCommand());
        put("blacklist", new BlacklistCommand());
        put("stats", new StatsCommand());
    }

    public List<AbstractCommand> getCommandsByCategory(CommandCategory category) {
        return getMap()
                .values()
                .stream()
                .filter(abstractCommand -> abstractCommand.getCategory() == category)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<AbstractCommand> getCommands(Member member) {
        return getMap()
                .values()
                .stream()
                .filter(abstractCommand -> member.hasPermission(abstractCommand.getPermission()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<SlashCommandData> getSlashCommands() {
        return getMap()
                .values()
                .stream()
                .map(AbstractCommand::getData)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<AbstractCommand> getCommands() {
        return getMap()
                .values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
