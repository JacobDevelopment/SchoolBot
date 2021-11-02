/*
 * This file is generated by jOOQ.
 */
package io.jking.untitled.jooq;


import io.jking.untitled.jooq.tables.GuildData;
import io.jking.untitled.jooq.tables.GuildSettings;
import io.jking.untitled.jooq.tables.GuildTickets;
import io.jking.untitled.jooq.tables.records.GuildDataRecord;
import io.jking.untitled.jooq.tables.records.GuildSettingsRecord;
import io.jking.untitled.jooq.tables.records.GuildTicketsRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GuildDataRecord> GUILD_DATA_PKEY = Internal.createUniqueKey(GuildData.GUILD_DATA, DSL.name("guild_data_pkey"), new TableField[] { GuildData.GUILD_DATA.GUILD_ID }, true);
    public static final UniqueKey<GuildSettingsRecord> GUILD_SETTINGS_PKEY = Internal.createUniqueKey(GuildSettings.GUILD_SETTINGS, DSL.name("guild_settings_pkey"), new TableField[] { GuildSettings.GUILD_SETTINGS.GUILD_ID }, true);
    public static final UniqueKey<GuildTicketsRecord> GUILD_TICKETS_PKEY = Internal.createUniqueKey(GuildTickets.GUILD_TICKETS, DSL.name("guild_tickets_pkey"), new TableField[] { GuildTickets.GUILD_TICKETS.ID }, true);
}
