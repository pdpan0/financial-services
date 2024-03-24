package br.com.pdpano.msusers.infra.gateways

import br.com.pdpano.msusers.domain.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

object UserJdbcUtils {
    const val CREATE_USER_SQL = """
        INSERT INTO ms_users.tb_users(full_name, tax_number, email, password, is_shopkeeper, vl_balance)
        VALUES (?, ?, ?, ?, ?, ?)
        RETURNING id_user
    """

    const val GET_USER_BY_ID_SQL = """
        SELECT * FROM ms_users.tb_users WHERE id_user = ?
    """

    const val FIND_USER_BY_EMAIL_OR_TAX_NUMBER_SQL = """
        SELECT * FROM ms_users.tb_users WHERE email = ? OR tax_number = ?
    """

    class UserRowMapper : RowMapper<User> {
        override fun mapRow(rs: ResultSet, rowNum: Int): User? {
            return User(
                idUser = rs.getLong("id_user"),
                email = rs.getString("email"),
                fullName = rs.getString("full_name"),
                password = rs.getString("password"),
                taxNumber = rs.getString("tax_number"),
                vlBalance = rs.getBigDecimal("vl_balance"),
                isShopkeeper = rs.getBoolean("is_shopkeeper"),
                createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
                isActive = rs.getBoolean("is_active")
            )
        }
    }
}