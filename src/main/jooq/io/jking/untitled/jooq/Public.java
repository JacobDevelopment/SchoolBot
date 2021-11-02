/*
 * This file is generated by jOOQ.
 */
package io.jking.untitled.jooq;


import io.jking.untitled.jooq.tables.GuildData;
import io.jking.untitled.jooq.tables.GuildInfractions;
import io.jking.untitled.jooq.tables.GuildSettings;
import io.jking.untitled.jooq.tables.GuildTickets;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.guild_data</code>.
     */
    public final GuildData GUILD_DATA = GuildData.GUILD_DATA;

    /**
     * The table <code>public.guild_infractions</code>.
     */
    public final GuildInfractions GUILD_INFRACTIONS = GuildInfractions.GUILD_INFRACTIONS;

    /**
     * The table <code>public.guild_settings</code>.
     */
    public final GuildSettings GUILD_SETTINGS = GuildSettings.GUILD_SETTINGS;

    /**
     * The table <code>public.guild_tickets</code>.
     */
    public final GuildTickets GUILD_TICKETS = GuildTickets.GUILD_TICKETS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            GuildData.GUILD_DATA,
            GuildInfractions.GUILD_INFRACTIONS,
            GuildSettings.GUILD_SETTINGS,
            GuildTickets.GUILD_TICKETS
        );
    }
}
