package kuzcoMain.ServerSide

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager

object DbHelper {

    val dbInstance by lazy {
        Database.connect("jdbc:sqlite:/data/data.db", "org.sqlite.JDBC")
    }

    init {
        TransactionManager.defaultDatabase = dbInstance
    }
}