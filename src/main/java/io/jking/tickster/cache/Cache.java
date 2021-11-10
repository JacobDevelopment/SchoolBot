package io.jking.tickster.cache;

import io.jking.tickster.cache.impl.GuildCache;
import io.jking.tickster.cache.impl.TicketCache;
import io.jking.tickster.database.Database;

public class Cache {

    private final GuildCache guildCache;
    private final TicketCache ticketCache;

    public Cache(Database database) {
        this.guildCache = new GuildCache(database);
        this.ticketCache = new TicketCache(database);
    }

    public GuildCache getGuildCache() {
        return guildCache;
    }

    public TicketCache getTicketCache() {
        return ticketCache;
    }
}
